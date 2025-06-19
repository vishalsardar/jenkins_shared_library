def call(){
  echo "This is Pushing image to DockerHub stage"
  withCredentials([usernamePassword(
      credentialsId: 'dockerHubCred',
      usernameVariable: 'dockerHubUser',
      passwordVariable: 'dockerHubPass'
  )]) {
      sh '''
          echo "Logging in to DockerHub"
          docker login -u "$dockerHubUser" -p "$dockerHubPass"
          docker image tag notes-app:latest "$dockerHubUser/notes-app:latest"
          docker push "$dockerHubUser/notes-app:latest"
          echo "Login successfull Image Pushed to DockerHub"
      '''
  }
}
