package api.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PropietarioTest {

    private Propietario propietario;

    @BeforeEach
    void before() {
        this.propietario = new Propietario("1", "Daniel", 30, DateUtil.getFormatedDate("1988-05-10 00:00"));
    }

    @Test
    void testConstructor() {
        LocalDateTime localDateTime = DateUtil.getFormatedDate("1988-05-10 00:00");
        assertEquals("1", this.propietario.getId());
        assertEquals("Daniel", this.propietario.getNombre());
        assertEquals(30, this.propietario.getEdad());
        assertTrue(localDateTime.isEqual(this.propietario.getNacimiento()));

        LocalDateTime localDateTime2 = DateUtil.getFormatedDate("1988-05-10 00:00");
        this.propietario.setNacimiento(localDateTime2);
        assertTrue(localDateTime2.isEqual(this.propietario.getNacimiento()));

        this.propietario.setNombre("Daniel Perez");
        assertEquals("Daniel Perez", this.propietario.getNombre());

        this.propietario.setEdad(35);
        assertEquals(35, this.propietario.getEdad());

        this.propietario.setId("2");
        assertNotEquals("1", this.propietario.getId());
    }

    @Test
    void testBuilder() {
        Propietario propietarioBuilder = new Propietario.Builder().id("1").nombre("Daniel").edad(30).nacimiento("1988-05-10 00:00").build();
        assertTrue(this.propietario.iguales(propietarioBuilder));
        Propietario propietarioBuilder2 = new Propietario.Builder().id("2").nombre("Daniel").edad(35).nacimiento("1988-05-10 00:00").build();
        assertTrue(!this.propietario.iguales(propietarioBuilder2));
    }


    @Test
    void testDateUtil(){
        boolean throwException = false;
        try{
            DateUtil du = new DateUtil();
        } catch(IllegalStateException ex){
            throwException = true;
        }
        assertTrue(throwException);
    }
}
