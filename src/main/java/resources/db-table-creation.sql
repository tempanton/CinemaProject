CREATE TABLE c_users
(
    id INTEGER PRIMARY KEY NOT NULL,
    login VARCHAR(255),
    password VARCHAR(255),
    birth_date DATE
);
CREATE UNIQUE INDEX "C_USERS_id_uindex" ON c_users (id);

CREATE TABLE c_role
(
    name VARCHAR(255),
    id INTEGER PRIMARY KEY NOT NULL
);
CREATE UNIQUE INDEX c_role_id_uindex ON c_role (id);

CREATE TABLE c_user_privileges
(
    role_id INTEGER,
    user_id INTEGER,
    CONSTRAINT fk4o7mmjj5ehq43flwxleml6tmr FOREIGN KEY (role_id) REFERENCES c_users (id),
    CONSTRAINT fk59guvkrwgof748ap8d0nicah2 FOREIGN KEY (user_id) REFERENCES c_role (id)
);


CREATE TABLE c_movie
(
    id INTEGER PRIMARY KEY NOT NULL,
    title VARCHAR(255),
    duration VARCHAR(255),
    price DOUBLE PRECISION
);

CREATE TABLE c_room
(
    id INTEGER PRIMARY KEY NOT NULL,
    room VARCHAR(255),
    seat INTEGER
);
CREATE UNIQUE INDEX c_room_id_uindex ON c_room (id);

CREATE TABLE c_seat
(
    seat INTEGER,
    reservation_flag BIT,
    coefficient BIGINT,
    id INTEGER PRIMARY KEY NOT NULL,
    seattype VARCHAR(255),
    room_id BIGINT,
    CONSTRAINT fkchlc8wu9ithmiss7h4ocobd58 FOREIGN KEY (room_id) REFERENCES c_room (id)
);


CREATE TABLE c_seance
(
    id INTEGER PRIMARY KEY NOT NULL,
    date DATE,
    totalprice DOUBLE PRECISION,
    movie_id BIGINT,
    room_id BIGINT,
    CONSTRAINT fkjx8v9nn6meujcutn1jrwtoh45 FOREIGN KEY (movie_id) REFERENCES c_movie (id),
    CONSTRAINT fkr8ly7hq8p66icd16nb1xag886 FOREIGN KEY (room_id) REFERENCES c_room (id)
);

CREATE TABLE c_order
(
    id INTEGER PRIMARY KEY NOT NULL,
    user_id BIGINT,
    CONSTRAINT fk22wupvc9nfjk5pgw6h332gc06 FOREIGN KEY (user_id) REFERENCES c_users (id)
);

CREATE TABLE c_ticket
(
    id INTEGER PRIMARY KEY NOT NULL
);

CREATE TABLE c_order_c_ticket
(
    order_id BIGINT NOT NULL,
    tickets_id BIGINT NOT NULL,
    CONSTRAINT fkfasj76hgx4jfqfh5bhbkks1vo FOREIGN KEY (order_id) REFERENCES c_order (id),
    CONSTRAINT fkclimg0tfk41jjsfux0hrlxm7r FOREIGN KEY (tickets_id) REFERENCES c_ticket (id)
);
CREATE UNIQUE INDEX uk_en76mf8gtb0nv2fctc3nabs20 ON c_order_c_ticket (tickets_id);


