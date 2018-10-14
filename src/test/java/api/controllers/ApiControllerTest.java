package api.controllers;

import api.exceptions.ArgumentNotValidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApiControllerTest {

    @Test
    void testValidate(){
        ServidorApiController servidorApiController = new ServidorApiController();
        assertThrows(ArgumentNotValidException.class, () -> servidorApiController.validate(null, "prueba"));
    }
}
