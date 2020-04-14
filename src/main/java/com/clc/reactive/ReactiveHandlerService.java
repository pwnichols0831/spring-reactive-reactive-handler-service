package com.clc.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
/**
 * <p>
 * <b>Description:</b>
 * </p>
 * <p>
 * This is the main entry point for the ReactiveHandler Service.
 * </p>
 * @author Paul W. Nichols
 *
 *@version: Example Template 0.1
 */
public class ReactiveHandlerService {
    
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReactiveHandlerService.class, args);
		log.info("Starting Application.");	
	}

}
