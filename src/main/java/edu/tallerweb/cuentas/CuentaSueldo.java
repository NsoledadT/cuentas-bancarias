package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta más simple, ya que se rige por la premisa
 * de que en tanto y en cuanto se tenga tanto o más dinero en
 * cuenta del que se quiere extraer, la operación se debe efectuar
 * correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {

	/**
     * No hay reglas adicionales para el dep�sito
     * @param monto a depositar
     */
    @Override
	public void depositar(final Double monto) throws CuentaBancariaException {
    	if(monto < 0) {
			 throw new CuentaBancariaException("No se aceptan n�meros negativos");
		 }
		 this.saldo += monto;
      }


    /**
     * No hay reglas adicionales para la extracci�n
     * @param monto a extraer
     */
    @Override
	public void extraer(final Double monto) throws CuentaBancariaException {
    	if(monto > this.saldo) {
			throw new CuentaBancariaException("Monto de extraccion mayor a Saldo de cuenta ");
	  }
    	 this.saldo -= monto;
    }



}
