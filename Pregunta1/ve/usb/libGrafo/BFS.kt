//Ana Santos 17-10602
package ve.usb.libGrafo
import java.util.LinkedList
import java.util.Queue
import java.util.Stack


/* 
DESCRIPCIÓN: Implementación del Algoritmo BFS, tomando como argumentos un grafo g y un entero representando un 
vértice s.
*/
public open class BFS(val g: Grafo, val s: Int) : Busqueda(g) {
    
    var n = g.obtenerNumeroDeVertices()
    var colores = Array(n){(Color.BLANCO)}
    var d = Array(n){(Integer.MAX_VALUE)}
    var pred = Array<Int?>(n){(null)}

    /*
    DESCRIPCIÓN: Se realiza la implementación de BFS. Através de 3 arreglos, que almacenan los datos de cada vértice según su 
    índice, uno para color, otro para predecesores, y el ultimo para las distancias. Por tanto, todas las asignaciones correspondientes 
    al vértice en el que se busca, se harán a los arreglos.
    
    PRECONDICIÓN: (s in 0..n-1)
    
    POSTCONDICIÓN: (queue.isEmpty() && (Para todo i : colores[i] == NEGRO))
    
    TIEMPO: O(|V|+|E|)
    */
    init {
        colores[s] = Color.GRIS
        d[s] = 0
        var queue = Cola<Int>(mutableListOf<Int>())
        queue.agregar(s)
        while (!queue.vacio()){
            var u = queue.remover()
            g.adyacentes(u).forEach { v ->
                if (colores[v.elOtroVertice(u)]==Color.BLANCO){
                    colores[v.elOtroVertice(u)] = Color.GRIS
                    d[v.elOtroVertice(u)] = d[u]+1
                    pred[v.elOtroVertice(u)] = u
                    queue.agregar(v.elOtroVertice(u))
                }
            }
            colores[u] = Color.NEGRO
        }
    }



    /*
    DESCRIPCIÓN: Función que retorna el predecesor de un vértice v, que se encuentra guardado en la posición v del 
    arreglo pr
    
    PRECONDICIÓN: (v in 0..n-1)
    
    POSTCONDICIÓN: (predecesor as Int?)
    
    TIEMPO: O(|V|)
    */
    fun obtenerPredecesor(v: Int) : Int? {  
        if (v !in 0..n-1){
            throw RuntimeException("El vertice ingresado no pertenece al grafo")
        }
        
        return this.pred[v]
    }

    /*
    DESCRIPCIÓN: Función que retorna la distancia de s hasta un vértice v, que se encuentra guardado en la posición v del 
    arreglo d
    
    PRECONDICIÓN: (v in 0..n-1)
    
    POSTCONDICIÓN: (d <= 0)
    
    TIEMPO: O(|V|)
    */
    fun obtenerDistancia(v: Int) : Int {  
        if (v !in 0..n-1){
            throw RuntimeException("El vertice ingresado no pertenece al grafo")
        } 
        
        return this.d[v]
    }

    /*
    DESCRIPCIÓN: Función que retorna true si s pertenece a los predecesores de v.
    
    PRECONDICIÓN: (v in 0..n-1)
    
    POSTCONDICIÓN: (hayCaminoHasta() retorna un booleano)
    
    TIEMPO: O(|V|)
    */ 
    fun hayCaminoHasta(v: Int) : Boolean {  
        if (v !in 0..n-1){
            throw RuntimeException("El vertice ingresado no pertenece al grafo")
        } 
        if (this.d[v] != 0) {
            return true
        } else {
            return false
        }
    }

    /*
    DESCRIPCIÓN: Función que retorna el camino más corto hasta v desde s, con la lista de predecesores en el arreglo
    pred posición v
    
    PRECONDICIÓN: (v in 0..n-1)
    
    POSTCONDICIÓN: (s in pred[v])
    
    TIEMPO: O(|V|)
    */
    fun caminoConMenosLadosHasta(v: Int) : Iterable<Int>  {
        if (v !in 0..n-1){
            throw RuntimeException("El vertice ingresado no pertenece al grafo")
        }

        var c = mutableListOf<Int?>()
        var camino = mutableListOf<Int>()
        var stack = Stack<Int>()
        var existe = this.hayCaminoHasta(v)

        if (existe) {
            var aux = v
            while (aux != s) {
                c.add(aux)
                aux = pred[aux] as Int
            }
        }
        c.add(s)
        stack.addAll(c)
        while (!stack.isEmpty()) {
            var aux = stack.pop() as Int
            camino.add(aux)
        }
        return camino
    }
        
    override fun buscar(f: Int, h: Int) : Int {
        var n = g.obtenerNumeroDeVertices()
        var colores = Array(n){(Color.BLANCO)}
        var d = Array(n){(Integer.MAX_VALUE)}
        var pred = Array<Int?>(n){(null)}
        var cont = 0
        
        if (s == f) {
            cont += 1
        }
        colores[s] = Color.GRIS
        d[s] = 0
        var queue = Cola<Int>(mutableListOf<Int>())
        queue.agregar(s)
        while (!queue.vacio()){
            var u = queue.remover()
            g.adyacentes(u).forEach { v ->
                if (colores[v.elOtroVertice(u)]==Color.BLANCO){
                    if (v.elOtroVertice(u) == f && cont == 0) {
                        cont += 1
                    } else if (cont > 0 && v.elOtroVertice(u) != h) {
                        cont += 1
                    } else if (v.elOtroVertice(u) == h) {
                        cont += 1
                        return cont
                    } else if (f == h && v.elOtroVertice(u) == h) {
                        return 1
                    }
                    colores[v.elOtroVertice(u)] = Color.GRIS
                    d[v.elOtroVertice(u)] = d[u]+1
                    pred[v.elOtroVertice(u)] = u
                    queue.agregar(v.elOtroVertice(u))
                }
            }
            colores[u] = Color.NEGRO
        }
        return -1
    }


}
