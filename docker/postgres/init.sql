create table if not exists pokemon(
    id serial primary key,
    pokedex integer not null,
    name varchar(50) not null
);

CREATE TABLE IF NOT EXISTS player(
      id        UUID PRIMARY KEY,
      name      VARCHAR(180) NOT NULL,
      createdOn VARCHAR(50) NOT NULL
);