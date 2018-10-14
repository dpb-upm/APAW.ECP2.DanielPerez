package api.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionsTest {

    @Test
    void testNotFoundException(){
        NotFoundException prueba_not_found = new NotFoundException("Prueba not found");
        assertEquals(prueba_not_found.getMessage(), "Not Found Exception. Prueba not found");
    }

    @Test
    void testArgumentNotValidException(){
        ArgumentNotValidException prueba_not_found = new ArgumentNotValidException("Prueba not found");
        assertEquals(prueba_not_found.getMessage(), "Argument Not Valid Exception. Prueba not found");
    }

    @Test
    void testRequestInvalidException(){
        RequestInvalidException prueba_not_found = new RequestInvalidException("Prueba not found");
        assertEquals(prueba_not_found.getMessage(), "Request Invalid Exception. Prueba not found");
    }
}
