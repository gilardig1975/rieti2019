package com.ibm.it.th.common.persistence.orm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


public class CustomLocalEntityManagerFactoryBean extends LocalEntityManagerFactoryBean
{
	@Override
	protected EntityManagerFactory createNativeEntityManagerFactory() throws PersistenceException
	{
		/*
		 * MAURI:fix required to avoid NoClassDefFoundError org/eclipse/persistence/sessions/server/ServerSession
		 * Breakpoints:
		 * AbstractAdvisorAutoProxyCreator [line: 70] [conditional] - getAdvicesAndAdvisorsForBean(Class<?>, String, TargetSource)	
		 * CustomLocalEntityManagerFactoryBean [line: 18] - createNativeEntityManagerFactory()	
		 * EntityManagerFactoryUtils [line: 130] - findEntityManagerFactory(ListableBeanFactory, String)	
		 * PersistenceAnnotationBeanPostProcessor [line: 357] - postProcessPropertyValues(PropertyValues, PropertyDescriptor[], Object, String)	
		 * PersistenceAnnotationBeanPostProcessor$PersistenceElement [line: 677] - getResourceToInject(Object, String)	
		 * LocalEntityManagerFactoryBean [entry] - createNativeEntityManagerFactory()	
		 */
		setEntityManagerFactoryInterface(EntityManagerFactory.class);
		setEntityManagerInterface(EntityManager.class);
		return Persistence.createEntityManagerFactory(getPersistenceUnitName());
	}
}
