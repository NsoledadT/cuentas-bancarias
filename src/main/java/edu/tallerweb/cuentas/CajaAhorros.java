package edu.tallerweb.cuentas;

/**
 * Similar a la CuentaSueldo, pero se pide que luego de la
 * quinta extracciÃ³n de dinero se cobre un costo adicional
 * por extracciÃ³n de $ 6
 */
public class CajaAhorros extends AbstractCuenta {
	private int contador;

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
     * Se cobran $6 adicionales por cada extracción luego de
     * la quinta.
     * @param monto a extraer
     */
    @Override
	public void extraer(final Double monto) throws CuentaBancariaException  {
    	NumerosNegativosException(monto);
    	Double montoAdicional;
    	if(contador == 5) {
			montoAdicional = monto + 6;
		 	   if(montoAdicional > this.saldo) {
				  throw new CuentaBancariaException(mensaje());
			   }
			   this.saldo -= montoAdicional;

		 }

		else {
			    if(monto > this.saldo) {
				  throw new CuentaBancariaException(mensaje());
			    }
			    this.saldo -= monto;
			    this.contador += 1;
		     }
		}

     /**
     * Permite enviar un mensaje
     * @return que se repite en varias oportunidades
     */
     private String mensaje() {
 	   return "Se intenta extraer más de lo que se tiene en el saldo";
 	  }
 }


