package com.oracle.bir.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName="PerformanceFilter", urlPatterns={"*.do"})
public class PerformanceFilter implements Filter {

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		long time = end - start;
		
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURL().toString();
		System.err.println(url + " : " + time + "ms");
		
        StringBuffer logMessage = ((HttpServletRequest) request).getRequestURL();
		logMessage.append("] = ");
		logMessage.append(end - start);
		logMessage.append("ms");
		logMessage.insert(0, "[");
 
        config.getServletContext().log(logMessage.toString());
	}

	@Override
	public void destroy() {
		
	}
	
}
