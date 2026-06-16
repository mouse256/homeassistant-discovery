# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

A small Java library that produces Home Assistant MQTT *discovery* payloads. Consumers build a `Discovery` object graph and serialize it to JSON (with Jackson) to publish on an MQTT discovery topic. The library does not do any MQTT I/O itself — it only models the payload. See https://www.home-assistant.io/integrations/mqtt/#mqtt-discovery.

Published as a Maven artifact: group `org.muizenhol`, name `homeassistant-discovery`.

## Commands

Uses the Gradle wrapper; Java 25 toolchain is configured in `build.gradle.kts` (Gradle will provision it).

- Build: `./gradlew build`
- Test: `./gradlew test`
- Single test class: `./gradlew test --tests "org.example.SomeTest"`
- Publish to local Maven repo: `./gradlew publishToMavenLocal`

Note: there are currently no tests (the `src/test/java/org/example` tree is empty).

## Architecture

The whole API is a tree of Jackson-annotated value types that serialize to a single discovery JSON document.

- `Discovery` (record) is the root: a `device`, an `origin`, a `state_topic`, and a `Map<String, Component>` of named `components`. The map keys become the component object keys in the JSON.
- `Component` (abstract) is the base for every entity. It holds the shared fields (`name`, `unique_id`, `platform`, `icon`, `availability`). `Component.WithState` adds command/state topics and on/off payloads for controllable entities.
- Concrete components live in `component/`: `Sensor`, `Light`, `Switch`, `Climate`. `Light`/`Switch` extend `WithState`; `Sensor` extends `Component` directly.
- Each component fixes its `Platform` by passing it to `super(...)` in its constructor (e.g. `Sensor` → `Platform.SENSOR`). `Platform` is one of `SENSOR, LIGHT, CLIMATE, SWITCH`.
- `DeviceClass` and `StateClass` are enums constraining `Sensor` fields, matching Home Assistant's sensor entity model.

### Key conventions

- **JSON field names come from Jackson, not Java naming.** Every serialized field is annotated with `@JsonProperty("ha_name")` (e.g. `unitOfMeasurement` → `unit_of_measurement`). The Java field name is for code; the annotation is the wire contract with Home Assistant. When adding a field, the `@JsonProperty` value must match HA's documented key.
- **Enums serialize lowercase** via a `@JsonValue getName()` that returns `name().toLowerCase()`. Follow this pattern for any new enum.
- **`@JsonInclude(NON_NULL)`** is applied so unset fields are omitted from the payload — keep new optional fields as nullable reference types (not primitives) if they should be omittable.
- **Builder pattern.** Components are constructed via a nested `static final class Builder` with fluent `withXxx(...)` methods and a `build()`. When adding a field to a component, add the corresponding builder field, `withXxx`, and wire it in `build()`.

### Adding a new component type

1. Create a class in `component/` extending `Component` (read-only) or `Component.WithState` (controllable), with a no-arg constructor calling `super(Platform.X)`.
2. Add the platform to the `Platform` enum if it doesn't exist.
3. Add `@JsonProperty`-annotated fields matching the HA integration's documented discovery keys (link the relevant HA docs page in a class Javadoc, as `Light` does).
4. Add a nested `Builder`.
