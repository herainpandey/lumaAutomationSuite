Feature: Purchase Online


  Scenario Outline: User able to purchase product online
    Given Launch Luma Site and go to Create an Account page
    And   Provide User information and create Account
    Then  Search product "<product>" via Search bar and navigate to Product grid
    Then  Click on product "<productName>" and navigate to Product detail page
    Then  Select Size "<size>" and Color "<color>" and click on Add to Cart button
    Then  Verify item "<productName>" is added to the Cart and proceed to checkout
    Then  Provide Shipping details and mode "<shippingMode>" then proceed to Review and Payment
    Then  Confirm order total and Place the Order
    Then  Verify purchase is successful


Examples:
    |product| productName         | size | color | shippingMode |
    |jacket | Adrienne Trek Jacket| L    | Orange| Fixed        |