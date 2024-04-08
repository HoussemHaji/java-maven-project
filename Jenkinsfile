def app
pipeline {
    agent any
    parameters{
        choice(name: 'VERSION', choices: ['1.0', '2.0', '3.0'], description: 'Choose the version to deploy')
        booleanParam(name: 'IS_TEST', defaultValue: true, description: 'Check to run tests')
    }
    stages {
        stage('Init') {
            steps {
                script{
                    app = load 'script.groovy'
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    app.buildApp()
                } 

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
                script{
                    env.ENV = input message: 'Choose the environment to deploy', parameters: [choice(name: 'ENV', choices: ['DEV', 'STAGE', 'PROD'], description: 'Choose the environment to deploy')]
                    app.deployApp()
                    echo "Deploying ${ENV} environment"

                }
            }
        }
    }
}