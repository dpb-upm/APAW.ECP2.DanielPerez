package api.controllers;

import api.dtos.PropietarioDto;
import api.entities.DateUtil;
import http.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PropietarioApiControllerTest {

    @Test
    void crearServidorOK() {
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR).body(new PropietarioDto("Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00"))).post();
        HttpResponse httpResponse= new Client().submit(request);
        assertEquals(httpResponse.getStatus(), HttpStatus.OK);
        assertNotNull(httpResponse.getBody());
    }

    @Test
    void crearServidorBadRequest() {
        HttpRequest request = HttpRequest.builder(PropietarioApiController.ADD_PROPIETARIO_SERVIDOR).path("/q").body(1).post();
        HttpException exception = assertThrows(HttpException.class, () -> new Client().submit(request));
        assertEquals(exception.getHttpStatus(), HttpStatus.BAD_REQUEST);
    }
}
