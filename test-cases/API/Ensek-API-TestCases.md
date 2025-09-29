## ENSEK-API Test Cases.

**ID - TC001, Title :Validate the API response when User Buy's a quantity of each fuel.**
**Description**:  User hits the given end point to buy different types of Fuels, user enters all the required information and user is able to buy the different types of fuels with available quantity and with the confirmation message.
**Pre-Requisite** : Authorised User, valid end point, check the available quantity before buying, Postman tool, Correct Fuel id.
**Steps** : user hits the endpoint to check the Qutantity of the Fuels , https://qacandidatetest.ensek.io/ENSEK/energy, Then User can see the Available quantity of all the Fuel and then user decides to buy the different quantity for each fuel. The end points to buy different fuel are with correct id's are:
a.) to purchase 15 units of  Gas, PUT request : https://qacandidatetest.ensek.io/ENSEK/buy/1/15   
b.) to purchase 2 Units of Electircity , Put request : https://qacandidatetest.ensek.io/ENSEK/buy/3/2
c.) to purchase 1 Unit of Oil , Put request: https://qacandidatetest.ensek.io/ENSEK/buy/4/1
**Expected Outcome**: 1. All the different types of fuels should be displayed with Available Quantity, ID, Price, Unit type.
                        2. Customer should get 200k(Success) Response in Postman. 
**Actual Outcome**: 1. All the different types of fuels are displayed with Available Quantity, ID, Price, Unit type.
                    2. Also got the 200k(Success) Response in Postman. 
**Notes** : Screenshots are attached Separately.                    
