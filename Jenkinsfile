node {

   stage('Clone repository') { // for display purposes
      // Get some code from a GitHub repository
      git 'git@github.com:zfan40/musixise-llk-service.git'
   }

   stage('Build image') {
      // Run the maven build
      sh 'mvn clean package -DskipTests=true docker:build'

   }

   stage('Push image') {
      sh 'docker push registry.cn-qingdao.aliyuncs.com/musixise/musixise_blockly:0.0.1-SNAPSHOT'
      sh 'docker push registry.cn-qingdao.aliyuncs.com/musixise/musixise_blockly:latest'
   }

   stage('deploy iamegs'){
      try{
        sh 'docker rm -f musixise-blockly'
      }catch(e){
        // err message
      }
      sh 'docker run  --name musixise-blockly --link=mysql:mysql -d -p8083:8080 -e "SPRING_PROFILES_ACTIVE=prod" registry.cn-qingdao.aliyuncs.com/musixise/musixise_blockly'
   }
}