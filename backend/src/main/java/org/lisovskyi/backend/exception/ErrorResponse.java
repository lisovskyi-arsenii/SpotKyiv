package org.lisovskyi.backend.exception;

public record ErrorResponse(int statusCode, String message) {}
