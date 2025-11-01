def call(String ProjectName, String ImageTag){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-token', passwordVariable: 'dockerhubpass', usernameVariable: 'dockeruser')]){
    sh "docker build -t ${dockeruser}/${ProjectName}:${ImageTag} ."
    sh "docker login -u ${dockeruser} -p ${dockerhubpass}"
    sh "docker push ${dockeruser}/${ProjectName}:${ImageTag}"
  }
}
