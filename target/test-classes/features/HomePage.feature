@web
  Feature: HomePage I Speak Better Page
    Background:
      Given: I am on home page
      @verifyApps
      Scenario: Verify Applications on Page
        When I click GooglePlayer on page
        And I click AppStore on Page
        Then I verify apps are displayed or not

        Scenario: Verify Language function
          When I click Language button
          And I click Turkish option
          And I verify Turkish page is displayed
          And I navigated back my home page
          Then I verify language function works

          Scenario: Verify chat Box function
            When I click Chat box
            Then I verify Chat box working

            Scenario: Verify flexible package
              When I selected