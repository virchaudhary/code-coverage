package com.example.codecoverage;

import com.example.codecoverage.strategy.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeCoverageApplication implements CommandLineRunner {

	@Autowired
	private Main main;

	public static void main(String[] args) {
		SpringApplication.run(CodeCoverageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		main.test();
	}
}
