**Test Case 1**

**ID: UI-TC01**
**Title**: Validate Home Page loads properly and all the Headers, Navigation links, Buttons are visible.

**Description**: When the user visits the URL, the page should fully load and display all the headers, navigation links, tabs, and logo text. Elements such as Logo, Home tab, About tab, Contact tab, Register, Log in, hero banner, Buy energy/Sell energy tab, and About Us should be visible with correct information.

**Pre-Requisite**: User should be an authorized user to access URL → Ensek App

**Steps**:

Visit the URL.

Verify the page loads fully.

Check visibility of Logo, Home, About, Contact, Register, Log in tabs.

Verify hero banner, Buy energy/Sell energy, About Us cards are visible.

**Expected Outcome**: All headers, navigation links, and cards are displayed properly.

**Actual Outcome**:  Test Case Passed – page loads correctly and all elements are displayed.

**Note**: Screenshots attached separately.

Test Case 2

ID: UI-TC02
Title: Validate Buy Quantity of each fuel

Description: User should be able to navigate to "Buy Some Energy" tab and purchase different types of fuels.

Pre-Requisite: User should be an authorized user to access URL.

Steps:

Visit the URL.

Navigate to Buy Some Energy tab.

View available energy options and quantities.

Enter required quantity in the input fields.

Click Buy and verify confirmation.

Expected Outcome: User is able to buy available fuel quantity and gets a confirmation message.

Actual Outcome:  Test Case Passed – User is able to buy energy and confirmation message is displayed.

Note: Options available – Gas, Electricity, Oil. Screenshots attached separately.

Test Case 3

ID: UI-TC03
Title: Validate output for large number of purchase quantity

Description: User should be able to buy large quantities of fuels or see a warning message for exceeding limits.

Pre-Requisite: User should be an authorized user to access URL.

Steps:

Visit the URL.

Navigate to Buy Some Energy tab.

Enter a very large number (e.g., 1000000000) as purchase quantity.

Click Buy.

Expected Outcome: Either purchase is successful within limit, or warning message is displayed for exceeding limit.

Actual Outcome:  Test Case Failed – No warning message displayed, server-side error occurred (Data validation issue).

Evidence: Screenshot attached.

Test Case 4

ID: UI-TC04
Title: Validate new user registration

Description: User should be able to navigate to Register, fill details (email, password), and register as a new user.

Pre-Requisite: User should be an authorized user to access URL. Password must be alphanumeric.

Steps:

Visit the URL.

Navigate to Register tab.

Enter email, alphanumeric password, confirm it.

Click Register.

Expected Outcome: User should be registered and see confirmation or warning message.

Actual Outcome:  Test Case Failed – No outcome or message after submission.

Evidence: Screenshot attached.

Suggestion: Registration should include additional fields (Name, Last Name, DOB, Address) for security.

Test Case 5

ID: UI-TC05
Title: Validate “Sell Some Energy” page displays key elements/information

Description: User should be able to navigate to Sell Energy tab and view all required information.

Pre-Requisite: User should be an authorized user to access URL.

Steps:

Visit the URL.

Navigate to Sell Energy tab.

Verify all required information is displayed.

Expected Outcome: All correct information should be displayed.

Actual Outcome:  Test Case Failed – Page only shows “Maintenance” banner, with no date or time.

Suggestion: Add date/time to indicate maintenance duration.

Evidence: Screenshot attached.

Test Case 6

ID: UI-TC06
Title: Validate “Contact” page displays key elements/information

Description: User should be able to view all required contact information.

Pre-Requisite: User should be an authorized user to access URL.

Steps:

Visit the URL.

Navigate to Contact page via navigation link.

Verify presence of contact email, address, and phone.

Expected Outcome: All correct and necessary contact details are displayed.

Actual Outcome:  Test Case Failed – Page shows “Erorr” banner (misspelled), and no contact details provided.

Suggestion: Correct spelling and add contact information for customer support.

Evidence: Screenshot attached.

Test Case 7

ID: UI-TC07
Title: Validate “Forgot Password” functionality

Description: User should be able to click “Forgot Password” link, enter registered email, and receive a password reset link.

Pre-Requisite: User should be registered and authorized.

Steps:

Visit the URL.

Navigate to Login page.

Look for Forgot Password link.

Enter registered email.

Verify reset password link is sent.

Expected Outcome: “Forgot Password” link is visible and confirmation message is shown after entering email (e.g., Password reset link sent to your email).

Actual Outcome:  Test Case Failed – No “Forgot Password” link present.

Suggestion: Add a visible “Forgot Password” link on login page.

Evidence: Screenshot attached.
