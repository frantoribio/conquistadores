# conquistadores
Conquistadores de Catán.<br>
Vamos a implementar un juego conocido como Conquistadores de Catán. <br>Nuestro juego será mucho más sencillo que el original y sólo permitirá a dos jugadores: un humano y el ordenador.
El funcionamiento es el siguiente:
El juego consiste en un mapa de 3x4 casillas, en cada casilla habrá un recurso (trigo, madera y carbón); un jugador que será el dueño de esa casilla y un valor numérico entre 1 y 6 (valores de un dado).
Al principio se inicializará el tablero colocando en cada casilla un recurso (de forma aleatoria) y asignándole un valor (también de forma aleatoria entre 1 y 6).
Al comienzo los dos jugadores tienen sus almacenes de madera, carbón y trigo a cero.
Después le preguntamos al usuario que casilla quiere ocupar y la convertimos en propiedad del mismo, luego el ordenador elige una casilla vacía al azar y la ocupa; posteriormente le volvemos a preguntar al usuario, luego el ordenador… y así hasta que estén las 12 casillas ocupadas (tengan propietario).
Una vez completado el tablero, comienza el juego:
Tiran los jugadores por turnos. El valor del dado se comparará con todos los valores de las casillas del tablero y con aquellos que coincidan se incrementará la cantidad de recursos que esas casillas indiquen a los propietarios de dichas casillas.
Ganará el primero que consiga llegar a 20 en todos los recursos.
Se valora:
• La elección de clases y la forma en que interactúan para implementar la solución.
• Claridad y ajuste de las clases a lo pedido en el enunciado.
• Se sigan los principios de abstracción y encapsulación de los objetos.
