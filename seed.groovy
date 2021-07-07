
  pipelineJob('frontend-ci') {
    configure { flowdefinition ->
      flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
        'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'refspec'('\'+refs/tags/*\':\'refs/remotes/origin/tags/*\'')
              'url'('https://github.com/zssravani/frontend.git')
            }
          }
          'branches' {
            'hudson.plugins.git.BranchSpec' {
              'name'('*/main/*')
            }
          }
        }
        'scriptPath'('Jenkinsfile')
        'lightweight'(true)
      }
    }
  }





