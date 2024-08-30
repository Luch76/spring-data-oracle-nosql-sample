# spring-data-oracle-nosql-sample

The Spring Data Oracle NoSQL Sample Application demonstrates how to easily use Oracle NoSQL databases in OCI using the [SDK for Spring Data for Oracle NoSQL Database](https://github.com/oracle/nosql-spring-sdk).

You may also view the SDK documentation here: https://docs.oracle.com/en/database/other-databases/nosql-database/23.1/springsdk/spring-sdk1.html

See the following implementation references for creating a Spring Data style access to Oracle NoSQL database:
- [Book POJO](./src/main/java/com/example/Book.java)
- [Book Repository](./src/main/java/com/example/BookRepository.java)
- [Book RestController](./src/main/java/com/example/BookController.java)
- [NoSQL configuration](./src/main/java/com/example/NoSQLConfig.java)


### Running the tests

Prerequisites:
- Java 21+
- Maven
- Access to an OCI account. If you don't have an account, you can sign up here: https://signup.oraclecloud.com/. This tutorial runs within the bounds of the Always-Free tier of OCI.
- A NoSQL table in your OCI account named "books", with the following schema:

| Column           | Type    |
|------------------|---------|
| id (primary key) | integer |
| title            | string  |
| author           | string  |
| price            | double  |

Run the tests with Maven, which will insert, update, query, and delete records from the "books" NoSQL table. 

```shell
mvn integration-test
```