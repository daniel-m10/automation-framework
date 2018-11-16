Feature: CustCare cases to automate

  Background: Login to Custcare
    Given I login to CUSTCARE web portal with CustcareUser credentials

  @C6564273 @deleteFromCCHistory @deleteFirstRowCCHistory
  Scenario: C6564273 Verify that Recharge could be done successfully followed by Refund for pin 83782422711
    When I query an account by pin equal to: 83782422711
      And I select CREDIT CARD ACH option inside RECHARGE menu
      And I complete RECHARGE transaction
    Then I expect to get message: Transaction Completed Successfully.
    When I select BILLING HISTORY option inside TRANSACTIONS menu
      And make sure that all check boxes are checked except COMMENTS,RAW DATA
      And I put 1 month back in from date for Get billing records
    Then 5 transaction should be displayed with type as Sale on Billing History page
    When I select PAYMENT HISTORY option inside TRANSACTIONS menu
    Then all transactions should be displayed with transaction type Sale on Payment History page
      And I should obtain null as result, when I look for NUM_ACTIVE_BALS data in PINTAB DEBIT table with values:
        | pin | 83782422711 |
    When I click first element on table
      And I complete refund transaction on the window displayed
    Then I expect to get message "$75.00 has been refunded to account"
    When I select BILLING HISTORY option inside TRANSACTIONS menu
      And I put 1 month back in from date for Get billing records
    Then there exist 5 transactions displayed on page with type as Sale and 1 as Refund on Billing History page
    When I select PAYMENT HISTORY option inside TRANSACTIONS menu
      And there exist 5 transactions displayed on page with type as Sale and 1 as Refund on Payment History page
      And I should obtain null as result, when I look for NUM_ACTIVE_BALS data in PINTAB DEBIT table with values:
        | pin | 83782422711 |

  @C6844636 @deleteSubscriberPlan
  Scenario: C6564273 Verify that unlimited plan could be bought with hard card and Renewed/Refunded with credit card in CustCare
    When I query an account by pin equal to: 8760021004
      And I select UNLIMITTED CALLING option inside FEATURES menu
      And I select ADDITIONAL OFFERS submenu from FEATURES_UNLIMITTED_CALLING menu
    Then I expect Additional Unlimited Offers text appears on Unlimited Calling page
      And I expect Plan Status text appears on page as Plan Status: Active
      And I expect Language Preference text appears on page as Message Language Preference:
      And there exist 2 Buy buttons
    When I select ENGLISH value form message language preference
      And I select 8760051004 for Activation code and I click on Redeem
    Then I should get the message Do want to redeem this code 8760051004?
      And the text You have successfully enrolled should exist
    When I select UNLIMITTED CALLING option inside FEATURES menu
      And I select CURRENT PLANS submenu from FEATURES_UNLIMITTED_CALLING menu
    Then I expect Unlimited Calling Plans text appears on Unlimited Calling page
      And Renew button should be visible and clickable
      And Update button should be visible and clickable
      And Redeem button should be visible and clickable
      And Show Details link should be visible and clickable
      And I expect Language Preference text appears on page as Message Language Preference:
      And I expect Enrollment Status text appears on page as Enrollment Status: Active
      And I expect Auto Renew text appears on page as Auto Renew:
    When I select BILLING HISTORY option inside TRANSACTIONS menu
      And make sure that all check boxes are checked except COMMENTS,RAW DATA
      And I put current in from date for Get billing records
      And I click record displayed on page
    Then I expect that all Hard Card values exist
    When I select ACCOUNT INFO option inside ACCOUNT menu
    Then a link under Unlimited/Current plans should be visible and clickable
    When I click unlimited link from Account Info page
    Then I expect Unlimited Calling Plans text appears on Unlimited Calling page
      And Renew button should be visible and clickable
      And Update button should be visible and clickable
      And Redeem button should be visible and clickable
      And Show Details link should be visible and clickable
      And I expect Language Preference text appears on page as Message Language Preference:
      And I expect Enrollment Status text appears on page as Enrollment Status: Active
      And I expect Auto Renew text appears on page as Auto Renew:
    When I select ENGLISH value form message language preference
      And I click Renew button on Unlimited Calling Plans
      And I accept the transaction
    Then the text You have successfully enrolled should exist
      And there exist 2 Renew buttons
      And there exist 1 Refund button
    When I click Renew button on Unlimited Calling Plans
      And I accept the transaction
    Then the error message Enrollment failed: Plan is already purchased should be displayed on page
    When I click Refund button on Unlimited Calling Plans
      And I accept the transaction
    Then the text You have successfully refunded should exist
      And I expect Unlimited Calling Plans text appears on Unlimited Calling page
      And Renew button should be visible and clickable
      And Update button should be visible and clickable
      And Redeem button should be visible and clickable
      And Show Details link should be visible and clickable
      And I expect Language Preference text appears on page as Message Language Preference:
      And I expect Enrollment Status text appears on page as Enrollment Status: Refunded
      And I expect Auto Renew text appears on page as Auto Renew: