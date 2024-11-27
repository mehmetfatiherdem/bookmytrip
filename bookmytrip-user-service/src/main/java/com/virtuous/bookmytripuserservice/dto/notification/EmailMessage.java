package com.virtuous.bookmytripuserservice.dto.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage extends NotificationMessage {

    private String recipient;
    private String subject;
    private String attachment;

    public EmailMessage(){}
    public EmailMessage(String messageBody, String recipient, String subject, String attachment) {
        super(messageBody);
        this.recipient = recipient;
        this.subject = subject;
        this.attachment = attachment;
    }
}
