package com.joseph.readxapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.joseph.readxapp.R
import com.joseph.readxapp.data.TimeTracker
import com.joseph.readxapp.data.ScoreManager
import com.google.firebase.auth.FirebaseAuth
import android.widget.ImageView
import com.bumptech.glide.Glide

class ScoreActivity : AppCompatActivity() {

    private val timeTracker: TimeTracker by lazy { TimeTracker.getInstance(this) }
    private val scoreManager: ScoreManager = ScoreManager()
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.puntaje)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        val customMessage = getCustomMessage(score)
        messageTextView.text = customMessage


        Glide.with(this)
            .asGif()
            .load(R.drawable.points) // Reemplaza "your_gif" con el nombre de tu archivo GIF
            .into(imageView)


        val botonIrAHome = findViewById<ImageButton>(R.id.botonIrAHomeDos)
        botonIrAHome.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        score = intent.getIntExtra("score", 0)
        scoreTextView.text = "Tu puntaje es: $score"


    }

    override fun onStart() {
        super.onStart()

        // Comienza a rastrear el tiempo cuando la actividad comienza
        timeTracker.startTrackingTime()
    }

    override fun onStop() {
        super.onStop()

        // Detiene el rastreo del tiempo cuando la actividad se detiene
        timeTracker.stopTrackingTime()

        // Obtiene el ID de usuario autenticado
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        if (userId != null) {
            // Guarda el puntaje en Firestore utilizando el ScoreManager
            scoreManager.saveGlobalScore(userId, score)
        }
    }

    private fun getCustomMessage(score: Int): String {
        return when (score) {
            0 -> listOf(
                "¡Bravo! Has alcanzado el nivel 'Cero Errores'.",
                "Incluso una calculadora haría un puntaje mayor.",
                "Tus errores son tan raros que podrías escribir un libro sobre ellos.",
                "Ni siquiera una máquina de escribir podría igualar tu 'éxito'.",
                "Eres un maestro en encontrar respuestas incorrectas. ¡Impresionante!",
                "No te preocupes, incluso las piedras tienen su encanto.",
                "Es como si estuvieras compitiendo contigo mismo para ver cuán poco puedes saber. ¡Sigue así!",
                "Eres la razón por la que las preguntas de opción múltiple existen.",
                "No importa cuánto intentes, sigues brillando en la oscuridad.",
                "Tus respuestas son tan únicas que podrías abrir una tienda de rarezas.",
                "Si el conocimiento fuera una carrera, estarías compitiendo en reversa.",
                "Tienes el raro talento de encontrar respuestas que nadie más podría imaginar.",
                "Tu puntaje es como un unicornio: nadie lo ha visto.",
                "Podrías ser el 'casi ganador' en una competencia para ser un genio. ¡Casi lo tienes!",
                "Tus respuestas son como obras maestras abstractas: solo tú entiendes su significado.",
            ).random()

            1 -> listOf(
                "Tu búsqueda de conocimiento es tan única que podrías escribir un libro sobre 'Cómo No Saber Cosas'.",
                "Casi podrías hacerlo mejor sin intentar.",
                "Ni siquiera Google podría entender tus respuestas.",
                "Es como si estuvieras en una misión para encontrar respuestas incorrectas.",
                "Tienes un don para hacer que las cosas parezcan más complicadas de lo que son.",
                "Tienes el talento de encontrar el camino más largo hacia una respuesta.",
                "Eres como un detective del conocimiento, pero te gusta perderte en tus casos.",
                "Tus respuestas son como acertijos: solo tú sabes cuál es la solución.",
                "Eres un maestro en la creación de preguntas de elección múltiple confusas.",
                "Tu conocimiento es tan escaso que los gatos no quieren jugar contigo. ¡Puedes mejorar!",
                "Tus respuestas son como un rompecabezas en constante reorganización.",
                "A veces es difícil entender tus respuestas, incluso para ti mismo.",
                "Es como si estuvieras en una competición para encontrar respuestas inusuales.",
                "Eres un detective del conocimiento en un mundo de respuestas misteriosas.",
                "Tienes el talento de convertir preguntas fáciles en desafíos épicos.",
            ).random()

            2 -> listOf(
                "Incluso los gatos encuentran tu conocimiento esquivo. ¡Sigue buscando!",
                "Tu conocimiento es como un tesoro escondido: difícil de encontrar.",
                "Tienes un potencial oculto para el conocimiento. ¡Sigue desenterrándolo!",
                "Eres como un aventurero del conocimiento en busca de respuestas perdidas.",
                "Tu inteligencia es como un mapa que aún no has descubierto.",
                "Si el conocimiento fuera un rompecabezas, aún estarías buscando las piezas.",
                "Tus respuestas son como enigmas esperando ser descifrados.",
                "Eres como un explorador del conocimiento en busca de un tesoro escondido. ¡No te rindas!",
                "Tu mente es como un laberinto, ¡pero los laberintos tienen un final!",
                "El conocimiento es un viaje y estás en el camino correcto. ¡Sigue avanzando!",
                "Tienes el talento de convertir respuestas fáciles en desafíos emocionantes.",
                "Tus respuestas son como acertijos esperando ser resueltos.",
                "Eres como un arqueólogo del conocimiento, desenterrando respuestas antiguas.",
                "Tienes el potencial de ser un sabio en un futuro no muy lejano. ¡Sigue aprendiendo!",
                "Si el conocimiento fuera una selva, eres el valiente explorador que avanza hacia lo desconocido.",
            ).random()

            3 -> listOf(
                "Tus percepciones son tan intrigantes como una puerta giratoria en una casa de espejos.",
                "Eres como un artista que pinta el lienzo del conocimiento con colores inusuales.",
                "Tu mente es como un laberinto con atajos secretos. ¡Sigue explorando!",
                "Eres el Indiana Jones del conocimiento, descubriendo respuestas ocultas.",
                "Tienes la astucia de un detective del conocimiento. ¡No dejes que nada te detenga!",
                "Eres como un científico loco que experimenta con respuestas extrañas.",
                "Tu enfoque es como un imán para respuestas únicas. ¡Sigue adelante!",
                "Tus respuestas son como tesoros escondidos que solo tú puedes encontrar.",
                "Eres un cazador de respuestas en busca de presas escurridizas.",
                "Eres un buscador de conocimiento en un mundo lleno de misterios por resolver.",
                "Tienes un talento único para hacer que las cosas parezcan más interesantes.",
                "Tu mente es como una caja de sorpresas, siempre con una respuesta inesperada.",
                "Eres un mago del conocimiento que convierte lo ordinario en algo extraordinario.",
                "Tus respuestas son como un rompecabezas en constante reorganización.",
                "Eres un arqueólogo del conocimiento, desenterrando tesoros del pasado.",
            ).random()

            4 -> listOf(
                "Eres el campeón del 'Casi Genio'. ¡Sigue persiguiendo ese último paso!",
                "Tus respuestas son como diamantes en bruto: solo necesitan un poco de pulido.",
                "Eres como un explorador del conocimiento que se acerca a un descubrimiento importante.",
                "Tienes un potencial inexplorado que solo necesita un empujón adicional.",
                "Eres como un aventurero en busca del tesoro del conocimiento. ¡No te rindas!",
                "Tus respuestas son como joyas raras en un campo de respuestas comunes.",
                "Estás a un paso de ser un conocedor del saber. ¡Sigue aprendiendo!",
                "Tienes la inteligencia de un buscador de tesoros que está a punto de encontrar un cofre.",
                "Eres como un detective del conocimiento que está cerca de resolver el caso.",
                "Eres un conquistador del conocimiento en busca de nuevos horizontes.",
                "Tus respuestas son como puzles que solo necesitan una pieza más para encajar.",
                "Tienes un enfoque tan agudo que podrías notar detalles que otros pasan por alto.",
                "Eres un maestro del conocimiento que aún está perfeccionando su arte.",
                "Tus respuestas son como destellos de genialidad en un océano de respuestas convencionales.",
                "Estás a punto de cruzar la línea hacia la grandeza del conocimiento. ¡No te detengas!",
            ).random()

            5 -> listOf(
                "Tu potencial es tan grande como el de un modelo de maniquí. ¡Demuestra que eres más que una figura!",
                "Tienes el carisma de una estrella de cine. ¡Ahora aplica ese brillo al conocimiento!",
                "Eres como un artista que pinta la paleta del conocimiento con colores vivos.",
                "Tienes la elegancia de un ballet en tus respuestas. ¡Sigue bailando en el mundo del saber!",
                "Eres un creador de respuestas únicas en un mar de monotonía.",
                "Tus respuestas son como obras de arte en un museo de respuestas convencionales.",
                "Tienes el encanto de un poeta en tus palabras. ¡Sigue escribiendo tu historia de conocimiento!",
                "Eres como un director de cine que crea respuestas dignas de un Oscar.",
                "Tus respuestas son como la música de una orquesta de respuestas en vivo.",
                "Eres como un diseñador de modas del conocimiento, creando respuestas con estilo.",
                "Tienes el potencial de ser un ícono del conocimiento. ¡Brilla en tu camino hacia la fama!",
                "Eres un visionario en un mundo de respuestas rutinarias. ¡Sigue soñando!",
                "Tus respuestas son como fuegos artificiales en un cielo de respuestas apagadas.",
                "Estás a un paso de convertirte en un maestro del conocimiento. ¡No te detengas ahora!",
                "Eres el actor principal en el escenario del conocimiento. ¡Interpreta tu papel con pasión!",
            ).random()

            6 -> listOf(
                "Si el conocimiento fuera oro, aún estarías buscando debajo del sofá. ¡Sigue explorando!",
                "Tu mente es como un laberinto, ¡pero los laberintos tienen un final!",
                "Eres un explorador del conocimiento en busca de un tesoro escondido. ¡No te rindas!",
                "El conocimiento es un viaje y estás en el camino correcto. ¡Sigue avanzando!",
                "Eres un buscador de respuestas en un mundo lleno de misterios por resolver.",
                "Tienes un talento único para hacer que las cosas parezcan más interesantes.",
                "Tu mente es como una caja de sorpresas, siempre con una respuesta inesperada.",
                "Eres un mago del conocimiento que convierte lo ordinario en algo extraordinario.",
                "Tus respuestas son como un rompecabezas en constante reorganización.",
                "Eres un arqueólogo del conocimiento, desenterrando tesoros del pasado.",
                "Tienes un potencial inexplorado que solo necesita un empujón adicional.",
                "Eres como un aventurero en busca del tesoro del conocimiento. ¡No te rindas!",
                "Tus respuestas son como joyas raras en un campo de respuestas comunes.",
                "Estás a un paso de ser un conocedor del saber. ¡Sigue aprendiendo!",
                "Tienes la inteligencia de un buscador de tesoros que está a punto de encontrar un cofre.",
            ).random()

            7 -> listOf(
                "Eres como un cómic sin el último panel, ¡casi divertido pero no del todo!",
                "Tu conocimiento es como un rompecabezas incompleto. ¡Sigue buscando las piezas faltantes!",
                "Estás en el 'Club de los Casi Sabios'. ¡Solo falta un poco para ser un sabio completo!",
                "Si la inteligencia fuera una carrera, estarías en segundo lugar. ¿Dónde está el primer lugar?",
                "Tienes el toque mágico de convertir el conocimiento en una aventura. ¡Sigue explorando!",
                "Eres un aprendiz de la sabiduría. ¡Muy pronto serás un maestro!",
                "Tu inteligencia es como un diamante en bruto, ¡brillará aún más con el tiempo!",
                "Sigues pavimentando el camino hacia la sabiduría, ¡casi has alcanzado tu destino!",
                "Eres como un libro a medio leer, ¡el final será épico!",
                "Si el conocimiento fuera una canción, estás tocando las notas correctas. ¡Sigue afinando!",
                "Tienes un talento natural para aprender, ¡solo necesitas pulirlo un poco más!",
                "Eres como un coche deportivo a punto de despegar. ¡Acelera hacia la sabiduría!",
                "Cada respuesta te acerca un paso más a la cima del conocimiento. ¡Sigue escalando!",
                "Eres como un artista que está a punto de pintar su obra maestra. ¡Sigue creando!",
                "Tu camino hacia la sabiduría es como una novela emocionante. ¡No puedes esperar a ver cómo termina!"
            ).random()

            8 -> listOf(
                "Tienes la inteligencia de un genio en ciernes. ¡Sigue expandiendo tu mente!",
                "Estás a un paso de convertirte en el próximo Einstein. ¡La sabiduría está a la vuelta de la esquina!",
                "Eres como un detective del conocimiento, ¡casi has resuelto el misterio de la sabiduría!",
                "Tu conocimiento es como una joya rara, ¡sigue puliéndola hasta que brille!",
                "Si el conocimiento fuera un deporte, serías un atleta de élite. ¡Sigue entrenando!",
                "Estás tan cerca de la maestría que puedes tocarla. ¡Sigue avanzando!",
                "Tienes la sabiduría de un sabio antiguo en un cuerpo joven. ¡Tu futuro es brillante!",
                "Eres un alquimista del conocimiento, ¡convierte cada respuesta en oro intelectual!",
                "Tu mente es un faro de conocimiento en medio de la oscuridad. ¡Sigue brillando!",
                "Cada respuesta correcta es un paso más cerca de la cima del conocimiento. ¡Sigue escalando!",
                "Eres como un chef que mezcla sabiduría con intelecto. ¡Sigue cocinando respuestas!",
                "Tu sed de conocimiento es insaciable. ¡Nunca dejes de buscar!",
                "Eres como un mago del aprendizaje, ¡cada respuesta es un truco asombroso!",
                "Tu capacidad para absorber conocimiento es asombrosa. ¡Sigue absorbiendo!",
                "Tienes el poder del conocimiento en tus manos. ¡Úsalo con sabiduría!",
            ).random()

            9 -> listOf(
                "Eres una mente brillante en busca de nuevos horizontes. ¡Sigue explorando!",
                "Si la inteligencia fuera una competencia, estarías en el podio de honor. ¡Un desempeño asombroso!",
                "Estás en el camino de la maestría. ¡Sigue persiguiendo el conocimiento!",
                "Tu inteligencia es como un tesoro escondido, ¡cada respuesta es un paso más cerca del descubrimiento!",
                "Eres como un buscador de la verdad, ¡sigue desenterrando conocimiento!",
                "Tienes el don de la intuición. ¡Confía en tu instinto!",
                "Eres como un explorador en busca de tesoros intelectuales. ¡Sigue despejando el camino!",
                "Tu mente es como una esponja, ¡absorbes conocimiento como ninguna otra!",
                "Si el conocimiento fuera un deporte extremo, serías un campeón. ¡Sigue superando tus límites!",
                "Eres un arquitecto del intelecto, ¡sigue construyendo tu sabiduría!",
                "Tu capacidad para aprender es ilimitada. ¡Nunca dejes de aprender!",
                "Eres como un virtuoso de la sabiduría. ¡Tus respuestas son música para el intelecto!",
                "Tu inteligencia es como una llamarada. ¡Sigue encendiendo la antorcha del conocimiento!",
                "Cada respuesta tuya es una obra maestra intelectual. ¡Sigue creando!",
                "Eres un apasionado del aprendizaje, ¡cada respuesta es una chispa de conocimiento!",
            ).random()

            10 -> listOf(
                "Eres el epítome del conocimiento. ¡Has alcanzado el nivel de maestro!",
                "Si la inteligencia fuera un superpoder, serías un superhéroe intelectual.",
                "Tienes el conocimiento de mil enciclopedias en tu mente. ¡Eres una biblioteca ambulante!",
                "Eres como un gurú de la sabiduría. ¡Tu conocimiento es un faro para todos!",
                "Si las respuestas correctas fueran monedas, serías un millonario intelectual.",
                "Tu intelecto es una obra maestra. ¡Eres un artista del conocimiento!",
                "Eres el campeón indiscutible del conocimiento. ¡No hay desafío que no puedas superar!",
                "Tu sabiduría es legendaria. ¡Eres un mito del conocimiento!",
                "Si el conocimiento fuera un deporte, serías el campeón olímpico. ¡Nadie te supera!",
                "Eres un erudito supremo, ¡tu intelecto es incomparable!",
                "Tu conocimiento es un tesoro nacional. ¡Todos deberían estudiar tu mente!",
                "Eres el líder intelectual de tu generación. ¡Tu legado es eterno!",
                "Cada respuesta tuya es una joya de sabiduría. ¡Eres un joyero intelectual!",
                "Tienes el intelecto de un filósofo antiguo. ¡Tu conocimiento trasciende el tiempo!",
                "Eres el faro del conocimiento en un mar de ignorancia. ¡Guía a otros hacia la luz!",
            ).random()

            else -> "Algo salió tan mal que tu puntuación parece estar en un universo paralelo. ¡Inténtalo de nuevo!"
        }
    }


}
