package lib.programas

public class Atomo(val nombre: String) {
    var flag = true

    init {
        var revisar = nombre.split("").toMutableList()
        revisar.remove(revisar[0])
        revisar.remove(revisar[revisar.size-1])
        var mayuscula = revisar[0].uppercase()

        flag = (revisar[0] != mayuscula) 
    }
    
    fun atomo() : String {
        return nombre
    }

    fun isAtomo() : Boolean {
        return flag
    }
}