package mx.com.citi.afect.conexion;

import progress.message.jclient.ConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;

public class SonicConector {
	private final String broker;
	private final String sonicUsuario;
	private final String sonicPassword;
	private final String queueName;
	private final String queueIDConexion;
	private Queue queue;
	private Connection connection;
	private Session session;

	/**
	 * @throws IOException  Exception about file reading
	 * @throws JMSException Exception about JMS Messages
	 * @author Jonathan Nicio
	 */
	public SonicConector() throws IOException, JMSException {

		FileInputStream fis = new FileInputStream("res/connexion.properties");

		// Properties of Broker
		Properties prop = new Properties();
		prop.load(fis);
		broker = prop.getProperty("broker");
		sonicUsuario = prop.getProperty("user");
		sonicPassword = prop.getProperty("password");
		queueName = prop.getProperty("queue");
		queueIDConexion = prop.getProperty("queue.id");

		fis.close();

		System.out.println("Parametros Leidos correctamente de Properties");

		queueConect();
	}

	/**
	 * @throws JMSException Exeption about JMS Messages
	 * @author Jonathan Nicio
	 */
	private void queueConect() throws JMSException {

		System.out.println("Intentando iniciar sesión con Sonic ...");

		ConnectionFactory conFac = new progress.message.jclient.ConnectionFactory(broker, queueIDConexion);
		connection = conFac.createConnection(sonicUsuario, sonicPassword);
		session = connection.createSession(false, AUTO_ACKNOWLEDGE);
		queue = session.createQueue(queueName);

		System.out.println("Sesión iniciada");
	}

	public Queue getQueue() {
		return queue;
	}

	public Session getSession() {
		return session;
	}

	public Connection getBrockerConnection() {
		return connection;
	}
}
