# ExpendIt - микросервис учета расходников
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