def call(String image, String tag){
  echo "This is a build stage"
  sh "docker build -t ${image}:${tag} ."
  echo "Build Completed"
}
