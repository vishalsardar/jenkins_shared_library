def call(){
  echo "This is Build stage"
  sh 'docker build -t notes-app:latest .'
}
