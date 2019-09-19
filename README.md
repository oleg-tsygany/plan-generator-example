# plan-generator-example

This is simple project which demonstrate how to calculate repayment plan as unencumbered REST service.

### What you’ll need to run this service
* A favorite text editor or IDE
* JDK 1.8 or later
* Maven 3.2+

You can also import the code straight into your IDE:
* Spring Tool Suite (STS)
* IntelliJ IDEA

### Build an executable JAR
You can run the application from the command line with Maven. You can also build a single executable JAR file that contains all the necessary dependencies, classes, and resources and run that. Building an executable jar so makes it easy to ship, version, and deploy the service as an application throughout the development lifecycle, across different environments, and so forth.

You can run the application by using ```./mvnw spring-boot:run```. Alternatively, you can build the JAR file with ```./mvnw clean package``` and then run the JAR file, as follows:

```java -jar target/plan-generator-example-0.1.0.jar```

### Test the service
Now that the service is up, you can use endpoint http://localhost:8080/generate-plan to feed initial data. The most convenient way is to use ```curl``` from command line as follows:

```$ curl  -H "Content-Type: application/json" -d'{"duration":24,"nominalRate":5,"startDate":"2018-01-01T00:00:01Z","loanAmount":5000}'  http://localhost:8080/generate-plan```

After that you wil able to see output of REST service as JSON like:
```{"payments":[{"borrowerPaymentAmount":219.36, "date":"2018-01-01", "initialOutstandingPrincipal":5000.0, "interest":20.83, "principal":198.53, "remainingOutstandingPrincipal":4801.47},.....```
