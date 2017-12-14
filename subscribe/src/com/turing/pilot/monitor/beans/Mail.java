package com.turing.pilot.monitor.beans;

import java.io.File;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.turing.pilot.monitor.utils.ReadProperties;


public class Mail {
	private MimeMessage	message;
	private Session		session;
	private Transport	transport;

	private String		mailHost		= "";
	private String		sender_username	= "";
	private String		sender_password	= "";

	/*
	 * 初始化方法
	 */
	public Mail(boolean debug) {
		this.mailHost = ReadProperties.getMailValue("smtp");
		this.sender_username = ReadProperties.getMailValue("username");
		this.sender_password = ReadProperties.getMailValue("password");

		session = Session.getInstance(ReadProperties.promail);
		session.setDebug(debug);// 开启后有调试信息
		message = new MimeMessage(session);
	}

	/**
	 * 发送邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param sendHtml
	 *            邮件内容
	 * @param receiveUser
	 *            收件人地址
	 * @param attachment
	 *            附件
	 */
	public void doSendHtmlEmail(String subject, String sendHtml, String receiveUser, File attachment) {
		try {
			// 发件人
			InternetAddress from = new InternetAddress(sender_username);
			message.setFrom(from);

			// 收件人
			// InternetAddress to = new InternetAddress(receiveUser);
			String[] receivers = receiveUser.split(";");
			String toList = getMailList(receivers);
			new InternetAddress();
			InternetAddress[] iaToList = InternetAddress.parse(toList);
			message.setRecipients(Message.RecipientType.TO, iaToList);

			// 邮件主题
			// message.setSubject(subject);
			message.setSubject(MimeUtility.encodeText(subject, "UTF-8", "B"));
			message.setSentDate(new Date());
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();

			// 添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(sendHtml, "text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);

			// 添加附件的内容
			if (attachment != null) {
				BodyPart attachmentBodyPart = new MimeBodyPart();
				DataSource source = new FileDataSource(attachment);
				attachmentBodyPart.setDataHandler(new DataHandler(source));

				// 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
				// 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
				// sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
				// messageBodyPart.setFileName("=?GBK?B?" +
				// enc.encode(attachment.getName().getBytes()) + "?=");

				// MimeUtility.encodeWord可以避免文件名乱码
				attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
				multipart.addBodyPart(attachmentBodyPart);
			}

			// 将multipart对象放到message中
			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();

			transport = session.getTransport("smtp");
			// smtp验证，就是你用来发邮件的邮箱用户名密码
			transport.connect(mailHost, sender_username, sender_password);
			// transport.connect(mailHost,25, sender_username, sender_password);
			// 发送
			transport.sendMessage(message, message.getAllRecipients());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String getMailList(String[] mailArray) {
		StringBuffer toList = new StringBuffer();
		int length = mailArray.length;
		if (mailArray != null && length < 2) {
			toList.append(mailArray[0]);
		} else {
			for (int i = 0; i < length; i++) {
				toList.append(mailArray[i]);
				if (i != (length - 1)) {
					toList.append(",");
				}

			}
		}
		return toList.toString();
	}

//	public static void main(String[] args) {
//		try {
//			Properties prop = new Properties();
//			prop.setProperty("mail.host", "smtp.qq.com");
//			prop.setProperty("mail.transport.protocol", "smtp");
//			prop.setProperty("mail.smtp.auth", "true");
//			// 使用JavaMail发送邮件的5个步骤
//			// 1、创建session
//			Session session = Session.getInstance(prop);
//			// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
//			session.setDebug(true);
//			// 2、通过session得到transport对象
//			Transport ts = session.getTransport();
//			// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
//			ts.connect("smtp.qq.com", "monitoradmin2@xinyinhe.com", "MonitorAdmin2");
//			// 4、创建邮件
//			Message message = createSimpleMail(session);
//			// 5、发送邮件
//			ts.sendMessage(message, message.getAllRecipients());
//			ts.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * @param session
//	 * @return
//	 * @throws Exception
//	 */
//	public static MimeMessage createSimpleMail(Session session) throws Exception {
//		// 创建邮件对象
//		MimeMessage message = new MimeMessage(session);
//		// 指明邮件的发件人
//		message.setFrom(new InternetAddress("monitoradmin2@xinyinhe.com"));
//		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
//		message.setRecipient(Message.RecipientType.TO, new InternetAddress("pengli@xinyinhe.com"));
//		// 邮件的标题
//		message.setSubject("只包含文本的简单邮件");
//		// 邮件的文本内容
//		message.setContent("你好啊！", "text/html;charset=UTF-8");
//		// 返回创建好的邮件对象
//		return message;
//	}
}