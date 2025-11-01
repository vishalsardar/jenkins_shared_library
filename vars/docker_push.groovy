def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-token', passwordVariable: 'dockerhubpass', usernameVariable: 'dockeruser')]){
    sh "docker login -u ${dockeruser} -p ${dockerhubpass}"
  }
  sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
