pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

                withMaven(maven: 'maven_3_6_3') {
                    sh 'mvn clean install'

                }

            }
        }
    stage ('Test Stage') {

            steps {

                withMaven(maven: 'maven_3_6_3') {
                    sh 'mvn test'

                }

            }
        }

    stage('Deploy to Staging'){
        steps {
                echo "Ok"
            }
    }

//     stage ('Cucumber Reports') {
//
//         steps {
//             cucumber buildStatus: "UNSTABLE",
//                 fileIncludePattern: "**/cucumber.json",
//                 jsonReportDirectory: 'target'
//
//         }
//
//     }

    }

}