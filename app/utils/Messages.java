package utils;

import play.mvc.Http;

public class Messages {
	public static String at(String key, Object... args){
		return Http.Context.current().messages().at(key, args);
	}
}
