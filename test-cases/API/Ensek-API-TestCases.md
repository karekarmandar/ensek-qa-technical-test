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

  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

   ## ENSEK-API-TC002 — Orders list returns each created order with expected details

**Goal**  
After TC001 buys a small quantity of each in-stock for different fuels, verify that **every** created order appears in `/ENSEK/orders` with the correct fields and values.

**Dependency on**  
- TC001 has run and captured the data for each successful purchase (energy id, quantity, optional order id).

**Endpoints**  
- Get : https://qacandidatetest.ensek.io/ENSEK/orders (list all orders)

**Pre-requisites**  
- User must have a list `createdOrders[]` from TC001 with one entry per purchase:  
  `[{ energy_id, quantity, orderId?, createdAtStart, createdAtEnd }]`  

  **Test Data**: the details are used form TC01 results
-Gas Purchase: "You have purchased 2957 m³ at a cost of 5.1000000000000005 
-there are 15 units remaining. 
-Your order id is a5a74d3e-248a-4daa-9eea-92b44632ff6b."

-Electric Purchase: "You have purchased 2 kWh at a cost of 0.94 
-there are 4305 units remaining. 
-Your order id is a4d0c8eb-ec41-47e1-98e6-9e6d2c2da342."
  
-Oil Purchase: "You have purchased 1 Litres at a cost of 0.6 
-there are 3 units remaining. 
-Your orderid is 73db236d-991b-4891-a2b9-9236ebe276f0."
 

**Steps**
1. **Fetch orders list**  
   - Send `GET /ENSEK/orders`, to fetch all the orders.
   - Expect `200 OK` and a JSON array.


2. **Validate fields for each created order**  
   - Use Order id from Test data to fecth the order.
   For each `createdOrders` validate : 
   - **ID:** 
   - **Fuel:**   
   - **Quantity** 
   - **Timestamps**
   

**Expected outcome (why)**  
- Every order you created in TC001 must appear in `/orders` **because** creation is a server-side persistence action; the list endpoint is the system of record.  
- Each order’s **energy_id** and **quantity** must match the request you sent (correctness of write), and pricing/timestamps must be consistent (data integrity).
  

- **PASS:** All created orders are present exactly once and all assertions above succeed.  

**Evidence**  
- Screenshot attached.


 
