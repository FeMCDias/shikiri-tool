pipeline {
    agent any
    stages {
        stage('Jenkins Tool') {
            steps {
                echo 'Jenkins Tool'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean install'
            }
        }      
    }
}