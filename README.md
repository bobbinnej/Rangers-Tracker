# Rangers Tracker
Rangers Tracker is a java web Application that allows rangers track wildlife sighting in the forest area
## Author
Jackline Njoroge

## Description
In very simple terms... This project will enable rangers track endagered animals and other wild animlas.
## Behaviour Driven Development
BDD focuses on the expected user experience with the app.
<br>
As the creator the intended functionality for this application is that the user will:
<br>
1. First go through a landing a with a brief description of the app.
2. Add a new ranger and see a list of existing rangers who are stored in the database.
3. Upon sighting wildlife the ranger should be able to navigate to sightings page and input information of id of endagered<br>or wildlife animal species, location of sighting and ranger (s) who spotted the animal.
4. Because we are more concerned on endagered species, the user should then navigste to the endagered animals page and input information about their id, name, health and age.
5. Finally go to the location page and see all locations in the area and be able to click a location to display all sightings in that area.

The application has undergone junit testing to ensure it works as expected.


## Technologies Used

- Intellij IDE.
  Gradle (JUnit).
  Postgres - To create a database
  Heroku and maven - To deploy the Application

## Set Up Instructions
- Clone this repository to a location in your file system.  https://github.com/bobbinnej/Rangers-Tracker
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

  ``# CREATE DATABASE wildlife_tracker``

  ``#\c wildlife_tracker``

  ``#CREATE TABLE animals ( id SERIAL PRIMARY KEY,name VARCHAR, age INTEGER,health VARCHAR, endangered BOOLEAN);``

  ``#CREATE TABLE rangers (id SERIAL PRIMARY KEY, name VARCHAR, badge VARCHAR);``

  ``#CREATE TABLE places (id SERIAL PRIMARY KEY, name VARCHAR)``

  ``#CREATE TABLE sightings (id SERIAL PRIMARY KEY, animalid INTEGER, rangerid INTEGER, placeid INTEGER)``

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

