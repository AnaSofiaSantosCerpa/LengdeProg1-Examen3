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
    var salir = true
    var listaDeClases = mutableListOf<Clase>()
    var listaDeSubs = mutableListOf<Subclase>()
    

    while (salir) {
        print("ACCION> ")
        var accion = readLine()!!
        val sincomillas = accion.split(" ")
        var action = sincomillas[0]

        if (action == "CLASS") {
            var tipo = sincomillas[1]
            var buscar1 = listaDeClases.find {it.nombre == tipo}
            var buscar2 = listaDeSubs.find {it.n == tipo}

            if (buscar1 != null) {
                println("ERROR: '$tipo' ya existe") 
            } else if (buscar2 != null) {
                println("ERROR: '$tipo' ya existe")
            } else {
                var dospuntos = sincomillas[2]
                if (dospuntos != ":") {
                    var metodos = sincomillas.subList(2,sincomillas.size).toMutableList()
                    var contar = 1
                    var i = 0
                    while (contar == 1 && i < metodos.size) {
                        var metodo = metodos[i]
                        contar = metodos.count {it == metodo}
                        i += 1
                    }
                    if (contar > 1) {
                        println("ERROR: Existe un metodo repetido")
                    } else  {
                        var clase = Clase(tipo,metodos)
                        listaDeClases.add(clase)
                    }
                    
                } else {
                    var superclase = sincomillas[3]
                    var buscar3 = listaDeClases.find {it.nombre == superclase}
                    var buscar4 = listaDeSubs.find {it.n == superclase}
                    var metodos = sincomillas.subList(4,sincomillas.size).toMutableList()
                    if (buscar3 == null && buscar4 == null) {
                        println("ERROR: $superclase no existe")
                    } else {
                        var sub = Subclase(tipo,superclase,metodos,listaDeClases,listaDeSubs)
                        var contar = 1
                        var i = 0
                        while (contar == 1 && i < metodos.size) {
                            var metodo = metodos[i]
                            contar = metodos.count {it == metodo}
                            i += 1
                        }
                        if (contar > 1){
                            println("ERROR: Existe un metodo repetido")
                        } else {
                            listaDeSubs.add(sub)
                        }
                    }
                }
            }                
        }
 

        if (action == "DESCRIBIR"){
            var tipo = sincomillas[1]
            var buscar1 = listaDeClases.find {it.nombre == tipo}
            var buscar2 = listaDeSubs.find {it.n == tipo}

            if (buscar1 == null && buscar2 == null) {
                println("ERROR: $tipo no existe")
            } else if (buscar1 != null) {
                buscar1!!.describir()
            } else if (buscar2 != null) {
                buscar2!!.describir()
            }

        }       
                
        if (action == "SALIR") {
            println("~~~")
            salir = false
        }
    }
}