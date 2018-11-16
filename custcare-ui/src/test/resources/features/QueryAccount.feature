Feature: Query account
  In order to test the query account functionality
  As a user
  I want to verify that query an account is working properly

  @qeauto_2046
  Scenario: C4222981: Verify that account can be queried by control number in Customer care
    Given I login to CUSTCARE web portal with CustcareUser credentials
    When I query an account by control number equal to: 1837084702
    Then I should be redirected to Account Info page
    When I select BILLING HISTORY option inside TRANSACTIONS menu
    Then Billing History page should be displayed with transaction records

  Scenario: Verify that account can be queried by pin in Customer care
    Given I login to CUSTCARE web portal with CustcareUser credentials
    When I query an account by pin equal to: 7322719000
    Then I should be redirected to Account Info page
    When I select BILLING HISTORY option inside TRANSACTIONS menu
    Then Billing History page should be displayed with transaction records

  Scenario: Database step example
    Then I should obtain null as result, when I look for NUM_ACTIVE_BALS data in PINTAB DEBIT table with values:
      | pin | 83782422711 |
