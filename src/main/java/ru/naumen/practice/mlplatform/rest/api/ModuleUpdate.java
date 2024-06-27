package ru.naumen.practice.mlplatform.rest.api;

import java.util.Map;

public record ModuleUpdate(
        String script,
        Map<String, String> metadata
) {
}
