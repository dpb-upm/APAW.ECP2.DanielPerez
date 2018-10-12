package api;

public class StrategyPropietarioB implements StrategyPropietarioInterface  {

    static final String TIPO = "B";

    @Override
    public String getTipoIStrategy(){
        return TIPO;
    }
}
