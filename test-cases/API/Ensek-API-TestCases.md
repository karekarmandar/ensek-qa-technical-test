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
  - To ge the list of fuel : https://qacandidatetest.ensek.io/ENSEK/energy 
  - To purchase Gas : https://qacandidatetest.ensek.io/ENSEK/buy/1/15  
  - To purchase Electricity : https://qacandidatetest.ensek.io/ENSEK/buy/3/2 
  - To purchase Oil :  https://qacandidatetest.ensek.io/ENSEK/buy/4/1 
  - To get the list of all oders: https://qacandidatetest.ensek.io/ENSEK/orders

**Steps**  
1. **Discover stock**  
   - Send `GET /ENSEK/energy`.  
   - Confirm `200 OK` and capture the list of fuels with their `id`, `price` and `quantityAvailable`.  
   - Build a list of items where `quantityAvailable > 0`.  

2. **Buy each fuel** (repeat for every in-stock item)  
   - For item `{id, quantityAvailable}`, send  
     `PUT /ENSEK/buy/{id}/1` (example: `/ENSEK/buy/1/1`).  
   - Expect `200 OK` and a confirmation message (may include an order id).  
   - Record `{energy_id: id, quantity: 1, orderId?}` for verification.

3. **(Optional) Verify stock decrement**  
   - Send `GET /ENSEK/energy` again and confirm that each purchased item’s `quantityAvailable` decreased by the amount bought.

**Expected outcome**  
- Each `PUT /ENSEK/buy/{id}/1` for an in-stock fuel returns **`200 OK`** with a success message.  
- (If step 3 executed) Stock for each purchased fuel is reduced by `1`.  
- No purchase is attempted for fuels with `quantityAvailable == 0`.

**Actual outcome**  
- _To be filled during execution (status codes, messages, any discrepancies)._  

**Evidence**  
- `evidence/api/ENSEK-API-TC001/energy_before.json`  
- `evidence/api/ENSEK-API-TC001/buy_<id>.json` (one per purchase)  
- `evidence/api/ENSEK-API-TC001/energy_after.json` (optional)

**Notes**  
- If the success message reports an incorrect “purchased amount” while orders/stock are correct, raise a **Minor content defect**; do not fail the functional test on message text alone.  
