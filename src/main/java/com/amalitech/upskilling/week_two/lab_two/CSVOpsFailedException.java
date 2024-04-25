package com.amalitech.upskilling.week_two.lab_two;

import java.io.Serial;

public class CSVOpsFailedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public CSVOpsFailedException(String message) {
        super(message);
    }

    public CSVOpsFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CSVOpsFailedException(Throwable cause) {
        super(cause);
    }
}
