def app
pipeline {
    agent any
    parameters{
        choice(name: 'VERSION', choices: ['1.0', '2.0', '3.0'], description: 'Choose the version to deploy')
        booleanParam(name: 'IS_TEST', defaultValue: true, description: 'Check to run tests')
    }
    stages {
        stage('Init') {
            script{
                app = Load('script.groovy')
                
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
                    app.deployApp()
                }
                echo "Deploying version ${params.VERSION}"
            }
        }
    }
}