# rieti2019

Eclipse

1. https://www.eclipse.org/downloads/packages/

2. Select "Eclipse IDE for Enterprise Java Developers"


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


Putty

1. https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html

2. Choose the "Windows Installer" msi
