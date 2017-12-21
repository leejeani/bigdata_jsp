package web.component;

import java.io.UnsupportedEncodingException;

public class Util {
	public static String convertKo(String str) {
		String result = null;
		try {
			result = 
			new String(str.getBytes("8859_1"),"KSC5601");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
