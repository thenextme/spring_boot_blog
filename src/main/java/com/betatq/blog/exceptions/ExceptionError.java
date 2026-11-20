package com.betatq.blog.exceptions;

import java.time.Instant;
import java.time.LocalDate;

public record ExceptionError(
        int errorCode,
        String msg,
        Instant timestamp
) {}
