package cn.edu.ccnu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Dataformat {

	public static String setJson(String group, HashMap<String, String> hm) {
		// 根据键值创建JSON
		JSONObject json = new JSONObject();
		JSONArray jArray = new JSONArray();
		JSONObject record = new JSONObject();

		for (Entry<String, String> entry : hm.entrySet()) {
			record.put(entry.getKey(), entry.getValue());
		}
		jArray.add(record);
		json.put(group, jArray);
		return json.toString();
	}

	public static String appendJson(String group, String jsonString,
			HashMap<String, String> hm) {
		JSONObject json = JSONObject.fromObject(jsonString);
		JSONArray jArray = null;
		try {
			jArray = json.getJSONArray(group);
		} catch (Exception e) {
			jArray = new JSONArray();
		}
		JSONObject record = new JSONObject();

		for (Entry<String, String> entry : hm.entrySet()) {
			record.put(entry.getKey(), entry.getValue());
		}
		jArray.add(record);
		json.put(group, jArray);
		return json.toString();
	}

	public static String removeJson(String group, String jsonString, int index) {
		JSONObject json = JSONObject.fromObject(jsonString);
		JSONArray jArray = json.getJSONArray(group);
		jArray.remove(index);
		json.put(group, jArray);
		return json.toString();
	}

	public static List<String> getJson(String group, String name,
			String jsonString) {
		List<String> list = new ArrayList<String>();
		JSONObject json = JSONObject.fromObject(jsonString);
		JSONArray jArray = json.getJSONArray(group);
		for (int i = 0; i < jArray.size(); i++) {
			JSONObject tmp = (JSONObject) jArray.get(i);
			list.add((String) tmp.get(name));
		}
		return list;
	}

}
