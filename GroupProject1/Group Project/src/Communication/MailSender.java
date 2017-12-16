package Communication;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {

    final String username = "cochaked@gmail.com"; //ur email
    final String password = "coc12345";
    

    public boolean send(String to,String sub,String msg,String url) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");  // to solve security issue.
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(username));//ur email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));//u will send to
            message.setSubject(sub);
            //message.setText("body"); // when we want to send only a body.
            
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(msg);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
           
            if(!url.equals("")){
            //attached 1 --------------------------------------------
            String file = url;
            String fileName = "file";
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            //------------------------------------------------------   
            }
            message.setContent(multipart);
            
            System.out.println("sending");
            Transport.send(message);
            System.out.println("Done");
            return true;
            
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        new MailSender().send("lasanrash@gmail.com", "dcvsdv", "dcs", "");
    }
}
