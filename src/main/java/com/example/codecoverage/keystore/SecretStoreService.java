package com.example.codecoverage.keystore;


import com.example.codecoverage.exception.InvalidKeyValueException;
import com.example.codecoverage.exception.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SecretStoreService implements SecretStore {

    private Map<Object, String> keySecretMap = new HashMap<>();

    @Override
    public <T> T storeSecret(T key, String secret) {
        if (key == null || secret == null || secret.isBlank()) {
            throw new InvalidKeyValueException("key or secret can not be null or empty.");
        }
        if (key instanceof String strKey) {
            key = (T) strKey.toLowerCase();
        }
        keySecretMap.put(key, secret);
        return key;
    }


    @Override
    public <T> String getSecret(T key) {
        if (key instanceof String strKey) {
            key = (T) strKey.toLowerCase();
        }
        return Optional.ofNullable(keySecretMap.get(key)).orElseThrow(() -> new KeyNotFoundException("Key is not found."));
    }


}
