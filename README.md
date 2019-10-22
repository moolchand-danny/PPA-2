# Professional Practice Assignment 2 - CIS4930

#### Authors: Danny Moolchand, Timothy Crowley  

----

### Table of Contents

  - [Table of Contents](#table-of-contents)
  - [Prerequisites](#prerequisites)
  - [Project Setup](#project-setup)
  - [Phase 1: Setting Up](#phase-1-setting-up-ppa1-code-for-continuous-integration)
  - [Phase 2: Docker Database](#phase-2-adding-data-storage--retreival-using-a-docker-database-container)
  - [Phase 3: Web-Enabled Interface](#phase-3-creating-a-web-enabled-interface-for-backend-function)
  - [Phase 4: Completed Pipeline and Stages](#phase-4-complete-ci-pipeline-with-build-and-test-stages)

----
### Prerequisites
**Docker Command to Setup MariaDB MySQL Server:**

docker run --name database -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mariadb/server:10.3

**To start the database if it does not start**

docker start database

**Base URL for Web Interface:**

localhost:5000

| **Paths** | **Purpose** |
| --- | --- |
| /distance  | View distance table in database  |
| /bmi  | View bmi table in database  |
| /distance/:x1/:y1/:x2/:y2  | Perform the distance calculation and store in database.   |
| /bmi/:weight/:feet/:inches  | Perform the bmi calculation and store in database.  |

### Project Setup

This is a Java Maven project. In order to run this yourself, you need the following:

[Java SE Development Kit 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  
[Eclipse IDE](https://www.eclipse.org/eclipseide/2018-12/)  
[Docker](https://docs.docker.com/toolbox/toolbox_install_windows/)  
[Git](https://git-scm.com/downloads)

**Setting up the project in Eclipse:**
  1. Navigate to the directory where you want the project to be stored
  2. Open terminal/command prompt and clone this repo to that directory
  3. In Eclipse go to File > Import > Projects from Git > Existing Local Repository
  4. Click on Add > Browse and navigate to the newly created PPA-2 folder.
  5. Select the new project and click finish.
  6. Click on PPA2-2 > Next
  7. Select "Import Existing Eclipse Projects" > Next > Finish

Now the project can be run from the "main.java" file. 


### Phase 1: Setting Up PPA1 Code for Continuous Integration
Screencast of Running Unit Tests on Jenkins Server
![Phase 1 Screencast of Running Tests on Jenkins Server](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Phase1.gif)


---

### Phase 2: Adding Data Storage & Retreival Using a Docker Database Container
Screencast of Storing and Retrieving Data from MySQL Database. Testing with the BMI function. (Also works for distance function)
![Phase 2 Screencast of Storing and Retrieving Data from MySQL Database](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Phase2.gif)

---

### Phase 3: Creating a Web-Enabled Interface for Backend Function
Screencast of Testing Distance GET/POST on Web Interface. Testing with the DISTANCE function. (Also works for /BMI)
![Phase 3 Screencast of Testing Distance GET/POST on Web Interface](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Phase3.gif)

---

### Phase 4: Complete CI Pipeline with Build and Test Stages
Screencast of completed pipline running on Jenkins server.
![Phase 4 Screencast of ](https://raw.githubusercontent.com/moolchand-danny/PPA-2/master/readme_assets/Phase4.gif)

---



