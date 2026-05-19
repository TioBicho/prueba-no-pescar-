package com.e_commerce.ms_detalleventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MsDetalleventasApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsDetalleventasApplication.class, args);
	}
}