package it.sistinf.wave3.spring.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceInterceptor
{

	private static Logger log = LoggerFactory.getLogger(ServiceInterceptor.class);

	public final Object around(ProceedingJoinPoint pjp) throws Throwable
	{

		Object output = null;
		String target = getTarget(pjp);

		before(pjp);
		try
		{
			output = pjp.proceed();

			after(pjp, output);

		} catch (Throwable e)
		{
			if (e instanceof Error)
				throw e;
			else
				doCatch(pjp, e);
		} finally
		{
			doFinally(pjp, output);
		}
		return output;
	}

	protected void before(ProceedingJoinPoint pjp)
	{
		log.info("BEFORE {}", getTarget(pjp));
		//NDC.push(target);
	}

	protected void after(ProceedingJoinPoint pjp, Object result)
	{
		log.info("AFTER {}", getTarget(pjp));
	}

	protected void doCatch(ProceedingJoinPoint pjp, Throwable t)
	{
		log.error("EXCEPTION " + t.getMessage(), t);
	}

	protected void doFinally(ProceedingJoinPoint pjp, Object result)
	{
		//NDC.pop();
	}

	protected String getTarget(ProceedingJoinPoint pjp)
	{
		try
		{
			return pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName();
		} catch (Throwable e)
		{
			return getClass().getName();
		}
	}

}
