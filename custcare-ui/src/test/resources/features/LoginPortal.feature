Feature: Custcare login
  In order to test the Custcare login functionality
  As a user
  I want to verify that a Custcare Login is working properly

  Scenario: Custcare login with valid credentials can be performed successfully.
    Given I login to CUSTCARE web portal with CustcareUser credentials
    Then I should be redirected to Home page

  Scenario: Custcare login with valid IDT credentials can be performed successfully.
    Given I login to Custcare portal as IDT user with IdtUser credentials
    Then I should be redirected to Home page
