package com.cdi.crud.infra.exception;

import javax.ejb.ApplicationException;

/**
 * Created by rmpestano on 11/1/14.
 */
@ApplicationException(rollback = true)
public class CustomException extends RuntimeException{
	private static final long serialVersionUID = 0L;

    public CustomException(String msg) {
        super(msg);
    }
}
