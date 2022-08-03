/*
CI-3641 Lenguajes de Programación I
Ana Santos 17-10602

                PARCIAL #3

Pregunta 4: Lenguaje escogido Kotlin
*/
import java.io.File
import java.util.*
import java.util.Scanner
import lib.programas.*

fun main(args: Array<String>) {
    println("IMPORTANTE: Esta implementación es sensible a los espacios en blanco, por ello debe")
    println("utilizarlos únicamente para separar las operaciones de una expresion y separar una")
    println("expresión de otra. Además sólo acepta hechos donde las variables se relaciones de")
    println("izquierda a derecha. Por favor, ingrese todos los hechos antes de ingresar las reglas.")
    println("Por ej: 'abuelo(X,Y) :- papa(X,Z), papa(Z,Y)'")
    
    println("\n")

    var salir = true
    var listaReglas = mutableListOf<Regla>()
    var listaDeEstructuras = mutableListOf<Estructura>()
    

    while (salir) {
        print("ACCION> ")
        var accion = readLine()!!
        val sincomillas = accion.split(" ")
        var action = sincomillas[0]

        if (action == "DEF") {
            if (sincomillas.size == 2) {               
                var expresion = sincomillas[1]
                val separar = expresion.split("(",")",",")

                if (!Atomo(separar[0]).isAtomo()) {
                    var n = Atomo(separar[0]).atomo()
                    println("ERROR: $n no cumple con la definicion de Estructura")
                } else {
                    var nombre = separar[0]
                    var arg1 = separar[1]
                    var arg2 = separar[2]
                    if (Atomo(arg1).isAtomo() && Atomo(arg2).isAtomo()) {
                        listaDeEstructuras.add(Estructura(nombre,Pair(arg1,arg2)))
                        println("Se definió el hecho '$expresion'")
                    } else {
                        println("ERROR: Definición incorrecta '$expresion' no está representada ni como hecho ni como regla")
                    }
                }
            } else {
                var listaAux = mutableListOf<Estructura>()
                var listaStrings = mutableListOf<String>()
                var struct = sincomillas[1]
                var flag = true
                for (i in 1..sincomillas.size-1) {
                    var expresion = sincomillas[i]
                    val separar = expresion.split("(",")",",")

                    if (i != 1) {
                        listaStrings.add(sincomillas[i])
                    }
                    
                    if (!Atomo(separar[0]).isAtomo()) {
                        var n = Atomo(separar[0]).atomo()
                        println("ERROR: $n no cumple con la definicion de Estructura para poder definir este hecho")
                        flag = false
                    } else {
                        var nombre = separar[0]
                        var arg1 = separar[1]
                        var arg2 = separar[2]
                        listaAux.add(Estructura(nombre,Pair(arg1,arg2)))
                    }
                }

                if (flag) {
                    var regla = Regla(listaAux,listaReglas)
                    listaReglas.add(regla)
                    var str = listaStrings.joinToString()
                    println("Se definió la regla $struct :- $str")
                    var prueba = regla.generarEstructuras(listaDeEstructuras)
                    listaDeEstructuras.addAll(prueba)
                }
            }
        }
 

        if (action == "ASK"){
            var expresion = sincomillas[1]
            val separar = expresion.split("(",")",",")
            var buscar1 = listaDeEstructuras.find {it.nombre == separar[0]}

            if (!Atomo(separar[0]).isAtomo()) {
                var n = separar[0]
                println("ERROR: $n no cumple con la definicion de Estructura")
            }

            if (buscar1 == null) {
                var n = separar[0]
                println("ERROR: $n no ha sido definido")
            } else {
                var n = separar[0]
                var x = separar[1]
                var y = separar[2]
                var listaAsk = mutableListOf<String>()

                for (struct in listaDeEstructuras) {
                    var coincidencia = struct.ask(n,x,y)
                    if (coincidencia != "") {
                        listaAsk.add(coincidencia)
                    }
                }

                if (listaAsk.isEmpty()) {
                    println("No es satisfacible")
                } else {
                    var size = listaAsk.size
                    var i = 0
                    var flag = true
                    
                    if (Atomo(x).isAtomo() && Atomo(y).isAtomo()) {
                        println(listaAsk[0])
                    } else {
                        while (flag && i < size) {
                            println(listaAsk[i])
                            print("[consultando $expresion]> ")
                            var user = readLine()!!

                            if (user == "RECHAZAR") {
                                i ++
                                if (i == size) {
                                    println("No es satisfacible")
                                }
                            } else {
                                println("Consulta aceptada")
                                flag = false
                            }
                        }
                    }
                }
            }
        }       
                
        if (action == "SALIR") {
            println("~~~")
            salir = false
        }
    }
}