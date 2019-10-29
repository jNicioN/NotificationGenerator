package mx.com.citi.afect.main;

import mx.com.citi.afect.message.LoadData;
import mx.com.citi.afect.queue.producer.QueueProducer;

public class MessageGenerator {

	public static void main(String[] args) {

		LoadData datos = new LoadData();

		datos.setTypeNotif(Integer.parseInt(args[0]));
		datos.setImei(args[1]);
		datos.setDelay(args[2]);

		QueueProducer producer = new QueueProducer();
		producer.sendMessage(datos.getNotification());
	}
}
