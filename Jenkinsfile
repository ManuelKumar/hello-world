node{
	
		defTomcatWeb = 'C:\\Manuel\\Projects\\apache-tomcat-9.0.44\\webapps\\'
		stage('SCM CheckOut') {
				git 'https://github.com/ManuelKumar/hello-world.git'
				
		}
		stage('Compile Package') {
			def JVMHOME = tool name: 'java8', type: 'jdk'
		   	def mvnHome = tool name:'maven-3', type: 'maven'	
			bat "${mvnHome}/bin/mvn clean install"
			//echo compile and 
		}
		stage('SonarQube Analysis') {
			def JVMHOME = tool name: 'java8', type: 'jdk'
			def mvnHome = tool name:'maven-3', type: 'maven'
			withSonarQubeEnv('sonar-6') {
			bat "${mvnHome}/bin/mvn org.codehaus.mojo:sonar-maven-plugin:2.4:sonar"
			}	
			//echo  Sonar Run Complete
		   	   
		}	
		stage('Deploy') {
		  	def JVMHOME = tool name: 'java8', type: 'jdk'	
			def mvnHome = tool name:'maven-3', type: 'maven'
			//deploy adapters: [tomcat8(credentialsId: 'Tomcat', path: '', url: 'http://localhost:8080')], contextPath: '/', war: '**/*.war'	
			//deploy adapters: [tomcat9(url: 'http://localhost:8080/', credentialsId: 'jenkins')], war: 'target/*.war', contextPath: '/'
		   	bat "${mvnHome}/bin/mvn tomcat:deploy   
		}
		
	
}
