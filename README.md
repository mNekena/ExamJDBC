To safekeep the credentials, we can use env variables.
Using the proper dependency:
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>

We create a .env file at the root of the project, and add the corresponding variables:
DB_URL=jdbc:postgresql://localhost:5432/bank
DB_USER=mnekena
DB_PASSWORD=pwd

Then in the actual code, we use the variable names instead
String url = System.getenv("DB_URL");
String user = System.getenv("DB_USER");
String password = System.getenv("DB_PASSWORD");
Connection conn = DriverManager.getConnection(url, user, password);
