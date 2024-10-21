package com.rancho_smart.ms_produccion_leche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProduccionLecheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProduccionLecheApplication.class, args);
	}

}
