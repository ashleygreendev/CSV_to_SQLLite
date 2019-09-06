# CSV_to_SQLLite

## Purpose of this Repo
    The purpose of this repo is to convert input CSV data into an SQLite database with minimalistic validation.

## Required Libraries, Tools, or Frameworks
    Maven should be installed as well as the proper JDK (Version 8 or above)

## Dependencies 
    opencsv
    sqlite-jdbc

## Assumptions Made
    1. the name of the DB should be the name of the CSV file. In this case, ms3Interview
    2. data validation should focus on whether the data exists. Further validation should be approached in several      ways
## How to Run the Project
    1. mvn compile
    2. mvn install
