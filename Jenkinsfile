@Library('deploy-conf') _
node() {
    try {
        String ANSI_GREEN = "\u001B[32m"
        String ANSI_NORMAL = "\u001B[0m"
        String ANSI_BOLD = "\u001B[1m"
        String ANSI_RED = "\u001B[31m"
        String ANSI_YELLOW = "\u001B[33m"

        stage('checkout public repo') {
		println "Jenkinsfile abcd"
            folder = new File("$WORKSPACE/.git")
            if (folder.exists())
            {
               println "Found .git folder. Clearing it.."
               sh'git clean -fxd'
            }
            checkout scm
        }

        ansiColor('xterm') {
            stage('deploy'){
                values = [:]
                envDir = sh(returnStdout: true, script: "echo $JOB_NAME").split('/')[-3].trim()
                module = sh(returnStdout: true, script: "echo $JOB_NAME").split('/')[-2].trim()
                jobName = sh(returnStdout: true, script: "echo $JOB_NAME").split('/')[-1].trim()
                currentWs = sh(returnStdout: true, script: 'pwd').trim()
                
                ansiblePlaybook = "${currentWs}/ansible/lp_cassandra_db_update.yml"
                ansibleExtraArgs = "--vault-password-file /var/lib/jenkins/secrets/vault-pass"
                values.put('currentWs', currentWs)
                values.put('env', envDir)
                values.put('module', module)
                values.put('jobName', jobName)
                values.put('ansiblePlaybook', ansiblePlaybook)
                values.put('ansibleExtraArgs', ansibleExtraArgs)
                println values
                ansible_playbook_run(values)
                currentBuild.result = "SUCCESS"
                currentBuild.description = "Artifact: ${values.artifact_version}, Private: ${params.private_branch}, Public: ${params.branch_or_tag}"
             }
        }
         summary()
     }
    catch (err) {
        currentBuild.result = "FAILURE"
        throw err
    }
    finally {
        slack_notify(currentBuild.result)
        email_notify()
    }
}
