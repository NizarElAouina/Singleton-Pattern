package Banque;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Journalisation {
	private static Journalisation uniqueInstance;
	private String log;
	private Journalisation() {
		log= new String();
	}
	public static Journalisation getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance = new Journalisation();
		}
		return uniqueInstance;
	}
	public void ajouterLog(String log) {
		Date d = new Date(0);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH'h'mm");
		this.log += "["+dateFormat.format(d)+"] "+log+"\n";
	}
	public String afficherLog() {
		return log;
	}
}

