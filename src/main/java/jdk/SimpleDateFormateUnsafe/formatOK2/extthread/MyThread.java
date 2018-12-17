package jdk.SimpleDateFormateUnsafe.formatOK2.extthread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jdk.SimpleDateFormateUnsafe.formatOK2.tools.DateTools;

public class MyThread extends Thread {

	private SimpleDateFormat sdf;
	private String dateString;

	public MyThread(SimpleDateFormat sdf, String dateString) {
		super();
		this.sdf = sdf;
		this.dateString = dateString;
	}

	@Override
	public void run() {
		try {
			Date dateRef = DateTools.getSimpleDateFormat("yyyy-MM-dd")
					.parse(dateString);
			String newDateString = DateTools.getSimpleDateFormat("yyyy-MM-dd")
					.format(dateRef);
			if (!newDateString.equals(dateString)) {
				System.out.println("ThreadName=" + this.getName()
						+ "������ �����ַ�����" + dateString + " ת���ɵ�����Ϊ��"
						+ newDateString);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
