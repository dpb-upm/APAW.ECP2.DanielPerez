El patrón strategy sirve para encapsular implementaciones en clases, es decir, un código que puede ser intercambiado por algún otro o ser reutilizado.

El ejemplo lo he aplicado a la clase Propietario.

Para aplicar diferentes funcionalidades o estrategias se ha creado una interfaz StrategyPropietarioInterface en la que se implementará la funcionalidad de devolver un tipo u otro de Propietario. Las clases StrategyPropietarioA y StrategyPropietarioB, son las encargadas de implementar dicha funcionalidad, las cuales tienen un método que retornan un String con el tipo de Propietario "A" o "B" (algo simple para mostrar el ejemplo). También se ha creado StrategyPropietarioDefault para crear una estrategia por defecto.

Para gestionar esto, se ha creado la clase StrategyPropietario, que gestiona la interfaz y dependiendo de la clase creada, se retornará un tipo u otro. Esta clase es un objeto privado de la clase Propietario, el cual se encargará de aplicar u obtener las diferentes estategias.

Con este ejemplo se muestra que un mismo Propietario puede ser de tipo A, de tipo B o puede ser restaurado por defecto y todo en tiempo de ejecución. En el caso de requerir una nueva estrategia, un tipo C por ejemplo, tan solo habría que crear la clase y el método para que un Propietario adopte esta estrategia.