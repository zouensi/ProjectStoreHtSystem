package com.zouensi.utils;

import java.util.UUID;
/**
 * 
 * @author zouensi
 * @date 2017��7��9��
 * ����:��ȡ����������
 */
public class UUIDUtils {
	/**
	 * ��ȡUUID
	 * @return
	 */
	public static String getUUID() {
		 String string = UUID.randomUUID().toString();
		 return string.replace("-", "");
	}
}
