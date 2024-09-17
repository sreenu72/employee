This the spring boot demo project for employee management.
Use the following maven commands to run this project :
for building : mvn clean install
for running : mvn spring-boot:run

It contains the following rest end points :

1) For fetching all the employees :

curl --location --request GET 'http://localhost:8080/api/employee' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "test",
    "department" : "Engineering",
    "position" : "dev",
    "salary" : 1000
}'

2) Adding Employee :

    curl --location 'http://localhost:8080/api/employee' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "test",
    "department" : "Engineering",
    "position" : "dev",
    "salary" : 10000
}' 

3) Updating Employee :

curl --location --request PUT 'http://localhost:8080/api/employee/1' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "test1",
    "department" : "Engineering",
    "position" : "dev",
    "salary" : 10000
}'

4) deleting an employee

curl --location --request DELETE 'http://localhost:8080/api/employee/1' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "test1",
    "department" : "Engineering",
    "position" : "dev",
    "salary" : 10000
}'

5) Get Employee by id 

curl --location --request GET 'http://localhost:8080/api/employee/2' \
--header 'Content-Type: application/json' \
--data '{
    "name" : "test1",
    "department" : "Engineering",
    "position" : "dev",
    "salary" : 10000
}'
