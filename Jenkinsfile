pipeline {

    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {


        stage('Build') {
            steps {
                echo 'In Build Stage'
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Junit Tests') {
            steps {
                sh 'mvn test -Dtest=mainTest'
            }
        }
        
        stage('HTTP Tests') {
            steps {
                sh 'mvn test -Dtest=httpTest'
            }
        }
        
        stage('Stub Tests') {
            steps {
                sh 'mvn test -Dtest=stubTest'
            }
        }

        stage('Deliver') {
            steps {
                echo 'In Deliver Stage. Not sure if this is needed'
            }
        }


    }
}
