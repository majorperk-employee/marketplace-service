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

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public String getCustomerIdentifier() {
        return customerIdentifier;
    }

    public void setCustomerIdentifier(String customerIdentifier) {
        this.customerIdentifier = customerIdentifier;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUtid() {
        return utid;
    }

    public void setUtid(String utid) {
        this.utid = utid;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getExternalRefID() {
        return externalRefID;
    }

    public void setExternalRefID(String externalRefID) {
        this.externalRefID = externalRefID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public TangoOrderSender getSender() {
        return sender;
    }

    public void setSender(TangoOrderSender sender) {
        this.sender = sender;
    }

    public TangoOrderRecipient getRecipient() {
        return recipient;
    }

    public void setRecipient(TangoOrderRecipient recipient) {
        this.recipient = recipient;
    }

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