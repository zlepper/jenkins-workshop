node {
    stage ('Preparation'){
        //Using the Pretested integration plugin to checkout out any branch in the ready namespace
        checkout(
            [$class: 'GitSCM',
            branches: [[name: '*/ready/**']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CleanBeforeCheckout'],
            pretestedIntegration(gitIntegrationStrategy: accumulate(),
            integrationBranch: 'master',
            repoName: 'origin')],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: 'zlepepr', //remember to change credentials and url.
            url: 'git@github.com:zlepper/jenkins-workshop.git']]])
    }
    
    stage ('build'){
        sh 'mvn clean package'
    }
    
    stage("Results") {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/gildedrose-*.jar'
    }
    stage("publish"){
        //This publishes the commit if the tests have run without errors
        pretestedIntegrationPublisher()
    }
    
    /*stage("Javadoc") {
        sh 'mvn site'
        archiveArtifacts 'target/javadoc'
    }*/
}