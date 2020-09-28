Feature: amazon

Scenario: print the rating and price of appium book
    Given login to amazon site
    When Select appium book and click on 10th book
    Then print the rating and price of item
   
    Scenario: print the rating and price of Furniture 
    Given login to wayfair site
    When Select Furniture, living room furniture, sectionals and navigate to the 12th Item
    Then print the rating and price of item
    
    Scenario: print the rating and price of iPhone
    Given login to amazon site
    When Select iPhone 11 Pro from shop IPhone
    Then print the rating and price of item
    
    