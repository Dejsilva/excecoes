package model.entidades;

import model.exceptions.DomainException;

public class Conta {

	private  Integer numero;
	private  String nome;
	private  Double saldo;
	private Double limiteRetirada;
	public Conta(Integer numero, String nome, Double saldo, Double limiteRetirada) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteRetirada = limiteRetirada;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getLimiteRetirada() {
		return limiteRetirada;
	}
	
	public void deposito(double quantia) {
		saldo += quantia;
		}
	public void retirar(double quantia) {
		validarRetirar(quantia);
		saldo -= quantia;
	}
	
	private void validarRetirar(double quantia) {
		if(quantia > getLimiteRetirada()) {
			throw new DomainException("A quantia excede o limite de saque");
		}
		if(quantia > getSaldo()) {
			throw new DomainException("Saldo insuficiente");
		}
	}
	
	}
	

