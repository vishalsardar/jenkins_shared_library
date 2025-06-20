def call(String username, String image, String tag){
  echo "This is Pushing image to DockerHub stage"
  echo "This is Push Stage"
  withCredentials([usernamePassword(
      credentialsId: 'dockerCred',
      usernameVariable: 'DOCKER_USERNAME',
      passwordVariable: 'DOCKER_PASSWORD')]){
          
          sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"   
      }
  
  sh "docker tag ${image}:${tag} ${username}/${image}:${tag}"
  sh "docker push ${username}/${image}:${tag}"
  echo "DockerHub login!!!! and Push Successfull"
}
