package dev.carlsberg.freemaker.services;

import dev.carlsberg.freemaker.EmailRequestModel;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * Created by pankaj on 4/21/2017.
 */

@Component
public interface ISendEmailService {

    void sendPlainTextEmail(EmailRequestModel emailRequestModel) throws MessagingException;
}
