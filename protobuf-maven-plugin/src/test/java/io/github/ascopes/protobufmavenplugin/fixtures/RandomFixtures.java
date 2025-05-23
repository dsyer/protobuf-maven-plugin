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
package io.github.ascopes.protobufmavenplugin.fixtures;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Random data fixtures.
 *
 * @author Ashley Scopes
 */
public final class RandomFixtures {

  private static final Random random = new Random();

  private RandomFixtures() {
    // Static-only class.
  }

  public static String someBasicString() {
    return UUID.randomUUID().toString();
  }

  public static int someInt() {
    return random.nextInt();
  }

  public static <T> T oneOf(Iterable<T> items) {
    var list = new ArrayList<T>();
    items.forEach(list::add);
    return list.get(random.nextInt(list.size()));
  }
}
