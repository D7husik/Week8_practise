package com.example.__12exercises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(demoApplication.class, args);

		System.out.println("\n" + "=".repeat(70));
		System.out.println("🚀 Spring IoC Lab Application Started Successfully!");
		System.out.println("=".repeat(70));
		System.out.println("📚 Available Exercises:");
		System.out.println("  1. Manual Wiring vs IoC - Check logs");
		System.out.println("  2. DI Types - Check logs");
		System.out.println("  3. Core Annotations - GET /products/{id}");
		System.out.println("  4. @Qualifier - POST /notify/email");
		System.out.println("  5. Scopes - GET /ids");
		System.out.println("  6. Request Scope - GET /request-id");
		System.out.println("  7. Mini Project - POST /notify/all");
		System.out.println("=".repeat(70) + "\n");
	}
}
