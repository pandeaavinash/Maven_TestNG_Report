package email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

public class Mailer
{
	
	public static void send(String from,String password,String to,String sub,String msg)
	{  
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);  
         
         
         Multipart multipart = new MimeMultipart();

         MimeBodyPart textBodyPart = new MimeBodyPart();
         textBodyPart.setText("your text");

         MimeBodyPart attachmentBodyPart= new MimeBodyPart();
         DataSource source = new FileDataSource(report.ExtentReport.reportFullPath); // ex : "C:\\test.pdf"
         attachmentBodyPart.setDataHandler(new DataHandler(source));
         attachmentBodyPart.setFileName(report.ExtentReport.reportName+".html"); // ex : "test.pdf"

         multipart.addBodyPart(textBodyPart);  // add the text part
         multipart.addBodyPart(attachmentBodyPart); // add the attachement part

         message.setContent(multipart);
         
         
         
         
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) 
        {
        	throw new RuntimeException(e);
        	}
	}
   
	/*public static void main(String[] args) 
	{    
   //from,password,to,subject,message  
	//Mailer.send("aavinashpande@gmail.com","Mandakini14#","aavinashpande@gmail.com","hello javatpoint","How r u?");  
   //change from, password and to  
	} */   

}



//If mail sending is not working then do follow below steps
//1. Login to Gmail. 
//2. Access the URL as https://www.google.com/settings/security/lesssecureapps 
//3. Select "Turn on"

