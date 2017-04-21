package dev.carlsberg.freemaker.controller;

import dev.carlsberg.freemaker.EmailRequestModel;
import dev.carlsberg.freemaker.services.ISendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * Created by pankaj on 4/21/2017.
 */

@RestController
@RequestMapping("dev/v1/api")
public class EmailController {

    @Autowired
    private ISendEmailService iSendEmailService;

    @RequestMapping(value = "/sendPlainTextEmail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendPlainTextEmail(@RequestBody EmailRequestModel emailRequestModel) throws MessagingException{
        iSendEmailService.sendPlainTextEmail(emailRequestModel);
    }
}
