# E-COMMERCE ORDER PROCESSING SYSTEM

Overview

This project is an order processing system designed for an e-commerce platform that handles different types of products: physical products, digital products, and gift cards. The system uses object-oriented principles to model the various product types, their behaviors, and shared characteristics.

Class Design

Object-Oriented Principles Applied

Abstraction: The OrderItem abstract class encapsulates common attributes (productName, price, quantity) and methods (getTotalPrice()), providing a blueprint for all order items.
Inheritance: Three concrete classes—PhysicalProduct, DigitalProduct, and GiftCard—inherit from OrderItem and implement specific behaviors.
Polymorphism: The getTotalPrice() method is overridden in child classes as needed, allowing for specific total price calculations.
Class Structure


API Design

Endpoints

HTTP Method: POST
URL: /orders
Request Body:
json

{
    "items": [
        {
        "type": "PhysicalProduct",
            "productName": "Laptop",
            "price": 100000,
            "quantity": 1,
            "shippingWeight": 2.5
        },
        {
            "type": "DigitalProduct",
            "productName": "E-Book",
            "price": 15000,
            "quantity": 1
        },
        {
            "type": "GiftCard",
            "productName": "Gift Card",
            "price": 25000,
            "quantity": 1,
            "recipientEmail": "recipient@gmail.com"
        }
    ]
}

Response:
json

{
    "orderId": "12345",
    "totalCost": 141500,
    "shippingCost": 1250,
    "summary": [
        {
            "productName": "Laptop",
            "totalPrice": 100000,
            "shippingCost": 1250
        },
        {
            "productName": "E-Book",
            "totalPrice": 15000
        },
        {
            "productName": "Gift Card",
            "totalPrice": 25000
        }
    ]
}

Retrieve Order

HTTP Method: GET
URL: /orders/{id}

Response:
json

{
    "orderId": "12345",
    "totalCost": 141500,
    "items": [
   
    ]
}

SCALABILITY AND EXTENSIBILITY

The design allows for easy addition of new product types by implementing the OrderItem abstract class. By defining common behaviors in interfaces, such as Shippable or DigitalDeliverable, the system remains flexible for future changes without affecting existing code.

TESTING INSTRUCTIONS

To test the solution:

Clone the repository:

git clone  https://github.com/loisnyishimente/EcommerceBackend_Minagri.git

->Compile and run the code using your preferred Java IDE (e.g., IntelliJ, Eclipse).

->Test the order creation by calling the /orders endpoint with sample data.
->Verify the order retrieval using the /orders/{id} endpoint.
->Check console outputs for operations like sending gift cards.

https://github.com/loisnyishimente/EcommerceBackend_Minagri.git

Conclusion

This README provides a comprehensive overview of the e-commerce order processing system's design and functionality. By following the object-oriented principles, the system is structured for maintainability and scalability, making it easy to extend with additional product types and functionalities.
