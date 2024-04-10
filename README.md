This is a simple project uses spring boot API to create a database of products including name, price, code, discount and more. 
We can add any product via below command in terminal:
$body = @{
     code = "5"     
     item = "E"   
     price = 50.0  
     discount = 20.0
     available = 1
 } | ConvertTo-Json
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/products" -Body $body -ContentType "application/json"
Upon using the above command, it runs a POST API to add an item to your data base and you would receive a message of "Product added successfully"
![image](https://github.com/Niloofar-didar/product_SpringBoot/assets/27611369/915dcce8-b544-4444-aad5-cf5689b36b3c)


So far, there exist three other APIS to get some information:
1- GET http://localhost:8080/filter/price/{{initialRange}}/{{finalRange}}
As it is shown in the image below, this API filters among the products based on the minimum and maximum price (initial-final Range) given.
![image](https://github.com/Niloofar-didar/product_SpringBoot/assets/27611369/8f2ed6ce-dcbf-4b03-85fd-de34857c5d46)


2- GET http://localhost:8080/sort/price
This API sorts the products based on their price.
![image](https://github.com/Niloofar-didar/product_SpringBoot/assets/27611369/d04d61dc-b024-4ee7-bb7c-338c4786d9d3)

3- GET http://localhost:8080/api/test?name=E&price=50
This API finds the record for the exact produce using its name and price
![image](https://github.com/Niloofar-didar/product_SpringBoot/assets/27611369/9b72eb32-8881-430a-9e6a-50165b44b00b)
