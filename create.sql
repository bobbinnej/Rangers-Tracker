CREATE DATABASE wildlife;
\c wildlife;

CREATE TABLE animals (id serial PRIMARY KEY, name varchar, category varchar, health varchar, age varchar, threattype varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, ranger varchar, animal varchar);
CREATE TABLE rangers (id serial PRIMARY KEY, ranger_name varchar, ranger_badge varchar, ranger_number varchar);
CREATE TABLE locations (id serial PRIMARY KEY, name varchar);