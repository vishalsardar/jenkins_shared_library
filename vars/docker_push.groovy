def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerhubpass', usernameVariable: 'dockeruser')]){
    sh "docker login -u ${dockeruser} -p ${dockerhubpass}"
  }
  sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
