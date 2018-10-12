El patr�n strategy sirve para encapsular implementaciones en clases, es decir, un c�digo que puede ser intercambiado por alg�n otro o ser reutilizado.

El ejemplo lo he aplicado a la clase Propietario.

Para aplicar diferentes funcionalidades o estrategias se ha creado una interfaz StrategyPropietarioInterface en la que se implementar� la funcionalidad de devolver un tipo u otro de Propietario. Las clases StrategyPropietarioA y StrategyPropietarioB, son las encargadas de implementar dicha funcionalidad, las cuales tienen un m�todo que retornan un String con el tipo de Propietario "A" o "B" (algo simple para mostrar el ejemplo). Tambi�n se ha creado StrategyPropietarioDefault para crear una estrategia por defecto.

Para gestionar esto, se ha creado la clase StrategyPropietario, que gestiona la interfaz y dependiendo de la clase creada, se retornar� un tipo u otro. Esta clase es un objeto privado de la clase Propietario, el cual se encargar� de aplicar u obtener las diferentes estategias.

Con este ejemplo se muestra que un mismo Propietario puede ser de tipo A, de tipo B o puede ser restaurado por defecto y todo en tiempo de ejecuci�n. En el caso de requerir una nueva estrategia, un tipo C por ejemplo, tan solo habr�a que crear la clase y el m�todo para que un Propietario adopte esta estrategia.