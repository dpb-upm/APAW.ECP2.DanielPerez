package api.entities;

public class StrategyPropietarioDefault implements StrategyPropietarioInterface  {

    static final String TIPO = "";

    @Override
    public String getTipoIStrategy(){
        return TIPO;
    }
}