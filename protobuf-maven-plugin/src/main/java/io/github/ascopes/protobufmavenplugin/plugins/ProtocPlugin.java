/*
 * Copyright (C) 2023 - 2025, Ashley Scopes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ascopes.protobufmavenplugin.plugins;

import org.jspecify.annotations.Nullable;

/**
 * Base interface for a Protoc plugin reference.
 *
 * <p>Plugins can be marked as skippable, but by default will not be
 * skipped.
 *
 * @author Ashley Scopes
 * @since 2.0.0
 */
public interface ProtocPlugin {

  @Nullable String getOptions();

  default int getOrder() {
    return 0;
  }

  default boolean isSkip() {
    return false;
  }
}
