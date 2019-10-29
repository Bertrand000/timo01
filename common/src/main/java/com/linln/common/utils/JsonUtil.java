/**
 *
 */
package com.linln.common.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.alibaba.fastjson.JSONObject;



/**

* <p>Title: JsonUtil.java<／p>
* <p>Description: 封装一些通用json数据  updata：设计json数据的转换 <／p>
* @author MoumouChen
* @date 2019年2月18日
* @version 1.1

*/
public class JsonUtil {

	/**
	 * 请求成功状态常量
	 */
	public static final Integer SUCCESS_STATUS = 1;
	/**
	 * 请求成功且包含返回数据状态常量
	 */
	public static final Integer SUCCESS_DATA_STATUS = 2;
	/**
	 * 请求失败状态常量
	 */
	public static final Integer FALES_STATUS = 0;
	//封装前台列表所需的json数据
	public static String jsonHandle(Long count,List list) {
		//日期处理
/*        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
        JSONArray jsonArr = JSONArray.fromObject(list, jsonConfig);*/
        //数据封装
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count",count);
        jsonObject.put("data", list);

        String result = jsonObject.toString();
		return result;
	}
	/**
	 * @Title: successStr
	 * @Description: 拼装处理成功的json
	 * @return String
	 * @throws
	 */
	public static String success(String info) {
		return successDataHandle(info,"wushuju");
	}

	/**
	* @Title: success
	* @Description: 拼装处理成功的json，包含返回数据
	* @param info
	* @param jsonData
	* @return String
	* @throws
	*/
	public static String success(String info,Object jsonData) {
		return successDataHandle(info,jsonData);
	}

	/**
	* @Title: successDataHandle
	* @Description: 成功数据处理
	* @param info
	* @param jsonData
	* @return String
	* @throws
	*/
	private static String successDataHandle(String info,Object jsonData){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status",SUCCESS_DATA_STATUS);
		jsonObject.put("msg", info);
		if( !"wushuju".equals(jsonData) ) {
			jsonObject.put("status", SUCCESS_STATUS);
			jsonObject.put("data", jsonData);
		}
		return jsonObject.toString();
	}
	public static String fail(String info) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status",FALES_STATUS);
		jsonObject.put("msg", info);
		return jsonObject.toString();
	}

	/**
	* @Title: toJSONObject
	* @Description: java实体类转json key 保留所有值为null的属性	ps:阿里的json包没找到值为null时保留key的转换方法
	* @param
	* @return JSONObject
	* @throws
	*/
	public static <T> JSONObject toJSONObject(T object) {
		//获得类
        Class clazz = object.getClass();
        // 获取实体类的所有属性信息，返回Field数组
        Field[] fields = clazz.getDeclaredFields();
        JSONObject jsonObj = new JSONObject();
        for (Field field : fields) {
        	jsonObj.put(field.getName(), "");
		}
		return jsonObj;
	}

}
