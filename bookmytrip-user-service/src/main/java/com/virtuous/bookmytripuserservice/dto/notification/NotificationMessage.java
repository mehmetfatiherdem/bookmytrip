package com.virtuous.bookmytripuserservice.dto.notification;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, // name to identify the type
        property = "type" // the JSON property for type info
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailMessage.class, name = "email")
})
@Getter
@Setter
public abstract class NotificationMessage {
    private String messageBody;

    public NotificationMessage(){}
    public NotificationMessage(String messageBody) {
        this.messageBody = messageBody;
    }

}
