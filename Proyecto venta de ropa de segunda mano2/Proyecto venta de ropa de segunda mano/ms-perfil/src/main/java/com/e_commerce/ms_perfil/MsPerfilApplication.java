package com.e_commerce.ms_perfil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsPerfilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPerfilApplication.class, args);
	}

}
