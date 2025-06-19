def call(String image, String tag){
  echo "This is Build stage"
  sh "docker build -t ${image}:${tag} ."
}
