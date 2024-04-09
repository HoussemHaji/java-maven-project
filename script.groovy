def buildApp(){
    echo "building the application..."
}

def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    sh "docker build -t lh0ss/java-demo-app:2.0 ."
    sh "docker push lh0ss/java-demo-app:2.0"
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this