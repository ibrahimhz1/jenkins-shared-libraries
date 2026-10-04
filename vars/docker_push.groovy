def call(String Project, String ImageTag, String dockerHubUser){
  echo "This is pushing image to Docker Hub ..."
  withCredentials([usernamePassword(
      credentialsId:"dockerHubCred", 
      passwordVariable: "dockerHubPass", 
      usernameVariable: "dockerHubUser")])
  {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker image tag ${Project}:${ImageTag} ${dockerHubUser}/${Project}:${ImageTag}"
  sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
