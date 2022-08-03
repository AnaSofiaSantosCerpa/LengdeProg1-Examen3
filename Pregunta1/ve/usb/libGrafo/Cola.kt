//Ana Santos 17-10602
package ve.usb.libGrafo

public open class Cola<T>(val l: MutableList<T>) : Secuencia<T>(l) {

    override fun remover() : T {
        if (this.vacio()) {
            throw RuntimeException ("ERROR: La Cola se encuentra vacía")
        }
        
        var elem = l[0]
        l.remove(elem)

        return elem
    }
}