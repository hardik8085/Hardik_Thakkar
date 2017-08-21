# Hardik_Thakkar

1) Clone repository

To run program 

Approach 1: 
import the project to IDE(Eclipse) by following steps:
File->Import->Gradle->Gradle Project
Build the project using gradle
start application through file located at default_package/MainApplication.java

Appriach 2:
open command line 
Go to folder projectFolder/build/libs
write following command
java -jar executable.jar


Assumption:
admin/orders/count.json?status=any will provide unique order count
admin/customers/count.json will provide unique customer count

admin/orders/orders.json?status=any will provide order in proper sequence and using this sequence calculate the meadian order value
