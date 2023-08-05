Old Version
GET
: http://localhost:8080/menu/view

Rest Контракти:
GET
: http://localhost:8080/api/v1/menu/view/1

Response example in the [menuViewResponseExample.json](menuViewResponseExample.json)

POST
: http://localhost:8080/api/v1/order/place/1

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
GET
: http://localhost:8080/menu/view/v2

Request bill
GET
: http://localhost:8080/api/v1/bill/1?type=card

1 is a table number, type card or cash