package com.mozart.model.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class MozartEmailUtil {
	private static final String HTML_CABECALHO = "<html lang=\"br\"><head><title>Mozart Hotel</title><link href=\"http://iasserver.mozart.com.br/ReservaHotel/crshoteis.css\" rel=\"stylesheet\" type=\"text/css\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE7\" /><meta http-equiv=\"content-language\" content=\"pt-br\" /><meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" /><meta name=\"robots\" content=\"index, follow\" /><meta http-equiv=\"pragma\" content=\"no-cache\" /><meta http-equiv=\"Cache-Control\" content=\"no-cache, no-store\" /><meta http-equiv=\"Pragma\" content=\"no-cache, no-store\" /><meta http-equiv=\"expires\" content=\"Mon, 06 Jan 1990 00:00:01 GMT\" /><meta name=\"description\" content=\"Mozart WEB - para você que sonhava em hospedar o melhor em tecnologia\" /></head><body>";
	private static final String HTML_RODAPE = "</body></html>";
	private String login;
	private String senha;
	private String smtp;
	private String to;
	private String from;
	private String cc;
	private String bcc;
	private String subject;
	private String message;
	private byte[] anexo;
	private String anexoName;

	public MozartEmailUtil() {
		this.login = "";
		this.senha = "";
		this.from = "mozart@mozart.com.br";
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTo() {
		return this.to;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getCc() {
		return this.cc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getBcc() {
		return this.bcc;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	private void reset() {
		this.login = "";
		this.senha = "";
		this.from = "mozart@mozart.com.br";
		this.to = "";
		this.cc = "";
		this.bcc = "";
		this.subject = "";
		this.message = "";
	}

	public void destroy() {
	}

	class SimpleAuth extends Authenticator {
		public String username = null;
		public String password = null;

		public SimpleAuth(String user, String pwd) {
			this.username = user;
			this.password = pwd;
		}

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.username, this.password);
		}
	}

	public MozartEmailUtil(String login, String senha, String smtp, String to,
			String from, String cc, String bcc, String subject, String message) {
		this.login = login;
		this.senha = senha;
		this.smtp = smtp;
		this.to = to;
		this.from = from;
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.message = message;
	}

	public boolean send() {
		try {
			System.setProperty("mail.mime.charset", "iso-8859-1");
			Properties mailProps = new Properties();
			mailProps.put("mail.smtp.host", "127.0.0.1");

			SimpleAuth auth = null;
			auth = new SimpleAuth(this.login, this.senha);

			mailProps.put("mail.smtp.auth", "false");
			mailProps.put("mail.user", this.login);
			mailProps.put("mail.pwd", this.senha);
			mailProps.put("mail.from", this.from);
			mailProps.put("mail.to", this.to);
			mailProps.put("mail.cc", this.cc);

			Session mailSession = Session.getInstance(mailProps, auth);
			mailSession.setDebug(false);

			MimeMessage email = new MimeMessage(mailSession);
			email.setRecipients(Message.RecipientType.TO, InternetAddress
					.parse(this.to));
			if (this.cc.length() != 0) {
				email.setRecipients(Message.RecipientType.CC, InternetAddress
						.parse(this.cc));
			}
			if (this.bcc.length() != 0) {
				email.setRecipients(Message.RecipientType.BCC, InternetAddress
						.parse(this.bcc));
			}
			email.setFrom(new InternetAddress(this.from));
			email.setSubject(this.subject);

			email.setDataHandler(new DataHandler(this.message, "text/html"));

			Multipart mp = new MimeMultipart();

			MimeBodyPart bodyPart = new MimeBodyPart();
			bodyPart
					.setContent(
							HTML_CABECALHO
									+ this.message + HTML_RODAPE,
							"text/html; charset=\"iso-8859-1\"");
			mp.addBodyPart(bodyPart);
			if (this.anexo != null) {
				MimeBodyPart anexoPart = new MimeBodyPart();
				anexoPart.setDataHandler(new DataHandler(
						new ByteArrayDataSource(this.anexo, "aplication/pdf")));
				anexoPart.setFileName(this.anexoName);
				mp.addBodyPart(anexoPart);
			}
			email.setContent(mp);

			Transport tr = mailSession.getTransport("smtp");
			tr.connect(this.smtp, this.login, this.senha);
			email.saveChanges();
			tr.sendMessage(email, email.getAllRecipients());
			tr.close();
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
			reset();
		}
		return false;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public byte[] getAnexo() {
		return this.anexo;
	}

	public void setAnexo(byte[] anexo) {
		this.anexo = anexo;
	}

	public String getAnexoName() {
		return this.anexoName;
	}

	public void setAnexoName(String anexoName) {
		this.anexoName = anexoName;
	}
}