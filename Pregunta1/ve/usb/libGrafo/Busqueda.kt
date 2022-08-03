//Ana Santos 17-10602
package ve.usb.libGrafo

abstract class Busqueda(val grafo: Grafo) {

    abstract fun buscar(f: Int, h: Int) : Int 
}