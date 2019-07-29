##### REST API documentation with CURL examples

You can run curl commands by using GitBash 

Users:
Admin admin@gmail.com admin
User1 user1@gmail.com 12345678
User2 user2@gmail.com 12345678

###### Consumables API: DONE!

CREATE Consumable

`curl -s -X POST -d '{"contract":"SVT1 2019-04-02", "name":"Canon 728", "price": "750","consumableModelId": "100004", "consumableTypeId": "100000", "status": "1", "roomId": "100009"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumables`

GET all Consumables: 

`curl -s http://localhost:8080/api/consumables`

GET full Consumables: 

`curl -s http://localhost:8080/api/consumables/full`

GET Consumables in Room with id 100009: 

`curl -s http://localhost:8080/api/consumables/room/100009`

GET Consumable with id 100024: 

`curl -s http://localhost:8080/api/consumables/100024`

UPDATE Consumable with id 100024

`curl -s -X PUT -d '{"id":"100024", "contract":"SVT1", "name":"Canon 728_fixed", "price": "840","consumableModelId": "100004", "consumableTypeId": "100000", "status": "2", "roomId": "100009"}' -H 'Content-Type: application/json' http://localhost:8080/api/consumables/100024`

DELETE Consumable with id 100024: 

`curl -s -X DELETE http://localhost:8080/api/consumables/100024`



###### ConsumeFact API: DONE!

CREATE ConsumeFact

`curl -s -X POST -d '{"roomId":"100016", "consumableId":"100015", "consumableModelId":"100062", "date":"2019-07-29"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumes`

GET all ConsumeFact: 

`curl -s http://localhost:8080/api/consumes`

GET ConsumeFact with id 100011: 

`curl -s http://localhost:8080/api/consumes/100011`

UPDATE ConsumeFact with id 100011:

`curl -s -X PUT -d '{"id":"100011", "roomId":"100017", "consumableId":"100014", "consumableModelId":"100062", "date":"2019-07-29"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumes/100011`

DELETE ConsumeFact with id 100011: 

`curl -s -X DELETE http://localhost:8080/api/consumes/100011`

###### Facility API:

CREATE 

`curl -s -X POST -d '{"name":"Canon 728"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/`

GET all : 

`curl -s http://localhost:8080/api/`

GET full : 

`curl -s http://localhost:8080/api//full`

GET  with id 100024: 

`curl -s http://localhost:8080/api//100024`

DELETE  with id 100024: 

`curl -s -X DELETE http://localhost:8080/api//100024`

###### Room API:

CREATE 

`curl -s -X POST -d '{"name":"Canon 728"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/`

GET all : 

`curl -s http://localhost:8080/api/`

GET full : 

`curl -s http://localhost:8080/api//full`

GET  with id 100024: 

`curl -s http://localhost:8080/api//100024`

DELETE  with id 100024: 

`curl -s -X DELETE http://localhost:8080/api//100024`

###### ConsumableType API:

CREATE 

`curl -s -X POST -d '{"name":"Canon 728"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/`

GET all : 

`curl -s http://localhost:8080/api/`

GET full : 

`curl -s http://localhost:8080/api//full`

GET  with id 100024: 

`curl -s http://localhost:8080/api//100024`

DELETE  with id 100024: 

`curl -s -X DELETE http://localhost:8080/api//100024`

###### ConsumableModel API:

CREATE 

`curl -s -X POST -d '{"name":"Canon 728"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/`

GET all : 

`curl -s http://localhost:8080/api/`

GET full : 

`curl -s http://localhost:8080/api//full`

GET  with id 100024: 

`curl -s http://localhost:8080/api//100024`

DELETE  with id 100024: 

`curl -s -X DELETE http://localhost:8080/api//100024`