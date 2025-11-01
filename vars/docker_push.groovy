def call(String Project, String ImageTag){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-token', passwordVariable: 'dockerhubpass', usernameVariable: 'dockeruser')]){
    sh "docker login -u ${dockeruser} -p ${dockerhubpass}"
    sh "docker push ${dockeruser}/${Project}:${ImageTag}"
  }
}
