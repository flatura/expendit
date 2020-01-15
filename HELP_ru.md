# ExpendIt - микросервис учета расходников
* Разработка: [Дмитрий Flatura Морозов](mailto://flatura@gmail.com) 2019 год
## Документация
### Цель разработки
* Отработка навыков, приобретенных на курсе [TopJava](http://javaops.ru/view/topjava); 
* Высвобождение временного ресурса небольшой команды ServiceDesk в образовательном учреждении за счет автоматизации рутинных задач учета расходников 
* Оптимизация процесса определения объемов закупаемых расходников. 

### Задачи сервиса
* Хранение и предоставление информации по местонахождению и объему остатков расходников;  
* Учет расхода и предоставление статистических данных по расходу.

### Особенности
* Авторизация пользователей с разделением на роли ADMIN(всё) и USER(только просмотр баланса и внесение нового расхода);
* RESTful API для работы frontend'а с сервисом;
* Поддержка PostgreSQL и HSQLDB (скрипты схемы и популирования в комплекте) с переключением через Maven-профили.

### Используемый стек технологий
* Java 9
* Maven 3
* Spring Boot 2
* Spring MVC
* Spring Data JPA
* Spring Security
* PostgreSQL / HSQLDB
* Maven профили
* REST API

### REST-API документация
#### По Сущностям
##### Пользователь
* POST   `/api/users` - Создать нового пользователя
* GET    `/api/users` - Получить всех пользователей 
* GET    `/api/users/{id}` - Получить пользователя по его id
* GET    `/api/users/by?name=` - Поиск пользователя по имени или части имени
* PUT    `/api/users/` - Изменить пользователя по его id
* DELETE `/api/users/{id}` - Удалить пользователя по его id

###### Consumable:
* POST   `/api/consumables` - Создать новый расходник
* GET    `/api/consumables` - Получить все расходники (вне зависимости от состояния)
* GET    `/api/consumables/by?status=` - Поиск расходников по статусу
* GET    `/api/consumables/by?roomId=` - Поиск расходников по id комнаты
* GET    `/api/consumables/by?name=` - Поиск расходников по имени или части имени
* GET    `/api/consumables/{id}` - Поиск расходника по его id
* PUT    `/api/consumables/{id}` - Изменить расходник по его id 
* DELETE `/api/consumables/{id}` - Удалить расходник по его id

###### ConsumeFact:
* POST   `/api/consumes` - Создать новый факт расхода
* GET    `/api/consumes` - Получить все факты расхода
* GET    `/api/consumes/{id}` - Получить факт расхода по его id 
* GET    `/api/consumes/by?modelId=` - Поиск фактов расхода по id модели расходника
* GET    `/api/consumes/by?roomId=` - Поиск фактов расхода по id комнаты
* GET    `/api/consumes/between?startDate={}&endDate={}` - Поиск фактов расхода между датами
* DELETE `/api/consumes/{id}` - Удалить факт расхода (удаляется, если указанный расходник сейчас в статусе 2(используется), в этом случае он возвращается на склад)

###### Facility: 
* POST   `/api/facilities` - Создать новое здание
* GET    `/api/facilities` - Получить все здания
* GET    `/api/facilities/{id}` - Получить здание по его id
* GET    `/api/facilities/by?name=` - Поиск зданий по имени или части имени 
* PUT    `/api/facilities/` - Изменить здание по её id 
* DELETE `/api/facilities/{id}` - Удалить здание по его id

###### Room:
* POST   `/api/rooms` - Создать новую комнату
* GET    `/api/rooms` - Получить все комнаты
* GET    `/api/rooms/{id}` - Получить комнату по ее id
* GET    `/api/rooms/by?name=` - Поиск комнат по имени или части имени
* GET    `/api/rooms/by?facilityId=` - Поиск комнат по зданию 
* PUT    `/api/rooms/{id}` - Изменить комнату по её id
* DELETE `/api/rooms/{id}` - Delete Room by id

###### ConsumableType:
* POST   `/api/types` - Добавить новый тип расходника
* GET    `/api/types` - Получить все типы расходников
* GET    `/api/types/{id}` - Получить тип расходника по его id 
* PUT    `/api/types/{id}` - Изменить тип расходника по его id
* DELETE `/api/types/{id}` - Удалить тип расходника по его id

###### ConsumableModel:
* POST   `/api/models` - Создать модель расходника
* GET    `/api/models` - Получить все модели расходников
* GET    `/api/models/{id}` - Получить модель расходника по его id
* PUT    `/api/models/{id}` - Изменить модель расходника по его id
* DELETE `/api/models/{id}` - Удалить модель расходника по его id

##### Statistics:
* GET    `/api/stats/summary` - Получить суммарную статистику расхода по всем моделям
* GET    `/api/stats/summary?startDate={}&endDate={}` - Получить статистику по расходу с группировкой по всем моделям в заданным периол
* GET    `/api/stats/available` - Получить суммарное число доступных расходников (статус = 1) по модели
* GET    `/api/stats/available?id={id}` - Получить число доступных расходников (статус = 1) 

#### By HTTP-request type:
#### GET
* GET    `/api/users` - Получить всех пользователей 
* GET    `/api/users/{id}` - Получить пользователя по его id
* GET    `/api/users/by?name=` - Поиск пользователя по имени или части имени
* GET    `/api/consumables` - Получить все расходники (вне зависимости от состояния)
* GET    `/api/consumables/by?status=` - Поиск расходников по статусу
* GET    `/api/consumables/by?roomId=` - Поиск расходников по id комнаты
* GET    `/api/consumables/by?name=` - Поиск расходников по имени или части имени
* GET    `/api/consumables/{id}` - Поиск расходника по его id
* GET    `/api/consumes` - Получить все факты расхода
* GET    `/api/consumes/{id}` - Получить факт расхода по его id 
* GET    `/api/consumes/by?modelId=` - Поиск фактов расхода по id модели расходника
* GET    `/api/consumes/by?roomId=` - Поиск фактов расхода по id комнаты
* GET    `/api/consumes/between?startDate={}&endDate={}` - Поиск фактов расхода между датами
* GET    `/api/facilities` - Получить все здания
* GET    `/api/facilities/{id}` - Получить здание по его id
* GET    `/api/facilities/by?name=` - Поиск зданий по имени или части имени 
* GET    `/api/rooms` - Получить все комнаты
* GET    `/api/rooms/{id}` - Получить комнату по ее id
* GET    `/api/rooms/by?name=` - Поиск комнат по имени или части имени
* GET    `/api/rooms/by?facilityId=` - Поиск комнат по зданию 
* GET    `/api/types` - Получить все типы расходников
* GET    `/api/types/{id}` - Получить тип расходника по его id 
* GET    `/api/models` - Получить все модели расходников
* GET    `/api/models/{id}` - Получить модель расходника по его id
* GET    `/api/stats/summary` - Получить суммарную статистику расхода по всем моделям
* GET    `/api/stats/summary?startDate={}&endDate={}` - Получить статистику по расходу с группировкой по всем моделям в заданным периол
* GET    `/api/stats/available` - Получить суммарное число доступных расходников (статус = 1) по модели
* GET    `/api/stats/available?id={id}` - Получить число доступных расходников (статус = 1) 

#### POST
* POST   `/api/users` - Создать нового пользователя
* POST   `/api/consumables` - Создать новый расходник
* POST   `/api/consumes` - Создать новый факт расхода
* POST   `/api/facilities` - Создать новое здание
* POST   `/api/rooms` - Создать новую комнату
* POST   `/api/types` - Добавить новый тип расходника
* POST   `/api/models` - Создать модель расходника

#### PUT
* PUT    `/api/users/` - Изменить пользователя по его id
* PUT    `/api/consumables/{id}` - Изменить расходник по его id 
* PUT    `/api/facilities/` - Изменить здание по её id 
* PUT    `/api/rooms/{id}` - Изменить комнату по её id
* PUT    `/api/types/{id}` - Изменить тип расходника по его id
* PUT    `/api/models/{id}` - Изменить модель расходника по его id

#### DELETE
* DELETE `/api/users/{id}` - Удалить пользователя по его id
* DELETE `/api/consumables/{id}` - Удалить расходник по его id
* DELETE `/api/consumes/{id}` - Удалить факт расхода (удаляется, если указанный расходник сейчас в статусе 2(используется), в этом случае он возвращается на склад)
* DELETE `/api/facilities/{id}` - Удалить здание по его id
* DELETE `/api/rooms/{id}` - Delete Room by id
* DELETE `/api/types/{id}` - Удалить тип расходника по его id
* DELETE `/api/models/{id}` - Удалить модель расходника по его id
