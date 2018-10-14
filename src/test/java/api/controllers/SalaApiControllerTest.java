package api.controllers;

import api.dtos.SalaDto;
import http.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class SalaApiControllerTest {

    private HttpResponse createHttpResponseSala(){
        int number = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        HttpRequest request = HttpRequest.builder(SalaApiController.SALA)
                .body(new SalaDto("Sala "+number, number))
                .post();
        return new Client().submit(request);
    }

    @Test
    void testPutSalaOK(){
        HttpResponse httpResponse = this.createHttpResponseSala();
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        String id = (String) httpResponse.getBody();
        assertNotNull(id);

        HttpRequest request2 = HttpRequest.builder(SalaApiController.SALA)
                .path(SalaApiController.ID_ID)
                .expandPath(id)
                .body("99")
                .put();
        HttpResponse httpResponse2 = new Client().submit(request2);
        assertEquals(httpResponse2.getStatus(), HttpStatus.OK);
        assertNull(httpResponse2.getBody());
    }

    @Test
    void testPutSalaBadRequest(){
        HttpResponse httpResponse = this.createHttpResponseSala();
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        String id = (String) httpResponse.getBody();
        assertNotNull(id);

        HttpRequest request2 = HttpRequest.builder(SalaApiController.SALA)
                .path(SalaApiController.ID_ID)
                .expandPath("")
                .body("99")
                .put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request2));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
