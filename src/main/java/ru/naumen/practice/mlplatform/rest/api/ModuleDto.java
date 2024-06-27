package ru.naumen.practice.mlplatform.rest.api;

import java.util.Map;

public record ModuleDto(
        String name,
        Map<String, String> metadata
) {
}
