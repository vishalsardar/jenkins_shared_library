def call(String url, String branch){
  echo "This is Code stage"
  git url: "${url}", branch: "${branch}"
}
