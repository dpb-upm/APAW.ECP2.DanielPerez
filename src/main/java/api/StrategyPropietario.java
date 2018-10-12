package api;

public class StrategyPropietario {

    private StrategyPropietarioInterface strategy;

    public void setStrategy(StrategyPropietarioInterface strategy) {
        this.strategy = strategy;
    }

    public String getTipoStrategy(){
        return strategy.getTipoIStrategy();
    }
}
