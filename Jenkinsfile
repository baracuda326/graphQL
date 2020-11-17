pipeline{
     agent any
     stages{
        stage('---maven---'){
            agent{
                docker{image 'maven:3-alpine'}
            }
            steps{
            sh 'mvn --version'
            }
        }
        stage('---clean---'){
            steps{
                sh "mvn clean"
            }
        }
        stage('---test---'){
            steps{
                sh "mvn test"
            }
        }
        stage('---package---'){
            steps{
                sh "mvn package"
            }
        }
     }
}