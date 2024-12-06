package com.harman.auth.service.dto;

public record UserCredential(String email, String password, String token) {
}
