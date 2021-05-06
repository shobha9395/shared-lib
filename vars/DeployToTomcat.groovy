def call (ip){
  sshagent(['Tomcat']) {
    sh "scp -o StrictHostKeyChecking=no target/myweb*.war ec2-user@${ip}:/opt/tomcat8/webapps/durga.war"
    sh "ssh ec2-user@${ip} /opt/tomcat8/bin/shutdown.sh"
    sh "ssh ec2-user@${ip} /opt/tomcat8/bin/startup.sh"
    
  }
  echo "Deploy to tomcat on ip= ${ip}"
}
