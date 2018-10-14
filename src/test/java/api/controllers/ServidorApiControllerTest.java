package api.controllers;

import api.dtos.ServidorDto;
import api.entities.TipoServidor;
import http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServidorApiControllerTest {

    private HttpResponse createHttpResponseServidor(){
        HttpRequest request = HttpRequest.builder(ServidorApiController.ADD_SERVIDOR).body(new ServidorDto(TipoServidor.WEB)).post();
        return new Client().submit(request);
    }

    @Test
    void crearServidorOK() {
        HttpResponse httpResponse = this.createHttpResponseServidor();
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
    }

    @Test
    void crearServidorBadRequest() {
        HttpRequest request = HttpRequest.builder(ServidorApiController.ADD_SERVIDOR).path("/q").body(1).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void patchServidorOK(){
        HttpResponse httpResponse = this.createHttpResponseServidor();
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());

        String id = (String) httpResponse.getBody();
        assertNotNull(id);

        HttpRequest request = HttpRequest.builder(ServidorApiController.ADD_SERVIDOR)
                .path(ServidorApiController.ID_ID)
                .expandPath(id)
                .path(ServidorApiController.TIPO_SERVIDOR)
                .body(TipoServidor.CORREO)
                .patch();
        HttpResponse httpResponse2 = new Client().submit(request);
        assertEquals(httpResponse2.getStatus(), HttpStatus.OK);
        assertNull(httpResponse2.getBody());
    }

    @Test
    void patchServidorBadRequest(){
        HttpResponse httpResponse = this.createHttpResponseServidor();
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());

        String id = (String) httpResponse.getBody();
        assertNotNull(id);

        HttpRequest request = HttpRequest.builder(ServidorApiController.ADD_SERVIDOR)
                .path(ServidorApiController.ID_ID)
                .expandPath(id)
                .body(TipoServidor.CORREO)
                .patch();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
