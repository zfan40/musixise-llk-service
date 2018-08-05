node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */

        sh 'mvn clean package -DskipTests=true docker:build'
    }

    stage('Test image') {
        /* Ideally, we would run a test framework against our image.
         * For this example, we're using a Volkswagen-type approach ;-) */

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        /* Finally, we'll push the image with two tags:
         * First, the incremental build number from Jenkins
         * Second, the 'latest' tag.
         * Pushing multiple tags is cheap, as all the layers are reused. */
        docker.withRegistry('registry.cn-qingdao.aliyuncs.com/musixise/musixise_blockly', 'aliyun-docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }

    stage('Deploy image') {
            /* Ideally, we would run a test framework against our image.
             * For this example, we're using a Volkswagen-type approach ;-) */

            app.inside {
                sh 'echo "Deploy passed"'
                sh 'docker run  --name musixise-blockly --link=mysql:mysql -d -p8083:8080 -e "SPRING_PROFILES_ACTIVE=prod" registry.cn-qingdao.aliyuncs.com/musixise/musixise_blockly'

            }
        }
}