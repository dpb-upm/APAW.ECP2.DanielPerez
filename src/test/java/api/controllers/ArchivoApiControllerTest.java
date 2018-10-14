package api.controllers;

import api.dtos.ArchivoDto;
import http.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoApiControllerTest {

    private HttpResponse createHttpResponseArchivo(){
        int number = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        HttpRequest request = HttpRequest.builder(ArchivoApiController.ARCHIVO)
                .body(new ArchivoDto("Archivo subido "+number, number))
                .post();
        return new Client().submit(request);
    }

    @Test
    void crearArchivoOK() {
        HttpResponse httpResponse = this.createHttpResponseArchivo();
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        System.out.println(httpResponse.getBody());
    }

    @Test
    void crearArchivoBadRequest() {
        HttpRequest request = HttpRequest.builder(ArchivoApiController.ARCHIVO).path("/q").body(1).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
