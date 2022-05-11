# Rangers Tracker
Rangers Tracker is a java web Application that allows rangers track wildlife sighting in the forest area and zoned areas. https://rangers-tracker.herokuapp.com/
## Author
Jackline Njoroge

## Description
In very simple terms... This application will enable rangers track endangered animals and other wild animals.
## Behaviour Driven Development
BDD focuses on the expected user experience with the app.
<br>
As the creator the intended functionality for this application is that the user will:
<br>
1. First go through a landing page a with a brief description of the app.
2. Add a new ranger and see a list of existing rangers who are stored in the database.
3. Upon sighting wildlife the ranger should be able to navigate to sightings page and input information of endangered<br>or wildlife animal species, location of sighting and ranger (s) who spotted the animal as well as its type.
4. Because we are more concerned on endangered species, the user should be able to specify whether the animal is endangered or not and input information about their id, name, health and age.
5.  The application makes it possible for the user to be able to save new rangers and new locations aside animals.

The application has undergone junit testing to ensure it works as expected.


## Technologies Used

- Intellij IDE.
  Gradle (JUnit).
  Postgres - To create a database
  Heroku and maven - To deploy the Application

## Set Up Instructions
- Clone this repository to a location in your file system. https://github.com/bobbinnej/Rangers-Tracker-for-Wildlife
- Open terminal then navigate to the root folder of the application. `cd rangers-tracker`
- Gradle build.
- Install postgres as mentioned below:

  ``sudo apt-get update``

  ``sudo apt-get install postgresql postgresql-contrib libpq-dev``

  Once it is done installing run

  ``sudo -u postgres createuser --superuser $USER``  
  to create  super user. Enter  desired password when prompted.
  
  Login into postgres with the following command:
  ``sudo -u postgres psql``
  Type psql on your terminal to connect to the server:

  ``psql``

- Restore the database schema (tables and columns) by running the following commands:

  ``# CREATE DATABASE wildlife``

  ``#\c wildlife``

  ``#CREATE TABLE animals (id serial PRIMARY KEY, name varchar, category varchar, health varchar, age varchar, threattype varchar);``
  `CREATE TABLE sightings (id serial PRIMARY KEY, location varchar, ranger varchar, animal varchar, type varchar);`
  `CREATE TABLE rangers (id serial PRIMARY KEY, ranger_name varchar, ranger_badge varchar, ranger_number varchar);`
 ` CREATE TABLE locations (id serial PRIMARY KEY, name varchar);`
## Development

To fix a bug or enhance an existing module, follow these steps:
- Fork the repo
- Create a new branch (git checkout -b improve-feature)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (git commit -am 'Improve feature')
- Push to the branch (git push origin improve-feature)
- Create a Pull Request


## Known Bugs

If you find a bug or would like to request a new function, reach out to me via bobbinnej@gmail.com

