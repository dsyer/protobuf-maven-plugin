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
package io.github.ascopes.protobufmavenplugin.sources.filter;

import io.github.ascopes.protobufmavenplugin.fs.FileUtils;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * File filter that asserts the given file is an existing file on the file system with a .proto file
 * extension.
 *
 * @author Ashley Scopes
 * @since 3.1.0
 */
public final class ProtoFileFilter implements FileFilter {

  @Override
  public boolean matches(Path rootPath, Path filePath) {
    return Files.isRegularFile(filePath) && FileUtils.getFileExtension(filePath)
        .filter(".proto"::equalsIgnoreCase)
        .isPresent();
  }
}
