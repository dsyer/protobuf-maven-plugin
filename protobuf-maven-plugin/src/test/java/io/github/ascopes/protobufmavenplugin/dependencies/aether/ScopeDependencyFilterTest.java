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
package io.github.ascopes.protobufmavenplugin.dependencies.aether;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;
import org.eclipse.aether.graph.Dependency;
import org.eclipse.aether.graph.DependencyNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Ashley Scopes
 */
@DisplayName("ScopeDependencyFilter tests")
class ScopeDependencyFilterTest {

  @DisplayName("null dependencies return true to match the Aether implementation behaviour")
  @Test
  void nullDependenciesReturnTrueToMatchTheAetherImplementationBehaviour() {
    // Given
    var node = mock(DependencyNode.class);
    when(node.getDependency()).thenReturn(null);

    var filter = new ScopeDependencyFilter(Set.of("compile", "runtime"));

    // When
    var result = filter.accept(node, List.of());

    // Then
    assertThat(result).isTrue();
  }

  @DisplayName("dependencies without any of the given scopes are filtered out")
  @Test
  void dependenciesWithoutAnyOfTheGivenScopesAreFilteredOut() {
    // Given
    var dependency = mock(Dependency.class);
    when(dependency.getScope()).thenReturn("test");

    var node = mock(DependencyNode.class);
    when(node.getDependency()).thenReturn(dependency);

    var filter = new ScopeDependencyFilter(Set.of("compile", "runtime"));

    // When
    var result = filter.accept(node, List.of());

    // Then
    assertThat(result).isFalse();
  }

  @DisplayName("dependencies with any of the given scopes are not filtered out")
  @Test
  void dependenciesWithAnyOfTheGivenScopesAreNotFilteredOut() {
    // Given
    var dependency = mock(Dependency.class);
    when(dependency.getScope()).thenReturn("compile");

    var node = mock(DependencyNode.class);
    when(node.getDependency()).thenReturn(dependency);

    var filter = new ScopeDependencyFilter(Set.of("compile", "runtime"));

    // When
    var result = filter.accept(node, List.of());

    // Then
    assertThat(result).isTrue();
  }
}
