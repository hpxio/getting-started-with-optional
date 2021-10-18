package com.app.gsw.j8optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ConditionalsWithOptionalObjectsTests {

  /* Check id Optional is non-null value the access value safely */
  @Test
  @DisplayName("Conditionals with Optional - ifPresent()")
  void assertThatNonNullOptionalObjectIsAccessSafely() {
    String name = "Optionals";
    Optional<String> optionalName = Optional.of(name);
    assertTrue(optionalName.isPresent());

    optionalName.ifPresent(n -> System.out.println(n.toUpperCase(Locale.ROOT)));
  }

  /* TODO: Explore ifPresentOrElse method from Java-9 API reference */
  @Test
  @DisplayName("Conditionals with Optional - ifPresent()")
  void assertThatNonNullOptionalObjectIsAccessSafelyOrElseAction() {
    String name = "Optionals";
    Optional<String> optionalName = Optional.of(name);

    /* here goes nothing */
    assertThat(optionalName.get(), is(name));
  }

  /* To return a pre-defined default in case of null value */
  @Test
  @DisplayName("Conditionals with Optional - orElse()")
  void assertThatDefaultValueIsReturnedIfNull() {
    String name = null;
    Optional<String> optionalName = Optional.ofNullable(name);

    log.info("Result -> {}", optionalName.orElse("Original value was null"));
  }

  @Test
  @DisplayName("Conditionals with Optional - orElseGet()")
  void assertThatSupplierIsCalledWhenValueIsNull() {
    String name = null;
    Optional<String> optionalName = Optional.ofNullable(name);

    log.info("Result -> {}", optionalName.orElseGet(() -> "Supplier called!"));
  }

  @Test
  @DisplayName("Conditionals with Optional - orElse() vs orElseGet()")
  void assertDifferenceBetweenOrElseAndOrElseGet() {
    String name = "Optional";
    Optional<String> optionalName = Optional.ofNullable(name);

    log.info("Result orElse() -> {}", optionalName
            .orElse(differenceBetweenOrElseAndOrElseGetHelperFunction(10)));

    log.info("Result orElse() -> {}", optionalName
        .orElseGet(() -> differenceBetweenOrElseAndOrElseGetHelperFunction(15)));
  }

  private String differenceBetweenOrElseAndOrElseGetHelperFunction(int input) {
    log.info("Trying to mmake sense here... let's calculate even-odd!");
    return (input % 2 == 0) ? "Even" : "Odd";
  }
}