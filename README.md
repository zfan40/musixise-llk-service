# musixise-llk-service
musixise llk api, generally the same as mb service
# musixise-mb-service

导入代码
$ git init
$ git remote add origin git@github.com:zfan40/musixise-llk-service.git


启动方法

mvn -Pprod clean package  -Dmaven.test.skip=true -X

BUILD_ID=dontKillMe /var/lib/jenkins/spring-boot-jenkins/api-deploy.sh dev 8082 musixise-new application-localhost.yml
