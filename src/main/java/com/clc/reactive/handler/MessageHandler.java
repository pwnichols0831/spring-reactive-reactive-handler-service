/**
 * 
 */
package com.clc.reactive.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * <p>
 * <b>Description:
 * </p>
 * <p>
 * This class is the Message Handler class. It will handle the actual reception of a server request
 * and then display the Servlet Request Content.
 * 
 * @author Paul W. Nichols
 *
 */
@Component
@Slf4j
public class MessageHandler {
		public Mono<ServerResponse> handleMessage(ServerRequest request) {
			log.info(String.format("Received request from: %s", request.remoteAddress().toString()));
			Mono<ServerResponse> results=null;
			try {
				results=ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue("RESULTS:"+new URLDecoder().decode(request.toString(),"UTF-8")));
				log.info("Completed Request.");
			}
			catch(UnsupportedEncodingException usex) {
				log.error("Error in decoding message.");
				log.error("Stack Trace:",usex);
			}
			return results;
		}		
}
