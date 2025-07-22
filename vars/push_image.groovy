def call(String username, String image, String tag){
  echo "This is Push stage"
  withCredentials([usernamePassword(
      credentialsId: 'dockerCred',
      usernameVariable: 'DOCKER_USER',
      passwordVariable: 'DOCKER_PASS'
      )]){
          sh "docker login -u $DOCKER_USER -p $DOCKER_PASS"
      }
  sh "docker image tag ${image}:${tag} ${username}/${image}:${tag}"
  sh "docker push ${username}/${image}:${tag}"
}
