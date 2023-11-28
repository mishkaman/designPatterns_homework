pipeline {
  agent any
  stages {
    stage('maven version') {
      parallel {
        stage('maven version') {
          steps {
            sh 'mvn --version'
          }
        }

        stage('test run') {
          steps {
            sh 'mvn clean test'
          }
        }

      }
    }

  }
}