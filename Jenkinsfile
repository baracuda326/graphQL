pipeline{
     agent any
     stages{
        stage('---clean---'){
            steps{
                bat "mvn clean"
            }
        }
        stage('---test---'){
            steps{
                bat "mvn test"
            }
        }
        stage('---package---'){
            steps{
                bat "mvn package"
            }
        }
        stage('---email---'){
            emailext body: 'build info', subject: 'build jenkins', to: 'dmitry.asmalouski@gmail.com'
        }
     }
}