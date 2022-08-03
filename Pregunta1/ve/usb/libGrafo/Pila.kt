//Ana Santos 17-10602
package ve.usb.libGrafo

public open class Pila<T>(val l: MutableList<T>) : Secuencia<T>(l) {

    override fun remover() : T {
        if (this.vacio()) {
            throw RuntimeException ("ERROR: La Pila se encuentra vacía")
        }
        
        var size = l.size
        var elem = l[size-1]
        l.remove(elem)

        return elem
    }
}