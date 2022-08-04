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

### To store the credential in AWS secret Manager
* Go to aws.amazon.com console and search for sercret manager.
* click on store a new secret.
* In our case we are using relational database so choose credentials for  Amazon RDS database.
* Provide username and password.
* Select encrytion key
* Choose db instance as aws-rds that we have created.
* Click on next.
* Give the secret name. It my case it is aws-db-credential.
* Click on next.
* Click on next from configure rotation which is optional and it is used if we change password in future we don't need to modify in application.properties it will automatically handle changed password.
* From review page copy the java code for secret manager.
* Click on store.

### To use aws secret manager 
* Add dependency gson and secretsmanager.
  Remove aws database credential from application.properties.
* Create ApplicationConfig configuration file.
* Create AwsSecrets class.
* To get accesskey and secret key go to aws.amaozon.com console  click on your name on right top of the screen in aws.amaozon.com console and click on security credentials.
* Click on access key then click on create access key and click on show access key.
* Copy secret key and access key.
* Create application.yml file and set aws access key and secret key there and use in ApplicationConfig class.