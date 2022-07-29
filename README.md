# Final Programacion Avanzada
# Integrantes : Fabbiano, Andrés / Orduna, Fernando
Auxilio Mecánico
Requerimientos del sistema
Se necesita modelar una aplicación que permita administrar los servicios de auxilio 
mecánico a sus clientes.
El circuito comienza con el ingreso de un pedido, indicando el lugar donde se encuentra el 
vehículo que necesita ser asistido y una descripción del problema que permite saber:
Si la reparación es simple o compleja. Si se requiere remolque o no. 
A su vez, un cliente puede contratar tres tipos de servicio:
●   Platinum permite una ilimitada cantidad de servicios.
●   Classic reparaciones ilimitadas y hasta 5 remolques al año.
●   Economic hasta 5 reparaciones al an o sin remolques ni reparaciones complejas.
Al ingresar el pedido de auxilio, se verifica que:
El cliente tenga la cuota al día. El máximo de mora depende de cada tipo de servicio: 
●   los Economic no deben estar morosos, 
●   los classic pueden deber hasta $ 200 y 
●   los platinum pueden deber hasta una cuota de lo que pagan mensualmente. 
Para saber la deuda del cliente se debe consultar al módulo de pagos. Este módulo no 
deben desarrollarlo, sólo definir la interfaz para poder comunicarse con  él.
El cliente solicite un tipo de servicio válido (por ejemplo, si es un Economic no puede hacer 
pedidos que requieran remolque, controlar los topes de servicios, etc).
Si alguna de estas cosas no se cumple, no se puede generar el pedido el sistema debe 
informar correctamente el motivo de la no aceptación del pedido.
Si el pedido es aceptado, se le debe asignar automáticamente un camión de auxilio. Para 
ello se debe poder saber cuales son los camiones que pueden responder a ese pedido.
Se cuenta con tres tipos de camiones: 
●   Mini taller móvil
●   Mini grúa
●   Gran grúa, que puede tener asociado un “taller de alta complejidad” (de cada gran 
grúa se sabe si tiene taller o no).
Las capacidades de cada tipo de camión son:●   El mini taller móvil sólo puede hacer reparaciones simples y que no requieran 
remolque. 
●   La mini grúa puede remolcar vehículos de hasta 3 toneladas. 
La gran grúa puede remolcar todo tipo de vehículos. Sólo las grandes grúas que cuenten 
con un taller de alta complejidad pueden realizar las reparaciones indicadas como 
complejas.
Si el cliente tiene servicio Platinum, se le asignará el camión que tenga menos pedidos 
pendientes. Para los demás tipos de servicio se le asignará el camión más económico 
teniendo el cuenta el costo de cada camión ordenado de menor a mayor (donde: mini taller; 
mini grúa, gran grúa, gran grúa con taller).
Cuando un camión finaliza un pedido esto se informa al sistema, esto permite saber los 
pedidos pendientes de cada camión.
Casos de prueba
Cada uno de los 5 test cases deberá ser realizado.
Se parte de un escenario en el que se cuenta con tres camiones: un mini taller, una mini 
grúa y una grúa con taller. La mini grúa tiene un pedido asignado.
Diferentes clientes piden un remolque:
●   Cliente Economic, el pedido es denegado (no puede solicitar remolques).
● Cliente Classic sin deuda y con un vehículo inferior a las 3 toneladas, se le asigna la 
mini grúa (el mini taller no puede remolcar, la mini grúa es la más económica de los 
otros dos).
●   Cliente Classic sin deuda y con un vehículo superior a las 3 toneladas, se le asigna 
la gran grúa porque la mini grúa no puede remolcarlo.
●   Cliente Classic con una deuda superior a los $200, el pedido es denegado por mora. 
●   Cliente Platinum, se le asigna la gran grúa que es la que está más libre (no tiene 
pedidos). 
