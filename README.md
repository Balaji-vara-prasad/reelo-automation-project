# Reelo Campaign Automation | Selenium + Java + TestNG

This project automates the end-to-end workflow of creating and testing a Campaign on **dev.reelo.io**, as part of the assignment provided by Reelo.

The automation covers:
1. Login with valid credentials  
2. Completing the onboarding flow  
3. Navigating to the Campaigns module  
4. Selecting a predefined campaign template  
5. Selecting SMS as the communication channel  
6. Configuring campaign details  
7. Sending a test SMS  
8. Saving & exiting the campaign setup  

---

## 🚀 Tech Stack

- **Java 11+**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **WebDriverManager**
- **Page Object Model (POM)**

---
## 📂 Project Structure

reelo-automation
│── pom.xml
│── testng.xml
└── src
└── test
└── java
└── com.reelo
├── pages
│ ├── BasePage.java
│ ├── LoginPage.java
│ ├── OnboardingPage.java
│ ├── CampaignsPage.java
│ └── CampaignEditorPage.java
└── tests
└── SignInToCampaignAndTest.java

📝 Assignment Requirements Covered

✔ Automated account login
✔ Handled onboarding sequence
✔ Navigated to Campaigns module
✔ Selected predefined campaign template
✔ Selected SMS as communication channel
✔ Added custom title
✔ Entered contact number
✔ Modified SMS content with user name
✔ Executed “Test Campaign”
✔ Successfully triggered SMS to mobile device
✔ Saved & exited campaign

📸 Required Submission Artifacts

Screenshot of received SMS (message containing your name)

GitHub project link (this repository)

Screen recording of the entire automation run

🙌 Author

P Balaji Vara Prasad
SDET / QA Automation Engineer
Java | Selenium | TestNG | Automation Frameworks

