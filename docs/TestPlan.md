# ENSEK QA Technical Test — Test Plan

**Test Plan ID:** EK001  
**Author:** Mandar Karekar (QA Engineer)  
**Timebox:** 48 hours from receipt  
**Web App (UI):** https://ensekautomationcandidatetest.azurewebsites.net/  
**API (Swagger):** https://qacandidatetest.ensek.io/

---

## 1. Introduction & Purpose
This test plan defines the scope, approach, and deliverables for validating the ENSEK Candidate Test Application.

The system has two parts:
- **Web UI** — public site with pages such as Home, About, Contact and the **Buy Energy** flow (plus Register/Login links shown in the header).
- **REST API** — endpoints for listing fuels/energy, buying energy, viewing orders, and (if provided) resetting test data.

The aim is to confirm that typical user workflows function correctly and that invalid inputs are handled gracefully. Testing will combine **manual execution** (one UI test case with evidence) and **API automation** to demonstrate engineering capability.

---

## 2. Objectives
- Verify **Buy Energy** works and UI feedback is correct.  
- Validate **API endpoints** for correctness (status codes, schema/fields), data integrity (orders list reflects purchases), and error handling.  
- Demonstrate **API automation** (Java + RestAssured + TestNG) and provide clear evidence.  
- Provide well-structured documentation (plan, strategy, cases, data, evidence) in the GitHub repository.

---

## 3. Scope

### In Scope
**UI (manual focus)**
- Home, About, Contact page visibility
- **Buy Energy** page: entering quantity, submitting, and observing feedback
- Basic navigation (header links)
- (Optional) Register/Login visibility only

**API (automation focus)**
- `GET /ENSEK/energy`  
- `PUT /ENSEK/buy/{id}/{quantity}`  
- `GET /ENSEK/orders` and `GET /ENSEK/orders/{orderId}`  
- (If present) `POST /ENSEK/login`, `POST /ENSEK/reset`  
- Negative/edge cases (invalid IDs/quantities, etc.)

### Out of Scope
- Performance/load, penetration/security testing, accessibility, full cross-browser/device matrix, production deployment tasks.

---

## 4. Test Items
- **UI features:** Navigation (Home/About/Contact), **Buy Energy** flow, basic page content.  
- **API resources:** Energy catalogue, buy operation, orders listing/detail, optional login/reset.

---

## 5. Test Approach
- **Manual UI:** Execute one representative scenario on **Buy Energy** (happy path). Capture screenshots and record results in `docs/TestEvidence.md`.  
- **API Automation:** Java 17 + Maven + TestNG + **REST Assured**.  
  - Discover fuel IDs via `GET /energy`.  
  - Buy a small quantity for **each** fuel via `PUT /buy/{id}/{quantity}`.  
  - Verify new orders appear in `GET /orders` with expected fields.  
  - Compute and report **count of orders created before today**.  
  - Add negative tests (0, negative, excessive quantity; non-existent fuel ID; malformed inputs).  
- **Evidence:** Surefire output + README run steps; screenshots and manual results in `docs/`.

---

## 6. Test Levels & Types
- **Levels:** API (primary, automated), UI (sanity/manual), light integration sanity (API → UI consistency where applicable).  
- **Types:** Functional (positive/negative), basic non-functional checks (status codes, simple latency observation), data integrity.

---

## 7. Entry & Exit Criteria
**Entry**
- Web app and API are reachable and stable.
- Test data approach agreed (see Section 10).

**Exit**
- Planned API scenarios (happy + representative negatives) automated and passing locally.
- One UI test executed with evidence and screenshots.
- Defects (if any) logged with clear repro steps.
- README explains how to run tests; repository is tidy and shareable.

---

## 8. Test Environment
- **UI URL:** https://ensekautomationcandidatetest.azurewebsites.net/ (Chrome latest)  
- **API Base:** https://qacandidatetest.ensek.io/  
- **Local:** VS Code/IntelliJ, Java 17, Maven, TestNG, REST Assured  
- **Optional tools:** Postman for quick exploration; Selenium WebDriver for a small UI sanity if time allows.

---

## 9. Roles & Responsibilities
- **Mandar Karekar (QA):** Test planning, test design, manual execution, API automation, evidence collection, defect logging, and reporting.

---

## 10. Test Data
- **Fuel IDs** discovered dynamically via `GET /ENSEK/energy`.  
- **Quantities:** representative set — `1, 3` (valid), `0, -1` (invalid), `999999` (excessive), and a non-numeric attempt for negative coverage (where applicable).  
- **Data files:**  
  - `docs/TestData.xlsx` (structured sheet of test inputs/expected outcomes)  
  - `docs/TestData.md` (quick Markdown table for instant visibility)

---

## 11. Risks & Mitigations
| Risk | Mitigation |
|------|------------|
| Shared/dirty environment affecting data | Use small quantities; re-query state; use reset endpoint if available |
| Flaky network / transient failures | Small bounded retry on reads (if needed); rerun verification |
| Timebox pressure | Prioritize API automation and one solid UI scenario; keep UI automation minimal |
| Schema or timestamp format surprises | Inspect responses early and adapt JSONPath parsing accordingly |

---

## 12. Suspension & Resumption Criteria
- **Suspend** testing if the environment is unavailable for >1 hour or core endpoints repeatedly fail (5xx) across attempts.  
- **Resume** when endpoints are reachable and stable; document downtime in `docs/TestEvidence.md`.

---

## 13. Deliverables
- `docs/TestPlan.md` (this document)  
- `docs/TestStrategy.md` (how testing is approached)  
- `docs/TestEvidence.md` (+ `/screenshots`) — manual UI execution results  
- `docs/TestData.xlsx` (+ `TestData.md`) — test inputs & expectations  
- `docs/DefectLog.md` — defects with ID, title, steps, expected/actual, severity, evidence link  
- `src/test/java/apiTests/*` — API automation code (REST Assured + TestNG)  
- (Optional) `src/test/java/uiTests/*` — small Selenium sanity  
- `README.md` — project overview & run instructions

---

## 14. Reporting
- **Automation:** Maven Surefire/TestNG output; optional HTML report (Allure/Extent) if time permits.  
- **Manual:** `docs/TestEvidence.md` with screenshots and pass/fail.  
- **Defects:** `docs/DefectLog.md` (table format).

---

## 15. Schedule (48-hour indicative)
- **T0–T8h:** Finalize plan/strategy; scaffold Maven; prove API connectivity.  
- **T8–T24h:** Automate happy paths; start negative cases.  
- **T24–T36h:** Execute UI scenario; capture evidence; complete negatives.  
- **T36–T48h:** Clean up, finalize docs, rerun, push, share access.

