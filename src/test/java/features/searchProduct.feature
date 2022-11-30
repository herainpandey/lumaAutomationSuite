Feature: Search Product Online

  @Sanity
  Scenario Outline: User able to purchase product online
    Then  Search product "<product>" via Search bar
    Then  Click on product "<productName>" and navigate to Product detail page
    When  Select Size "<size>" and Color "<color>" and go to cart page


Examples:
    |product| productName         | size | color |
    |jacket | Adrienne Trek Jacket| L    | Orange|


  @Sanity
  Scenario Outline: User able to purchase product online
    Then  Search product "<product>" via Search bar
    Then  Click on product "<productName>" and navigate to Product detail page
    When  Select Size "<size>" and Color "<color>" and go to cart page


    Examples:
      |product| productName         | size | color |
      |jacket | Adrienne Trek Jackets| M    | Orange|