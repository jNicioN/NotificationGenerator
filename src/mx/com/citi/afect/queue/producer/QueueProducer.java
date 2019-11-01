package mx.com.citi.afect.queue.producer;

import mx.com.citi.afect.connection.SonicConnector;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.IOException;


public class QueueProducer {

	/**
	 * @param message Message to add to queue
	 * @author Jonathan Nicio
	 */
	public void sendMessage(String message,String imei) {

		MessageProducer sender;
		SonicConnector connector;

		try {
			connector = new SonicConnector();
			connector.getBrockerConnection().start();
			Session session = connector.getSession();
			sender = session.createProducer(connector.getQueue());

			TextMessage tMessage = session.createTextMessage();
			tMessage.setStringProperty("IMEI", imei);

			System.out.print("Setting imei = "+imei+"\n");

			tMessage.setText(String.valueOf(message));

			System.out.println("Mensaje Convertido :\n" + tMessage.getText());

			sender.send(tMessage);

			System.out.println("Mensaje Enviado");

			session.close();
			connector.getBrockerConnection().close();

			System.out.println("Sesión Cerrada");

		} catch (IOException e) {
			System.out.println("Ocurrio un problema al cargar el archivo\n");
			e.printStackTrace();
		} catch (JMSException e) {
			System.out.println("Ocurrio un problema con la conexión\n");
			e.printStackTrace();
		}


	}

}
