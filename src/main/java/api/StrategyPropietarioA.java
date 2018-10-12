package api;

public class StrategyPropietarioA implements StrategyPropietarioInterface {

    static final String TIPO = "A";

    @Override
    public String getTipoIStrategy() {
        return TIPO;
    }
}
