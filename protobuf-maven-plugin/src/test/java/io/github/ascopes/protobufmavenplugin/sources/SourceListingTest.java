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
package io.github.ascopes.protobufmavenplugin.sources;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("SourceListing tests")
class SourceListingTest {

  @DisplayName(".flatten() returns the expected value")
  @Test
  void flattenReturnsTheExpectedValue() {
    // Given
    var listings = List.of(
        ImmutableSourceListing.builder()
            .sourceRoot(Path.of("foo", "bar"))
            .sourceFiles(List.of(
                Path.of("foo", "bar", "baz.proto"),
                Path.of("foo", "bar", "bork.proto")
             ))
            .build(),
        ImmutableSourceListing.builder()
            .sourceRoot(Path.of("eggs", "spam"))
            .sourceFiles(List.of(
                Path.of("eggs", "spam", "baz.proto"),
                Path.of("eggs", "spam", "bork.proto")
            ))
            .build()
    );

    // When
    var files = SourceListing.flatten(listings);

    // Then
    assertThat(files)
        .containsExactlyInAnyOrder(
            Path.of("foo", "bar", "baz.proto"),
            Path.of("foo", "bar", "bork.proto"),
            Path.of("eggs", "spam", "baz.proto"),
            Path.of("eggs", "spam", "bork.proto")
        );
  }
}
