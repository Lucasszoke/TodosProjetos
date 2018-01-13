package email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    public static void main(String[] args) {
        String email = "testeemaillucas@gmail.com", senha = "0741852963", emailDestino = "emailDestino@gmail.com";
        
        enviaEmail(email, senha, emailDestino);
    }
    
    static void enviaEmail(String email, String senha, String emailDestino){
        Properties props = new Properties();
        //Parâmetros de conexão com servidor Gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, senha);
            }
        });
        //Inicia teste para envio de E-Mail
        session.setDebug(true);
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email)); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(emailDestino);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Testando envio de email");//Assunto
            message.setText("Enviei este email para testar meu código");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            System.out.println("Enviado.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
