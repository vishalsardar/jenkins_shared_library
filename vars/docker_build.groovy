def call(String ProjectName,String ImageTag,String dockerHubUSer){
  sh "docker build -t ${dockerHubUSer}/${ProjectName}:${ImageTag} ."
}
