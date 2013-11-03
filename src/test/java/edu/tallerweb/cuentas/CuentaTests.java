package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	@Test
	public void queVerifiqueLaConsigna() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacía, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected=CuentaBancariaException.class)
	public void queVerifiqueLaConsignaException() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);
        cuenta.extraer(4000.0);
	}

	@Test
	public void QueVerifiqueCajaAhorro() {
		CajaAhorros caja = new CajaAhorros();
		caja.depositar(2000.0);
		Assert.assertEquals("al depositar $ 2000.0 en una cuenta vacÃ­a, tiene $ 2000.0",
				2000.0, caja.getSaldo(), 0.0);
		caja.extraer(100.0);
		Assert.assertEquals("al extraer $ 100.0 de 2000.0 se tiene $ 1900.0",
				1900.0, caja.getSaldo(), 0.0);
		caja.extraer(200.0);
		Assert.assertEquals("al extraer $ 200.0 de $ 1900.0 se tiene 1700.0",
				1700.0, caja.getSaldo(), 0.0);
		caja.extraer(50.0);
		Assert.assertEquals("al extraer $ 50.0 de $ 1700.0 se tiene 1650.0",
				1650.0, caja.getSaldo(), 0.0);
		caja.extraer(300.0);
		Assert.assertEquals("al extraer $ 300.0 de $ 1650.0 se tiene 1350.0",
				1350.0, caja.getSaldo(), 0.0);
		caja.extraer(500.0);
		Assert.assertEquals("al extraer $ 500.0 de $ 1350.0 se tiene 850.0",
				850.0, caja.getSaldo(), 0.0);
		caja.extraer(500.0);
        Assert.assertEquals("al extraer $ 506.0  de $ 850.0 se tiene 344.0",
				344.0, caja.getSaldo(), 0.0);
		caja.extraer(100.0);
		Assert.assertEquals("al extraer $ 106.0 de $ 344.0 se tiene 238.0",
				238.0, caja.getSaldo(), 0.0);
		caja.extraer(232.0);
		Assert.assertEquals("al extraer $ 238.0 de $ 344.0 se tiene 0.0",
				0.0, caja.getSaldo(), 0.0);
     }

	@Test(expected=CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionCajaAhorros() {
		CajaAhorros caja = new CajaAhorros();
		caja.depositar(3500.0);
		caja.extraer(4000.0);
	}

	@Test
	public void queVerifiqueCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(1500.0);
        cuenta.depositar(4000.0);
		Assert.assertEquals("al depositar $ 4000.0 en una cuenta vacia, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);
		 cuenta.depositar(5000.0);
		 Assert.assertEquals("al depositar $ 5000.0 en una cuenta de 4000.0, tiene $ 9000.0",
					9000.0, cuenta.getSaldo(), 0.0);
		 cuenta.extraer(7000.0);
		 Assert.assertEquals("al extraer $ 7000.0 en una cuenta de 9000.0, tiene $ 2000.0",
					2000.0, cuenta.getSaldo(), 0.0);
		 cuenta.extraer(3000.0);
		 Assert.assertEquals("al extraer $ 3000.0 en una cuenta de 2000.0 con un decubiertoTotal de 1500, tiene $ -500.0",
					-450.0, cuenta.getDescubierto(), 0.0);
		 Assert.assertEquals("al extraer $ 3000.0 en una cuenta de 2000.0 con un decubiertoTotal de 1500, tiene $ -500.0",
					0.0, cuenta.getSaldo(), 0.0);
		 cuenta.depositar(500.0);
		 Assert.assertEquals("al depositar 500.0 en una cuenta con descubierto de -450.0" ,
					-1500.0, cuenta.getDescubierto(), 0.0);
		 Assert.assertEquals("al depositar 500.0 en una cuenta con descubierto de -450.0" ,
					50.0, cuenta.getSaldo(), 0.0);
		 cuenta.extraer(300.0);
		 Assert.assertEquals("al extrae 300.0 en una cuenta con saldo 50.0" ,
					0.0, cuenta.getSaldo(), 0.0);
		 Assert.assertEquals("al extrae 300.0 en una cuenta con saldo 50.0" ,
					-1237.5, cuenta.getDescubierto(), 0.0);
		 cuenta.extraer(100.0);
		 Assert.assertEquals("al extrae 100.0 en una cuenta con decubierto de -1237.5" ,
					-1132.5, cuenta.getDescubierto(), 0.0);
		 cuenta.extraer(1000.0);
		 Assert.assertEquals("al extrae 1000.0 en una cuenta con decubierto de -1132.5" ,
					-82.5, cuenta.getDescubierto(), 0.0);

    }

}
