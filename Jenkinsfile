pipeline{
	
	agent any
	
	//def JVMHOME = tool name: 'java-1', type: 'jdk'
	tools {
	  jdk "java8"
	}	
	
	stages {
		stage('SCM CheckOut') {
			git 'https://github.com/ManuelKumar/hello-world'
		}
		stage('Compile Package') {
			def mvnHome = tool name:'maven-3', type: 'maven'
			bat "${mvnHome}/bin/mvn clean install"
			//echo compile and 

		}
		stage('SonarQube Analysis') {
			def mvnHome = tool name:'maven-3', type: 'maven'
			withSonarQubeEnv('sonar-6') {
			bat "${mvnHome}/bin/mvn sonar:sonar"
			}	
			//echo  Sonar Run Complete
		}	
		stage('Deploy') {
			//deploy adapters: [tomcat8(credentialsId: 'Tomcat', path: '', url: 'http://localhost:8080')], contextPath: '/', war: '**/*.war'	
			deploy adapters: [tomcat9(url: 'http://localhost:8080/', 
				      credentialsId: 'jenkins')], 
				war: 'target/*.war',
			     contextPath: '/'
		}
	}	
	
}
