package br.com.ifrs.SGRU.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String errorCode;
	private final String orderId;

	public BusinessException(String errorCode, String orderId, Exception e) {
		super(e);
		this.errorCode = errorCode;
		this.orderId = orderId;
	}

	public BusinessException(String errorCode, Exception e) {
		super(e);
		this.orderId = "";
		this.errorCode = errorCode;
	}

	public BusinessException(String errorCode, String orderId) {
		super();
		this.orderId = orderId;
		this.errorCode = errorCode;
	}

}
