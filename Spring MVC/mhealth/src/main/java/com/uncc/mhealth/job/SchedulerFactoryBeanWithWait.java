package com.uncc.mhealth.job;

import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class SchedulerFactoryBeanWithWait extends SchedulerFactoryBean{

	@Override
	public void destroy() throws SchedulerException{
		super.destroy();
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
