package mx.com.citi.afect.message;

public class LoadData {
	private int typeNotif;
	private String imei;
	private String delay;

	public void setTypeNotif(int typeNotif) {
		this.typeNotif = typeNotif;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getNotification() {
		String strMessage;

		NotificationSelector message = new NotificationSelector();
		strMessage = message.getMessage(typeNotif);

		strMessage = strMessage.replace("IMEIVALUE", imei);
		strMessage = strMessage.replace("EXTIME", delay);

		System.out.println(strMessage);

		return strMessage;
	}
}
