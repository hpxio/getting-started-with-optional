package com.app.gsw.j8optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateOptionalObjectsTests {

  /* Creating a non-null Optional Object of type String */
  @Test
  @DisplayName("Optional Object Creation - Non-Null Object Types")
  void assertThatOptionalObjectIsCreated() {
    Optional<String> optionalName = Optional.of("Angel");
    assertTrue(optionalName.isPresent());
  }

  /* Creating a null Optional Object of type String */
  @Test
  @DisplayName("Optional Object Creation - Null Object Types")
  void assertThatOptionalValueIsFalseForNullObjects() {

    /* NOTE: If Optional<String> optionalName = null was used,
     * then it will throw invalid declaration error since
     * Optional does not allow usage of null directly.*/
    Optional<String> optionalName = Optional.empty();
    assertFalse(optionalName.isPresent());
  }

  /* Attempting to create an Optional object with that has null value */
  @Test
  @DisplayName("Optional Object Creation - Creating Optional Objects of Null values")
  void assertThatCreatingOptionalOfNullValueThrowsException() {
    String name = null;
    assertThrows(NullPointerException.class, () -> Optional.of(name));
  }

  /* Attempting to create an Optional object with that has null value */
  @Test
  @DisplayName("Optional Object Creation - Allowing Optional Objects of Null values")
  void assertThatAllowingOptionalOfNullValueNotThrowException() {
    String name = null;
    Optional<String> optionalName = Optional.ofNullable(name); // should not throw error here
    assertTrue(optionalName.isEmpty());
  }

  /* Accessing an Optional object that has no value (null) */
  @Test
  @DisplayName("Optional Object Creation - Accessing Empty Optional Objects")
  void assertThatAccessingEmptyObjectThrowsNullPointerException() {
    Optional<String> optionalName = Optional.empty();
    assertThrows(NoSuchElementException.class, optionalName::get);
  }
}