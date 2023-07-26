package br.com.educandoweb.curso.model.entidades.enums;

public enum PedidoStatus {
 PAGO(1),
 AGUARDANDO_PAGAMENTO(2),
 CANCELADO(3);
	
	private int code;
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalido codigo do PedidoStatus");
	}
}
