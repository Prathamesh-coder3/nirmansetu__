package com.nirmaansetu.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @Value("${spring.application.name:NirmaanSetu}")
    private String appName;

    @Value("${spring.profiles.active:dev}")
    private String activeProfile;

    @Value("${nirmaansetu.demo-mode:true}")
    private boolean demoMode;

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> resp = new java.util.LinkedHashMap<>();
        resp.put("status", "UP");
        resp.put("application", appName);
        resp.put("version", "1.0.0");
        resp.put("message", "NirmaanSetu Backend is running");
        resp.put("profile", activeProfile);
        resp.put("demoMode", demoMode);
        resp.put("timestamp", LocalDateTime.now().toString());
        resp.put("organization", "Government of Maharashtra");
        resp.put("sihProblem", "26135");
        return resp;
    }
}
