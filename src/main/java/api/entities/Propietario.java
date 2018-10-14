package api.entities;

import java.time.LocalDateTime;

public class Propietario {

    private String id;
    private String nombre;
    private int edad;
    private LocalDateTime nacimiento;

    private StrategyPropietario strategy;

    public void setStrategyA(){
        StrategyPropietarioInterface strategyPropietario = new StrategyPropietarioA();
        this.strategy.setStrategy(strategyPropietario);
    }

    public void setStrategyB(){
        StrategyPropietarioInterface strategyPropietario = new StrategyPropietarioB();
        this.strategy.setStrategy(strategyPropietario);
    }

    public void setStrategyDefault(){
        StrategyPropietarioInterface strategyPropietario = new StrategyPropietarioDefault();
        this.strategy.setStrategy(strategyPropietario);
    }

    public Propietario(){
        this.strategy = new StrategyPropietario();
        this.strategy.setStrategy(new StrategyPropietarioDefault());
        this.id = "";
        this.nombre = "";
        this.edad = 0;
    }

    public Propietario(String id) {
        this.strategy = new StrategyPropietario();
        this.strategy.setStrategy(new StrategyPropietarioDefault());
        this.id = id;
    }

    public Propietario(String nombre, int edad, LocalDateTime nacimiento){
        this.id = "";
        this.nombre = "";
        this.edad = 0;
        this.strategy = new StrategyPropietario();
        this.strategy.setStrategy(new StrategyPropietarioDefault());
    }

    public Propietario(String id, String nombre, int edad, LocalDateTime nacimiento) {
        this.strategy = new StrategyPropietario();
        this.strategy.setStrategy(new StrategyPropietarioDefault());
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nacimiento = nacimiento;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre + strategy.getTipoStrategy();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDateTime nacimiento) {
        this.nacimiento = nacimiento;
    }

    public boolean iguales(Propietario propietario){
        return this.id.equals(propietario.getId()) && this.getNombre().equals(propietario.getNombre()) && this.getEdad() == propietario.getEdad() && this.getNacimiento().isEqual(propietario.getNacimiento());
    }

    static class Builder {

        private Propietario propietario;

        public Builder id(String id) {
            propietario = new Propietario(id);
            propietario.strategy = new StrategyPropietario();
            propietario.strategy.setStrategy(new StrategyPropietarioDefault());
            return this;
        }

        public Builder nombre(String nombre) {
            propietario.setNombre(nombre);
            return this;
        }

        public Builder edad(int edad) {
            propietario.setEdad(edad);
            return this;
        }

        public Builder nacimiento(String fecha) {
            propietario.setNacimiento(DateUtil.getFormatedDate(fecha));
            return this;
        }

        public Propietario build() {
            return propietario;
        }
    }
}
