package edu.tallerweb.cuentas;

/**
 * La más compleja de las cuentas, ésta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no sólo se considera
 * el que se posee, sino el límite adicional que el banco
 * estará brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrará
 * un 5% como comisión sobre todo el monto en descubierto
 * consumido en la operación.
 *
 * Por ejemplo, si tuviéramos $ 100 en la cuenta, y quisiéramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubrió, más el 5% adicional sobre el descubierto otorgado.
 */
public class CuentaCorriente extends AbstractCuenta {
	private final Double descubiertoTotal;
	private Double descubierto;
	/**
     * Toda cuenta corriente se inicia con un l�mite total
     * para el descubierto.
     * @param descubiertoTotal
     */
    public CuentaCorriente(final Double descubiertoTotal) throws CuentaBancariaException {
    	NumerosNegativosException(descubiertoTotal);
		this.descubiertoTotal = descubiertoTotal;
		this.descubierto = descubiertoTotal;
	}


    /**
     * Todo dep�sito deber� cubrir primero el descubierto,
     * si lo hubiera, y luego contar para el saldo de la
     * cuenta.
     * @param monto a depositar
     */
    @Override
	public void depositar(final Double monto) throws CuentaBancariaException {
    	Double calculo;
    	NumerosNegativosException(monto);
  	  if(this.descubierto == this.descubiertoTotal) {
  		this.saldo += monto;
  	  }
  		  else {
  			  calculo = this.descubiertoTotal - this.descubierto;
  			 if(monto < calculo) {
  				throw new CuentaBancariaException("El Monto ingresado insuficiente");
  			 }
  			  this.saldo += monto - calculo;
  			  this.descubierto = this.descubiertoTotal;
            }
	 }

    /**
     * Se cobrar� el 5% de comisi�n sobre el monto girado
     * en descubierto.
     * Por supuesto, no puede extraerse m�s que el total
     * de la cuenta, m�s el descubierto (comisi�n inclu�da)
     * @param monto a extraer
     */
    @Override
	public void extraer(final Double monto)  throws CuentaBancariaException {
    	NumerosNegativosException(monto);
    	 Double extraccion;
    	  if(this.saldo < monto) {
    		    extraccion =(monto - this.saldo) * 1.05 ;
    		   if(extraccion > this.descubierto) {
    			   throw new CuentaBancariaException("No se puede realizar la operaci�n");
    		   }
    		   this.descubierto -= extraccion;
    		   this.saldo = 0.0;

    	  }
    	  else {
    		  this.saldo -= monto;
    	 }
    }

   /**
     * Permite saber el saldo en descubierto
     * @return el descubierto de la cuenta
     */
    public Double getDescubierto() {
           return this.descubierto;
    }

}