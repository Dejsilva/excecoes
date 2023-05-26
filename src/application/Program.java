package application;

import java.util.Locale;
import java.util.Scanner;

import model.entidades.Conta;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados da conta");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteRetirada = sc.nextDouble();
		
		Conta conta = new Conta(numero, titular, saldo, limiteRetirada);
		
		System.out.println();
		System.out.print("Informe uma quantia para sacar: ");
		double quantia = sc.nextDouble();
		
		try {
			conta.retirar(quantia);
			System.out.printf("Novo saldo: %.2f%n", conta.getSaldo());
		}
		catch (DomainException e){
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
