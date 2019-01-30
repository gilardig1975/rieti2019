# rieti2019

Eclipse

1. https://www.eclipse.org/downloads/packages/

2. Select "Eclipse IDE for Enterprise Java Developers"

3. Start workspace

4. Configure WebSphere Liberty profile

5. Help -> Market place -> Decompiler

6. Organize Import / Code Formatter / Working Set

Websphere Liberty profile

1. https://developer.ibm.com/wasdev/downloads/download-latest-stable-websphere-liberty-runtime/

2. Accept license and download

3. To install all the Java EE 8 features, run:

		bin/installUtility install javaee-8.0

4. Additional support (optional)
	Use installUtility (located in the wlp/bin folder) to install additional features from the Liberty Repository such as adminCenter-1.0, servlet-4.0, collectiveController-1.0:

		bin/installUtility install adminCenter-1.0

	Start the server using:

		bin/server start

	To deploy an application, copy the .war file to the serverÕs dropins directory:

		usr/servers/server-name/dropins

	There is no need to restart the server; the application should just work!
	Installing full Java EE 8 support


Java Development Kit 8

1. https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2. Choose appropriate version

3. Accept license and download


Cloud Foundry

1. https://docs.cloudfoundry.org/cf-cli/install-go-cli.html

2. Follow the instructions for your operating system. For Windows Installation go to "1. Download the Windows installer."

3. Push command

		cf push SampleWeb -b liberty-for-java -p <serverName> -u none --hostname <domain>.eu-gb.mybluemix.net

Putty

1. https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html

2. Choose the "Windows Installer" msi



Maven

1. https://maven.apache.org/download.cgi

2. Download binary version from the list



Git

1. https://git-scm.com/download/win

2. Download installer from the list



Event Streams | Message Hub

1. https://console.bluemix.net/docs/services/EventStreams/index.html#getting_started


Java Batch

	<authorization-roles id="com.ibm.ws.batch">
		<security-role name="batchAdmin">	
			<special-subject type="EVERYONE"/>
		</security-role>
		<security-role name="batchSubmitter">
			<special-subject type="EVERYONE"/>
		</security-role>
		<security-role name="batchMonitor">
			<special-subject type="EVERYONE"/>
		</security-role>
	</authorization-roles>


Spring

1. Spring boot initializer: https://start.spring.io/

2. Spring boot reference guide: https://docs.spring.io/spring-boot/docs/2.1.2.RELEASE/reference/

3. Spring reference guide

	pdf: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/pdf/
	html: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/
