// Data needed to create an order:

// "amount" - Set TangoOrder value from faceValue or Custom entry
// "customerIdentifier" - ??
// "sendEmail" - True
// "utid" - Get from RewardItem DB

// externalRefID - this will be OUR transaction ID 

// recipient - email - required if sendEmail is true - user account email
// recipient - firstName - required if sendEmail is true (100 character max)
// sender - firstName - always optional (100 character max)
// sender - lastName - always optional (100 character max)
// sender - email - always optional

// etid - Optional. The unique identifier for the email template you would like to use. Only applicable if sendEmail is true.

package com.majorperk.marketservice.model.reward;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TangoOrder {
    
    @Id
	@GeneratedValue
    Long id;

    // "amount" - Set TangoOrder value from faceValue or Custom entry
    // "customerIdentifier" - ??
    // "sendEmail" - True
    // "utid" - Get from RewardItem DB

    // externalRefID - this will be OUR transaction ID 

    // recipient - email - required if sendEmail is true - user account email
    // recipient - firstName - required if sendEmail is true (100 character max)
    // sender - firstName - always optional (100 character max)
    // sender - lastName - always optional (100 character max)
    // sender - email - always optional

    // etid - Optional. The unique identifier for the email template you would like to use. Only applicable if sendEmail is true.

    public TangoOrder() {}
    public TangoOrder(RewardItem item, Integer value) {}

}