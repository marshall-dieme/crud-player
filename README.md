
# SpringBoot Team - Player CRUD

This is a project used to explain how to use EntityManager with JPA in the SpringBoot framework

## How to use
These are the different steps to make your application run in local :

    1- Clone the repository with th command : 
        git clone https://github.com/marshall-dieme/crud-player.git

    2- Open the project in your favorite IDE (vs code, intellij, eclipse)

    3- Create the application.properties file in /src/main/resources

    4- Add the database configuration in the application.properties file
        spring.datasource.url= jdbc:mysql://localhost:3306/<database_name>
        spring.datasource.username=<database_user>
        spring.datasource.password=<database_password>
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true

    5- Run the Springboot application


### Thank you 

