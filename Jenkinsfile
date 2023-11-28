pipeline {
  agent any
  stages {
    stage('maven version') {
      parallel {
        stage('maven version') {
          steps {
            bat 'mvn --version'
          }
        }

        stage('test run') {
          steps {
            bat 'mvn clean test'
          }
        }

      }
    }

  }
}