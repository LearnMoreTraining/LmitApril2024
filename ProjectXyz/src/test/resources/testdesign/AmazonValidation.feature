Feature: Amazon Homepage Validation
  @sc01 @beta @amazon01
    #before
  Scenario: search functionaity
    #beforestep
    When user enter the product name "iphone" in search box
    #afterstep
      # beforestep
    Then verfiy the search result
  #afterstep
  #after

  @mutliple
  Scenario Outline: multiple
    When user enter the product name "<Search Product>" in search box
    Then verfiy the search result
   Examples:
     | Search Product |
     | iphone         |
     | laptop         |
     | powerbank      |

  @amazon02
    #before
  Scenario: handle the static dropdown

    When user selects the required value from the category dropdown
    And extract the dropdown values
  #after

  @amazon03
  Scenario: handle the mouse actions
    Given user selects the baby wishlist
    When user navigates to child window

   @drag01
  Scenario: drag and drop
    Given user drag and drops