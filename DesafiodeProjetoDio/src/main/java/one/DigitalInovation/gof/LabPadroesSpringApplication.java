package one.DigitalInovation.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class LabPadroesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesSpringApplication.class, args);
	}

}
