use course_for_sell;

CREATE TABLe users
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    fullname   VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    phone      VARCHAR(10) UNIQUE  NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

create table roles
(
    id   int primary key auto_increment,
    name varchar(20) unique not null
);

create table users_roles
(
    user_id bigint,
    role_id int,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

CREATE TABLE categories
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE courses
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255) UNIQUE NOT NULL,
    description TEXT                NOT NULL,
    price       DECIMAL(10, 2)      NOT NULL,
    image       BLOB                NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE lessons
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE contents
(
    id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(255) UNIQUE NOT NULL,
    text  LONGTEXT,
    video LONGBLOB
);

CREATE TABLE subcategories
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) UNIQUE NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE orders
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_date TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
    total      DECIMAL(10, 2) NOT NULL,
    status     VARCHAR(50) DEFAULT 'Pending',
    user_id    BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE ratings
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    content   LONGTEXT NOT NULL,
    stars     INT DEFAULT 1,
    user_id   BIGINT,
    course_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (course_id) REFERENCES courses (id)
);

CREATE TABLE courses_lessons
(
    course_id BIGINT,
    lesson_id BIGINT,
    FOREIGN KEY (course_id) REFERENCES courses (id),
    FOREIGN KEY (lesson_id) REFERENCES lessons (id)
);

CREATE TABLE lesson_contents
(
    lesson_id  BIGINT,
    content_id BIGINT,
    FOREIGN KEY (lesson_id) REFERENCES lessons (id),
    FOREIGN KEY (content_id) REFERENCES contents (id)
);

CREATE TABLE order_courses
(
    order_id  BIGINT,
    course_id BIGINT,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (course_id) REFERENCES courses (id)
);


insert into categories (id, name) values (1, 'Yotz');
insert into categories (id, name) values (2, 'Agivu');
insert into categories (id, name) values (3, 'Ntags');
insert into categories (id, name) values (4, 'Eayo');
insert into categories (id, name) values (5, 'Digitube');
insert into categories (id, name) values (6, 'Gigazoom');
insert into categories (id, name) values (7, 'Layo');
insert into categories (id, name) values (8, 'Avavee');
insert into categories (id, name) values (9, 'Dazzlesphere');
insert into categories (id, name) values (10, 'Topdrive');
insert into categories (id, name) values (11, 'Quamba');
insert into categories (id, name) values (12, 'Ailane');
insert into categories (id, name) values (13, 'Skipfire');
insert into categories (id, name) values (14, 'Thoughtbeat');
insert into categories (id, name) values (15, 'Flashpoint');
insert into categories (id, name) values (16, 'Dabshots');
insert into categories (id, name) values (17, 'Gigaclub');
insert into categories (id, name) values (18, 'Lajo');
insert into categories (id, name) values (19, 'Jaloo');
insert into categories (id, name) values (20, 'Divavu');
insert into categories (id, name) values (21, 'DabZ');
insert into categories (id, name) values (22, 'Edgetag');
insert into categories (id, name) values (23, 'Nlounge');
insert into categories (id, name) values (24, 'Roodel');
insert into categories (id, name) values (25, 'Dynava');
insert into categories (id, name) values (26, 'Oba');
insert into categories (id, name) values (27, 'BlogXS');
insert into categories (id, name) values (28, 'Skyndu');
insert into categories (id, name) values (29, 'Yakidoo');
insert into categories (id, name) values (30, 'Oyondu');
insert into categories (id, name) values (31, 'Browsetype');
insert into categories (id, name) values (32, 'Meejo');
insert into categories (id, name) values (33, 'Photobug');
insert into categories (id, name) values (34, 'Gabvine');
insert into categories (id, name) values (35, 'Buzzdog');
insert into categories (id, name) values (36, 'Gigabox');
insert into categories (id, name) values (37, 'Edgeclub');
insert into categories (id, name) values (38, 'Edgewire');
insert into categories (id, name) values (39, 'Tazz');
insert into categories (id, name) values (40, 'Yodoo');
insert into categories (id, name) values (41, 'Quamba');
insert into categories (id, name) values (42, 'Zazio');
insert into categories (id, name) values (43, 'Leenti');
insert into categories (id, name) values (44, 'Digitube');
insert into categories (id, name) values (45, 'Trunyx');
insert into categories (id, name) values (46, 'Jabbercube');
insert into categories (id, name) values (47, 'Dabtype');
insert into categories (id, name) values (48, 'Kwimbee');
insert into categories (id, name) values (49, 'Meevee');
insert into categories (id, name) values (50, 'Roomm');
insert into categories (id, name) values (51, 'Eabox');
insert into categories (id, name) values (52, 'Kazu');
insert into categories (id, name) values (53, 'Yoveo');
insert into categories (id, name) values (54, 'Quinu');
insert into categories (id, name) values (55, 'Edgeclub');