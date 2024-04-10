pipeline {
    agent any
    stages {
        stage('Jenkins Tool') {
            steps {
                echo 'Tool Interface'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean install'
            }
        }      
    }
}