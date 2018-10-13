package api.controllers;

import api.dtos.ServidorDto;
import api.entities.TipoServidor;
import http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServidorApiControllerTest {

    @Test
    void crearServidorOK() {
        HttpRequest request = HttpRequest.builder(ServidorApiController.ADD_SERVIDOR).body(new ServidorDto(TipoServidor.WEB)).post();
        HttpResponse httpResponse= new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
    }

    @Test
    void crearServidorBadRequest() {
        HttpRequest request = HttpRequest.builder(ServidorApiController.ADD_SERVIDOR).path("/q").body(1).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
