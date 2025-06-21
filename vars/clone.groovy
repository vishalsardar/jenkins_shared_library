def call(String url, String branch){
  echo "This is a Code Clone stage"
  git url:"${url}",branch:"${branch}"
  echo "Code Cloned"
}
