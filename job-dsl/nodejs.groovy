job('NodeJS example') {
    scm {
        git('https://github.com/muhzub-vagrant/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('muhzub-vagrant')
            node / gitConfigEmail('muhzub-vagrant@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
