package com.tutu.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tutu.vo.UserInfoVO;


public class MyInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		UserInfoVO user = (UserInfoVO)session.get("user");
		if(null==user){
			return Action.LOGIN; 
		}
		return invocation.invoke();
	}




}
