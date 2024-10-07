package org.euroit.luxmedtask;

import org.springframework.boot.SpringApplication;

public class TestLuxMedTaskApplication {

	public static void main(String[] args) {
		SpringApplication.from(LuxMedTaskApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
