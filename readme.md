### Changes Made as part of the challenge

- Added Unit test cases
- Fixed issue in save employee endpoint by adding @RequestBody
- Added Spring Security dependency to protect the API with credentials
- Implemented Simple cache mechanism to cache database calls
- Added comments for the classes as required
- Implemented logging using Spring AOP

### Build and Run the Application

- Run `mvn spring-boot:run` for starting the application (or use your IDE)
- use java 8
- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

### My experience in Java

- I have 8+ years experience in Java and Spring Boot
- I have been using Spring and Spring Boot for the last 8+ years of my career
- My Tech Stack
  * Java, Spring Core, Spring Boot, Spring Security, Spring AOP, PostgreSQL, REST API
  * JUnit, Mockito
  * Apache HDFS, Apache Hive, Apache HBase, Apache Kafka
  * Gradle, Maven, Git, BitBucket, JIRA, Bamboo Build, Agile - SCRUM
  * Code Quality: SonarQube

### Improvements

- Cache can be implemented with Cache Provider,so that we can use cache efficiently (e.g., TTL)
- Add more profiles for test, dev and prod
- Implement spring security based on database or ldap auth provider instead of in-memory authentication
- Implement metrics and use it in visualization tool (e.g., grafana) for better analysis
