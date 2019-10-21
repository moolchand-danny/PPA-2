# Professional Practice Assignment 2 - CIS4930

#### Authors: Danny Moolchand, Timothy Crowley  

----

### Table of Contents

  - [Table of Contents](#table-of-contents)
  - [Prerequisites](#prerequisites)
  - [Phase 1: Setting Up](#phase-1-setting-up-ppa1-code-for-continuous-integration)
  - [Phase 2: Docker Database](#phase-2-adding-data-storage--retreival-using-a-docker-database-container)
  - [Phase 3: Web-Enabled Interface](#phase-3-creating-a-web-enabled-interface-for-backend-function)
  - [Phase 4: Completed Pipeline and Stages](#phase-4-complete-ci-pipeline-with-build-and-test-stages)

----
### Prerequisites
Docker command to setup MariaDB MySQL server:

docker run --name database -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mariadb/server:10.3

Base URL: localhost:5000

| Path | Purpose |
| --- | --- |
| /distance  | View distance table in database  |
| /bmi  | View bmi table in database  |
| /distance/:x1/:y1/:x2/:y2  | Perform the distance calculation and store in database.   |
| /bmi/:weight/:feet/:inches  | Perform the bmi calculation and store in database.  |


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



