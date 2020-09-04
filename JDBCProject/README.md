[![Downloads](https://media-exp1.licdn.com/dms/image/C4D0BAQGUUbYm7AI-Ug/company-logo_200_200/0?e=1606953600&v=beta&t=ElBiRi0gbFgBUh22ShVN1GCKM4qZtjcqiYKyYjAwaIk)](https://media-exp1.licdn.com/dms/image/C4D0BAQGUUbYm7AI-Ug/company-logo_200_200/0?e=1606953600&v=beta&t=ElBiRi0gbFgBUh22ShVN1GCKM4qZtjcqiYKyYjAwaIk)
---

**Overview**
---
This JDBC project involves migrating employee data from a .csv to a MySQL database 
using Java and concurrency to process and filter the data and conform to the SQL 
database constraints.

**Usage**
---
Firstly, the user must configure the Properties.txt file by adding the appropriate
data to the required value. The csvFilePath is the file path of the .csv file that
is going to be migrated. The database address is the destination MySQL database with 
required username and password below.
```
csvFilePath=
databaseAddress=
username=
password=
```
Example,
```
csvFilePath=src/main/resources/Employees.csv
databaseAddress=//localhost:3306/Database
username=username
password=password
```
Your .csv file should have the following columns in that order:
```
Emp ID,Name Prefix,First Name,Middle Initial,Last Name,Gender,E Mail,Date of Birth,Date of Joining,Salary
```
With the properties file configured, running the main() application will start the 
migration process. The logs.log file will give detailed report on the process, including
success or fail of the migration.

**Data Validation Criteria**
---
The software will deem data verified based on the criteria listed below, as well as any
restrictions listed by the destination database:

1. EmployeeID - Must be a positive integer which is less than or equal to 2,147,483,647

1. Honorific - Must be strictly either "Mr.", "Mrs.", "Ms.", "Hon.", "Prof.", "Dr.", "Drs."
1. First Name - Must be all letters (Program converts to correct noun case)
1. Middle Initial - Must be a single letter (Converts to upper case)
1. Last Name - Must be all letters (Program converts to correct noun case)
1. Gender - Must be strictly either "M" or "F"
1. Email - Email must be of form xxx.xxx@xxxx.xxx
1. Date Of Birth - Must be of form "xx/xx/xxxx"
1. Date Of Joining - Must be of form "xx/xx/xxxx"
1. Salary - Must be a positive integer which is less than or equal to 2,147,483,647


Whenever the criteria is not met, or the database imposes additional restrictions on the
data, the software attempts to write these records to a file called "InvalidEmployees.csv".
The records are written with a message giving a reason as to why the migration process
 could not occur with that particular record(in .csv format).

**Testing**
---
The software was tested using with expected outputs. The software was tested on a .csv
file with 10,000 records and was completed in ~7300 milliseconds on average. 

The data verification classes were tested and conform to the data criteria listed above.
Also databases with a `PRIMARY_KEY` and different `data_type` requirements were tested 
and the software dealt with the thrown exceptions, without halting.

**Logging**
---
The log file details most of the significant processes which go on during the migration
process, along with useful information for the user. An example is given below.

[![Downloads](https://github.com/Sparta-MCamacho/Sparta/blob/master/Assets/Example%20of%20log%20file.png)](https://github.com/Sparta-MCamacho/Sparta/blob/master/Assets/Example%20of%20log%20file.png)










