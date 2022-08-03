package lib.programas

public class Clase(val nombre: String, val metodo: MutableList<String>) {
    
    fun tipo() : String {
        
        return nombre
    }
    
    fun metodos() : MutableList<String> { 
        
        return metodo
    }

    fun describirMetodos(s: String) {
        var n = this.tipo()
        println("$s -> $n :: $s")
    } 

    fun describir() {
        var m = this.metodos()
        for (i in m) {
            this.describirMetodos(i)
        }
    }

}