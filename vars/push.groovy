def call(String imagge, String tag){
  echo "This is Pushing image to DockerHub stage"
  withCredentials([usernamePassword(
      credentialsId: 'dockerHubCred',
      usernameVariable: 'dockerHubUser',
      passwordVariable: 'dockerHubPass'
  )]) {
      sh """
          echo "Logging in to DockerHub"
          docker login -u "$dockerHubUser" -p "$dockerHubPass"
          docker image tag notes-app:latest "$dockerHubUser/$imagge:$tag"
          docker push "$dockerHubUser/$image:$tag"
          echo "Login successfull, Image Pushed to DockerHub"
      """
  }
}
