DROP TABLE IF EXISTS consume_fact;
DROP TABLE IF EXISTS consumable;
DROP TABLE IF EXISTS consumable_model;
DROP TABLE IF EXISTS consumable_type;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS facility;
DROP SEQUENCE IF EXISTS users_seq;
DROP SEQUENCE IF EXISTS users_roles_seq;
DROP SEQUENCE IF EXISTS facility_seq;
DROP SEQUENCE IF EXISTS room_seq;
DROP SEQUENCE IF EXISTS consumable_type_seq;
DROP SEQUENCE IF EXISTS consumable_model_seq;
DROP SEQUENCE IF EXISTS consumable_seq;
DROP SEQUENCE IF EXISTS consume_fact_seq;

CREATE SEQUENCE users_seq START WITH 100000;
CREATE SEQUENCE users_roles_seq START WITH 100000;
CREATE SEQUENCE facility_seq START WITH 100000;
CREATE SEQUENCE room_seq START WITH 100000;
CREATE SEQUENCE consumable_type_seq START WITH 100000;
CREATE SEQUENCE consumable_model_seq START WITH 100000;
CREATE SEQUENCE consumable_seq START WITH 100000;
CREATE SEQUENCE consume_fact_seq START WITH 100000;

CREATE TABLE users
(
  	id               INTEGER PRIMARY KEY DEFAULT nextval('users_seq'),
  	name             VARCHAR(45)                 NOT NULL,
  	email            VARCHAR(255)                 NOT NULL,
  	password         VARCHAR(60)                 NOT NULL,
  	registered       TIMESTAMP DEFAULT now() NOT NULL,
  	enabled          BOOL DEFAULT TRUE       NOT NULL,
 	CONSTRAINT unique_user_idx UNIQUE (email)
);

CREATE TABLE users_roles
(
    user_role_id     INTEGER PRIMARY KEY DEFAULT nextval('users_roles_seq'),
  	user_id          INTEGER                 NOT NULL,
   	role             VARCHAR(20),
   	CONSTRAINT users_roles_idx UNIQUE (user_id, role),
   	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE facility (
	id               INTEGER PRIMARY KEY DEFAULT nextval('facility_seq'),
	name            varchar(255)          NOT NULL,
	address          varchar(255)          NOT NULL UNIQUE,
	comments         varchar(255),
	CONSTRAINT unique_facility_idx UNIQUE (name, address)
);

CREATE TABLE room (
	id               INTEGER PRIMARY KEY DEFAULT nextval('room_seq'),
	name            varchar(255)          NOT NULL,
	facility_id      integer               NOT NULL,
	storage          boolean               NOT NULL,
	user_id          integer			   ,
	comments         varchar(255)          ,
	CONSTRAINT unique_room_idx UNIQUE (name, facility_id),
	FOREIGN KEY (facility_id) REFERENCES facility (id) ON DELETE CASCADE,
	FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE SET NULL
);

CREATE TABLE consumable_type (
	id               INTEGER PRIMARY KEY DEFAULT nextval('consumable_type_seq'),
	name             varchar(255)          NOT NULL UNIQUE,
	comments         varchar(255)          
);

CREATE TABLE consumable_model (
	id               INTEGER PRIMARY KEY DEFAULT nextval('consumable_model_seq'),
	name             varchar(30)           NOT NULL,
	partnumber       varchar(30)           NOT NULL UNIQUE,
	consumable_type_id  INTEGER            NOT NULL,
	resource         integer               NOT NULL,
	FOREIGN KEY (consumable_type_id) REFERENCES consumable_type (id)
);

CREATE TABLE consumable (
	id               INTEGER PRIMARY KEY DEFAULT nextval('consumable_seq'),
	name             varchar(255)          NOT NULL,
	contract	     	 varchar(255),
	price            integer,
	consumable_model_id integer            NOT NULL,
	room_id			 		 INTEGER			         NOT NULL,
	status           integer               NOT NULL,
	FOREIGN KEY (consumable_model_id) REFERENCES consumable_model (id) ON DELETE SET NULL
);

CREATE TABLE consume_fact (
	id               INTEGER PRIMARY KEY DEFAULT nextval('consume_fact_seq'),
	room_id			 INTEGER			   	NOT NULL,
	storage_id       INTEGER      NOT NULL,
	consumable_id    INTEGER              	NOT NULL,
	consumable_model_id INTEGER          	NOT NULL,
	date             DATE                 	NOT NULL,
  FOREIGN KEY (room_id) REFERENCES room (id),
	FOREIGN KEY (storage_id) REFERENCES room (id),
	FOREIGN KEY (consumable_model_id) REFERENCES consumable_model (id) ON DELETE SET NULL
);