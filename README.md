### Overview

This document and project work serves to showcase my web development skills. The application represents my code challenge.

### Application

Here is a sample of my application (a viewer of things):

![](https://github.com/tach9593/quotesserver/blob/master/GardenQuotesProject.png?raw=true)

### About

**Step 1**: Open the web page using [http://localhost:4200/](http://localhost:4200/) and when the page loads enter a search term. Use full words. There are no restrictions in the number of characters you search on.

**Step 2**: Click on 'Find' button to find any quote containing your term.

**Step 3**: The results that match your search display alphabetically by Quote in a table.

The app uses Public API called Quote Garden.  It is a REST API for quotes. The database currently includes more than 5000 quotes.  

Only the search term API feature is utilized. For information about this Public API read https://pprathameshmore.github.io/QuoteGarden/#get-all-quotes.
Use this link to test if the service is up and running: https://quote-garden.herokuapp.com/

## Installation

The installation requires Nodejs.  You need to execute a Java executable jar file which runs a Springboot microservice.

## Steps

**Step 1**: Open a command window and clone this project from github "git clone https://github.com/tach9593/quotesserver.git"

**Step 2**: Now change the directory to the project "cd /'project path'/src/main/js/angularclient"

**Step 3**: Run "npm install".  Make sure the node modules folder is installed. 

**Step 4**: Now open your IDE.  You need to build the Springboot project. Using your IDE, import the project quoteservice from your local file system. Run a Maven install build target to create the jar.   Find the location of the executable jar and double click on  quoteservice-0.0.1-SNAPSHOT.jar.   There currently isn't an easy way to terminate the microservice (See TODO #7). You'll need to manually kill the running process on your machine or run a post request "http://localhost:8080/shutdownContext" through Postman.
Make sure the Tests run successfully:
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0


**Step 5**: Go back to the command window and change directory back to the angularclient folder (/quoteservice/src/main/js/angularclient).  Run "ng serve --open" to start the server. 

**Step 6**: The browser window should load automatically to page [http://localhost:4200/](http://localhost:4200/). Test the Web App.

## TODOS

**1.** Upgrade Angular to version 7 from 5

**2.** Finish error handling on client side and enhance file logging on microservice side

**3.** Clean up Typescript

**4.** Add spinner to page

**5.** Finish writing Unit Tests

**6.** Write client Unit Tests

**7.** Implement a better solution to kill the microservice process
