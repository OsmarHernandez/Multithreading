# Multithreading

Realizar un Programa que utilice el esquema de Productor/Consumidor 
utilizando multi-hilos y cooperacion de procesos usando memoria compartida, 
con un buffer finito (10)

Un hilo debe pedir al usuario que teclee algo (solo caracteres alfanumericos), 
y cuando este presione enter se data por terminada la captura. 
Entonces dejara el texto en el buffer de memoria compartida

El otro hilo debe estar consumiendo las cadenas de texto y debe traducir lo que se escribio en clave morse.

Al tener un esquema de buffer finito, cuando este este lleno, el primer hilo debe bloquearse.

El programa podra ser hecho en cualquier lenguaje de programacion. 
Debe estar documentado, usar buenas practicas de codificacion, 
ser orientados a objetos y usar buenas practicas de OOP.
