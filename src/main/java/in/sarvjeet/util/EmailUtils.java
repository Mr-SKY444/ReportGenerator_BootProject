package in.sarvjeet.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender sender; 
	
	public boolean sendMail(String toMail, String sub, String body, File file) throws Exception {
		
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
		helper.setTo(toMail);
		helper.setSubject(sub);
		helper.setText(body, true);
		
		FileSystemResource fsr=new FileSystemResource(file);
		helper.addAttachment(file.toString(), fsr);
		
		sender.send(mimeMessage);
		return true;
	}
}
