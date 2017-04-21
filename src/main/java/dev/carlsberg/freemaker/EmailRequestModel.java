package dev.carlsberg.freemaker;

import java.util.List;

/**
 * Created by pankaj on 4/21/2017.
 */
public class EmailRequestModel {

    public String senderEmailId;
    public String receiverEmailId;
    public String emailSubject;
    public String receiverFirstName;
    public String receiverLastName;
    public List<String> attachmentUrls;

}
