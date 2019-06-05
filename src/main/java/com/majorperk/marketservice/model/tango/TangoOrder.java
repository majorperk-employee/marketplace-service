package com.majorperk.marketservice.model.tango;

public class TangoOrder {
    String accountIdentifier = "main-account";
    String customerIdentifier = "main-customer";

    int amount;
    String utid;
    
    String emailSubject;
    String externalRefID;
    String message;
    String notes;
    boolean sendEmail;

    TangoContactInfo sender;
    TangoContactInfo recipient;

    public TangoOrder( 
        String accountIdentifier, 
        String customerIdentifier, 
        int amount, 
        String utid, 
        boolean sendEmail, 
        TangoContactInfo sender, 
        TangoContactInfo recipient 
    ) {
        this.accountIdentifier = accountIdentifier;
        this.customerIdentifier = customerIdentifier;
        this.amount = amount;
        this.utid = utid;
        this.sendEmail = sendEmail;
        this.sender = sender;
        this.recipient = recipient;
    };

    public TangoOrder( 
        String accountIdentifier, 
        String customerIdentifier, 
        int amount, 
        String utid, 
        String emailSubject, 
        String externalRefID, 
        String message, 
        String notes, 
        boolean sendEmail, 
        TangoContactInfo sender, 
        TangoContactInfo recipient 
    ) {
        this.accountIdentifier = accountIdentifier;
        this.customerIdentifier = customerIdentifier;
        this.amount = amount;
        this.utid = utid;
        this.emailSubject = emailSubject;
        this.externalRefID = externalRefID;
        this.message = message;
        this.notes = notes;
        this.sendEmail = sendEmail;
        this.sender = sender;
        this.recipient = recipient;
    };

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public TangoContactInfo getSender() {
        return sender;
    }

    public void setSender(TangoContactInfo sender) {
        this.sender = sender;
    }

    public TangoContactInfo getRecipient() {
        return recipient;
    }

    public void setRecipient(TangoContactInfo recipient) {
        this.recipient = recipient;
    }

}