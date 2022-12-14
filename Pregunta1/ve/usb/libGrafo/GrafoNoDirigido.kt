//Ana Santos 17-10602
package ve.usb.libGrafo
import java.io.BufferedReader
import java.io.File

/* 
DESCRIPCIÓN: Implementación de un Grafo No Dirigido que se puede construir desde el número
de vértices que tendrá el grafo o desde un archivo .txt y una variables que nos indica si las
aristas contendrán peso.
*/

public class GrafoNoDirigido: Grafo {
    override var vertices: Int = 0
    var grafo = Array(vertices) {mutableListOf<Arista>()}
    override var lados: Int = 0
    override var grado : Int = 0

    // Se construye un grafo a partir del número de vértices como un arreglo de listas
    //mutables vacías
    constructor(numDeVertices: Int) {
        this.vertices = numDeVertices
        this.grafo = Array(this.vertices){mutableListOf<Arista>()}
    }

    
    //Se construye un grafo a partir de un archivo.  
    constructor(nombreArchivo: String) {
        var linea = mutableListOf<String>()
        //Se separa el archivo por lineas, que pasaran a ser elementos de una lista mutable
        File(nombreArchivo).useLines{ lines -> lines.forEach { linea.add(it) }}
        this.vertices = linea[0].toInt()
        this.grafo = Array(this.vertices){mutableListOf<Arista>()}
        var sub = linea.subList(2,linea.size)

        sub.forEach {
            val sincomillas = it.split(" ")
            val a = Arista(sincomillas[0].toInt(),sincomillas[1].toInt())
            var x = a.cualquieraDeLosVertices()
            var y = a.elOtroVertice(x)
            var cambio = true

            if (x!=y) {    
                this.grafo[x].forEach { i ->
                    var u = i.elOtroVertice(x)
                    cambio = cambio && (y != u)
                }
                if (cambio) {
                    this.grafo[x].add(a)
                    this.grafo[y].add(a)
                    this.lados +=1
                }
            }    
        } 
    }

    /*
    DESCRIPCIÓN: Revisa que no los vértices de la arista no representen un bucle. Posteriormente
    revisa en cada lado adyacente de del vertice x, el cual representa uno de los vertices de la 
    arista, el otro vértice distinto a cualquiera de que se encuentren ingresados, reservando la 
    afirmación en la variable cambio. Por último, si cambio es igual a true, se introduce la arista
    tanto en la lista de adyacencia de x como en la lista de adyacencia de y, suma un lado al grafo.
    Finalmnete, retorna cambio.
    
    PRECONDICIÓN: ((x in 0..vertices-1) && (y in 0..vertices-1))
    
    POSTCONDICIÓN: (a in grafo)
    
    TIEMPO: O(|E|)
    */
    fun agregarArista(a: Arista) : Boolean {
        var x = a.cualquieraDeLosVertices()
        var y = a.elOtroVertice(x)
        var cambio = true

        if (x!=y) {    
            this.grafo[x].forEach { i ->
                var u = i.elOtroVertice(x)
                cambio = cambio && (y != u)
            }
            if (cambio) {
                this.grafo[x].add(a)
                this.grafo[y].add(a)
                this.lados +=1
            }
        }    
        return cambio
    }

    /*
    DESCRIPCIÓN: Función que retorna la variable lados, donde se reserva el número de lados del grafo.
    
    PRECONDICIÓN: (lados es un dato tipo entero)
    
    POSTCONDICIÓN: (obtenerNumeroDeLados() retorna un dato tipo entero)
    
    TIEMPO: O(1)
    */
    override fun obtenerNumeroDeLados(): Int {
        return this.lados
    }

    /*
    DESCRIPCIÓN: Función que retorna la variable vértices, donde se reserva el número de vértices del grafo.
    
    PRECONDICIÓN: (vertices es un dato tipo entero)
    
    POSTCONDICIÓN: (obtenerNumeroDeLados() retorna un dato tipo entero)
    
    TIEMPO: O(1)
    */
    override fun obtenerNumeroDeVertices() : Int {
        return this.vertices
    }

    /*
    DESCRIPCIÓN: Función que retorna una lista de adyacentes de v, que es la lista que se encuentra guardada
    en la posición v del arreglo grafo.
    
    PRECONDICIÓN: (v in 0..vertices-1)
    
    POSTCONDICIÓN: (adyacentes() es una lista de aristas)
    
    TIEMPO: O(1)
    */
    override fun adyacentes(v: Int) : Iterable<Arista> {
		return this.grafo[v]
    }

    /*
    DESCRIPCIÓN: Función que retorna una lista con todos las aristas, iterando sobre la variable 
    grafo que contiene todas las listas de adyacencias de todos los vértices.
    
    PRECONDICIÓN: (!grafo.isEmpty())
    
    POSTCONDICIÓN: (!arista.isEmpty())
    
    TIEMPO: O(|V|*|E|)
    */
    override operator fun iterator() : Iterator<Arista> {
        var arista = listOf<Arista>()

        for (i in this.grafo) {
            i.forEach { new -> 
                if (new !in arista && Arista(new.u,new.v) !in arista) {
                    arista += new
                }
            }
        }
        
        return arista.iterator()
    }

    /*
    DESCRIPCIÓN: Función que retorna el grado de un vértice, el cual corresponde al tamaño de la lista grafo[v]
    
    PRECONDICIÓN: (v in 0..vertices-1)
    
    POSTCONDICIÓN: (grado >= 0)
    
    TIEMPO: O(numeroDeAdyacentesDev)
    */
    override fun grado(v: Int) : Int {
        this.grado = this.grafo[v].size
        return this.grado
    }

    /*
    DESCRIPCIÓN: Función que retorna el grafo como String
    
    PRECONDICIÓN: (aristas == E && vertices > 0)
    
    POSTCONDICIÓN: (G = (V, E) as String)
    
    TIEMPO: O(|V|*|E|)
    */
    override fun toString() : String {
        var grafostring: String 
        var lista : MutableList<String> = mutableListOf()
        var v = listOf<Int>()

        for (i in 0..this.vertices-1) {
            v += (i)
            this.grafo[i].forEach { arista ->
                var str = arista.toString()
                if (!(lista.contains(str))) {
                    lista.add(str)
                }
            }
        }

        grafostring = lista.joinToString()
        val verticesstring = v.joinToString()

        return "El grafo no dirigido es (V = ["+verticesstring+"] , E = ["+grafostring+"])"
    }
}
