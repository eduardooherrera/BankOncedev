package com.oncedev.bank.models;

import java.math.BigInteger;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cuenta {
	@Id
	@NotNull
	private Long  numeroCuenta;
	private String descripcion;
	private String tipoCuenta;
	private BigInteger saldo;
	private Boolean estado;
	
	private String identificacion;

	
	public Cuenta() {}
	
	public Cuenta(@NotNull Long numeroCuenta, String descripcion, String tipoCuenta, BigInteger saldo, Boolean estado,
			String identificacion) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.descripcion = descripcion;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.estado = estado;
		this.identificacion = identificacion;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public BigInteger getSaldo() {
		return saldo;
	}

	public void setSaldo(BigInteger saldo) {
		this.saldo = saldo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	
}
