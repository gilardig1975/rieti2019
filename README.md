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


Java Tutorial

1. Thinking in Java (Bruce Eckel)


JEE Tutorial

1. https://javaee.github.io/tutorial/


Spring

1. Spring boot initializer: https://start.spring.io/

2. Spring boot reference guide: https://docs.spring.io/spring-boot/docs/2.1.2.RELEASE/reference/

3. Spring reference guide

	pdf: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/pdf/

	html: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/

4. Sample application context

		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns:context="http://www.springframework.org/schema/context"
			xsi:schemaLocation="http://www.springframework.org/schema/beans
			http://www.springframework.org/schema/beans/spring-beans.xsd
			http://www.springframework.org/schema/context
			http://www.springframework.org/schema/context/spring-context.xsd">

			<!--<context:component-scan base-package="it.sistinf.wave3.pippo" />-->

		</beans>

5.Sample interceptor configuration

		<?xml version="1.0" encoding="UTF-8"?>
		<beans xmlns="http://www.springframework.org/schema/beans"
			xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xmlns:aop="http://www.springframework.org/schema/aop"
			xsi:schemaLocation="
				http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
				http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
			">

			<import resource="classpath:resources/st/applicationContext.xml"/>

			<aop:aspectj-autoproxy/>

			<bean id="serviceInterceptor" class="it.sistinf.wave3.spring.util.ServiceInterceptor" scope="singleton" /> 
			<aop:config>
				<aop:aspect ref="serviceInterceptor">
					<!--
						A business service is the execution of any method defined on a service
						interface. This definition assumes that interfaces are placed in the
						"service" package, and that implementation types are in sub-packages.

						If you group service interfaces by functional area (for example,
						in packages com.xyz.someapp.abc.service and com.xyz.someapp.def.service) then
						the pointcut expression "execution(* com.xyz.someapp..service.*.*(..))"
						could be used instead.

						Alternatively, you can write the expression using the 'bean'
						PCD, like so "bean(*Service)". (This assumes that you have
						named your Spring service beans in a consistent fashion.)
					-->
					<aop:pointcut id="serviceExecution" expression="execution(public * it.sistinf.wave3.spring.mallo..*(..)))"/>
					<aop:around pointcut-ref="serviceExecution" method="around"/>
				</aop:aspect>
			</aop:config>

		</beans>


5. Persistence configuration

		<bean id="emf" class="org.springframework.orm.jpa.LocalEntityManagerFactoryBean"> 
			<property name="persistenceUnitName" value="${persistence.unit.name}" />
		</bean>
		<bean id="txManager" class="org.springframework.orm.jpa.JpaTransactionManager">
			<property name="entityManagerFactory" ref="emf" />
		</bean>
