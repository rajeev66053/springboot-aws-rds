# springboot-aws-rds 

* To work with aws rds we need to login to aws amazon console.
* Go to service and search RDS.
* Then click on RDS. It will redirect to amazon RDS.
* Click on the databases in side navigation.
* Click on create database.
* Choose Mysql database and choose version of mysql.In my case it is "MySQL 8.0.28".
* Choose free tier.
* In setting section give DB instance identifier.
* Give credentials username and password.
* Click on additional connectivity configuration.
* Choose publicly accessible to yes.
* Click on additional configuration.
* Give initial database name.
* click on create database.
* click on db instance.
* Copy the endpoint.
* Click on security.
* Click on security group id.
* Click on edit enbound rule.  
* Click on add rule.
* choose type as MYSQL/Aurora.
* choose source as custom.
* click save rules.


* Run the application
* To test the application use postman.
  > [POST] http://localhost:5000/book
  
```
{
    "name":"core java",
    "price": 100
}

```
* To view the added data go to mysql work bench application.
* Click on add connection.
* Give connection name.
* Add hostname as aws RDS endpoint.
* click Test connection.
* If test connection pass, open the new connection.
* The database name on the springboot application.properties must match with database name in mysql workbench.


### Deploy in elastic beanstalk
* In application.properties. set mysql configuration with aws rds.
* Create jar file of springboot application using mvn clean install.
* Go to aws.amazon.com and find elastic bean stalk
* create application name.
* Click on create environment.
* choose platform as java
* click on configure more options.
* click on option on database. click on edit the database.
* set username and password of aws database.
* click on save.
* click on create environment.
* click on upload and deploy.
* choose a file and upload jar file.
* click on deploy.
* click on the link.