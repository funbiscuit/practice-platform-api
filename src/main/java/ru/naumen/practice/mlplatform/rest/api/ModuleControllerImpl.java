package ru.naumen.practice.mlplatform.rest.api;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/v0/modules")
@RestController
public class ModuleControllerImpl {
    private final Map<String, ModuleObj> modules = new HashMap<>();

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void delete(@PathVariable String name) {
        if (!modules.containsKey(name)) {
            throw new IllegalArgumentException("Module " + name + " not found");
        }
        modules.remove(name);
    }

    @GetMapping
    public List<ModuleDto> getAll() {
        return modules.values().stream()
                .map(m -> new ModuleDto(
                        m.name(),
                        m.metadata()
                ))
                .toList();
    }

    @GetMapping("/debug")
    public Collection<ModuleObj> getAllDebug() {
        return modules.values();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ModuleDto save(@Validated @RequestBody ModuleInput input) {
        if (modules.containsKey(input.name())) {
            throw new IllegalArgumentException("Module " + input.name() + " already exists");
        }
        var module = new ModuleObj(
                input.name(),
                input.script(),
                input.metadata()
        );
        modules.put(input.name(), module);
        return new ModuleDto(module.name(), module.metadata());
    }

    @PutMapping("/{name}")
    public ModuleDto update(@PathVariable String name,
                            @Validated @RequestBody ModuleUpdate input) {
        if (!modules.containsKey(name)) {
            throw new IllegalArgumentException("Module " + name + " not found");
        }

        var module = new ModuleObj(
                name,
                input.script(),
                input.metadata()
        );
        modules.put(name, module);
        return new ModuleDto(module.name(), module.metadata());
    }
}
