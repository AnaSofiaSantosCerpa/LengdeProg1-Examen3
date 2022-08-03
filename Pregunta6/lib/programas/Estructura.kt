package lib.programas

public class Estructura(val nombre: String, val sec: Pair<String,String>, ) {
    
    init {
        var flag = true
    }
    
    fun atomo() : String {
        return nombre
    }

    fun secuencia() : Pair<String,String> {
        return sec
    }

    fun ask(n:String, x: String, y: String) : String {
        var str = ""

        if (Atomo(x).isAtomo() && Atomo(y).isAtomo()) {
            if (this.atomo() == n && this.secuencia() == Pair(x,y)) {
                str = "Satisfacible"
            } 
        } else if (Atomo(x).isAtomo() && Variable(y).isVariable()) {
            if (this.atomo() == n && this.secuencia().first == x) {
                var newY = this.secuencia().second
                str = "Satisfacible, cuando '$y = $newY'. ¿Qué desea hacer?"
            }
        } else if (Variable(x).isVariable() && Atomo(y).isAtomo()) {
            if (this.atomo() == n && this.secuencia().second == y) {
                var newX = this.secuencia().first
                str = "Satisfacible, cuando '$x = $newX'. ¿Qué desea hacer?"
            }
        } else {
            if (this.atomo() == n) {
                var newX = this.secuencia().first
                var newY = this.secuencia().second
                str = "Satisfacible, cuando '$x = $newX' y '$y = $newY'. ¿Qué desea hacer?"
            }
        }


        return str
    }


}