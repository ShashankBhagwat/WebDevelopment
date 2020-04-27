package com.test.servlet.listener.requestlistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

	public RequestListener() {
	}

	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("Request Destroy");
	}

	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("Request Created");
	}

}
