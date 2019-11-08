### Overview

This document and project work serves to demonstrate my efforts to showcase my web development skills.

## Application

Here is a view of my application:

![](https://bitbucket.org/tach9593/quoteservice/raw/6cafce3b07fb461cb798dc290c891402307467e6/GardenQuotesProject.png)

### How to Use the Application

**Step 1**: Open the web page using [http://localhost:4200/](http://localhost:4200/) and when the page loads enter a search term. Use full words. There are no restrictions in the number of characters you search on.

**Step 2**: Click on 'Find' button to find any quote containing your term.

**Step 3**: The results that match your search display alphabetically by Quote in a table.

The app uses Public API called Quote Garden.  It is a REST API for quotes. The database currently includes more than 5000 quotes.  

Only the search term API feature is utilized. For information about this Public API read https://pprathameshmore.github.io/QuoteGarden/#get-all-quotes.
Use this link to test if the service is up and running: https://quote-garden.herokuapp.com/

**Table of Contents**

[TOC]

# Installation

The installation requires Nodejs.  You need to execute a Java executable jar file which runs a Springboot microservice.

##Steps

**Step 1**: Open a command window and clone this project from bitbucket.git "clone https://bitbucket.org/tach9593/quoteservice.git"

**Step 2**: Now change the directory to the project "cd /<project path>/quoteservice/src/main/js/angularclient"

**Step 3**: Run "npm install".  Make sure the node modules folder is installed. 

**Step 4**: Now open your IDE.  You need to build the Spring project. Using your IDE, import the project quoteservice from the file system. Run a Maven build to create the jar.   Under the projects target folder locate quoteservice-0.0.1-SNAPSHOT.jar.  This is an executable jar file. Double click on this file to start up the service. There currently isn't an exit code shut off the service. You'll need to manually kill the running task on your machine.
Make sure the Tests run successfully:
[INFO] Results:
[INFO] 
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0


**Step 5**: Go back to the command window and change directory back to the angularclient folder (/quoteservice/src/main/js/angularclient).  Run "ng serve --open" to start the server. 

**Step 6**: The browser window should load automatically to page [http://localhost:4200/](http://localhost:4200/). Test the Web App.
