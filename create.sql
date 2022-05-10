CREATE DATABASE wildlife;
\c wildlife;

CREATE TABLE animals (id serial PRIMARY KEY, name varchar, category varchar, health varchar, age varchar, threattype varchar);
CREATE TABLE sightings (id serial PRIMARY KEY, name varchar);
CREATE TABLE rangers (id serial PRIMARY KEY, rangerName varchar, rangerBadge varchar, rangerId int);
CREATE TABLE locations (id serial PRIMARY KEY, name varchar);