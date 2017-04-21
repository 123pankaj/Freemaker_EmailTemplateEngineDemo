package dev.carlsberg.freemaker.services;

import dev.carlsberg.freemaker.EmailRequestModel;
import dev.carlsberg.freemaker.models.EmailResponseModel;
import dev.carlsberg.freemaker.validator.ParamsValidator;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pankaj on 4/21/2017.
 */

@Component
public class SendEmailService implements ISendEmailService{
    @Autowired
    private Configuration configuration;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendPlainTextEmail(EmailRequestModel emailRequestModel) throws MessagingException {
        EmailResponseModel model = new EmailResponseModel();

        if (emailRequestModel==null || emailRequestModel.receiverEmailId==null || !ParamsValidator.emailValidator(emailRequestModel.receiverEmailId)){
            model.responseCode=1;
            model.errorMessage="Receiver Email Is Empty Or Invalid";
            return;
        }

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject(emailRequestModel.emailSubject);
        mimeMessageHelper.setFrom(emailRequestModel.senderEmailId);
        mimeMessageHelper.setTo(emailRequestModel.receiverEmailId);
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("receiverFirstName", emailRequestModel.receiverFirstName);
        modelMap.put("receiverLastName", emailRequestModel.receiverLastName);
        mimeMessageHelper.setText(geContentFromTemplate(modelMap), true);
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
    }

    private String geContentFromTemplate(Map<String, Object> modelMap) {
        StringBuilder content = new StringBuilder();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("plain_email_file.txt"), modelMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
