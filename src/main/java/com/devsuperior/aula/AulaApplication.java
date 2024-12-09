package com.devsuperior.aula;

import com.devsuperior.aula.entities.Order;
import com.devsuperior.aula.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order1 = new Order(1034, 150.00, 20.0);
		Order order2 = new Order(2282, 800.00, 10.0);
		Order order3 = new Order(1309, 95.90, 0.0);



		System.out.println("Resolução do desafio feita por Marcio Coelho como requisito para obtenção do certificado DevSuperior (Nelio Alves)");

		System.out.println("RESULTADO :");
		System.out.println("Pedido código " + order1.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order1));
		System.out.println("-------");
		System.out.println("Pedido código " + order2.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order2));
		System.out.println("-------");
		System.out.println("Pedido código " + order3.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order3));
		System.out.println("-------");


		Locale.setDefault(Locale.US);
		Scanner sc  = new Scanner(System.in);
		System.out.print("Digite codigo do pedido ");
		int codigo = sc.nextInt();

		System.out.print("Digite o valor base do pedido ");
		double valorBase = sc.nextDouble();

		System.out.print("Digite a porcentagem do desconto ");
		double desconto = sc.nextDouble();

		Order order4 = new Order(codigo, valorBase, desconto);


		System.out.println("-------");
		System.out.println("Pedido código " + order4.getCode());
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order4));
	}
}
