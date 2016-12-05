package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Util {

	public static boolean isEmpty(String field){
		return (field == null || field.isEmpty() || field == "" || "".equals(field.trim()));
	}
	
	public static void removeSessionAttr(HttpServletRequest req, String key){
		HttpSession session = req.getSession(false);
		if(session != null)
			session.removeAttribute(key);
	}
	
	public static Object getSessionAttr(HttpServletRequest req, String key){
		HttpSession session = req.getSession(false);
		if(session == null)
			return null;
		Object out = session.getAttribute(key);
		
		session.removeAttribute(key);
		return out;
	}
	
	public static Integer tryParseInt(Object obj, Integer defaultVal){
		
		if(obj == null) 
			return defaultVal;
		
		if(obj instanceof Integer) 
			return (Integer) obj;
		
		try {
			String val = obj.toString();
			return Integer.parseInt(val);
		}catch (Exception e) {
			return defaultVal;
		}
	}
	
}
