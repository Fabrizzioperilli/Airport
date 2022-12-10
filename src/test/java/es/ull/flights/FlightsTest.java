package es.ull.flights;

import org.junit.jupiter.api.*;

import es.ull.passengers.Passenger;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FlightsTest {

  Flight flight;

  @BeforeEach
  void setUp() {
    flight = new Flight("AA123", 50);
  }

  @Test
  @DisplayName("Test flight number")
  public void testFlightNumber() {
    assertEquals("AA123", flight.getFlightNumber());
    assertNotEquals(null, flight.getFlightNumber());
  }

  @Test
  @DisplayName("Test flight number with invalid format")
  public void testFlightNumberInvalidFormat() {
    assertThrows(RuntimeException.class, () -> new Flight("AA123456", 100));
  }

  @Test
  @DisplayName("Test add passenger")
  public void testAddPassenger() {
    Passenger passenger = new Passenger("12345678A", "John Doe", "ES");
    assertTrue(flight.addPassenger(passenger));
  }

  @Test
  @DisplayName("Test add passenger with less seats")
  public void testAddPassengerWithLessSeats() {
    Flight flight = new Flight("AA123", 1);
    Passenger passenger = new Passenger("12345678A", "John Doe", "ES");
    flight.addPassenger(passenger);
    assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger));
  }

  @Test
  @DisplayName("Test remove passenger")
  public void testRemovePassenger() {
    Passenger passenger = new Passenger("12345678A", "John Doe", "ES");
    flight.addPassenger(passenger);
    assertTrue(flight.removePassenger(passenger));
  }
};
