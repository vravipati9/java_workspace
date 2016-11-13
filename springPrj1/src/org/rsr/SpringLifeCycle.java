package org.rsr;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SpringLifeCycle implements InitializingBean, DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("bean desttoryed");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean initialized");
		
	}
}
