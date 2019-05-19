package com.majorperk.marketservice.model.tango;

public class TangoOrder {
    String accountIdentifier = "main-account";
    String customerIdentifier = "main-customer";

    String amount;
    String utid;
    
    String emailSubject;
    String externalRefID;
    String message;
    String notes;
    String sendEmail;

    TangoOrderSender sender;
    TangoOrderRecipient recipient;

}

interface TangoOrderSender {
    String senderemail = "";
    String senderfirstName = "";
    String senderlastName = "";
}

interface TangoOrderRecipient {
    String recipientemail = "";
    String recipientfirstName = "";
    String recipientlastName = "";
}