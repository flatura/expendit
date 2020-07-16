# ExpendIt - REST приложение по учету расходных материалов с авторизацией и правами доступа на основе ролей на стеке Maven/Spring Boot/Hibernate
* Разработка: [Дмитрий Flatura Морозов](mailto://flatura@gmail.com) 2020 год
## Documentation
### Development goal
* Отработка навыков, приобретенных на курсе [TopJava](http://javaops.ru/view/topjava); 
* Высвобождение временного ресурса небольшой команды ServiceDesk в образовательном учреждении за счет автоматизации рутинных задач учета расходников; 
* Оптимизация процесса определения объемов закупаемых расходников. 

### Service tasks
* Хранение и предоставление информации по местонахождению и объему остатков расходников;  
* Учет расхода и предоставление статистических данных по расходу;

### Features
* Авторизация пользователей с разделением на роли ADMIN(всё) и USER(только просмотр баланса и внесение нового расхода);
* RESTful API для работы frontend'а с сервисом;
* Поддержка PostgreSQL и HSQLDB (скрипты схемы и популирования в комплекте) с переключением через maven-профили;

### Stack
* Java 9
* Maven 3
* Spring Boot 2
* Spring MVC
* Spring Data JPA
* Spring Security
* PostgreSQL / HSQLDB
* Maven/Spring profiles
* REST API

### REST-API documentation
#### By Entity 
##### User
* POST   `/api/users` - Create new User
* GET    `/api/users` - Get all User 
* GET    `/api/users/{id}` - Get User by id
* GET    `/api/users/by?name=` - Filter User by name 
* PUT    `/api/users/` - Update User by id
* DELETE `/api/users/{id}` - Delete User by id  

###### Consumable:
* POST   `/api/consumables` - Create Consumable
* GET    `/api/consumables` - Get all Consumables 
* GET    `/api/consumables/by?status=` - Filter Consumables by status
* GET    `/api/consumables/by?roomId=` - Filter Consumables by roomId
* GET    `/api/consumables/by?name=` - Filter Consumables by name
* GET    `/api/consumables/{id}` - Get Consumable by id
* PUT    `/api/consumables/{id}` - UPDATE Consumable by id 
* DELETE `/api/consumables/{id}` - DELETE Consumable 

###### ConsumeFact:
* POST   `/api/consumes` - Create new ConsumeFact
* GET    `/api/consumes` - Get all ConsumeFact 
* GET    `/api/consumes/{id}` - Get ConsumeFact with id 
* GET    `/api/consumes/by?modelId=` - Filter ConsumeFacts by modelId
* GET    `/api/consumes/by?roomId=` - Filter ConsumeFacts by roomId
* GET    `/api/consumes/between?startDate={}&endDate={}` - Get ConsumeFacts between dates
* DELETE `/api/consumes/{id}` - Delete ConsumeFact by id 

###### Facility: 
* POST   `/api/facilities` - Create new Facility
* GET    `/api/facilities` - Get all Facilities 
* GET    `/api/facilities/{id}` - Get Facility by id
* GET    `/api/facilities/by?name=` - Filter Facility by name 
* PUT    `/api/facilities/` - Update Facility by id
* DELETE `/api/facilities/{id}` - Delete Facility by id  

###### Room:
* POST   `/api/rooms` - Create new Room
* GET    `/api/rooms` - Get all Room: 
* GET    `/api/rooms/{id}` - Get Room by id
* GET    `/api/rooms/by?name=` - Filter Room by name
* GET    `/api/rooms/by?facilityId=` - Filter Room by facilityId
* PUT    `/api/rooms/{id}` - Update Room by id
* DELETE `/api/rooms/{id}` - Delete Room by id

###### ConsumableType:
* POST   `/api/types` - Create new ConsumableType  
* GET    `/api/types` - Get all ConsumableType
* GET    `/api/types/{id}` - Get ConsumableType by id 
* PUT    `/api/types/{id}` - Update ConsumableType by id
* DELETE `/api/types/{id}` - Delete ConsumableType by id

###### ConsumableModel:
* POST   `/api/models` - Create new ConsumableModel  
* GET    `/api/models` - Get all ConsumableModel
* GET    `/api/models/{id}` - Get ConsumableModel by id 
* PUT    `/api/models/{id}` - Update ConsumableModel by id
* DELETE `/api/models/{id}` - Delete ConsumableModel by id

##### Statistics:
* GET    `/api/stats/summary` - Get summary consume statistics
* GET    `/api/stats/summary?startDate={}&endDate={}` - Get consume statistics between dates
* GET    `/api/stats/available` - Get summary available consumables count
* GET    `/api/stats/available?id={id}` - Get count of consumable with id

#### By HTTP-request type:
#### GET
* GET    `/api/users` - Get all User
* GET    `/api/users/{id}` - Get User by id
* GET    `/api/users/by?name=` - Get User by name
* GET    `/api/consumables` - Get all Consumables 
* GET    `/api/consumables/by?status=` - Filter Consumables by status
* GET    `/api/consumables/by?roomId=` - Filter Consumables by roomId
* GET    `/api/consumables/by?name=` - Filter Consumables by name
* GET    `/api/consumables/{id}` - Get Consumable by id
* GET    `/api/consumes` - Get all ConsumeFact 
* GET    `/api/consumes/{id}` - Get ConsumeFact with id 
* GET    `/api/consumes/by?modelId=` - Filter ConsumeFacts by modelId
* GET    `/api/consumes/by?roomId=` - Filter ConsumeFacts by roomId
* GET    `/api/consumes/between?startDate={}&endDate={}` - Get ConsumeFacts between dates
* GET    `/api/facilities` - Get all Facilities 
* GET    `/api/facilities/{id}` - Get Facility by id
* GET    `/api/facilities/by?name=` - Filter Facility by name 
* GET    `/api/rooms` - Get all Room: 
* GET    `/api/rooms/{id}` - Get Room by id
* GET    `/api/rooms/by?name=` - Filter Room by name
* GET    `/api/rooms/by?facilityId=` - Filter Room by facilityId
* GET    `/api/types` - Get all ConsumableType 
* GET    `/api/types/{id}` - Get ConsumableType by id
* GET    `/api/types/by?name=` - Get ConsumableType by name 
* GET    `/api/models` - Get all ConsumableModel
* GET    `/api/models/by?name=` - - Get all ConsumableModel
* GET    `/api/models/{id}` - Get ConsumableModel by id
* GET    `/api/models/by?name=` - Get ConsumableModel by name
* GET    `/api/stats/consumes` - Get summary consume statistics
* GET    `/api/stats/consumes?startDate={}&endDate={}` - Get consume statistics between dates
* GET    `/api/stats/available` - Get amount of all available consumables
* GET    `/api/stats/available?id={id}` - Get amount of available consumable with model id

#### POST
* POST   `/api/users` - Create new User
* POST   `/api/consumables` - Create Consumable
* POST   `/api/consumes` - Create new ConsumeFact
* POST   `/api/facilities` - Create new Facility
* POST   `/api/rooms` - Create new Room
* POST   `/api/types` - Create new Type
* POST   `/api/models` - Create new ConsumableModel

#### PUT
* PUT    `/api/users/` - Update User by id
* PUT    `/api/consumables/{id}` - UPDATE Consumable by id 
* PUT    `/api/facilities/` - Update Facility by id
* PUT    `/api/rooms/{id}` - Update Room by id
* PUT    `/api/types/{id}` - Update Type by id
* PUT    `/api/models/{id}` - Update ConsumableModel by id

#### DELETE
* DELETE `/api/users/{id}` - Delete User by id  
* DELETE `/api/consumables/{id}` - DELETE Consumable 
* DELETE `/api/consumes/{id}` - Delete ConsumeFact by id
* DELETE `/api/facilities/{id}` - Delete Facility by id   
* DELETE `/api/rooms/{id}` - Delete Room by id
* DELETE `/api/types/{id}` - Delete TYpe by id
* DELETE `/api/models/{id}` - Delete ConsumableModel by id

### CURL examples

You can run curl commands by using GitBash 

Users:
Admin admin@gmail.com password
User1 user1@gmail.com 12345678
User2 user2@gmail.com 12345678

###### Users

CREATE User: 
`curl -s -X POST -d '{"email":"newuser@mail.ru", "name":"User3", "password": "p@ssw0rD","enabled": "true"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/api/users -u Admin:password`

GET all Users: 
`curl -s http://localhost:8080/api/users -u Admin:password`

GET User with name admin
`curl -s "http://localhost:8080/api/users/by?name=Admin" -u Admin:password`

UPDATE User with id 100001: 
`curl -s -X PUT -d '{"id":"100001", "name":"User3", "email":"newuser@mail.ru", "password": "p@ssw0rD","enabled": "true", "registered":"2020-01-10"}' -H 'Content-Type: application/json' http://localhost:8080/api/users/100001 -u Admin:password`

DELETE User with id 100001: 
`curl -s -X DELETE http://localhost:8080/api/users/100001 -u Admin:password`

###### Consumables

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

###### ConsumeFact

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

###### Facility

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

###### Room

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

###### ConsumableType

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

###### ConsumableModel

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

###### Statistics

GET Consume counts between 2019-05-10 and 2019-05-11 (there must be 2 entries in result)
`curl -s "http://localhost:8080/api/stats/summary?startDate=2019-05-10&endDate=2019-05-11" -u user:password`

GET Summary consume counts (there must be 3 entries in result)
`curl -s "http://localhost:8080/api/stats/summary" -u user:password`

GET Summary amount of available consumables at storages
`curl -s "http://localhost:8080/api/stats/available" -u user:password`

###### Thymeleaf Web Pages and Forms

Статистика расхода по моделям за всё время
http://localhost:8080/stats/consume

OK! Баланс остатков по моделям  
http://localhost:8080/stats/balance

Добавить расход
http://localhost:8080/add/consume

Добавить приход
http://localhost:8080/add/incoming

