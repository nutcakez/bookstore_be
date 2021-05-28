# bookstore_be
 Backend for bookstore
 
## requirements
 jdk8, docker
 
## how to run
 .\gradlew bootBuildImage  
 docker-compose up

## features
## get customer's orders
  #### url: 
  localhost:8080/order/{userid}  
  #### method:  
  get  
  #### sample return message:  
  {  
    "8": [  
        11,  
        25,  
        4325420  
    ],  
    "9": [  
        1,  
        27,  
        4310  
    ]  
}  

## post customer's order
  #### url 
  localhost:8080/order
  #### method
  post
  #### example of request body:
  {  
        "userid":2,  
        "bookIds":[1,27,4310]  
  }  
  
  #### sample return message:
  {  
    "OrderedBooks": "[1, 27, 4310]",  
    "message": "Order successfully saved!",  
    "OrderId": "9"  
  }
  
 ## delete customer's order
 #### url
 localhost:8080/order/{orderid}
 #### method
 delete
 #### sample return message:
 Order deleted. The order consisted 3 books.
  
