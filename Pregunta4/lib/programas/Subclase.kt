package lib.programas

public class Subclase(val n: String, val superclase: String, val metodo: MutableList<String>, val listaC: MutableList<Clase>, val listaS: MutableList<Subclase>) {
        var buscarC = listaC.find {it.nombre == superclase}
        var buscarS = listaS.find {it.n == superclase}
        var superSAnteriores = mutableListOf<Subclase>()
        var superCAnterior = Clase("",mutableListOf<String>())
    
    
    init {
        if (buscarC != null) {
            superCAnterior = buscarC!!
        } else if (buscarS != null) {
            superSAnteriores.add(buscarS!!)
            var tipoVerificar = buscarS!!.superClase()
            var buscar = listaS.find {it.n == tipoVerificar}
            while (buscar != null) {
                superSAnteriores.add(buscar!!)
                tipoVerificar = buscar!!.superClase()
                buscar = listaS.find {it.n == tipoVerificar}
            }
            var buscar1 = listaC.find {it.nombre == tipoVerificar}
            superCAnterior = buscar1!!

        }

        
    }




    fun tipo() : String {
        
        return n
    }

    fun superClase() : String {
    
        return superclase
    }

    fun metodos() : MutableList<String> {

        return metodo
    }

    fun describirSubMetodos(s: String) {
        var nombre = this.tipo()
        println("$s -> $nombre :: $s")
    }

    fun describir() {
        if (buscarC != null) {
            var mSuper = superCAnterior.metodos()
            var mSub = this.metodos()
            for (i in mSuper) {
                if (mSub.contains(i)) {
                    this.describirSubMetodos(i)
                } else {
                    superCAnterior.describirMetodos(i)
                }
            }

            for (i in mSub) {
                if (!mSuper.contains(i)) {
                    this.describirSubMetodos(i)
                }
            }
        } else if (buscarS != null) {
            var mSuper = superCAnterior.metodos()
            var mSub = this.metodos()
            var metodosImprimir = mutableListOf<String>()

            //Se añaden todos los metodos de las superclases sin repeticiones
            metodosImprimir.addAll(mSuper)
            for (j in (0..superSAnteriores.lastIndex).reversed()) {
                var m = superSAnteriores[j].metodos()
                for (i in m) {
                    if (!metodosImprimir.contains(i)) {
                        metodosImprimir.add(i)
                    }
                }
            }
            for (m in mSub) {
                if (!metodosImprimir.contains(m)) {
                    metodosImprimir.add(m)
                }
            }
            
            //Se verifica metodo a metodo para realizar la impresion de la vtables
            
            for (m in metodosImprimir) {
                if (mSub.contains(m)) {
                    this.describirSubMetodos(m)
                } else {
                    var flag = true 
                    var i = 0
                    while (flag && i < superSAnteriores.size) {
                        var n = superSAnteriores[i].metodos()
                        if (n.contains(m)) {
                            superSAnteriores[i].describirSubMetodos(m)
                            flag = false
                        } else {
                            i += 1
                        }

                        if (i == superSAnteriores.size && flag) {
                            superCAnterior.describirMetodos(m)
                        }
                    }
                }
            }
        }
    }

}