package mx.com.citi.afect.message;

public class LoadData {
	private int typeNotif;
	private String imei;
	private String delay;
	private String notificationId;

	public void setTypeNotif(int typeNotif) {
		this.typeNotif = typeNotif;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setNotificationId(String notificationId ) {
		this.notificationId = notificationId;
	}

	public String getNotification() {
		String strMessage;

		NotificationSelector message = new NotificationSelector();
		strMessage = message.getMessage(typeNotif);

		strMessage = replaceSpecialCharacters(strMessage);


		strMessage = strMessage.replace("IMEIVALUE", imei);
		strMessage = strMessage.replace("EXTIME", delay);
		strMessage = strMessage.replace("NOTIDVALUE", notificationId );

		System.out.println(strMessage);

		return strMessage;
	}

	private static String replaceSpecialCharacters(String chain){
		String msg;
		msg = chain.replace("\r", "\\n")
				.replace("\\r", "\\n")
				.replace("\n", "\\n")
				.replace("\f", "\\f")
				.replace("\t", "\\t");
		return msg;
	}


}
