Feature: Purchase Online

  @Regression
  Scenario Outline: User able to purchase product online
    Given User is on Luma Home Page and Navigates to Create Account Page
    Then  Create User Account
    Then  Search product "<product>" via Search bar
    Then  Click on product "<productName>" and navigate to Product detail page
    When  Select Size "<size>" and Color "<color>" and go to cart page
    Then  Verify item "<productName>" is added to the Cart and proceed to checkout
    Then  Provide Shipping details and mode "<shippingMode>" then proceed to Review and Payment
    Then  Confirm order total and Place the Order
    Then  Verify purchase is successful


Examples:
    |product| productName         | size | color | shippingMode |
    |jacket | Adrienne Trek Jacket| L    | Orange| Fixed        |