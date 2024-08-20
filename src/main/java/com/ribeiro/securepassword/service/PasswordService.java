package com.ribeiro.securepassword.service;

import java.util.List;

public interface PasswordService {

    List<String> validatePass(String pass);
}
