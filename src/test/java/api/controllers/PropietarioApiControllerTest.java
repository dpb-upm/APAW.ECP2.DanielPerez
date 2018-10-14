package api.controllers;

import api.dtos.PropietarioDto;
import api.entities.DateUtil;
import http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropietarioApiControllerTest {

    @Test
    void crearPropietarioOK() {
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .body(new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00")))
                .post();
        HttpResponse httpResponse= new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
    }

    @Test
    void crearPropietarioBadRequest() {
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .path("/q")
                .body(1)
                .post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void obtenerPropietarioOK(){
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .body(new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00")))
                .post();
        HttpResponse httpResponse = new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        String id = (String) httpResponse.getBody();

        HttpRequest request2 = HttpRequest.builder(PropietarioApiController.GET_PROPIETARIO_SERVIDOR)
                .body(id)
                .get();
        HttpResponse httpResponse2 = new Client().submit(request2);
        assertEquals(httpResponse2.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse2.getBody());
    }

    @Test
    void obtenerPropietarioBadRequest(){
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .body(new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00")))
                .post();
        HttpResponse httpResponse = new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        String id = (String) httpResponse.getBody();

        HttpRequest request2 = HttpRequest.builder(PropietarioApiController.GET_PROPIETARIO_SERVIDOR)
                .path("/id")
                .body(id)
                .get();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request2));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }

    @Test
    void putPropietarioOK(){
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .body(new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00")))
                .post();
        HttpResponse httpResponse = new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        String id = (String) httpResponse.getBody();
        assertNotNull(id);

        HttpRequest request2 = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .path(PropietarioApiController.ID_ID)
                .expandPath(id)
                .body("99")
                .put();
        HttpResponse httpResponse2 = new Client().submit(request2);
        assertEquals(httpResponse2.getStatus(), HttpStatus.OK);
        assertNull(httpResponse2.getBody());
    }

    @Test
    void putPropietarioBadRequest(){
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .body(new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00")))
                .post();
        HttpResponse httpResponse = new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
        String id = (String) httpResponse.getBody();
        assertNotNull(id);

        HttpRequest request2 = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR)
                .path(PropietarioApiController.ID_ID)
                .expandPath("")
                .body("99")
                .put();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request2));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
