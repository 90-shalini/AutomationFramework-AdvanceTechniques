package com.tranings.advanceselenium.waytoautomation.library;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class Mailer {	
	public static void sendReportByGMail()
	     {

	      // Recipient's email ID needs to be mentioned.
		String from="2016.gudda@gmail.com";
		String pass="password123";
		String to="90.shalini@gmail.com";
		
	      // Sender's email ID needs to be mentioned

	      // Assuming you are sending email from localhost
	      //String host = "localhost";
		String host = "smtp.gmail.com";
	      // Get system properties
	      Properties properties = System.getProperties();
	      // Setup mail server
	      //properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.starttls.enable", "true");	      
	      properties.put("mail.smtp.host", host);	       
	      properties.put("mail.smtp.user", from);	       
	      properties.put("mail.smtp.password", pass);	       
	      properties.put("mail.smtp.port", "587");	       
	      properties.put("mail.smtp.auth", "true");
	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Report");

	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();

	         // Fill the message
	         messageBodyPart.setText("Please find the attached report file.");
	         	
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = ".\\test-output\\emailable-report.html";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("TestNG Report");
	         multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart );

	         // Send message
	         Transport transport = session.getTransport("smtp");	         
	         transport.connect(host, from, pass);	          
	         transport.sendMessage(message, message.getAllRecipients());	          
	         transport.close();
	         System.out.println("Sent message successfully....");
	      }catch (AddressException ae) {
	    	  
	    	  ae.printStackTrace();
	    	   
	    	  }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	}