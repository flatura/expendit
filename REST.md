##### REST API documentation with CURL examples

You can run curl commands by using GitBash 

Users:
Admin admin@gmail.com admin
User1 user1@gmail.com 12345678
User2 user2@gmail.com 12345678

###### Users API

CREATE User: 

`curl -s -X POST -d '{"email":"newuser@mail.ru", "name":"User3", "password": "p@ssw0rD","enabled": "true"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/users -u Admin:password`

GET all Users: 

`curl -s http://localhost:8080/api/users -u Admin:password`

GET User with name admin

`curl -s "http://localhost:8080/api/users/by?name=Admin" -u Admin:password`

UPDATE User with id 100001: 

`curl -s -X PUT -d '{"id":"100001", "name":"User3", "email":"newuser@mail.ru", "password": "p@ssw0rD","enabled": "true", "registered":"2020-01-10T19:39:29.460+0000"}' -H 'Content-Type: application/json' http://localhost:8080/api/users/100001 -u Admin:password`

DELETE User with id 100001: 

`curl -s -X DELETE http://localhost:8080/api/users/100001 -u Admin:password`

###### Consumables API

CREATE Consumable

`curl -s -X POST -d '{"contract":"SVT1 2019-04-02", "name":"Canon 728", "price": "750","consumableModelId": "100004", "consumableTypeId": "100000", "status": "1", "roomId": "100009"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumables -u admin:password`

GET all Consumables: 

`curl -s http://localhost:8080/api/consumables -u user:password`

GET full Consumables: 

`curl -s "http://localhost:8080/api/consumables/by?status=1" -u user:password`

GET Consumables in Room with id 100009: 

`curl -s "http://localhost:8080/api/consumables/by?room=100009"  -u user:password`

GET Consumables by name CB435: 

`curl -s "http://localhost:8080/api/consumables/by?name=CB435"  -u user:password`

GET Consumable with id 100024: 

`curl -s http://localhost:8080/api/consumables/100024 -u Admin:password`

UPDATE Consumable with id 100024

`curl -s -X PUT -d '{"id":"100024", "contract":"SVT1", "name":"Canon 728_fixed", "price": "840","consumableModelId": "100004", "consumableTypeId": "100000", "status": "2", "roomId": "100009"}' -H 'Content-Type: application/json' http://localhost:8080/api/consumables/100024 -u admin:password`

DELETE Consumable with id 100024: 

`curl -s -X DELETE http://localhost:8080/api/consumables/100024 -u admin:password`

###### ConsumeFact API

CREATE ConsumeFact

`curl -s -X POST -d '{"roomId":"100016", "consumableId":"100015", "date":"2019-07-29"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumes -u admin:password`

GET all ConsumeFact: 

`curl -s http://localhost:8080/api/consumes  -u user:password`

GET ConsumeFact with id 100011: 

`curl -s http://localhost:8080/api/consumes/100006  -u user:password`

GET ConsumeFacts with ConsumeModelId 100038 (there must be 4 entries in result)

`curl -s http://localhost:8080/api/consumes/by?modelId=100038 -u user:password`

GET ConsumeFacts in Room with Id 100003 (there must be 2 entries in result)

`curl -s http://localhost:8080/api/consumes/by?roomId=100003 -u user:password`

GET ConsumeFacts in between 2019-05-10 and 2019-05-11 (there must be 3 entries in result)

`curl -s "http://localhost:8080/api/consumes/between?startDate=2019-05-10&endDate=2019-05-11" -u user:password`

DELETE ConsumeFact with id 100011: 

`curl -s -X DELETE http://localhost:8080/api/consumes/100011 -u admin:password`

###### Facility API

CREATE Facility:

`curl -s -X POST -d '{"name":"FacilityNew", "address":"AddressNew", "comments":"No"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/facility  -u admin:password`

GET all Facilities: 

`curl -s http://localhost:8080/api/facilities -u user:password`

GET Facility with id 100001: 

`curl -s http://localhost:8080/api/facilities/100001 -u user:password`

GET Facility with name 790: 

`curl -s "http://localhost:8080/api/facilities/by?name=790" -u user:password`

UPDATE Facility with id 100001:

`curl -s -X PUT -d '{"id":"100001", "name":"Facility", "address":"Address2", "comments":"No"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/facilities/100001 -u admin:password`

DELETE Facility with id 100009: 

`curl -s -X DELETE http://localhost:8080/api/facilities/100009 -u admin:password`

###### Room API

CREATE Room:

`curl -s -X POST -d '{"name":"NewRoom", "facilityId":"100003", "storage":"false", "userId":"100000", "comments":""}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/rooms -u admin:password`

GET all Room: 

`curl -s http://localhost:8080/api/rooms -u user:password`

GET Room with id 100001: 

`curl -s http://localhost:8080/api/rooms/100238 -u user:password`

GET Room with name like 43: 

`curl -s http://localhost:8080/api/rooms/by?name=43 -u user:password`

GET Room with facilityId = 100001: 

`curl -s http://localhost:8080/api/rooms/by?facilityId=100001 -u user:password`

UPDATE Room with id 100001:

`curl -s -X PUT -d '{"name":"NewNAME", "facilityId":"100003", "storage":"true", "userId":"100000", "comments":"edited"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/rooms/100238 -u admin:password`

DELETE  with id 100001: 

`curl -s -X DELETE http://localhost:8080/api/rooms/100238 -u admin:password`

###### ConsumableType API

CREATE Type

`curl -s -X POST -d '{"name":"Ink Color Pigment"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/types -u admin:password`

GET all Type: 

`curl -s http://localhost:8080/api/types -u user:password`

GET Type with id 100024: 

`curl -s http://localhost:8080/api/types/100001 -u user:password`

GET Type with name like Ink: 

`curl -s http://localhost:8080/api/types/by?name=ink -u user:password`

DELETE Type with id 100024: 

`curl -s -X DELETE http://localhost:8080/api/types/100003 -u admin:password`

###### ConsumableModel API

CREATE ConsumableModel

`curl -s -X POST -d '{"name":"Canon 728", "partNumber":"728-1", "consumableTypeId":"100000", "resource":"5008"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumablemodels -u admin:password`

GET all ConsumableModels: 

`curl -s http://localhost:8080/api/models -u user:password`

GET ConsumableModel with id 100001: 

`curl -s http://localhost:8080/api/models/100001 -u user:password`

GET ConsumableModel by name: 

`curl -s http://localhost:8080/api/models/by?name=435 -u user:password`

GET ConsumableModel by typeId: 

`curl -s http://localhost:8080/api/models/by?typeId=100001 -u user:password`

UPDATE ConsumableModel with id 100002

`curl -s -X PUT -d '{"id":"100002", "name":"Canon 728", "partNumber":"728-1", "consumableTypeId":"100001", "resource":"5008"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/models/100002 -u admin:password`

DELETE ConsumableModel with id 100001: 

`curl -s -X DELETE http://localhost:8080/api/models/100001 -u admin:password`