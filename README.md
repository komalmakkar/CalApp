# Spring Boot Cal App
```
Design a calendar service that can create events for users.

Mandatory Requirements:

Users can enter their shift timings (working hours) or create busy slots. It’s possible for users to have more than one shift in a day. [multishift to be added]
Users can fetch events of themselves and other users. [done]
Users can create events with other users for a defined start time and end time and delete events created by themselves. [done]
Organizer of an event can fetch the most favorable upcoming empty slot for a given set of users and a particular duration. [TBD]

For instance user A would like to check the favorable slot with user B, user C to set an event of 4 hours duration. This would require user A to check the upcoming events in his/her calendar as well as for user B, user C.

Users can fetch events where they have conflicts for themselves for a particular day.

Bonus Extensions:

Organizers can have the capability to create recurring events in future for a specific number of times. Recurring events will have the exact same start and end time of day with the same set of users.
Guidelines:

Use any IDE
Write a driver class for demo purposes. Which will execute all the commands in one place in the code and have test cases.
You can print the output in the console. Do not create any UI for the application.
Please prioritize code compilation, execution, and completion
Work on the expected output first and then add bonus features last.
Expectations:

Your code should cover all the mandatory functionalities explained above.
Your code should be executable and clean.
Your code should be properly refactored, and exceptions should be gracefully handled.
Please add any assumptions taken in a README file.
How will you be evaluated?

Code should be working.
Code readability and testability
Separation Of Concerns
Object-Oriented concepts.
Language proficiency.
Scalability
Test Coverage
Concurrency handling(Bonus Points)
At the end of the completion of 105 min, please mail the zipped code to nikita.futur.con@phonepe.com and shivani.sahraot@phonepe.com. Any delays in submission than 120 min will lead to disqualification
[execution time limit] 3 seconds (java)

[memory limit] 1 GB
```

## How to Run Application

**Start the application using any of the commands mentioned below**

> **Note:** First two commands need to run inside the root folder of this project i.e inside the **spring-boot-hello-world** folder


- **Using maven** <br/>``` mvn spring-boot:run```


- **From jar file**
  Create a jar file using '**mvn clean install**' command and then execute
  <br/>```java -jar target/spring-boot-2-hello-world-1.0.2-SNAPSHOT.jar```


- **Directly from IDE**
  <br/>```Right click on HelloWorldApplication.java and click on 'Run' option```
  <br/><br/>

> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.properties** file that is available inside the **src > main > resources** folder.

<br/>




# Sample CURL Commands 
```
curl --location --request PUT 'http://localhost:8080/user/' \
--header 'Content-Type: application/json' \
--data '{
    "userName": "Komal3"
}'
```

```
curl --location --request PUT 'http://localhost:8080/user/d4f58e73-1219-42ea-88ad-b77b0b1a7dd1/Event/' \
--header 'Content-Type: application/json' \
--data '{
    "participants": [
        "821d1a5c-daf9-4565-aa47-4287551956a3"
    ],
    "StartHour": 1,
    "EndHour": 5
}'
```

```
curl --location --request DELETE 'http://localhost:8080/user/d4f58e73-1219-42ea-88ad-b77b0b1a7dd1/Event/f862adcc-1298-4b05-84ce-d8675930ca7f' 
```

```
curl --location 'http://localhost:8080/user/d4f58e73-1219-42ea-88ad-b77b0b1a7dd1/Event/Conflict'
```
