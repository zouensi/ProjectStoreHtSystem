package com.zouensi.utils;




import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
/**
 * 
 * @author zouensi
 * @date 2017��7��9��
 * ����:�����ʼ�������
 */
public class MailUtils {

	public static void sendMail(String email, String emailMsg)
			throws AddressException, MessagingException {
			// �����Ự����
		//1�����������������(�Ự����)
		Properties props = new Properties();//��װ����
		props.setProperty("mail.transport.protocol", "SMTP");//���÷��ʼ���Э��
		props.setProperty("mail.host", "localhost");//���÷��ʼ��ĵ�ַ(smtp�����������ַ)
		props.setProperty("mail.smtp.auth", "true");// ָ����֤Ϊtrue

		// ������֤����֤�����ߵ��˻�������
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				//��֤�����û���������
				return new PasswordAuthentication("kefu", "kefu");//����
			}
		};

		Session session = Session.getInstance(props, auth);//�Ự����
		
		
		// �����ʼ�����		
		Message message = new MimeMessage(session);//�����ʼ�����
		message.setFrom(new InternetAddress("kefu@dell-pc.com")); // ���÷�����
		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // ���÷��ͷ�ʽ�������
		message.setSubject("�����ʼ�");//�ʼ�����
		message.setContent(emailMsg, "text/html;charset=utf-8");//�����ʼ�������

		
		// �ʼ�����
		Transport.send(message);
	}
}
