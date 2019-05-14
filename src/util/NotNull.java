package util;
//ÅÐ¶Ï×Ö·û´®²»Îª¿Õ
public class NotNull {
	public static boolean isempty(String str) {
		if (null == str || "".equals(str.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
