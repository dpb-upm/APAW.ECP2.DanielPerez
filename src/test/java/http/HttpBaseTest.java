package http;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HttpBaseTest {

    @Test
    void testHttpBase(){
        HttpBase httpBase = new HttpBase();
        httpBase.addHeaderParam("1", "value");
        Map<String, String> headerParams = httpBase.getHeaderParams();
        assertEquals("value", headerParams.get("1"));
        assertNull(headerParams.get("2"));
    }
}
