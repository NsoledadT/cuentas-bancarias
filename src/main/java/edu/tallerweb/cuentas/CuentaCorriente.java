package edu.tallerweb.cuentas;

/**
 * La m√°s compleja de las cuentas, √©sta permite establecer una
 * cantidad de dinero a girar en descubierto. Es por ello que
 * cada vez que se desee extraer dinero, no s√≥lo se considera
 * el que se posee, sino el l√≠mite adicional que el banco
 * estar√° brindando.
 *
 * Por supuesto esto no es gratis, ya que el banco nos cobrar√°
 * un 5% como comisi√≥n sobre todo el monto en descubierto
 * consumido en la operaci√≥n.
 *
 * Por ejemplo, si tuvi√©ramos $ 100 en la cuenta, y quisi√©ramos
 * retirar $ 200 (con un descubierto de $ 150), podremos hacerlo.
 * Pasaremos a deberle al banco $ 105 en total: los $ 100 que
 * nos cubri√≥, m√°s el 5% adicional sobre el descubierto otorgado.
 */
public class CuentaCorriente extends AbstractCuenta {
	private final Double descubiertoTotal;
	private Double descubierto;
	/**
     * Toda cuenta corriente se inicia con un lÌmite total
     * para el descubierto.
     * @param descubiertoTotal
     */
    public CuentaCorriente(final Double descubiertoTotal) throws CuentaBancariaException {
    	if(descubiertoTotal < 0) {
	    	throw new CuentaBancariaException("No se permiten numeros negativos");
		}
		this.descubiertoTotal = descubiertoTotal;
		this.descubierto = descubiertoTotal *(-1);
	}


    /**
     * Todo depÛsito deber· cubrir primero el descubierto,
     * si lo hubiera, y luego contar para el saldo de la
     * cuenta.
     * @param monto a depositar
     */
    @Override
	public void depositar(final Double monto) throws CuentaBancariaException {
  	  if(Math.abs(this.descubierto) == this.descubiertoTotal) {
  		this.saldo += monto;
  	  }
  		  else {
  			 if(monto < Math.abs(this.descubierto)) {
  				throw new CuentaBancariaException("El Monto ingresado insuficiente");
  			 }
  			  this.saldo += monto - Math.abs(this.descubierto);
  			  this.descubierto = descubiertoTotal *(-1);
            }
	 }

    /**
     * Se cobrar· el 5% de comisiÛn sobre el monto girado
     * en descubierto.
     * Por supuesto, no puede extraerse m·s que el total
     * de la cuenta, m·s el descubierto (comisiÛn incluÌda)
     * @param monto a extraer
     */
    @Override
	public void extraer(final Double monto)  throws CuentaBancariaException {
    	 Double descubiertoFuncion;
    	  if(this.saldo < monto) {
    		    descubiertoFuncion =(monto - this.saldo) * 1.05 ;
    		   if(descubiertoFuncion > Math.abs(this.descubierto)) {
    			   throw new CuentaBancariaException("No se puede realizar la operaciÛn");
    		   }
    		   this.descubierto -= descubiertoFuncion * (-1);
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