package com.zouensi.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author zouensi
 * @date 2017��7��8��
 * ����:dao��service���󴴽�����
 */
@SuppressWarnings("all")
public class BeanFactory {
	private BeanFactory() {
		
	}
	/**
	 * ͨ�������ļ���ȡ��Ӧȫ���޶��������������ҷ���
	 * @param id
	 * @return
	 */
	public static<T> T getBean(Class<T> temp) {
		SAXReader saxReader = new SAXReader();
		//��ȡ�����ļ���Ӧ��������
		InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("/applicationContext.xml");
		Object obj = null;
		try {
			//��ȡdocument����
			Document document = saxReader.read(resourceAsStream);
			//��ȡ��Ԫ��
			Element rootElement = document.getRootElement();
			//��ȡ��Ԫ���������Ԫ��
			List<Element> elements = rootElement.elements();
			for (Element element : elements) {
//				System.out.println(element.attributeValue("class"));
				//���Ԫ��id�������idƥ��ɹ����ȡȫ���޶�����ͨ��������ж��󴴽�
				if(temp.getName().contains(element.attributeValue("id"))) {
					Class<?> clazz = Class.forName(element.attributeValue("class"));
					obj = clazz.newInstance();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(resourceAsStream!=null) {
					resourceAsStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (T)obj;
	}
}
