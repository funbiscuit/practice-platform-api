package ru.naumen.practice.mlplatform.rest.api;

import java.util.Map;

public record ModuleInput(
        String name,
        String script,
        Map<String, String> metadata
) {
}
