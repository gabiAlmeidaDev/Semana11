package com.semana11.projetoAnotacoes.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class JwtSecurityConfig {

    private static final String RSA_PUBLIC_KEY =
            "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3FlqJr5TRskIQIgdE3Dd\n" +
            "7D9lboWdcTUT8a+fJR7MAvQm7XXNoYkm3v7MQL1NYtDvL2l8CAnc0WdSTINU6IRv\n" +
            "c5Kqo2Q4csNX9SHOmEfzoROjQqahEcve1jBXluoCXdYuYpx4/1tfRgG6ii4Uhxh6\n" +
            "iI8qNMJQX+fLfqhbfYfxBQVRPywBkAbIP4x1EAsbC6FSNmkhCxiMNqEgxaIpY8C2\n" +
            "kJdJ/ZIV+WW4noDdzpKqHcwmB8FsrumlVY/DNVvUSDIipiq9PbP4H99TXN1o746o\n" +
            "RaNa07rq1hoCgMSSy+85SagCoxlmyE+D+of9SsMY8Ol9t0rdzpobBuhyJ/o5dfvj\n" +
            "KwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(decodePublicKey(RSA_PUBLIC_KEY)).build();
    }

    private RSAPublicKey decodePublicKey(String key) {
        try {
            key = key.replaceAll("-----END PUBLIC KEY-----", "")
                    .replaceAll("-----BEGIN PUBLIC KEY-----", "")
                    .replaceAll("\\s", "");
            X509EncodedKeySpec spec = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) kf.generatePublic(spec);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to decode public key", e);
        }
    }
}

