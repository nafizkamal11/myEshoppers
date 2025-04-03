create table users(
	id int not null auto_increment,
	user_name varchar(50) not null,
    password varchar(500) not null,
    enabled boolean not null,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null,

    primary key(id)
);

create table roles (
	id int not null auto_increment,
    name varchar(50) not null,

    primary key(id)
);

create table users_roles(
	users_id int,
    roles_id int,

    primary key(users_id, roles_id),
    foreign key(users_id) references users(id),
    foreign key(roles_id) references roles(id)
);