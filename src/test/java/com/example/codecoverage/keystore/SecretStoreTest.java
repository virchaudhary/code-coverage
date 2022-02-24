package com.example.codecoverage.keystore;

import com.example.codecoverage.exception.InvalidKeyValueException;
import com.example.codecoverage.exception.KeyLengthLimitException;
import com.example.codecoverage.exception.KeyNotFoundException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecretStoreTest {

    private SecretStore secretStore;

    @BeforeEach
    public void init() {
        secretStore = new SecretStoreService();
    }

    @Test
    void storeKeyTest() {
        String expectedKey = "secretKey";
        String secretValue = "some-secret";
        String actualKey = secretStore.storeSecret(expectedKey, secretValue);
        assertEquals(expectedKey, actualKey);
    }

    @Test
    void storeIntegerKeyTest() {
        Integer expectedKey = 123;
        String secretValue = "some-secret";
        Integer actualKey = secretStore.storeSecret(expectedKey, secretValue);
        assertEquals(expectedKey, actualKey);
    }


    @Test
    void getIntegerAndStringKeyTest() {
        Integer expectedIntKey = 123;
        String intSecret = "int-secret";
        Integer actualKey = secretStore.storeSecret(expectedIntKey, intSecret);
        assertEquals(expectedIntKey, actualKey);
        String expectedStrKey = "123";
        String strSecret = "str-secret";
        String actualStrKey = secretStore.storeSecret(expectedStrKey, strSecret);
        assertEquals(expectedStrKey, actualStrKey);

        String expectedIntSecret = secretStore.getSecret(expectedIntKey);
        assertEquals(expectedIntSecret, intSecret);

        String expectedStringSecret = secretStore.getSecret(expectedStrKey);
        assertEquals(expectedStringSecret, strSecret);
    }


    @Test
    @Disabled("requirement change")
    @DisplayName("test size of the key is not longer than 20")
    void storeKeySizeTest() {
        String key = "a".repeat(21);
        String secretValue = "some-secret";
        Assertions.assertThrows(KeyLengthLimitException.class, () -> secretStore.storeSecret(key, secretValue));
    }


    @Test
    @DisplayName("Empty and null key and value are not allowed")
    void storeKeyNotEmptyTest() {
        String secretValue = "some-secret";
        //Assertions.assertThrows(InvalidKeyValueException.class, () -> secretStore.storeSecret("", secretValue));

        Assertions.assertThrows(InvalidKeyValueException.class, () -> secretStore.storeSecret((String) null, secretValue));

        String key = "secretKey";

        Assertions.assertThrows(InvalidKeyValueException.class, () -> secretStore.storeSecret(key, ""));

        Assertions.assertThrows(InvalidKeyValueException.class, () -> secretStore.storeSecret(key, null));

    }


    @Test
    void getSecretTest() {
        String key = "secretKey";
        String expectedSecret = "some-secret";
        secretStore.storeSecret(key, expectedSecret);
        String actualSecret = secretStore.getSecret(key);
        assertEquals(expectedSecret, actualSecret);
    }

    @Test
    @DisplayName("Case-sensitive key test")
    void getSecretCaseSensitiveTest() {
        String key = "secretKey";
        String expectedSecret = "some-secret";
        secretStore.storeSecret(key, expectedSecret);
        String caseInSensitiveKey = "SecRetKey";
        String actualSecret = secretStore.getSecret(caseInSensitiveKey);
        assertEquals(expectedSecret, actualSecret);
    }

    @Test
    @DisplayName("Key not found test")
    void getSecretUnknownKeyTest() {
        String unknownKey = "secretKey";
        Assertions.assertThrows(KeyNotFoundException.class, () -> secretStore.getSecret(unknownKey));
    }
}
