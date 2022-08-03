package lib.programas

public class Regla(val regla: MutableList<Estructura>, val lista: MutableList<Regla>) {
    var nombre = regla[0].atomo()

    fun name() : String {

        return nombre
    }

    fun atributos() : MutableList<Estructura> {
        var sub = regla.subList(1,regla.size)
        
        return sub
    }

    fun askParaRegla(n:String, x: String, listaE: MutableList<Estructura>, listaS: MutableList<String>) : MutableList<String> {
        var devolver = mutableListOf<String>()

        if (listaS.isEmpty()) {
            for (i in listaE) {
                if (n == i.atomo() && x == i.secuencia().first && !devolver.contains(i.secuencia().second)) {
                    devolver.add(i.secuencia().second)
                }
            }
        } else {
            for (i in listaE) {
                for (j in listaS) {
                    if (n == i.atomo() && j == i.secuencia().first && !devolver.contains(i.secuencia().second)) {
                        devolver.add(i.secuencia().second)
                    }
                }
            }
        }

        return devolver
    } 


    fun generarEstructuras(listaE: MutableList<Estructura>) : MutableList<Estructura> {
        var args = this.atributos()
        var argsSize = args.size
        var x = regla[0].secuencia().first
        var y = regla[0].secuencia().second
        var listaFinal = mutableListOf<Estructura>()
        var listaStrings = mutableListOf<String>()

        //genero la lista con todas las constantes
        for (i in listaE) {
            var x = i.secuencia().first 
            var y = i.secuencia().second
            if (!listaStrings.contains(x)) {
                listaStrings.add(x)
            }
            if (!listaStrings.contains(y)) {
                listaStrings.add(y)
            }
        }

        for (i in listaStrings) {
            var nuevaStr = mutableListOf<String>()
            var listaAux = mutableListOf<Estructura>()

            for (j in args) {
                nuevaStr = this.askParaRegla(j.atomo(),i,listaE,nuevaStr)
            }
            if (!nuevaStr.isEmpty()) {
                for (j in nuevaStr) {
                    listaAux.add(Estructura(this.name(),Pair(i,j)))
                }
            }
            listaFinal.addAll(listaAux)
        }

        return listaFinal
    }

    
    
}    