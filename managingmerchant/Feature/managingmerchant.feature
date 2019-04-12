@ManageMerchant
Feature: Merchant Management

Background:
	Given Admin is Logged in
	And Admin is on the Manage Merchant page

  @AddMerchant
  Scenario: Adding a new Merchant
    When Details of Merchant are added
    Then Merchant is added Successfully to the database

  @ShowMerchant
  Scenario: Viewing details of a Merchant
    When ID of an existing Merchant is entered to View details
    Then Merchant details are shown Successfully
    
  @UpdateMerchant
  Scenario: Updating details of a Merchant
    When ID of an existing Merchant alongwith new details
    Then Merchant is added Successfully to the database
    
  @RemoveMerchant
  Scenario: Removing a Merchant
    When ID of an existing Merchant is entered to remove Merchant
    Then Merchant is Successfully removed from the database
