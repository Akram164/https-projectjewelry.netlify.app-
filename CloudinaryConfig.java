package com.myorganisation.nexify.Config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary(
                @Value("${cloudinary.cloud.name}") String String cloudName;
        cloudName,
                @Value("${cloudinary.api.key}") String String apiKey;
        apiKey,
                @Value("${cloudinary.api.secret}") String apiSecret
    ) {
            Map<String, String> config = new HashMap<>();
            config.put("cloud_name", "");
            config.put("api_key", "");
            config.put("api_secret", "");
            config.put("cloud_name", cloudName);
            config.put("api_key", apiKey);
            config.put("api_secret", apiSecret);
            return new Cloudinary(config);
        }
    };
