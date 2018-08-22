pipeline {
    triggers {
      pollSCM '* * * * */1'
    }
}

node {

    stage ('Preparation'){
        checkout scm
    }

    stage ('build'){
        sh 'mvn clean package'
    }

    stage("Results") {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/gildedrose-*.jar'
    }

    /*stage("Javadoc") {
        sh 'mvn site'
        archiveArtifacts 'target/javadoc'
    }*/
}