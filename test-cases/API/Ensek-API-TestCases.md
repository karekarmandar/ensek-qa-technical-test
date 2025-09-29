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
  

**Steps**
1. **Fetch orders list**  
   - Send `GET /ENSEK/orders`, to fetch all the orders.
   - Expect `200 OK` and a JSON array.

2. **Filter to this test run**  
   - If your `createdOrders` entries have `orderId`, match directly by `id == orderId`.  
   - If not, match by tuple `(energy_id == <id> AND quantity == <q>)` and, if the schema includes a timestamp, ensure it’s between `createdAtStart` and `createdAtEnd`.

3. **Validate fields for each created order**  
   For each `createdOrders[i]`:
   - **Presence:** Exactly **one** matching order exists in the list.  
   - **Identity:** `energy_id` equals the one you bought; `quantity` equals the one you sent.  
   - **Pricing (if present):** `totalPrice == unitPrice * quantity` within ±0.01.  
   - **Timestamps (if present):** `createdAt ∈ [createdAtStart, createdAtEnd]` and `createdAt ≤ now()`.  
   - **Schema sanity:** Required fields are non-null; types match Swagger (e.g., numbers are numbers).

4. **(Optional) Fetch by id**  
   - For any entry where you stored `orderId`, call `GET /ENSEK/orders/{orderId}` and repeat the checks above for that single resource.

**Expected outcome (why)**  
- Every order you created in TC001 must appear in `/orders` **because** creation is a server-side persistence action; the list endpoint is the system of record.  
- Each order’s **energy_id** and **quantity** must match the request you sent (correctness of write), and pricing/timestamps must be consistent (data integrity).

**Pass / Fail criteria**  
- **PASS:** All created orders are present exactly once and all assertions above succeed.  
- **FAIL:** Any missing order, duplicate, mismatched field, wrong math, or out-of-range timestamp. Log a defect with the exact request/response bodies.

**Evidence**  
- `evidence/api/ENSEK-API-TC002/orders_all.json` (GET /orders response)  
- `evidence/api/ENSEK-API-TC002/order_<orderId>.json` (optional per-order fetch)  
- Screenshot(s) of Postman Tests tab with green checks.


 
