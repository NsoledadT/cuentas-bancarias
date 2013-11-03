package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta m√°s simple, ya que se rige por la premisa
 * de que en tanto y en cuanto se tenga tanto o m√°s dinero en
 * cuenta del que se quiere extraer, la operaci√≥n se debe efectuar
 * correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {

	/**
     * No hay reglas adicionales para el depÛsito
     * @param monto a depositar
     */
    @Override
	public void depositar(final Double monto) throws CuentaBancariaException {
    	if(monto < 0) {
			 throw new CuentaBancariaException("No se aceptan n˙meros negativos");
		 }
		 this.saldo += monto;
      }


    /**
     * No hay reglas adicionales para la extracciÛn
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
