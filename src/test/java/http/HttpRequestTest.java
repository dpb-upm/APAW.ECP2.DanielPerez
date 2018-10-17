package http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HttpRequestTest {

    @Test
    void testToString() {
        HttpRequest httpRequest = new HttpRequest("/path", HttpMethod.GET);
        httpRequest.addQueryParam("key1", "value1");
        httpRequest.addQueryParam("key2", "value2");
        assertEquals(0, httpRequest.toString().indexOf("GET /path?key1=value1&key2=value2"));
    }

    @Test
    void testIsEqualsPathTrue() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertTrue(httpRequest.isEqualsPath("path/{id}/path"));

    }

    @Test
    void testIsEqualsPathFalseForDistinct() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertFalse(httpRequest.isEqualsPath("path2/{id}/path"));
    }

    @Test
    void testIsEqualsPathFalseForLength() {
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        assertFalse(httpRequest.isEqualsPath("path/{id}/path/other"));
    }

    @Test
    void testHttpRequestMethodClear(){
        HttpRequest httpRequest = new HttpRequest("path/3/path", HttpMethod.GET);
        httpRequest.setMethod(HttpMethod.DELETE);
        assertEquals(httpRequest.getMethod(), HttpMethod.DELETE);
        assertNotEquals(httpRequest.getMethod(), HttpMethod.GET);
        httpRequest.clearQueryParams();
        assertTrue(httpRequest.getParams().isEmpty());
        httpRequest.setPath("path/4");
        assertEquals(httpRequest.getPath(), "path/4");
        assertNotEquals(httpRequest.getPath(), "path/3/path");
    }

    @Test
    void testHttpRequestBuilder(){
        HttpRequest.Builder httpRequest = HttpRequest.builder("qwe").headerParam("1", "value");
    }
}
