package com.exemple.SistemaKanban;

import org.springframework.boot.SpringApplication;

public class TestSistemaKanbanApplication {

	public static void main(String[] args) {
		SpringApplication.from(SistemaKanbanApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
