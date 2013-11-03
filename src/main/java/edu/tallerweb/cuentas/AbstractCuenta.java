package edu.tallerweb.cuentas;


	public abstract class AbstractCuenta {
		protected Double saldo = 0.0;

	        /**
	         * Agrega a la cuenta el monto determinado
	         * @param monto a depositar
	         */
	        public abstract void depositar(final Double monto);

	        /**
	         * Retira de la cuenta el monto determinado
	         * @param monto a extraer
	         */
	        public abstract void extraer(final Double monto);

	        /**
	         * Permite saber el saldo de la cuenta
	         * @return el saldo de la cuenta
	         */
	        public Double getSaldo()  throws CuentaBancariaException  {
	        	return this.saldo;
	        }

	        public void NumerosNegativosException(Double monto) {
	        	if(monto < 0) {
	   			 throw new CuentaBancariaException("No se aceptan n�meros negativos");
	        	}
	   		  }

}

