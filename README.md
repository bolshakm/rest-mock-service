Old Version
GET
: http://localhost:8080/menu/view

Rest Контракти:
GET
: http://localhost:8080/api/v1/menu/view/1/23

Response example in the [menuViewResponseExample.json](menuViewResponseExample.json)

POST
: http://localhost:8080/api/v1/order/place/1/23

Request body:

```json
{
  "tableNumber": 5,
  "orderedDishes": {
    "1": 2,
    "2": 1,
    "3": 3
  }
}
```
В orderedDishes ключи це айдішники продуктів а значкення це кількість.
Тобто в першому рядку "1": 2, "1" - це айдішник продукту, а 2 це замовлена кількість.

Response example:
```json
{
  "orderedDish": [
    {
      "dish": {
        "id": 2,
        "name": "Margherita Pizza",
        "description": "Description for Drink Margherita Pizza",
        "price": 3.0
      },
      "quantity": 2
    },
    {
      "dish": {
        "id": 3,
        "name": "Sushi Roll",
        "description": "Description for Drink Sushi Roll",
        "price": 4.5
      },
      "quantity": 1
    },
    {
      "dish": {
        "id": 4,
        "name": "Caesar Salad",
        "description": "Description for Drink Caesar Salad",
        "price": 6.0
      },
      "quantity": 3
    }
  ],
  "totalSum": 13.5
}
```

New menu page:

Request bill
GET
: http://localhost:8080/api/v1/bill/1/23?type=card

1 is a cafe id, 23 is a table number, type card or cash

Get cafe data
GET
: http://localhost:8080/api/v1/cafe/1
1 is a cafe id

Response:

```json
{
    "name": "Summertime cafe",
    "address": "Streat 2/3",
    "workingHours": {
        "Thu": "9:00-21:00",
        "Tue": "9:00-21:00",
        "Wed": "9:00-21:00",
        "Sat": "9:00-21:00",
        "Fri": "9:00-21:00",
        "Mon": "9:00-21:00",
        "Sun": "9:00-17:00"
    },
    "facebook": "https://www.facebook.com",
    "instagram": "https://www.instagram.com",
    "tripAdvisor": "https://www.tripadvisor.com"
}
```

Get current order data for table
GET
: http://localhost:8080/api/v1/order/1/21

For empty body put table number 33 http://localhost:8080/api/v1/order/1/33

Response:

```json
{
  "orderedDish": [
    {
      "dish": {
        "id": 1,
        "name": "Chicken Alfredo",
        "description": "Description for Drink Chicken Alfredo",
        "price": 1.5
      },
      "quantity": 3
    },
    {
      "dish": {
        "id": 3,
        "name": "Sushi Roll",
        "description": "Description for Drink Sushi Roll",
        "price": 4.5
      },
      "quantity": 2
    },
    {
      "dish": {
        "id": 35,
        "name": "Espresso",
        "description": "Description for Drink Espresso",
        "price": 1.5
      },
      "quantity": 3
    },
    {
      "dish": {
        "id": 4,
        "name": "Caesar Salad",
        "description": "Description for Drink Caesar Salad",
        "price": 6.0
      },
      "quantity": 3
    },
    {
      "dish": {
        "id": 36,
        "name": "Espresso",
        "description": "Description for Drink Espresso",
        "price": 3.0
      },
      "quantity": 4
    },
    {
      "dish": {
        "id": 37,
        "name": "Espresso",
        "description": "Description for Drink Espresso",
        "price": 4.5
      },
      "quantity": 3
    }
  ],
  "totalSum": 21
}
```