package com.app.gsw.j8optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConditionalsWithOptionalObjectsTests {

  /* Check id Optional is non-null value the access value safely */
  @Test
  @DisplayName("Conditionals with Optional - Proceed operation based on Optional conditional")
  void assertThatNonNullOptionalObjectIsAccessSafely() {
    String name = "Optionals";
    Optional<String> optionalName = Optional.of(name);
    assertTrue(optionalName.isPresent());

    optionalName.ifPresent(n -> System.out.println(n.toUpperCase(Locale.ROOT)));
  }

  /* TODO: Explore ifPresentOrElse method from Java-9 API reference */
  @Test
  @DisplayName("Conditionals with Optional - Proceed operation based on Optional if-else")
  void assertThatNonNullOptionalObjectIsAccessSafelyOrElseAction() {
    String name = "Optionals";
    Optional<String> optionalName = Optional.of(name);

    /* here goes nothing */
    assertThat(optionalName.get(), is(name));
  }
}