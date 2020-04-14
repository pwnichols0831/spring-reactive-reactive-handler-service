/**
 * 
 */
package com.clc.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.clc.reactive.handler.MessageHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * <b>Description:</b>
 * </p>
 * <p>
 * This is the Application Router that will route incoming request to the endpoint,
 * /api/sendMessage endpoint with a path variable to the MessageHandler class.
 * </p>
 * @author Paul W. Nichols
 *
 *@version Example Template 0.1
 */
@Configuration
@Slf4j	
public class ApplicationRouter {
	
	
	@Bean
	public RouterFunction<ServerResponse> routeMessage(MessageHandler messageHandler) {
	return RouterFunctions.route(RequestPredicates.GET("/api/sendMessage/{message}").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),messageHandler::handleMessage);
	  }
}
