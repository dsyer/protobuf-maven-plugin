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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MavenProtocPlugin tests")
class MavenProtocPluginTest {

  @DisplayName("the default value for getDependencyResolutionDepth is the expected value")
  @Test
  void theDefaultValueForGetDependencyResolutionDepthIsTheExpectedValue() {
    // Given
    var obj = mock(MavenProtocPlugin.class);
    when(obj.getDependencyResolutionDepth()).thenCallRealMethod();

    // Then
    assertThat(obj.getDependencyResolutionDepth()).isNull();
  }
}
