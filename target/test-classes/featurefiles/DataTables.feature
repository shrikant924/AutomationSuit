Feature: Demonstration of datatables in cucumber
  Scenario: Verify datatable
    Given User should be on Data Entry page
    Then Input the below data


      | UserName         | Password     | ConfirmPassword | Name           | Mobile     | DOB        | Address  | PinCode |
      | Shrikantlohar123 | shrikant@123 | Shrikant@123    | Shrikant Lohar | 7083922924 | 22/12/1994 | Tuljapur | 413601  |
      | Shrikantlohar143 | shrikant@143 | Shrikant@143    | Shrikant Lohar | 7083922924 | 22/12/1994 | Tuljapur | 413601  |

