package api.controllers;

import api.dtos.ArchivoDto;
import api.entities.Archivo;
import http.*;
import org.junit.jupiter.api.Test;

import java.util.List;
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
    }

    @Test
    void crearArchivoBadRequest() {
        HttpRequest request = HttpRequest.builder(ArchivoApiController.ARCHIVO).path("/q").body(1).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void crearMultiArchivoOK() {
        for (int i = 0; i < 5; i++){
            HttpResponse httpResponse = this.createHttpResponseArchivo();
            assertEquals(httpResponse.getStatus(), HttpStatus.OK);
            assertNotNull(httpResponse.getBody());
        }

        HttpRequest request = HttpRequest.builder(ArchivoApiController.ARCHIVO).get();
        HttpResponse httpResponse2 = new Client().submit(request);
        List<Archivo> archivos = (List<Archivo>) httpResponse2.getBody();
        assertTrue(archivos.size() >= 5);
    }

    @Test
    void crearMultiArchivoBadRequest() {
        for (int i = 0; i < 5; i++){
            HttpResponse httpResponse = this.createHttpResponseArchivo();
            assertEquals(httpResponse.getStatus(), HttpStatus.OK);
            assertNotNull(httpResponse.getBody());
        }

        HttpRequest request = HttpRequest.builder(ArchivoApiController.ARCHIVO).path("/id").get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
