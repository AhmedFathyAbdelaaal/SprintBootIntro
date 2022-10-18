# SprintBootIntro
A simple CRUD program that utilized Springboot &amp; postgres to be ran. &amp; is written in Java.

## Content of This Github Repository:
	-demo.zip : the initial project we started with that was downloaded from Spring Initializr.  
	-DemoApplication.java : main file we use to run the API.  
	-pom.xml : our xml file that has our dependancies. Spring Initializr made for us.  
	-application.properties : our properties file we use later on to define the data base we connect to.
	-student folder : Folder contains a few files:  
		-Student.java : our student class that has setters, getters, constructors of our student data.  
		-StudentConfig.java : our Configuration file. has our initial starting data for our data base.  
		-StudentController.java : Our RestController that controls our API & calls for the functions neccessary.  
		-StudentRepository.java : Our Repository.  
		-StudentService.java : Our Service Layer providing functionality for our API.  

## What Are We Doing?  

We are going to be building an application. It excludes any front end dev requirements, going to be fully back end. 

##The API will recieve GET, POST, PUT & DELETE requests & act on them. (Basic CRUD functions)

We will also have a Service Layer, wwhich will handle business logic.

Then we have a Data Access Layer, it is responsible for connection to our data base

Then finally our database being connected to, using Postgresql.

## To start:

Head to Spring  Initializr: 

	https://start.spring.io/

	We are using a Maven Project.

	Our Language is Java.

	You can use the latest stable Spring Boot. (For me Spring Boot 2.7.4)

	as for the project metadata you can leave it as is or change it to your liking. Packaging of course is Jar or War, whichever you can extract. for me i used War.

	And i used Java 18 as it is the version i was using, but you can use whichever you have.

	For the Dependancies we need a few Dependancies:
		1. Spring Web.
		2. Spring Data JPA. (Connection to our database is going to be through JPA & Hibernate).
		3. PostgreSQL Driver. (For PostgreSQL Compatability since we are using it).

### I will be linking a link to do the Spring Initializr Step for you incase any issues arise.
Link : https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.7.4&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web,data-jpa,postgresql

#### Generate your Spring Folder. Download it & Extract it where you want it to be.

## NEXT: We open it using Intellij. I Used Intellij Community Edition. 

Expand it, and you will see a file named pom.xml. it has the project meta data & the dependencies we chose earlier. and a testing dependency given to us by spring boot itself.  
The file also includes the java version you use in the properties tag and project details all at the top.
  
In the top the Parent is spring-boot-starter-parent given us also by spring boot itself to make it run.
  
### Starting the application is  easy.
  
From demo expand src. test folder is for testing purposes. main folder is what we are going to be interested in.
  
in main expand java. in java there is the DemoApplication or <name>Application depending on which name you gave your project. thats the file we will be running to start our app.
  
Inside the DemoApplication or <name>Application file is a very empty and simple Spring Boot Application.
  
In the main folder again, in the resources folder there exists a file named application.properties, this is where we can configure all the properties for our application and environment specific properties. This will be expanded further. 
The static and Templates folders in the resources folder are for web development purposes. (HTML CSS and such).
  
Run DemoApplication/<name>Application
  
It will fail, because it will try connecting to a database but we dont have one yet. so we have to remove the connection related dependancy to be able to run it for now.
  
To make it run for now, go to pom.xml
  
One of the dependancies with the artifactId of "spring-boot-starter-data-jpa" that whole dependancy has to be commented out so it will go from:  
	 
```html
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
		
TO:

<!--
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
-->
```
Then to make sure it applied you have to right click on pom.xml & hover over maven, then click on "reload project". It should reload automatically eventually but we do this to make sure it does when we want it to.

Now we run it we shouldnt face any issues or any exit codes.

#### logs will look something like this:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.4)

2022-10-17 16:25:00.400  INFO 13516 --- [           main] com.example.demo.Demo2Application        : Starting Demo2Application using Java 18.0.2 on [Your LAPTOP ID] with PID 13516
2022-10-17 16:25:00.404  INFO 13516 --- [           main] com.example.demo.Demo2Application        : No active profile set, falling back to 1 default profile: "default"
2022-10-17 16:25:01.680  INFO 13516 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-10-17 16:25:01.689  INFO 13516 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-10-17 16:25:01.690  INFO 13516 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.65]
2022-10-17 16:25:01.796  INFO 13516 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-10-17 16:25:01.796  INFO 13516 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1308 ms
2022-10-17 16:25:02.239  INFO 13516 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-10-17 16:25:02.251  INFO 13516 --- [           main] com.example.demo.Demo2Application        : Started Demo2Application in 2.477 seconds (JVM running for 3.112)
```

on the third line, with tomcat. you will see "Tomcat initialized with port(s): 8080 (http)".
  
The port 8080 is the one our program is connected to right now. This means we are running a webserver and we can access it so see the data by using localhost:8080
  
It will be empty for now but we can have some stuff in it. and Spring Boot returns such stuff in json format, which is good for handling them.
  
So now that we are done with the setup, breif explainations of what happens will be given below.
  
#### our Java code will be simple, 

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
```

infact it will stay as it is. because it works as it is for starting the web server.

Then we have to create a Package. said package will contain the API methods & the data. 

So for the location of the new package, it will be under the "com.example.demo", the folder that containes your demoApplication/<name>Application

we name the package "Student" & in it, we create a "Student" java class.

we Identify above the class with @Entity & @Table

like this:

```java
@Entity
@Table
public class Student {
```

inside the class we also make a sequence.
it is done like so:

```java
	@Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "student_sequence"
    )
```

in the Student Class we just created we initialize our variables we will use. 

```java
	private  long id;
	private  long id;       //student's id 
    private String name;    //student's name
    private String email;   //student's email
    private LocalDate dob;  //student's date of birth
    @Transient
    private Integer age;    //student's age
```

@Transient will help cover age in the database as we dont need it there. & also help when we get to counting the age using the date of birth of the student.

We need constructors for it, we will have three different ones,
1. the nothing constructor:

```java
	public Student() {
    }
```

2. Everything without Age(because we dont need it):

```java
	public Student(long id,
                     String name,
                     String email,
                     LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
```

3. one without age & id: 

```java
	public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
```

We also create their setters & getters. 

but in the getAge function we change the inside of it to: 

```java
public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }
```

This will set the age to the correct one according to the date of birth rather than the user giving it.

rest of setters & getters end up looking like this. 

```java
public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    public void setAge(Integer age) {
        this.age = age;
}
```

Then we do the toString() like this:

```java 
	@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
	}
```

Intellij is used to make all of these as it has automatic tools for that, but you can do it yourself. (to make intellij do it: right click then click on generate then choose what you want intellij to create).

And thats the Student class done.

This will only help in storing and getting the data. 

Now we need to create the API Layer:

So we need a controller of Student. so we create a class called "StudentController" this is in the same package as the "Student" class. 

at the begining of it after the imports we add 

```java
@RestController //Makes this class the controller of the API
@RequestMapping(path = "api/v1/student") //The path is the extension we add to localhost:8080 to be able to access our web server data.
```

Inside the StudentController class we call a class we are about to create called "studentService". This function will activate if GET method is used & calls  "studentService" to get the students.

```java
	@GetMapping //the mapping of GET sensor. if we call GET this function will be the one to work.
    public List<Student> getStudents(){
        return  studentService.getStudents();
    }
```

before we continue onto the next Functions we need to establish studentService.

create a class named "StudentService" in the "student" package.  

and to expand on it we need to also quickly create a repository for the students.

also create a file named "StudentRepository" but make it as an interface. this is also in the "student" package.

in the interface we add the @Repository marker above the interface. then we extend the interface to the JpaRepository<Student, Long>

 then inside of it we add "@Query("SELECT s FROM Student s WHERE s.email = ?1")" & "Optional<Student> findStudentByEmail(String email);"
 
the interface code wwill look like this. (without the imports)

```java
	@Repository
	public interface StudentRepository extends JpaRepository<Student,Long> {
		@Query("SELECT s FROM Student s WHERE s.email = ?1")
		Optional<Student> findStudentByEmail(String email);
	}
```

So now onto continuing "StudentService":

we identify it with "@Service" above the class.

then we create a variable connected to the StudentRepository we just created. & add its constructor with "@Autowired" above

it is done like so:

```java
	private final StudentRepository studentRepository;
	@Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
```

after so we do the function to get the students we will save.

it is a function that will return a List<Student>, to return the content of our data we call on "studentRepository.findAll()" to get all students back.

```java
	public List<Student> getStudents(){
        return studentRepository.findAll();
    }
```

So now we need a place for our base students data to be stored. 

we create another class in the "student" package named "StudentConfig".

in it we put "@Configuration" above the class to identify it.

in the class we also add a variable commandLineRunner with data type CommandLineRunner and we have a bracket in it with StudentRepository repository data time. and the return args in it will be our data. it will looks something like this.
we also need add @Bean inside the class above the CommandLineRunner.

```java
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ahmed = new Student(
                    1L,
                    "Ahmed",
                    "Ahmed@gmail.com",
                    LocalDate.of(2001, 5, 14)
            );
            Student mohammad = new Student(
                    2L,
                    "Mohammad",
                    "Mohammad@gmail.com",
                    LocalDate.of(2004, 5, 25)
            );

            repository.saveAll(List.of(ahmed,mohammad));
        };
    }
}
``` 

So there in the StudentConfig we have our starting data. and at the end of it we call repository.saveAll to save the data we created to the repo. Now that we have all our basis ready, also create the rest of the API's functions. POST, DELETE & PUT

for POST we identify it with  @PostMapping and write it like so:

```java
	@PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
``` 

for DELETE we identify it with  @DeleteMapping and write it like so & here we got the StudentID in the link to be used to identify the item to be Deleted:

```java
	@DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentID){
        studentService.deleteStudent(studentID);
    }
``` 

for PUT (the updating) we identify it with @PutMapping and write it like so & here we got the StudentID in the link to be used to identify the item to be Deleted:

```java
	@PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentID") Long studentID, @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentID,name,email);
    }
``` 

All of them call to student Service, the service class responsible for handling them. we are going to go over them one by one also starting with POST.

for POST:

in the studentService class, we create a function addNewStudent(Student student): 

in it we create Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail()).  this will get the field with the email of the person we want to input, if it is already in the systme, we cant create that accound as no two accounts can have the same email so we test that out with isPresent(). if it exists already in the system we return an error message using 

```java
throw new IllegalStateException("email taken");
```

if the email doesnt exist in the repo already we save the current details given. The whole function should look something like this:
```java
	public void addNewStudent(Student student) {
            Optional<Student> studentOptional =  studentRepository.findStudentByEmail(student.getEmail());
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            studentRepository.save(student);
    }
```

for DELETE:

in the studentService class, we create a function deleteStudent(Long studentID): 

Then we have to see if the ID given to be deleted exists and has a student related to it. to do so we create a boolean exists that returns true if it exists. 
it is done with :

```java
boolean exists = studentRepository.existsById(studentID);
```

if ID doesnt exist then we have to return an error message like before with an appropriate message. else we can delete the data using .deleteByID. the final function will look like:
```java
	public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("student with ID " + studentID + " doesnt exist");
        }
        studentRepository.deleteById(studentID);
    }
```

For PUT:

in the studentService class, we create a function updateStudent(Long studentID, String name, String email):

we first check if the student exists with its ID like this:
```java
 Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new IllegalStateException("student with ID " + studentID + " doesnt exist"));
``` 

Then if the name given is different from the one that already exists, we can change it and we do it with .setName. we also have to make sure that the name is not empty and not null. 

The same is done for the email but with the exception of us giving an error if the email is taken by a different user. if the email isnt taken and is valifd we can update is with .setEmail.

At the top of this function we add @Transactional so we can use the setters and getters we want. The function in the end will look like this:

```java
	@Transactional
    public void updateStudent(Long studentID,String name,String email) {
        Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new IllegalStateException("student with ID " + studentID + " doesnt exist"));
        if(name!= null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!= null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
```


Now that we are done with the hefty parts, we now need to set up our PostgreSQL server and connect it to be able to test if it actually works.

in the resources folder we need to go to the application.properties and add the following text:

```
	spring.datasource.url=jdbc:postgresql://localhost:5432/student
	spring.datasource.username=
	spring.datasource.password=12345
	spring.jpa.hibernate.ddl-auto=create-drop
	spring.jpa.show-sql=true
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.jpa.properties.hibernate.format_sql=true
	server.error.include-message=always
```

"spring.datasource.url=jdbc:postgresql://localhost:5432/student" is the url  to the postgresql database we will start later

"spring.datasource.username=
spring.datasource.password=12345" 
are the username & password for the database you will set when creating it.

"
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
"

Gives spring.jpa  its properties.

"
server.error.include-message=always
"
This will allow error messages appear.


After doing so, we have to install PostgreSQL

I will have a seperate document regarding its installation & bugs you may encounter, but here i will only show the main steps we have to do.
 
After installing the latest PostgreSQL, we open the shell, Search SQL on your laptop and open "SQL Shell (psql)". thats the shell for postgresql.
Leave the server as it is.
leave the Database as it is.
keep the port as 5432
keep the username as it is, empty
and key in the password you put in when installing postgres. After so,

Key in: CREATE DATABASE student;
Then pass privellages to it: GRANT ALL PRIVILEGES ON DATABASE "student" TO postgres;
// if encounter issues with cant see user : Then create a ROLE with superuser privilages, the name of the role should be the same as your computer user

key in: \l 

you will see all the databases we have. in our case we should see student in there somewhere.


key in: \c student

to connect to the student databse

key in: \d

To see its relationships.

Now that we did this we can uncomment the dependancy we commented out in the begining in the pom.xml file.

```html
<!--
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
-->
```	
TO:
```HTML
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Then run the program throught demoApplication/<name>Application & your server is working.

Now we can use something like Postman to GET, POST, PUT & DELETE with the link being http://localhost:8081/api/v1/student

For GET we have it as: GET http://localhost:8080/api/v1/student

For POST we have it as: POST http://localhost:8080/api/v1/student with the body of 
```json
{
    "name": "hamza",
    "email":"hamza@gmail.com",
    "dob":"1995-12-17"
}
```

For the DELETE we specifiy the ID by adding it to the end of the Link: DELETE http://localhost:8080/api/v1/student/1

For the PUT, we specify the things we want to change in the link as well: PUT http://localhost:8080/api/v1/student/?name=hamada&email=hamada@gmail.com

If your want only email or name your remove whicher & the "&"

.

And that should be it for the project. you can make it into a jar file after.

we click on the maven tab to the right . open the demo tab then open the Lifecycle tab and click on clean And run it. then after it is complete you click on install and run it. and it will produce a jar file you are able to run in t he terminal. 

it can be run with

```
java -jar demo-0.0.1-SNAPSHOT.jar
```

and you can give it a specific port if 8080 is not what you want with 

```
java -jar demo-0.0.1-SNAPSHOT.jar --server.port=8081
```

And thats how you can do this project.

Overall, during this whole leangthy process we made an API thats capable of basic CRUD behaviours using Spring Boot with PostgreSQL. it was a nice & enlightning process to learn something new  & interesting. definetly more there to learn as this is just the begining in my Java and SpringBoot journey.



Issues may be faced when trying to run the program with postgres:
1. May get an invalid password error
	-make sure the password in the application properties is correct. The username also has to be the same.

```
	spring.datasource.url=jdbc:postgresql://localhost:5432/student
	spring.datasource.username=
	spring.datasource.password=12345
	spring.jpa.hibernate.ddl-auto=create-drop
	spring.jpa.show-sql=true
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.jpa.properties.hibernate.format_sql=true
	server.error.include-message=always
```
	- if it still doesnt work:
	-in C:\Program Files\PostgreSQL\15\data , the file "pg_hba.conf"  scroll to the bottom & make your connection type like this:
	```
		# TYPE  DATABASE        USER            ADDRESS                 METHOD

		# "local" is for Unix domain socket connections only
		local   all             all                                     trust
		# IPv4 local connections:
		host    all             all             127.0.0.1/32            trust
		# IPv6 local connections:
		host    all             all             ::1/128                 trust
		# Allow replication connections from localhost, by a user with the
		# replication privilege.
		local   replication     all                                     scram-sha-256
		host    replication     all             127.0.0.1/32            scram-sha-256
		host    replication     all             ::1/128                 scram-sha-256
	```
	- We changed the METHOD from scram-sha-256 to trust.

2. The server may not recognise your role.

so in SQL Shell we have to create a superuser Role with the same name the program cant recognise. to do so, in the shell:
	key in: CREATE ROLE rolename LOGIN SUPERUSER PASSWORD 'samePasswordYouUsed';
```
	Key note is: i am not sure if those troubleshooting methods are good. but it made the program run for me and hence it is why i did it.
```

