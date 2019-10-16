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

        stage('Junit Function Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    sh 'echo 'hello''
                }
            }
        }

        stage('Deliver') {
            steps {
                echo 'In Deliver Stage'
            }
        }


    }
}