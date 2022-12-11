package es.ull.flightspassengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.*;
import es.ull.passengers.Passenger;
import static org.junit.jupiter.api.Assertions.*;

class FlightPassengersTest {
  Flight flight;
  Passenger passenger;

  @BeforeEach
  void setUp() {
    flight = new Flight("AA123", 50);
    passenger = new Passenger("12345678A", "Juan Perez", "ES");
  }
  
  @Test
  @DisplayName("Test add passenger")
  void testAddPassenger() {
    assertTrue(flight.addPassenger(passenger));
  }

  @Test
  @DisplayName("Test add passenger with less seats")
  void testAddPassengerWithLessSeats() {
    Flight flight2 = new Flight("AA123", 1);
    Passenger passenger2 = new Passenger("12345678A", "Maria Diaz", "ES");
    flight2.addPassenger(passenger);
    assertThrows(RuntimeException.class, () -> flight2.addPassenger(passenger2));
  }

  @Test
  @DisplayName("Test remove passenger")
  void testRemovePassenger() {
    flight.addPassenger(passenger);
    assertTrue(flight.removePassenger(passenger));
  }

  @Test
  @DisplayName("Test remove passenger not added")
  void testRemovePassengerNotAdded() {
    assertFalse(flight.removePassenger(passenger));
  }
};