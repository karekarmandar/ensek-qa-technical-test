## ENSEK-API-TC001 — Buy a quantity of each available fuel

**Goal**  
Validate that a user can purchase a small quantity of **each in-stock fuel**, and that the API returns success and records the orders.

**Endpoints**  
- `GET  https://qacandidatetest.ensek.io/ENSEK/energy` — list fuels/stock  
- `PUT  https://qacandidatetest.ensek.io/ENSEK/buy/{id}/{quantity}` — buy fuel  
- `GET  https://qacandidatetest.ensek.io/ENSEK/orders` — verify orders 

**Pre-requisites**  
- Valid base URL and network access.  
- Authorised User  
- Postman (or equivalent tool).  
- Note: No request body is required for the `PUT` call; values are path parameters.

**Test data**  : 
  - To get the list of fuel : https://qacandidatetest.ensek.io/ENSEK/energy 
  - To purchase Gas : https://qacandidatetest.ensek.io/ENSEK/buy/1/15  
  - To purchase Electricity : https://qacandidatetest.ensek.io/ENSEK/buy/3/2 
  - To purchase Oil :  https://qacandidatetest.ensek.io/ENSEK/buy/4/1 
  - To get the list of all oders: https://qacandidatetest.ensek.io/ENSEK/orders

**Steps**  
1. **Discover stock**  
   - Send `GET Request' from the Test data  to get list of all the Fuels
   - Confirm `200 OK` and capture the list of fuels with their `id`, `price` and `quantityAvailable`.  
   - Build a list of items where `quantityAvailable > 0`.  

2. **Buy each fuel** (repeat for every in-stock item)  
   - Send 'PUT Request' from the Test Data to appropriately To purchase different types of Fuels with ID
   - Expect `200 OK` and a confirmation message (may include an order id).  
   - Record `{energy_id: id, quantity: 1, orderId?}` for verification.
     

3. **(Optional) Verify stock decrement**  
   - Send `GET /ENSEK/energy` again and confirm that each purchased item’s `quantityAvailable` decreased by the amount bought.

**Expected outcome**  
- Each Get Request should display proper iformation about the fuel, such as : Type, id, quantity, Unit type.
- Each `PUT Request' should returns **`200 OK`** with a success message, depending on the quanity.
- (If step 3 executed) Stock for each purchased fuel is reduced by `1`.  
- No purchase is attempted for fuels with `quantityAvailable == 0`.

**Actual outcome**  
- Each Get Request displays proper iformation about the fuel, such as : Type, id, quantity, Unit type.
- Each `PUT Request' returns **`200 OK`** with a success message.
- ( step 3 executed) Stock for each purchased fuel is reduced by `1`.  

**Evidence**  
- Screenshots Attached Seperately.

 
