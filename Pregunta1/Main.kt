/*
CI-3641 Lenguajes de Programación I
Ana Santos 17-10602

                PARCIAL #3

Pregunta 1.b: Lenguaje escogido Kotlin, se usaron archivos de una librería 
realizada previamente relacionada con grafos.
*/
import ve.usb.libGrafo.*

fun main (args: Array<String>) {
    var archivo = args[0]
    var grafo = GrafoNoDirigido(archivo) 
    
    println("IMPORTANTE: A continuación se le pedirán el nodo inicial de Busqueda para BFS, el nodo d y el nodo h")
    print("Inserte el nodo inicial: ")
    var s = readLine()!!.toInt()
    print("Inserta el nodo d: ")
    var d = readLine()!!.toInt()
    print("Inserta el nodo h: ")
    var h = readLine()!!.toInt()

    //BUSQUEDA APLICANDO BFS
    var bfs = BFS(grafo,s)
    var cantidad = bfs.buscar(d,h)
    
    println("Cantidad de nodos visitados desde $d hasta $h aplicando BFS => $cantidad")

    var dfs = DFS(grafo)
    cantidad = dfs.buscar(d,h)

    println("Cantidad de nodos visitados desde $d hasta $h aplicando DFS => $cantidad")




    
}