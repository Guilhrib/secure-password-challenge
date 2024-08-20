package com.ribeiro.securepassword.controller;

import java.util.List;

public record FailureResponse(
        List<String> failures
) {
}
