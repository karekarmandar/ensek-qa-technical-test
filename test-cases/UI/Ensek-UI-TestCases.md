# Test Case 1, ID - UI- TC01 , Title : Validate Home Page loads Propelry and all the Headers, Navigation links, Buttons are visible.
- **Description** :  When the user visits the url , the Page should fully load and the page should display all the Headers, Navigation links, tabs, logo text. Such as Logo, Home tab, Home Page, About Tab, Contact tab, Register, Log in, hero banner and Buy energy / Sell energy / tab , About us are visible and the page has all the required information dispalyed with proper information
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/ 
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/ , checks the web page for Ensek Loads fully and properly, Verifies the Logo, Home, About tab, Contact tab, Register, Log in tab,  hero banner and Buy energy / Sell energy /  tab , About us cards visible. User verifies all the information is displayed properly and nothing is missing.
- **Expected Outcome** : Header shows Logo, Home, About, Contact, Register, Log in; hero banner and Buy energy / Sell energy / About us cards visible.
- **Actual Outcome** : Test Case Passed - the page loads correctly and the required tabs and functionalities are displayed properly.
- **Note**: Screenshots Attached Seperately.

-------------------------------------------------------------------------------------------------------------------------------------------
# Test Case 2, ID - UI- TC02 , Title : Validate buy quantity of each fuel
- **Description** : When the user visits the url , the Page should fully load and User should be able to Navigate to "Buy Some Energy" Tab and user should be able to buy different types of fuels
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/ 
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/  , check the web page for Ensek Loads fully and propely,Then User clicks on "Buy Some Enery" tab. Then the user see the different types options to buy the energy with available Quantity. Then User enter's the required quantity to buy in each filed and clicks Buy option and gets the confirmation message. 
- **Expected Outcome**: User should be able to buy the avaibale Quantity of Fuel/Energy and Proper Confirmation Message should be displayed ( after purchase).
- **Actual Outcome** :Test Case Passed - As User is able to buy the avaibale Quantity of Energy and Proper Confirmation Message is displayed after purchase.
- **Note**:The avaliable options are , Gas , Electricity and Oil.  Screenshots Attached Seperately.

-------------------------------------------------------------------------------------------------------------------------------------------
# Test Case 3, ID - UI- TC03 , Title : Validate the output for Large number of Purchase Quantity
- **Description** : When the user visits the url , the Page should fully load and User should be able to Navigate to "Buy Some Energy" Tab and user should be able to buy different types of fuels with Large quantity or should get warning message for the Limited Quantity.
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/ 
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/  , check the web page for Ensek Loads fully and propely,Then User clicks   on "Buy Some Enery" tab. Then the user see the different types options to buy the energy with available Quantity. Then User enter's the Large number ( ex: 1000000000) of required quantity to buy in each filed and clicks Buy option and gets the confirmation message or Warning Message.
- **Expected Outcome**: User should be able to buy the avaibale Quantity of Fuel/Energy or Warning Message should be displayed due to Large Quantity.
- **Actual Outcome** :Test Case Failed - As No warning Message is displayed and got Server Side error ( Data validation error)
- **Evidence**: Screenshot attached

-------------------------------------------------------------------------------------------------------------------------------------------

# Test Case 4, ID - UI- TC04 , Title : Validate the output for New Registration New User
- **Description** : When the user visits the url , the Page should fully load and User should be able to Navigate to "Register", fills all the deatils, email , password and clicks on register.
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/, user should have alpha-numerical password.
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/  , check the web page for Ensek Loads fully and propely,Then User clicks on "Register" to register him/her as a new user. Enters email, alpha-numeric password, confirms it and clicks register.
- **Expected Outcome**: User should be able to able to register and should get confirmation message or warning/alert message if details are not correct.
- **Actual Outcome** : Test Case Failed as Nothing happens. No Outcome, No warning , No message.
- **Evidence**: Screenshot attached
- **Suggestion**:   For Registration , it is advised to have Name, Last name, DOB, Address field for safety secure reasons .

  -------------------------------------------------------------------------------------------------------------------------------------------
# Test Case 5, ID - UI- TC05 , Title : Validate the "Sell Some Energy" Page all the key elements/information are visible.
- **Description** :  When the user visits the url , and navigates to "Sell energy "/ tab , the user should be able to see visible all the required information dispalyed on the page.
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/ , navigates to "Sell energy "/ tab, and verifies all the required information on the page.
- **Expected Outcome**: All the correct and necessary information should be displayed on the page.
- **Actual Outcome**: Test Case Failed. The page has only "Maintainance" banner . There is no time or date mentioned , how long the page will be under Maintainance.
- **Suggestion**:  Advised to add some information like date or time on "Sell Some Energy" page , so customers are aware.
- **Evidence**: Screenshot attached

    -------------------------------------------------------------------------------------------------------------------------------------------
  
# Test Case 6, ID - UI- TC06 , Title : Validate the "Contact" Page all the key elements/information are visible.
- **Description** :  When the user visits the url , and navigates to "Contact" page , the user should be able to see visible all the required information dispalyed on the page.
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/ , navigates to "Contact" page via Contact Navigation link, and verifies all the required information on the page, such as contact email, address, phone.
- **Expected Outcome**: All the correct and necessary information should be displayed on the page.
- **Actual Outcome**: Test Case Failed. The page has only "Erorr" banner which is mispelled, the correct spelling should be , "Error". 
- **Suggestion**: Correct the Error Spelling and also mention some contact details such as  email, address, phone. Because some customr might require to contact the office for unknow reason or urgency.
- **Evidence**: Screenshot attached
  -------------------------------------------------------------------------------------------------------------------------------------------

  # Test Case 7, ID - UI- TC07 , Title : Validate the "Forgot Password" functionality
  - **Description** :  When the user visits the url , and navigates to "Forgot Password" link , the user should be able to see "Forgot Password" link and should be able to click on it. The functionality should give user to enater email address for passwrd recovery.
- **Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/, user should be pre-registered.
- **Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/ , clicks on "Login" tab/link on the Top right of the home page then User looks for "Forgot Password" link,   user enters valid registered email for password recovery. And user gets new " Password" link to reset.
- **Expected Outcome**: "Forgot Password" link is visible and user gets confirmation message after entering the email address. Ex: New Password reset link sent to registered email
- **Actual Outcome**: No "Forgot Password" link present.
- **Suggestion**: "Forgot Password" link must be present or visible on the login page. 
- **Evidence**: Screenshot attached











