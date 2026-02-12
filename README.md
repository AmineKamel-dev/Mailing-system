# Mailing-System 📬  
A Spring Boot Backend Mailing System Template

##  Project Overview
A Spring Boot-based backend template designed for sending emails.  
This project serves as a reusable starting point for any Java application requiring automated email functionality — such as notification systems, password resets, newsletters, or system alerts. 

---

##  Tech Stack
- **Java** (Spring Boot framework)  
- **Maven** for project management  
- **Spring boot** + **Spring-mail** (`spring-boot-starter-mail`) for email support  
- SMTP protocol for sending mail  

---

##  Prerequisites
Before running this project, ensure you have:

- Java JDK 17 or newer  
- Maven installed on your system  
- Valid SMTP credentials (Gmail, Outlook, SendGrid, or custom SMTP server)

Spring Boot will use these to send emails. 
You should configure settings in `application.properties` .

---

## ⚙️ Configuration
Update the **mail settings** in `src/main/resources/application.properties` like the example below:

```properties
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=yourEmailPassword

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
