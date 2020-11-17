pipeline {
    agent {
        docker{
            image "maven:3.6.0-jdk-11"
            label "docker"
        }
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn -version"
                sh "mvn clean"
            }
        }
        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
        stage('Deploy') {
            steps {
                sh "mvn package"
            }
        }
    }

    post{
        always{
            cleanWs()
        }
    }
}