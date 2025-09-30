# Test Case 1, ID - UI- TC01 , Title : Home Page loads Propelry and all the key elements are visible.
**Description** :  When the user visits the url , the Page should fully load and the page should display all the tabs, functionalities, elements. Such as Logo, Home tab, Home Page, About Tab, , Contact tab, Register, Log in functionality, hero banner and Buy energy / Sell energy / tab , About us  visible and the page has all the required information dispalyed.
**Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/ 
**Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/ , checks the web page for Ensek Loads fully and properly, Verifies the Logo, Home, About tab, Contact tab, Register, Log in tab,  hero banner and Buy energy / Sell energy /  tab , About us cards visible. User verifies all the information is displayed properly and nothing is missing.
**Expected Outcome** : Header shows Logo, Home, About, Contact, Register, Log in; hero banner and Buy energy / Sell energy / About us cards visible.
**Actual Outcome** : Test Case Passed - the page loads correctly and the required tabs and functionalities are displayed properly.
**Note**: Screenshots Attached Seperately.

-------------------------------------------------------------------------------------------------------------------------------------------
# Test Case 2, UI-ID - TC02 , Title : Validate buy quantity of each fuel
**Description** : When the user visits the url , the Page should fully load and User should be able to Navigate to "Buy Some Energy" Tab and user should be able to buy different types of fuels
**Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/ 
**Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/  , check the web page for Ensek Loads fully and propely,Then User clicks on "Buy Some Enery" tab. Then the user see the different types options to buy the energy with available Quantity. Then User enter's the required quantity to buy in each filed and clicks Buy option and gets the confirmation message. 
**Expected Outcome**: User should be able to buy the avaibale Quantity of Fuel/Energy and Proper Confirmation Message should be displayed ( after purchase).
**Actual Outcome** :Test Case Passed - As User is able to buy the avaibale Quantity of Energy and Proper Confirmation Message is displayed after purchase.

**Note**:The avaliable options are , Gas , Electricity and Oil.  Screenshots Attached Seperately.

-------------------------------------------------------------------------------------------------------------------------------------------
# Test Case 3, UI - ID - TC03 , Title : Validate the output for Large number of Purchase Quantity
**Description** : When the user visits the url , the Page should fully load and User should be able to Navigate to "Buy Some Energy" Tab and user should be able to buy different types of fuels with Large quantity or should get warning message for the Limited Quantity.
**Pre-Requisite** : User should be Authorised user to access url, https://ensekautomationcandidatetest.azurewebsites.net/ 
**Steps**: User visits the url, https://ensekautomationcandidatetest.azurewebsites.net/  , check the web page for Ensek Loads fully and propely,Then User clicks on "Buy Some Enery" tab. Then the user see the different types options to buy the energy with available Quantity. Then User enter's the Large number ( ex: 1000000000) of required quantity to buy in each filed and clicks Buy option and gets the confirmation message or Warning Message.
**Expected Outcome**: User should be able to buy the avaibale Quantity of Fuel/Energy or Warning Message should be displayed due to Large Quantity.
**Actual Outcome** :Test Case Failed - As No warning Message is displayed and got Server Side error ( Data validation error)
**Evidence**: Screenshot attached


