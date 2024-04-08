pipeline {
    agent any
    parameters{
        choice(name: 'VERSION', choices: ['1.0', '2.0', '3.0'], description: 'Choose the version to deploy')
        booleanParam(name: 'IS_TEST', defaultValue: true, description: 'Check to run tests')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            when{
                expression { params.IS_TEST == true }
            }
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                echo "Deploying version ${params.VERSION}"
            }
        }
    }
}