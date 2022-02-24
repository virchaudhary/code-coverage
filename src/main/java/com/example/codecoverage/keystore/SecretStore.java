package com.example.codecoverage.keystore;

public interface SecretStore {
    <T> T storeSecret(T key, String secret);
    <T> String getSecret(T key);
}
