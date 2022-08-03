//Ana Santos 17-10602
package ve.usb.libGrafo

abstract class Secuencia<T> (val lista: MutableList<T>)  {

    fun vacio() : Boolean {
        var empty = lista.isEmpty()
        
        return empty
    }

    fun agregar(i: T) {
        lista.add(i)
    }

    abstract fun remover() : T 
}