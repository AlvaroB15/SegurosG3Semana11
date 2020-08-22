package com.segurosx.models;

import com.segurosx.models.patterns.ICorreoMediator;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


public class CorreoMediator implements ICorreoMediator {

    private String servidorSMTP ;
    Properties prop = new Properties();
    
    @Override
    public void setServidorCorreoSMTP(String servidorIP) {
        
        this.servidorSMTP = servidorIP;
    }
    
    private String preparaMensaje(String nombre)  {
        final StringBuffer salida = new StringBuffer();

        salida.append("\n================================================================\n");
        salida.append(" Mediator envia mensaje por Correo, servidor IP: "+ servidorSMTP );
        salida.append("\n                                    Cliente: "+ nombre );
        salida.append("\n================================================================\n");

        return salida.toString();
    }

    @Override
    public void enviaCorreoSMTP(Cliente cliente,String msg) {
        prop.setProperty("mail.smtp.host","smtp.gmail.com");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.port", servidorSMTP); //El puerto SMTP seguro de Google
        prop.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(prop);
        
        String correoEnvia = "iammiguel60@gmail.com";
        String contraseño = "rrjvkcinpysbpoeu";
        String destinatario = "miguel.ramirez7@unmsm.edu.pe";
        String asunto = "Notificacion Seguro";
        String mensaje = preparaMensaje(cliente.getNombre())+msg;
        
        MimeMessage mail = new MimeMessage(session);
        
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport trans = session.getTransport("smtp");
            trans.connect(correoEnvia,contraseño);
            trans.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            trans.close();
            
            JOptionPane.showMessageDialog(null, "mensaje enviado a cliente: " + cliente.getNombre());
            
        } catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
        
        // enviando correo...
        System.out.println(  preparaMensaje(cliente.getNombre()) );
        
    }
    
}
