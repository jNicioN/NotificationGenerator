package mx.com.citi.afect.message;

import java.io.*;

class NotificationSelector {

	String getMessage(int type){
		String notification= null;
		String notType = "res/";

		switch (type){
			case 1:
				notType = notType + "type1.txt";
				break;
			case 2:
				notType = notType + "type2.txt";
				break;
			case 3:
				notType = notType + "type3.txt";
				break;
			default:
				System.out.println("Notificaci\u00f3n 1 por default");
				notType = notType + "type1.txt";
		}

		File notFile = new File(notType);
		FileReader notFR;
		BufferedReader notBF = null;

		try {
			notFR = new FileReader(notFile);
			notBF = new BufferedReader(notFR);

		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo " + notFile.getName() + "\n En la ruta: \n " + notFile.getAbsolutePath() + "\n");
			e.printStackTrace();
		}
		try{
			StringBuilder sb = new StringBuilder();
			String lines;
			if (notBF != null) {
				while ((lines = notBF.readLine()) != null){
					sb.append(lines);
				}
			}
			notification = sb.toString();
			System.out.println("Mensaje leido: \n" + notification);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return notification;
	}
}
