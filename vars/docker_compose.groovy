def call(){
  echo "This is deploying the code ..."
  sh "docker compose down && docker compose up -d"
}
