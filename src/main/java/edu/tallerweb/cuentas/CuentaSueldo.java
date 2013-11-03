package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta mÃ¡s simple, ya que se rige por la premisa
 * de que en tanto y en cuanto se tenga tanto o mÃ¡s dinero en
 * cuenta del que se quiere extraer, la operaciÃ³n se debe efectuar
 * correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {

	/**
     * No hay reglas adicionales para el depósito
     * @param monto a depositar
     */
    @Override
	public void depositar(final Double monto) throws CuentaBancariaException {
    	NumerosNegativosException(monto);
		 this.saldo += monto;
      }


    /**
     * No hay reglas adicionales para la extracción
     * @param monto a extraer
     */
    @Override
	public void extraer(final Double monto) throws CuentaBancariaException {
    	NumerosNegativosException(monto);
    	if(monto > this.saldo) {
			throw new CuentaBancariaException("Monto de extraccion mayor a Saldo de cuenta ");
	  }
    	 this.saldo -= monto;
    }



}
