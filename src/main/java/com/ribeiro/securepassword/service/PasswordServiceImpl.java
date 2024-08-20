package com.ribeiro.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.ribeiro.securepassword.model.enums.FailureType.HIGHER_EIGHT;
import static com.ribeiro.securepassword.model.enums.FailureType.CAPITAL_LETTER;
import static com.ribeiro.securepassword.model.enums.FailureType.SMALL_LETTER;
import static com.ribeiro.securepassword.model.enums.FailureType.NUMBER;
import static com.ribeiro.securepassword.model.enums.FailureType.SPECIAL_CHARACTER;

@Service
public class PasswordServiceImpl implements PasswordService {
    private List<String> failures;

    @Override
    public List<String> validatePass(String pass) {
        failures = new ArrayList<>();
        validateLength(pass);
        validateUppercase(pass);
        validateLowercase(pass);
        validateNumber(pass);
        validateSpecialCharacter(pass);
        return failures;
    }

    private void validateLength(String pass) {
        if(pass != null && pass.length() < 8) {
            failures.add(HIGHER_EIGHT.getDescription());
        }
    }

    private void validateUppercase(String pass) {
        if(!Pattern.matches(".*[A-Z].*", pass)) {
            failures.add(CAPITAL_LETTER.getDescription());
        }
    }

    private void validateLowercase(String pass) {
        if(!Pattern.matches(".*[a-z].*", pass)) {
            failures.add(SMALL_LETTER.getDescription());
        }
    }

    private void validateNumber(String pass) {
        if(!Pattern.matches(".*\\d.*", pass)) {
            failures.add(NUMBER.getDescription());
        }
    }

    private void validateSpecialCharacter(String pass) {
        if(!Pattern.matches(".*\\W.*", pass)) {
            failures.add(SPECIAL_CHARACTER.getDescription());
        }
    }
}
