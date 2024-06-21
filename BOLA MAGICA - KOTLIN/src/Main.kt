const val RESPUESTA_AFIRMATIVA = "✔"
const val RESPUESTA_NEGATIVA = "X"
const val RESPUESTA_DUDOSA = "?"

val respuestas = mapOf(
    "Sí" to RESPUESTA_AFIRMATIVA,
    "Es cierto" to RESPUESTA_AFIRMATIVA,
    "Totalmente" to RESPUESTA_AFIRMATIVA,
    "Sin duda" to RESPUESTA_AFIRMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no" to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_DUDOSA
)

fun main() {
    println("Hola soy tu bola 8 magica creada en KOTLIN, ¿Cual de estas opciones deseas realizar?")
    println("1. Realizar una pregunta")
    println("2. Revisar todas las respuestas")
    println("3. Salir")

    val valorIngresado = readLine()

    when(valorIngresado){
        "1" -> realizarpregunta()
        "2" -> mostrarRespuestas(RESPUESTA_DUDOSA)
        "3" -> salir()
        "4" -> error()
    }


}

fun error(){
    println("Escogiste una opcion no valida")
}

fun salir(){
 println("Hasta luego")
}

fun realizarpregunta (){
    println("¿Que pregunta deseas realizar?")
    readLine()
    println("Asi que esa era tu pregunta...La respuesta a eso es:")
    val respuestagenerada = respuestas.keys.random()
    println(respuestagenerada)
}

fun mostrarRespuestas(RESPUESTA_DUDOSA: String) {
    println("Selecciona una opción")
    println("1.Revisar todas las respuestas")
    println("2.Revisar solo las respuestas afirmativas")
    println("3.Revisar solo las respuestas dudosas")
    println("4.Revisar solo las respuestas negativas")

    val opcioningresada = readLine()

    when(opcioningresada){
        "1" -> mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoderespuesta = RESPUESTA_AFIRMATIVA)
        "3" -> mostrarRespuestasPorTipo(tipoderespuesta = RESPUESTA_NEGATIVA)
        "4" -> mostrarRespuestasPorTipo(tipoderespuesta = RESPUESTA_DUDOSA)
        else -> println("Respuesta no valida")
    }
}

fun mostrarRespuestasPorTipo(tipoderespuesta : String = "Todos") {

    fun mostrarrespuesta(filtro : String){
        respuestas.filterValues{it == filtro}
            .also { respuestasPositivas -> println(respuestasPositivas.keys) }
    }


  when(tipoderespuesta){
      "TODOS" -> respuestas.keys.forEach{respuestas -> println(respuestas)}
      RESPUESTA_AFIRMATIVA -> mostrarrespuesta(RESPUESTA_AFIRMATIVA)


      RESPUESTA_NEGATIVA -> mostrarrespuesta(RESPUESTA_NEGATIVA)


      RESPUESTA_DUDOSA -> mostrarRespuestas(RESPUESTA_DUDOSA)

  }
}



