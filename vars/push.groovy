def call(String imagge, String tag){
  echo "This is Pushing image to DockerHub stage"
  withCredentials([usernamePassword(
      credentialsId: 'dockerHubCred',
      usernameVariable: 'dockerHubUser',
      passwordVariable: 'dockerHubPass'
  )]) {
      sh 'echo "Logging in to DockerHub"'
      sh 'docker login -u "$dockerHubUser" -p "$dockerHubPass"'
      sh "docker image tag ${image}:${tag} \$dockerHubUser/${image}:${tag}"
      sh "docker push \$dockerHubUser/${image}:${tag}"
      echo "Login successful, Image Pushed to DockerHub"
  }
}
