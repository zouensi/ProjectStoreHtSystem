package com.zouensi.utils;

/**
 * 
 * @author zouensi
 * @date 2017��7��9��
 * ����:����������
 */
public class Utils {
	private Utils() {
		
	}
	/**
	 * �ж��ַ����Ƿ�Ϊnull
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null||"".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
