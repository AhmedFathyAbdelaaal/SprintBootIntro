
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

