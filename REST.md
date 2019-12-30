##### REST API documentation with CURL examples

You can run curl commands by using GitBash 

Users:
Admin admin@gmail.com adMinPa$$ ROLE_ADMIN ROLE_USER
user1 user1@gmail.com password ROLE_USER
User2 user2@gmail.com password ROLE_USER

###### Consumables API: DONE!

CREATE Consumable

`curl -s -X POST -d '{"contract":"SVT1 2019-04-02", "name":"Canon 728", "price": "750","consumableModelId": "100004", "consumableTypeId": "100000", "status": "1", "roomId": "100009"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumables -u Admin:password`

GET all Consumables: 

`curl -s http://localhost:8080/api/consumables -u user:password`

GET full Consumables: 

`curl -s http://localhost:8080/api/consumables/full -u user:password`

GET Consumables in Room with id 100009: 

`curl -s http://localhost:8080/api/consumables/room/100009  -u Admin:password`

GET Consumable with id 100023: 

`curl -s http://localhost:8080/api/consumables/100023 -u Admin:password`

UPDATE Consumable with id 100023

`curl -s -X PUT -d '{"id":"100023", "contract":"SVT1", "name":"Canon 728_fixed", "price": "840","consumableModelId": "100004", "consumableTypeId": "100000", "status": "2", "roomId": "100009"}' -H 'Content-Type: application/json' http://localhost:8080/api/consumables/100023 -u Admin:password`

DELETE Consumable with id 100023: 

`curl -s -X DELETE http://localhost:8080/api/consumables/100023 -u Admin:password`

###### ConsumeFact API: DONE!

CREATE ConsumeFact

`curl -s -X POST -d '{"roomId":"100016", "consumableId":"100015", "date":"2019-07-29"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumes -u Admin:password`

GET all ConsumeFact: 

`curl -s http://localhost:8080/api/consumes  -u user:password`

GET ConsumeFact with id 100011: 

`curl -s http://localhost:8080/api/consumes/100006  -u user:password`

GET ConsumeFacts with ConsumeModelId 100038 (there must be 4 entries in result)

`curl -s http://localhost:8080/api/consumes/model/100038 -u user:password`

GET ConsumeFacts in Room with Id 100003 (there must be 2 entries in result)

`curl -s http://localhost:8080/api/consumes/room/100003 -u user:password`

GET ConsumeFacts in between 2019-05-10 and 2019-05-11 (there must be 3 entries in result)

`curl -s "http://localhost:8080/api/consumes/between?startDate=2019-05-10&endDate=2019-05-11" -u user:password`

DELETE ConsumeFact with id 100006: 

`curl -s -X DELETE http://localhost:8080/api/consumes/100006 -u Admin:password`

###### Facility API: DONE!

CREATE Facility:

`curl -s -X POST -d '{"name":"FacilityNew", "address":"AddressNew", "comments":"No"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/facility  -u Admin:password`

GET all Facilities: 

`curl -s http://localhost:8080/api/facilities -u user:password`

GET Facility with id 100001: 

`curl -s http://localhost:8080/api/facilities/100001 -u user:password`

UPDATE Facility with id 100001:

`curl -s -X PUT -d '{"id":"100001", "name":"Facility", "address":"Address2", "comments":"No"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/facilities/100001 -u Admin:password`

DELETE  with id 100009: 

`curl -s -X DELETE http://localhost:8080/api/facilities/100009 -u Admin:password`

###### Room API: DONE!

CREATE Room:

`curl -s -X POST -d '{"name":"NewRoom", "facilityId":"100003", "storage":"false", "userId":"100000", "comments":""}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/rooms -u Admin:password`

GET all Room: 

`curl -s http://localhost:8080/api/rooms -u user:password`

GET Room with id 100001: 

`curl -s http://localhost:8080/api/rooms/100238 -u user:password`

UPDATE Room with id 100001:

`curl -s -X PUT -d '{"name":"NewNAME", "facilityId":"100003", "storage":"true", "userId":"100000", "comments":"edited"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/rooms/100238 -u Admin:password`

DELETE  with id 100001: 

`curl -s -X DELETE http://localhost:8080/api/rooms/100238 -u Admin:password`

###### ConsumableType API:

CREATE 

`curl -s -X POST -d '{"name":"Canon 728"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/ -u Admin:password`

GET all : 

`curl -s http://localhost:8080/api/types -u user:password`

GET  with id 100024: 

`curl -s http://localhost:8080/api/types/100024 -u user:password`

CREATE 

`curl -s -X POST -d '{"name":"Canon 728"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/types -u Admin:password`

DELETE  with id 100024: 

`curl -s -X DELETE http://localhost:8080/api/types/100024 -u Admin:password`

###### ConsumableModel API:

CREATE ConsumableModel

`curl -s -X POST -d '{"name":"Canon 728", "partNumber":"728-1", "consumableTypeId":"100000", "resource":"5008"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/consumablemodels -u Admin:password`

GET all ConsumableModels: 

`curl -s http://localhost:8080/api/models -u user:password`

GET ConsumableModel with id 100001: 

`curl -s http://localhost:8080/api/models/100001 -u user:password`

UPDATE ConsumableModel with id 100002

`curl -s -X PUT -d '{"id":"100002", "name":"Canon 728", "partNumber":"728-1", "consumableTypeId":"100001", "resource":"5008"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/models/100002 -u Admin:password`

DELETE ConsumableModel with id 100001: 

`curl -s -X DELETE http://localhost:8080/api/models/100001 -u Admin:password`