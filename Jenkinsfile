pipeline{
     agent any
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