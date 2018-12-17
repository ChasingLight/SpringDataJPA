package jdk.SimpleDateFormateUnsafe.formatOK2.tools;

import java.text.SimpleDateFormat;

public class DateTools {

	private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

	public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
		SimpleDateFormat sdf = null;
		sdf = tl.get();
		if (sdf == null) {   // nice
			sdf = new SimpleDateFormat(datePattern);
			tl.set(sdf);
		}
		return sdf;
	}

}
