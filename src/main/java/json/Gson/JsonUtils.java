package json.Gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonUtils {
	private static Gson gson = new Gson();

	// Java Object TO JSON String
	/**
	 * string转为json字符串
	 * 
	 * @param string
	 *            普通字符串对象
	 * @return String jsonStr json字符串
	 */
	public static String getJsonFromString(String string) {
		String jsonResult = gson.toJson(string);
		return jsonResult;
	}

	/**
	 * List对象转为json字符串
	 * 
	 * @param list
	 * @return String jsonStr json字符串
	 */
	public static String getJsonFromArrayList(List<?> list) {
		String jsonResult = gson.toJson(list);
		return jsonResult;
	}

	/**
	 * Map对象转为json字符串
	 * 
	 * @param map
	 * @return String jsonStr json字符串
	 */
	public static String getJsonFromHashMap(Map<?, ?> map) {
		String jsonResult = gson.toJson(map);
		return jsonResult;
	}

	/**
	 * Object转为json字符串
	 * 
	 * @param obj
	 *            java对象
	 * @return String jsonStr json字符串
	 */
	public static String getJsonFromObject(Object obj) {
		String jsonResult = gson.toJson(obj);
		return jsonResult;
	}

	// JSON String To Java Object
	/**
	 * @param jsonString
	 * @return String 对象
	 */
	public static String getStringFromJson(String jsonString) {
		String str = gson.fromJson(jsonString, String.class);
		return str;
	}

	/**
	 * @param jsonString
	 * @return List 对象
	 */
	public static List<?> getArrayListFromJson(String jsonString) {
		List<?> list = gson.fromJson(jsonString, new TypeToken<List<?>>(){}.getType());
		
		return list;
	}
	
	public static <T> List<T> getArrayListFromJson(String jsonString, Class<T> classType) {
		List<T> list = new ArrayList<T>();
		JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
		for(final JsonElement elem : array){
			list.add(gson.fromJson(elem, classType));
		}
		return list;
	}

	/**
	 * @param jsonString
	 * @return Map 对象
	 */
	public static Map<?, ?> getHashMapFromJson(String jsonString) {
		Map<?, ?> hashMap = gson.fromJson(jsonString,
				new TypeToken<HashMap<?, ?>>() {
				}.getType());
		return hashMap;
	}

	public static Map<?, ?> getHashMapFromJson(InputStream inputStream) {
		try{
			final BufferedReader reader = 
					new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			
			Map<?, ?> hashMap = gson.fromJson(reader,
					new TypeToken<HashMap<?, ?>>() {
					}.getType());
			return hashMap;		
			
			
		}catch(UnsupportedEncodingException e){
			throw new RuntimeException(e);
		}

	}	
	
	/**
	 * @param jsonString
	 * @return Object 对象
	 */

	public static <T> T getObjectFromJson(String jsonString,  Class<T> classType) {
		return gson.fromJson(jsonString, classType);
	}

	public static <T> T fromJson(String jsonString, Type typeOfT)
	{
		return gson.fromJson(jsonString, typeOfT);
	}

}
