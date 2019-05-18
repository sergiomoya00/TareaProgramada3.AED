package SYSTEM;

/**
 *
 * @author Naveen
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import GUI.Ventanainicial;
public class EmailSend {

    
    
    public void enviar(){
  try {
            String host = "smtp.gmail.com";
            String user = "checho.quiros99@gmail.com";
            String pass = "aca";//txtemail.getText();
            String to = "sergioquiros1999@gmail.com";
            String from = "checho.quiros99@gmail.com";
            String subject = "Texto Enviado";
            String messageText = "caca";//Texto1.getText();
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("Enviado Correctamente");
            JOptionPane.showMessageDialog(null, "Correo Enviado exitosamente");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}