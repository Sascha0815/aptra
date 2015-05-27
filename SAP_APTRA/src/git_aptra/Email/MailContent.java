package git_aptra.Email;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
 
public class MailContent{
    public static void main(String[] args) throws AddressException, MessagingException    {
    	
        String recipient = "fabian.gierer@web.de";
        String subject = "Terminerinnerung von Aptra";
        String text = "Hallo. Dies ist eine Erinnerung für ihren Termin bei Aptra."
        		+ "Weitere Details:";
       
        Mail.send(MailAccounts.WEB, recipient, subject, text);      
    }
}