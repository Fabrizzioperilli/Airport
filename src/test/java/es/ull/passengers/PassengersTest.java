package es.ull.passengers;
import es.ull.flights.Flight;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PassengersTest {
  Passenger passenger;

  @BeforeEach
  void setUp() {
    passenger = new Passenger("12345678A", "Juan Perez", "ES");
  }

  @Test
  @DisplayName("Test passenger identifier")
  void testPassengerIdentifier() {
    assertEquals("12345678A", passenger.getIdentifier());
    assertNotEquals(null, passenger.getIdentifier());
  }

  @Test
  @DisplayName("Test passenger name")
  void testPassengerName() {
    assertEquals("Juan Perez", passenger.getName());
    assertNotEquals(null, passenger.getName());
  }

  @Test
  @DisplayName("Test passenger country code")
  void testPassengerCountryCode() {
    assertEquals("ES", passenger.getCountryCode());
    assertNotEquals(null, passenger.getCountryCode());
  }

  @Test
  @DisplayName("Test passenger country code with invalid format")
  void testPassengerCountryCodeInvalidFormat() {
    assertThrows(IllegalArgumentException.class, () -> new Passenger("12345678A", "Carlos", "E"));
  }

  @Test
  @DisplayName("Test toString")
  void testToString() {
    assertEquals("Passenger Juan Perez with identifier: 12345678A from ES", passenger.toString());
    assertNotEquals(null, passenger.toString());
  }

  @Test
  @DisplayName("Test join flight")
  void testJoinFlight() {
    Flight flight = new Flight("AA123", 50);
    passenger.joinFlight(flight);
    assertEquals(flight, passenger.getFlight());
  }
};