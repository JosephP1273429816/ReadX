package com.joseph.readxapp.data

data class Question(
    val question: String,
    val text: String,
    val answers: List<String>,
    val correctAnswer: Int
)

object QuestionData {
    val questionList = ArrayList<Question>()

    init {
        questionList.add(
            Question(
                "Según el texto, para que la atención primaria en salud, por parte de la medicina oficial, pueda atender a más del 20 % de la población, sería necesario principalmente",

                "La medicina popular colombiana conserva una amplia serie de conocimientos empíricos sobre gran diversidad de recursos botánicos, que han sido esenciales para el cuidado de la salud . Pero, con la oficialización de la medicina a finales del siglo XIX, la creación de las primeras escuelas de medicina y de farmacia y la creación de una legislación que buscaba regular estas disciplinas, muchos de estos conocimientos fueron rechazados al igual que sus prácticas médicas . Paradójicamente, mientras la medicina oficial negaba los conocimientos populares, se servía de ellos para desarrollar muchos de los avances farmacéuticos de los que se vale la medicina oficial para sus tratamientos . Por otro lado, según la Organización Mundial de la Salud, la atención primaria en salud por parte de la medicina oficial cubre apenas a un20 % de la población en los países en vías de desarrollo, mientras que el80 % tiene que recurrir a otras prácticas médicas populares y lo hace en gran parte por la poca garantía de acceso y de aseguramiento de la población pobre.Lo anterior sigue generando inconformidad en quienes practican la medicina oficial pues consideran que la medicina popular no representa un conocimiento válido porque no se fundamenta en pruebas científicas y no está regulada.Sin embargo, ambas medicinas pueden llegar a ser complementarias si se estudian de manera juiciosa y se determinan cuáles de las prácticas y de los recursos botánicos usados por la medicina popular son perjudiciales y cuáles brindan alternativas de salud a las poblaciones necesitadas . De esta manera, también se promueve la inclusión, el reconocimiento y el respeto por la diversidad cultural y por los conocimientos populares . Tomado y adaptado de: Prieto Gaona, Oriana.(2011).Proyecto de investigación sobre medicina popular .",

                listOf(
                    "promover sistemas de financiación adecuados y equitativos que canalicen los recursos necesarios para lograr una atención de mejor calidad y con mayor cobertura.",
                    "prever el envejecimiento demográfico de la población, las estructuras familiares cambiantes, y el de los mercados de trabajo informales.",
                    "respetar el derecho a los servicios de salud, el respeto a las diferencias culturales y a los principios de igualdad y de no discriminación.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De acuerdo con Arturo Escobar, el propósito de la doctrina Truman era",

                "En su discurso de posesión como presidente de Estados Unidos el 20 de enero de 1949, Harry Truman anunció al mundo entero su concepto de “ trato justo”.Un componente esencial del concepto era su llamado a Estados Unidos y al mundo para resolver los problemas de las “áreas subdesarrolladas” del globo: Más de la mitad de la población del mundo vive en condiciones cercanas a la miseria . Su alimentación es inadecuada, es víctima de la enfermedad. Su vida económica es primitiva y está estancada . Su pobreza constituye un obstáculo y una amenaza tanto para ellos como para las áreas más prósperas . Por primera vez en la historia, la humanidad posee el conocimiento y la capacidad para aliviar el sufrimiento de estas gentes… Creo que deberíamos poner a disposición de los amantes de la paz los beneficios de nuestro acervo de conocimiento técnico para ayudarlos a lograr sus aspiraciones de una vida mejor … Lo que tenemos en mente es un programa de desarrollo basado en los conceptos del trato justo y democrático … Producir más es la clave para la paz y la prosperidad.Y la clave para producir más es una aplicación mayor y más vigorosa del conocimiento técnico y científico moderno( Truman,1964).La doctrina Truman inició una nueva era en la comprensión y el manejo de los asuntos mundiales, en particular de aquellos que se referían a los países económicamente menos avanzados . El propósito era bastante ambicioso: crear las condiciones necesarias para reproducir en todo el mundo los rasgos característicos de las sociedades avanzadas de la época : altos niveles de industrialización y urbanización, tecnificación de la agricultura, rápido crecimiento de la producción material y los niveles de vida, y adopción generalizada de la educación y los valores culturales modernos. En concepto de Truman, el capital, la ciencia y la tecnología eran los principales componentes que harían posible tal revolución masiva . Solo así el sueño americano de paz y abundancia podría extenderse a todos los pueblos del planeta.La invención del Tercer Mundo.Construcción y deconstrucción del desarrollo( Introducción).Arturo Escobar ",

                listOf(
                    "crear condiciones para reproducir en todo el mundo los rasgos característicos de las sociedades avanzadas.",
                    "adoptar, en el primer mundo, el sueño americano de paz y abundancia, la educación y los valores culturales modernos.",
                    "iniciar una nueva era en la comprensión y manejo de los asuntos de los países económicamente más avanzados.",
                    "se derogue la ley de que la medicina científica es la única oficial.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "Para alcanzar los propósitos de la doctrina, Harry Truman proponía como estrategia",


                "En su discurso de posesión como presidente de Estados Unidos el 20 de enero de 1949, Harry Truman anunció al mundo entero su concepto de “ trato justo”.Un componente esencial del concepto era su llamado a Estados Unidos y al mundo para resolver los problemas de las “áreas subdesarrolladas” del globo: Más de la mitad de la población del mundo vive en condiciones cercanas a la miseria . Su alimentación es inadecuada, es víctima de la enfermedad. Su vida económica es primitiva y está estancada . Su pobreza constituye un obstáculo y una amenaza tanto para ellos como para las áreas más prósperas . Por primera vez en la historia, la humanidad posee el conocimiento y la capacidad para aliviar el sufrimiento de estas gentes… Creo que deberíamos poner a disposición de los amantes de la paz los beneficios de nuestro acervo de conocimiento técnico para ayudarlos a lograr sus aspiraciones de una vida mejor … Lo que tenemos en mente es un programa de desarrollo basado en los conceptos del trato justo y democrático … Producir más es la clave para la paz y la prosperidad.Y la clave para producir más es una aplicación mayor y más vigorosa del conocimiento técnico y científico moderno( Truman,1964).La doctrina Truman inició una nueva era en la comprensión y el manejo de los asuntos mundiales, en particular de aquellos que se referían a los países económicamente menos avanzados . El propósito era bastante ambicioso: crear las condiciones necesarias para reproducir en todo el mundo los rasgos característicos de las sociedades avanzadas de la época : altos niveles de industrialización y urbanización, tecnificación de la agricultura, rápido crecimiento de la producción material y los niveles de vida, y adopción generalizada de la educación y los valores culturales modernos. En concepto de Truman, el capital, la ciencia y la tecnología eran los principales componentes que harían posible tal revolución masiva . Solo así el sueño americano de paz y abundancia podría extenderse a todos los pueblos del planeta.La invención del Tercer Mundo.Construcción y deconstrucción del desarrollo( Introducción).Arturo Escobar ",

                listOf(
                    "elevar los niveles de industrialización y urbanización.",
                    "tratar equitativamente a todas las naciones y a todos los pueblos del planeta.",
                    "producir más fortaleciendo la alianza entre capital, ciencia y tecnología.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "En el segundo párrafo, se desvirtúa a los opositores de la tauromaquia",


                "DEFENSA DE LA FIESTA BRAVA Jorge Nacif La fiesta de los toros es uno de los espectáculos más antiguos de la humanidad, sus primeros antecedentes datan de la antigua Grecia . Desde entonces, este juego tuvo muchos detractores.Los que están en contra de la fiesta, argumentan que se “ tortura ” al toro con las banderillas, y claro, que la res es muerta en el ruedo . Sin embargo, creo que los opositores no entienden en lo más mínimo lo que es el toreo.La tauromaquia es, ante todo, un arte pues posee dos características fundamentales: la estética y la técnica, aunque el arte es un concepto subjetivo, casi siempre cumple con estos dos elementos.Pero el arte del toreo tiene algo más : el peligro.Decía David Silveti que el don más generoso de un artista es poner en juego la vida misma . Para los que no sepan, los puyazos que dan los picadores tienen un objetivo claro . La carne del toro se come y como esta se contamina por la adrenalina, el puyazo sirve para descongestionar al toro, mientras sangra, se va purificando.Por otra parte, la muerte del toro debe ser entendida como algo natural, toda vida termina en la muerte, la única certeza que tenemos siempre . Finalmente se habla de los derechos de los animales, bueno, esto se oye bien pero es una falacia, el término de derecho es un concepto meramente humano.Lo importante en una sociedad es garantizar los derechos de los hombres . Olé ... Adaptado de: Nacif, Jorge.“ Defensa de la fiesta brava ”. Disponible en : http ://de10.com.mx/detalle416.html",

                listOf(
                    "citando la opinión de una fuente reconocida como David Silveti.",
                    "denunciando su falta de comprensión del arte del toreo.",
                    "alabando la forma en que se tortura al animal en el ruedo.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "Entre las razones dadas por Jorge Nacif para sustentar su tesis, resulta una falacia",


                "DEFENSA DE LA FIESTA BRAVA Jorge Nacif La fiesta de los toros es uno de los espectáculos más antiguos de la humanidad, sus primeros antecedentes datan de la antigua Grecia . Desde entonces, este juego tuvo muchos detractores.Los que están en contra de la fiesta, argumentan que se “ tortura ” al toro con las banderillas, y claro, que la res es muerta en el ruedo . Sin embargo, creo que los opositores no entienden en lo más mínimo lo que es el toreo.La tauromaquia es, ante todo, un arte pues posee dos características fundamentales: la estética y la técnica, aunque el arte es un concepto subjetivo, casi siempre cumple con estos dos elementos.Pero el arte del toreo tiene algo más : el peligro.Decía David Silveti que el don más generoso de un artista es poner en juego la vida misma . Para los que no sepan, los puyazos que dan los picadores tienen un objetivo claro . La carne del toro se come y como esta se contamina por la adrenalina, el puyazo sirve para descongestionar al toro, mientras sangra, se va purificando.Por otra parte, la muerte del toro debe ser entendida como algo natural, toda vida termina en la muerte, la única certeza que tenemos siempre . Finalmente se habla de los derechos de los animales, bueno, esto se oye bien pero es una falacia, el término de derecho es un concepto meramente humano.Lo importante en una sociedad es garantizar los derechos de los hombres . Olé ... Adaptado de: Nacif, Jorge.“ Defensa de la fiesta brava ”. Disponible en : http ://de10.com.mx/detalle416.html",

                listOf(
                    "citar a David Silveti, pues él es un reconocido torero que evidentemente tendrá la misma opinión del autor respecto a la tauromaquia.",
                    "recurrir a un referente histórico para expresar que, aunque desde los inicios de la tauromaquia ha habido detractores, nunca han logrado impedirla.",
                    "indicar que el toro, como todos los seres, debe morir, porque establece una analogía entre un hecho natural y la muerte provocada."
                ),
                2
            )
        )
        questionList.add(
            Question(
                "Según el enunciado anterior, ¿cuál de las siguientes palabras sería el antónimo más adecuado para la expresión “mutua benevolencia”?",


                "“Aunque las comodidades de esta vida pueden aumentarse con la ayuda mutua, sin embargo, como eso se puede conseguir dominando a los demás mejor que asociándose con ellos, nadie debe dudar de que los hombres por su naturaleza, si no existiera el miedo, se verían inclinados más al dominio que a la sociedad . Por lo tanto, hay que afirmar que el origen de las sociedades grandes y duraderas no se ha debido a la mutua benevolencia de los hombres sino al miedo mutuo”.Tomado de : Hobbes, T.(1999).Tratado sobre el ciudadano . trad . Joaquín Rodríguez Feo, Madrid, Trotta.",

                listOf(
                    "Mutua negligencia.",
                    "Mutuo desagrado.",
                    "Mutua hostilidad."
                ),
                2
            )
        )
        questionList.add(
            Question(
                "¿Qué función cumple el conector “sin embargo” en el texto anterior?",


                "“Aunque las comodidades de esta vida pueden aumentarse con la ayuda mutua, sin embargo, como eso se puede conseguir dominando a los demás mejor que asociándose con ellos, nadie debe dudar de que los hombres por su naturaleza, si no existiera el miedo, se verían inclinados más al dominio que a la sociedad . Por lo tanto, hay que afirmar que el origen de las sociedades grandes y duraderas no se ha debido a la mutua benevolencia de los hombres sino al miedo mutuo”.Tomado de : Hobbes, T.(1999).Tratado sobre el ciudadano . trad . Joaquín Rodríguez Feo, Madrid, Trotta.",

                listOf(
                    "Desmentir la idea de que la ayuda mutua aumenta las comodidades y afirmar que es por medio del dominio de los demás que se logra.",
                    "Contrastar la idea de que la ayuda mutua aumenta las comodidades, con la idea de que es más efectivo dominar a los demás para aumentarlas.",
                    "Cuestionar la idea de que la ayuda mutua aumenta las comodidades al afirmar que en realidad el dominio puede aumentarlas."
                ),
                1
            )
        )
        questionList.add(
            Question(
                "Por un lado el autor afirma (i) que el miedo origina las sociedades. Por otro lado, (ii) que si no existiera el miedo el hombre buscaría dominar a los demás.¿Cuál es la relación argumentativa entre estas dos afirmaciones?",

                "“Aunque las comodidades de esta vida pueden aumentarse con la ayuda mutua, sin embargo, como eso se puede conseguir dominando a los demás mejor que asociándose con ellos, nadie debe dudar de que los hombres por su naturaleza, si no existiera el miedo, se verían inclinados más al dominio que a la sociedad . Por lo tanto, hay que afirmar que el origen de las sociedades grandes y duraderas no se ha debido a la mutua benevolencia de los hombres sino al miedo mutuo”.Tomado de : Hobbes, T.(1999).Tratado sobre el ciudadano . trad . Joaquín Rodríguez Feo, Madrid, Trotta.",

                listOf(
                    "(ii) es una premisa y (i) la conclusión.",
                    "(i) y (ii) son premisas de un mismo argumento.",
                    "(i) y (ii) presentan la misma conclusión de diferente manera."
                ),
                0
            )
        )
        questionList.add(
            Question(
                "¿Cuál de las siguientes afirmaciones expresa de manera exacta la antítesis de la tesis principal del texto anterior?",


                "“Aunque las comodidades de esta vida pueden aumentarse con la ayuda mutua, sin embargo, como eso se puede conseguir dominando a los demás mejor que asociándose con ellos, nadie debe dudar de que los hombres por su naturaleza, si no existiera el miedo, se verían inclinados más al dominio que a la sociedad . Por lo tanto, hay que afirmar que el origen de las sociedades grandes y duraderas no se ha debido a la mutua benevolencia de los hombres sino al miedo mutuo”.Tomado de : Hobbes, T.(1999).Tratado sobre el ciudadano . trad . Joaquín Rodríguez Feo, Madrid, Trotta.",

                listOf(
                    "El origen de las sociedades grandes y duraderas se debe a la desconfianza de los hombres que las conforman.",
                    "El origen de las sociedades grandes y duraderas se explica por la indiferencia de los hombres que las conforman.",
                    "El origen de las sociedades grandes y duraderas resulta de la colaboración desinteresada de los hombres que las conforman."
                ),
                2
            )
        )
        questionList.add(
            Question(
                "De acuerdo con las ideas expresadas en el texto, si “los hombres por su naturaleza están más inclinados al dominio que a la sociedad”, ¿por qué aparecieron sociedades grandes y duraderas?",


                "“Aunque las comodidades de esta vida pueden aumentarse con la ayuda mutua, sin embargo, como eso se puede conseguir dominando a los demás mejor que asociándose con ellos, nadie debe dudar de que los hombres por su naturaleza, si no existiera el miedo, se verían inclinados más al dominio que a la sociedad . Por lo tanto, hay que afirmar que el origen de las sociedades grandes y duraderas no se ha debido a la mutua benevolencia de los hombres sino al miedo mutuo”.Tomado de : Hobbes, T.(1999).Tratado sobre el ciudadano . trad . Joaquín Rodríguez Feo, Madrid, Trotta.",

                listOf(
                    "Es natural para el hombre asociarse con otros para ejercer su dominio con seguridad.",
                    "Para ampliar su capacidad de dominio, al hombre le resulta más efectivo vivir en sociedad.",
                    "El hombre busca la seguridad y es más seguro para él vivir en comunidad que estar expuesto a ser dominado por otro."
                ),
                2
            )
        )
        questionList.add(
            Question(
                "De acuerdo con el texto ¿cuál de las siguientes afirmaciones es compatible con la posición del autor sobre la inclinación natural del hombre hacia la dominación de los demás?",


                "“Aunque las comodidades de esta vida pueden aumentarse con la ayuda mutua, sin embargo, como eso se puede conseguir dominando a los demás mejor que asociándose con ellos, nadie debe dudar de que los hombres por su naturaleza, si no existiera el miedo, se verían inclinados más al dominio que a la sociedad . Por lo tanto, hay que afirmar que el origen de las sociedades grandes y duraderas no se ha debido a la mutua benevolencia de los hombres sino al miedo mutuo”.Tomado de : Hobbes, T.(1999).Tratado sobre el ciudadano . trad . Joaquín Rodríguez Feo, Madrid, Trotta.",

                listOf(
                    "El dominio es una inclinación deseable en tanto que favorece la cooperación entre los hombres.",
                    "El dominio es una inclinación ineludible, pues resulta más eficiente para alcanzar comodidades que la ayuda mutua.",
                    "El dominio es una inclinación admirable en tanto que causa el miedo que conlleva a la creación de la sociedad."
                ),
                1
            )
        )
        questionList.add(
            Question(
                "De los siguientes enunciados, ¿cuál NO se puede deducir correctamente de la afirmación “un hombre es justo solo si su conducta se adecúa a las normas de un orden social supuestamente justo”?",

                "La Justicia es en primer lugar una cualidad posible, pero no necesaria, de un orden social que regula las relaciones mutuas entre los hombres.Sólo secundariamente es una virtud humana, ya que un hombre es justo sólo si su conducta se adecúa a las normas de un orden social supuestamente justo.Pero¿ qué significa decir que un orden social es justo ? Significa que este orden social regula la conducta de los hombres de un modo satisfactorio para todos, es decir, que todos los hombres encuentran en él la felicidad.La búsqueda de la Justicia es la eterna búsqueda de la felicidad humana.Es una finalidad que el hombre no puede encontrar por sí mismo y por ello la busca en la sociedad . La Justicia es la felicidad social, garantizada por un orden social.Platón, identificando la Justicia con la felicidad, sostiene que un hombre justo es feliz y un hombre injusto es infeliz.Evidentemente, la afirmación según la cual la Justicia es la felicidad no es una respuesta definitiva, sino una forma de eludir el problema.Pues inmediatamente se plantea la cuestión :‘¿Qué es la felicidad?’. Tomado de : Kelsen, H. (1992). ¿Qué es justicia?. Planeta - De Agostini .",

                listOf(
                    "Un hombre que se comporta justamente sigue las normas de un orden social.",
                    "Todo hombre que no se adecúe a las normas de un orden social justo es injusto.",
                    "Hay hombres que se adecúan a un orden social supuestamente justo y sin embargo son injustos.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "Considere el siguiente enunciado: “La búsqueda de la Justicia es la eterna búsqueda de la felicidad humana”,¿Cuál de las siguientes opciones se puede concluir del enunciado ?",


                "La Justicia es en primer lugar una cualidad posible, pero no necesaria, de un orden social que regula las relaciones mutuas entre los hombres.Sólo secundariamente es una virtud humana, ya que un hombre es justo sólo si su conducta se adecúa a las normas de un orden social supuestamente justo.Pero¿ qué significa decir que un orden social es justo ? Significa que este orden social regula la conducta de los hombres de un modo satisfactorio para todos, es decir, que todos los hombres encuentran en él la felicidad.La búsqueda de la Justicia es la eterna búsqueda de la felicidad humana.Es una finalidad que el hombre no puede encontrar por sí mismo y por ello la busca en la sociedad . La Justicia es la felicidad social, garantizada por un orden social.Platón, identificando la Justicia con la felicidad, sostiene que un hombre justo es feliz y un hombre injusto es infeliz.Evidentemente, la afirmación según la cual la Justicia es la felicidad no es una respuesta definitiva, sino una forma de eludir el problema.Pues inmediatamente se plantea la cuestión :‘¿Qué es la felicidad?’. Tomado de : Kelsen, H. (1992). ¿Qué es justicia?. Planeta - De Agostini .",


                listOf(
                    "Quien busca la justicia no encuentrta la felicidad.",
                    "Quien busca la justicia también busca la felicidad.",
                    "El que busca la justicia nunca encuentra la felicidad.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "Considere el siguiente fragmento: “¿Qué significa decir que un orden social es justo? Significa que este orden social regula la conducta de los hombres de un modo satisfactorio para todos, es decir, que todos los hombres encuentran en él la felicidad”.¿Cuál de las siguientes opciones es una antítesis de las ideas presentadas ?",


                "La Justicia es en primer lugar una cualidad posible, pero no necesaria, de un orden social que regula las relaciones mutuas entre los hombres.Sólo secundariamente es una virtud humana, ya que un hombre es justo sólo si su conducta se adecúa a las normas de un orden social supuestamente justo.Pero¿ qué significa decir que un orden social es justo ? Significa que este orden social regula la conducta de los hombres de un modo satisfactorio para todos, es decir, que todos los hombres encuentran en él la felicidad.La búsqueda de la Justicia es la eterna búsqueda de la felicidad humana.Es una finalidad que el hombre no puede encontrar por sí mismo y por ello la busca en la sociedad . La Justicia es la felicidad social, garantizada por un orden social.Platón, identificando la Justicia con la felicidad, sostiene que un hombre justo es feliz y un hombre injusto es infeliz.Evidentemente, la afirmación según la cual la Justicia es la felicidad no es una respuesta definitiva, sino una forma de eludir el problema.Pues inmediatamente se plantea la cuestión :‘¿Qué es la felicidad?’. Tomado de : Kelsen, H. (1992). ¿Qué es justicia?. Planeta - De Agostini .",

                listOf(
                    "Un orden social no puede ser justo y no regular de modo satisfactorio el comportamiento de todos los miembros de la comunidad donde tal orden rige.",
                    "Los órdenes sociales justos proveen felicidad para todos los miembros de la comunidad donde tales órdenes rigen.",
                    "Un orden social puede ser justo y aun así no regular de modo satisfactorio el comportamiento de todos los miembros de la comunidad donde tal orden rige."
                ),
                2
            )
        )
        questionList.add(
            Question(
                "¿Cuál de las siguientes afirmaciones contradice las ideas que presenta el autor?",


                "Nadie es justo por voluntad sino porque no tiene el poder de cometer injusticias. Esto lo percibiremos mejor si nos imaginamos las cosas del siguiente modo : demos tanto al justo como al injusto el poder de hacer lo que cada uno de ellos quiere, y a continuación sigámoslos para observar hasta dónde lo lleva a cada uno el deseo.Entonces sorprenderemos al justo tomando el mismo camino que el injusto, siguiendo sus propios intereses, lo que toda criatura persigue por naturaleza como un bien, pero que la fuerza de la ley obliga a seguir el camino del respeto por la igualdad.El poder del que hablo sería efectivo al máximo si aquellos hombres adquirieran una fuerza tal como la que se dice que cierta vez tuvo Giges, el antepasado del lidio . Giges era un pastor que servía al entonces rey de Lidia . Un día sobrevino una gran tormenta y un terremoto que rasgó la tierra y produjo un abismo en el lugar en que Giges llevaba el ganado a pastorear.Asombrado al ver esto, descendió al abismo y halló, entre otras maravillas que narran los mitos, un caballo de bronce, hueco y con ventanillas, a través de las cuales divisó adentro un cadáver de tamaño más grande que el de un hombre, según parecía, y que no tenía nada excepto un anillo de oro en la mano.Giges le quitó el anillo y salió del abismo.Ahora bien, los pastores hacían su reunión habitual para dar al rey el informe mensual concerniente a la hacienda, cuando llegó Giges llevando el anillo . Tras sentarse entre los demás, casualmente volvió el engaste del anillo hacia el interior de su mano . Al suceder esto se tornó invisible para los que estaban sentados allí, quienes se pusieron a hablar de él como si se hubiera ido . Giges se asombró, y luego, examinando el anillo, dio vuelta al engaste hacia afuera y tornó a hacerse visible.Al advertirlo, experimentó con el anillo para ver si tenía tal propiedad, y comprobó que así era: cuando giraba el engaste hacia adentro, su dueño se hacía invisible, y cuando lo giraba hacia afuera, se hacía visible.En cuanto se hubo cerciorado de ello, maquinó el modo de formar parte de los que fueron a la residencia del rey como informantes y, una vez allí, sedujo a la reina y con ayuda de ella mató al rey y se apoderó del reino.Por consiguiente, si hubiese dos anillos como el de Giges y se diera uno a un hombre justo y otro a uno injusto, ninguno perseveraría en la justicia ni soportaría abstenerse de bienes ajenos, cuando podría tanto apoderarse impunemente de lo que quisiera del mercado, como, al entrar en las casas, acostarse con la mujer que prefiriera, y tanto matar a unos como librar de las cadenas a otros, según su voluntad, y hacer todo como si fuera igual a un dios entre los hombres.En esto, el hombre justo no haría nada diferente del injusto, sino que ambos marcharían por el mismo camino . E incluso se diría que esto es una importante prueba de que nadie es justo si no es forzado a serlo, por no considerarse a la justicia como un bien individual, ya que allí donde cada uno se cree capaz de cometer injusticias, las comete . En efecto, todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría.",

                listOf(
                    "Algunas personas actúan justamente a pesar de poder actuar de manera injusta.",
                    "La injusticia, contrariamente a la justicia, es natural en el ser humano.",
                    "La injusticia, contrariamente a la justicia, se comete voluntariamente."
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De los siguientes enunciados, ¿cuál presenta un supuesto subyacente a la afirmación “Todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría”?",

                "Nadie es justo por voluntad sino porque no tiene el poder de cometer injusticias. Esto lo percibiremos mejor si nos imaginamos las cosas del siguiente modo : demos tanto al justo como al injusto el poder de hacer lo que cada uno de ellos quiere, y a continuación sigámoslos para observar hasta dónde lo lleva a cada uno el deseo.Entonces sorprenderemos al justo tomando el mismo camino que el injusto, siguiendo sus propios intereses, lo que toda criatura persigue por naturaleza como un bien, pero que la fuerza de la ley obliga a seguir el camino del respeto por la igualdad.El poder del que hablo sería efectivo al máximo si aquellos hombres adquirieran una fuerza tal como la que se dice que cierta vez tuvo Giges, el antepasado del lidio . Giges era un pastor que servía al entonces rey de Lidia . Un día sobrevino una gran tormenta y un terremoto que rasgó la tierra y produjo un abismo en el lugar en que Giges llevaba el ganado a pastorear.Asombrado al ver esto, descendió al abismo y halló, entre otras maravillas que narran los mitos, un caballo de bronce, hueco y con ventanillas, a través de las cuales divisó adentro un cadáver de tamaño más grande que el de un hombre, según parecía, y que no tenía nada excepto un anillo de oro en la mano.Giges le quitó el anillo y salió del abismo.Ahora bien, los pastores hacían su reunión habitual para dar al rey el informe mensual concerniente a la hacienda, cuando llegó Giges llevando el anillo . Tras sentarse entre los demás, casualmente volvió el engaste del anillo hacia el interior de su mano . Al suceder esto se tornó invisible para los que estaban sentados allí, quienes se pusieron a hablar de él como si se hubiera ido . Giges se asombró, y luego, examinando el anillo, dio vuelta al engaste hacia afuera y tornó a hacerse visible.Al advertirlo, experimentó con el anillo para ver si tenía tal propiedad, y comprobó que así era: cuando giraba el engaste hacia adentro, su dueño se hacía invisible, y cuando lo giraba hacia afuera, se hacía visible.En cuanto se hubo cerciorado de ello, maquinó el modo de formar parte de los que fueron a la residencia del rey como informantes y, una vez allí, sedujo a la reina y con ayuda de ella mató al rey y se apoderó del reino.Por consiguiente, si hubiese dos anillos como el de Giges y se diera uno a un hombre justo y otro a uno injusto, ninguno perseveraría en la justicia ni soportaría abstenerse de bienes ajenos, cuando podría tanto apoderarse impunemente de lo que quisiera del mercado, como, al entrar en las casas, acostarse con la mujer que prefiriera, y tanto matar a unos como librar de las cadenas a otros, según su voluntad, y hacer todo como si fuera igual a un dios entre los hombres.En esto, el hombre justo no haría nada diferente del injusto, sino que ambos marcharían por el mismo camino . E incluso se diría que esto es una importante prueba de que nadie es justo si no es forzado a serlo, por no considerarse a la justicia como un bien individual, ya que allí donde cada uno se cree capaz de cometer injusticias, las comete . En efecto, todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría.",
                listOf(
                    "La justicia, al igual que la injusticia, brinda ventajas individuales.",
                    "La injusticia, a diferencia de la justicia, brinda pocas ventajas individuales",
                    "La justicia no brinda ninguna de las ventajas individuales que la injusticia brinda."
                ),
                0
            )
        )
        questionList.add(
            Question(
                "¿Cuál de las siguientes afirmaciones constituye una razón a favor de la tesis principal del texto anterior, a saber, que cuando alguien actúa justamente lo hace por obligación y no voluntariamente ?.",


                "Nadie es justo por voluntad sino porque no tiene el poder de cometer injusticias. Esto lo percibiremos mejor si nos imaginamos las cosas del siguiente modo : demos tanto al justo como al injusto el poder de hacer lo que cada uno de ellos quiere, y a continuación sigámoslos para observar hasta dónde lo lleva a cada uno el deseo.Entonces sorprenderemos al justo tomando el mismo camino que el injusto, siguiendo sus propios intereses, lo que toda criatura persigue por naturaleza como un bien, pero que la fuerza de la ley obliga a seguir el camino del respeto por la igualdad.El poder del que hablo sería efectivo al máximo si aquellos hombres adquirieran una fuerza tal como la que se dice que cierta vez tuvo Giges, el antepasado del lidio . Giges era un pastor que servía al entonces rey de Lidia . Un día sobrevino una gran tormenta y un terremoto que rasgó la tierra y produjo un abismo en el lugar en que Giges llevaba el ganado a pastorear.Asombrado al ver esto, descendió al abismo y halló, entre otras maravillas que narran los mitos, un caballo de bronce, hueco y con ventanillas, a través de las cuales divisó adentro un cadáver de tamaño más grande que el de un hombre, según parecía, y que no tenía nada excepto un anillo de oro en la mano.Giges le quitó el anillo y salió del abismo.Ahora bien, los pastores hacían su reunión habitual para dar al rey el informe mensual concerniente a la hacienda, cuando llegó Giges llevando el anillo . Tras sentarse entre los demás, casualmente volvió el engaste del anillo hacia el interior de su mano . Al suceder esto se tornó invisible para los que estaban sentados allí, quienes se pusieron a hablar de él como si se hubiera ido . Giges se asombró, y luego, examinando el anillo, dio vuelta al engaste hacia afuera y tornó a hacerse visible.Al advertirlo, experimentó con el anillo para ver si tenía tal propiedad, y comprobó que así era: cuando giraba el engaste hacia adentro, su dueño se hacía invisible, y cuando lo giraba hacia afuera, se hacía visible.En cuanto se hubo cerciorado de ello, maquinó el modo de formar parte de los que fueron a la residencia del rey como informantes y, una vez allí, sedujo a la reina y con ayuda de ella mató al rey y se apoderó del reino.Por consiguiente, si hubiese dos anillos como el de Giges y se diera uno a un hombre justo y otro a uno injusto, ninguno perseveraría en la justicia ni soportaría abstenerse de bienes ajenos, cuando podría tanto apoderarse impunemente de lo que quisiera del mercado, como, al entrar en las casas, acostarse con la mujer que prefiriera, y tanto matar a unos como librar de las cadenas a otros, según su voluntad, y hacer todo como si fuera igual a un dios entre los hombres.En esto, el hombre justo no haría nada diferente del injusto, sino que ambos marcharían por el mismo camino . E incluso se diría que esto es una importante prueba de que nadie es justo si no es forzado a serlo, por no considerarse a la justicia como un bien individual, ya que allí donde cada uno se cree capaz de cometer injusticias, las comete . En efecto, todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría.",

                listOf(
                    "Solo la igualdad garantiza el respeto por la ley.",
                    "La injusticia brinda las mismas ventajas individuales que la justicia.",
                    "Siempre que una persona cuente con la libertad para cometer injusticias lo hará."
                ),
                2
            )
        )
        questionList.add(
            Question(
                "¿Cuál de las siguientes afirmaciones sintetiza adecuadamente las ideas contenidas en el primer párrafo?",


                "Nadie es justo por voluntad sino porque no tiene el poder de cometer injusticias. Esto lo percibiremos mejor si nos imaginamos las cosas del siguiente modo : demos tanto al justo como al injusto el poder de hacer lo que cada uno de ellos quiere, y a continuación sigámoslos para observar hasta dónde lo lleva a cada uno el deseo.Entonces sorprenderemos al justo tomando el mismo camino que el injusto, siguiendo sus propios intereses, lo que toda criatura persigue por naturaleza como un bien, pero que la fuerza de la ley obliga a seguir el camino del respeto por la igualdad.El poder del que hablo sería efectivo al máximo si aquellos hombres adquirieran una fuerza tal como la que se dice que cierta vez tuvo Giges, el antepasado del lidio . Giges era un pastor que servía al entonces rey de Lidia . Un día sobrevino una gran tormenta y un terremoto que rasgó la tierra y produjo un abismo en el lugar en que Giges llevaba el ganado a pastorear.Asombrado al ver esto, descendió al abismo y halló, entre otras maravillas que narran los mitos, un caballo de bronce, hueco y con ventanillas, a través de las cuales divisó adentro un cadáver de tamaño más grande que el de un hombre, según parecía, y que no tenía nada excepto un anillo de oro en la mano.Giges le quitó el anillo y salió del abismo.Ahora bien, los pastores hacían su reunión habitual para dar al rey el informe mensual concerniente a la hacienda, cuando llegó Giges llevando el anillo . Tras sentarse entre los demás, casualmente volvió el engaste del anillo hacia el interior de su mano . Al suceder esto se tornó invisible para los que estaban sentados allí, quienes se pusieron a hablar de él como si se hubiera ido . Giges se asombró,y luego, examinando el anillo, dio vuelta al engaste hacia afuera y tornó a hacerse visible.Al advertirlo, experimentó con el anillo para ver si tenía tal propiedad, y comprobó que así era: cuando giraba el engaste hacia adentro, su dueño se hacía invisible, y cuando lo giraba hacia afuera, se hacía visible.En cuanto se hubo cerciorado de ello, maquinó el modo de formar parte de los que fueron a la residencia del rey como informantes y, una vez allí, sedujo a la reina y con ayuda de ella mató al rey y se apoderó del reino.Por consiguiente, si hubiese dos anillos como el de Giges y se diera uno a un hombre justo y otro a uno injusto, ninguno perseveraría en la justicia ni soportaría abstenerse de bienes ajenos, cuando podría tanto apoderarse impunemente de lo que quisiera del mercado, como, al entrar en las casas, acostarse con la mujer que prefiriera, y tanto matar a unos como librar de las cadenas a otros, según su voluntad, y hacer todo como si fuera igual a un dios entre los hombres.En esto, el hombre justo no haría nada diferente del injusto, sino que ambos marcharían por el mismo camino . E incluso se diría que esto es una importante prueba de que nadie es justo si no es forzado a serlo, por no considerarse a la justicia como un bien individual, ya que allí donde cada uno se cree capaz de cometer injusticias, las comete . En efecto, todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría.",

                listOf(
                    "El que alguien sea justo es un deber que se deriva de la conciencia moral que tienen todos los hombres.",
                    "El que alguien sea justo resulta de una imposición, pues toda persona sin las restricciones y exigencias de la ley buscará satisfacer sus deseos.",
                    "La justicia es una ilusión, ya que lo natural es que una persona busque cumplir sus deseos y alcanzar sus intereses, sin reparar en la igualdad que exige la ley.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "Dada la estructura del texto anterior, ¿qué propósito general tiene el autor al introducir el relato sobre el anillo de Giges, y cómo lo alcanza?",

                "Nadie es justo por voluntad sino porque no tiene el poder de cometer injusticias. Esto lo percibiremos mejor si nos imaginamos las cosas del siguiente modo : demos tanto al justo como al injusto el poder de hacer lo que cada uno de ellos quiere, y a continuación sigámoslos para observar hasta dónde lo lleva a cada uno el deseo.Entonces sorprenderemos al justo tomando el mismo camino que el injusto, siguiendo sus propios intereses, lo que toda criatura persigue por naturaleza como un bien, pero que la fuerza de la ley obliga a seguir el camino del respeto por la igualdad.El poder del que hablo sería efectivo al máximo si aquellos hombres adquirieran una fuerza tal como la que se dice que cierta vez tuvo Giges, el antepasado del lidio . Giges era un pastor que servía al entonces rey de Lidia . Un día sobrevino una gran tormenta y un terremoto que rasgó la tierra y produjo un abismo en el lugar en que Giges llevaba el ganado a pastorear.Asombrado al ver esto, descendió al abismo y halló, entre otras maravillas que narran los mitos, un caballo de bronce, hueco y con ventanillas, a través de las cuales divisó adentro un cadáver de tamaño más grande que el de un hombre, según parecía, y que no tenía nada excepto un anillo de oro en la mano.Giges le quitó el anillo y salió del abismo.Ahora bien, los pastores hacían su reunión habitual para dar al rey el informe mensual concerniente a la hacienda, cuando llegó Giges llevando el anillo . Tras sentarse entre los demás, casualmente volvió el engaste del anillo hacia el interior de su mano . Al suceder esto se tornó invisible para los que estaban sentados allí, quienes se pusieron a hablar de él como si se hubiera ido . Giges se asombró, y luego, examinando el anillo, dio vuelta al engaste hacia afuera y tornó a hacerse visible.Al advertirlo, experimentó con el anillo para ver si tenía tal propiedad, y comprobó que así era: cuando giraba el engaste hacia adentro, su dueño se hacía invisible, y cuando lo giraba hacia afuera, se hacía visible.En cuanto se hubo cerciorado de ello, maquinó el modo de formar parte de los que fueron a la residencia del rey como informantes y, una vez allí, sedujo a la reina y con ayuda de ella mató al rey y se apoderó del reino.Por consiguiente, si hubiese dos anillos como el de Giges y se diera uno a un hombre justo y otro a uno injusto, ninguno perseveraría en la justicia ni soportaría abstenerse de bienes ajenos, cuando podría tanto apoderarse impunemente de lo que quisiera del mercado, como, al entrar en las casas, acostarse con la mujer que prefiriera, y tanto matar a unos como librar de las cadenas a otros, según su voluntad, y hacer todo como si fuera igual a un dios entre los hombres.En esto, el hombre justo no haría nada diferente del injusto, sino que ambos marcharían por el mismo camino . E incluso se diría que esto es una importante prueba de que nadie es justo si no es forzado a serlo, por no considerarse a la justicia como un bien individual, ya que allí donde cada uno se cree capaz de cometer injusticias, las comete . En efecto, todo hombre piensa que la injusticia le brinda más ventajas individuales que la justicia, y está en lo cierto, si habla de acuerdo con esta teoría.",

                listOf(
                    "Convencer a la audiencia de que todo hombre cometerá injusticias cuando tenga la oportunidad. Así lo hizo Giges una vez descubrió el poder que le otorgaba el anillo.",
                    "Reforzar en la audiencia la idea de que todos cometemos injusticias. El caso de Giges ilustra cómo las personas aparentemente justas en realidad cometen grandes injusticias.",
                    "Persuadir a la audiencia de que actuar justamente requiere mucha fuerza de voluntad. En el caso de Giges, la tentación derivada del poder del anillo doblegó su voluntad."
                ),
                0
            )
        )
        questionList.add(
            Question(
                "En el texto, el autor hace referencia a Rubens para mostrar que",

                "A mucha gente le gusta ver en los cuadros lo que también le gustaría ver en la realidad. Se trata de una preferencia perfectamente comprensible. A todos nos atrae lo bello en la naturaleza y agradecemos a los artistas que lo recojan en sus obras. Esos mismos artistas no nos censurarían por nuestros gustos. Cuando el gran artista flamenco Rubens dibujó a su hijo, estaba orgulloso de sus agradables facciones y deseaba que también nosotros admiráramos al pequeño. Pero esta inclinación a los temas bonitos y atractivos puede convertirse en nociva si nos conduce a rechazar obras que representan asuntos menos agradables. El gran pintor alemán Alberto Durero seguramente dibujó a su madre con tanta devoción y cariño como Rubens a su hijo. Su verista estudio de la vejez y la decrepitud puede producirnos tan viva impresión que nos haga apartar los ojos de él y, sin embargo, si reaccionamos contra esta primera aversión, quedaremos recompensados con creces, pues el dibujo de Durero, en su tremenda sinceridad, es una gran obra. En efecto, de pronto descubrimos que la hermosura de un cuadro no reside realmente en la belleza de su tema. No sé si los golfillos que el pintor español Murillo se complacía en pintar eran estrictamente bellos o no, pero tal como fueron pintados por él, poseen desde luego gran encanto.",

                listOf(
                    "a todos nos atrae lo bello y por fortuna el arte lo recoge en la pintura.",
                    "algunos artistas plasman en sus obras lo que nos gusta ver en la realidad.",
                    "la inclinación en el arte por los temas bonitos y atractivos es bastante nociva.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "¿Cuál de los siguientes enunciados expresa un juicio de valor presente en el texto?",

                "A mucha gente le gusta ver en los cuadros lo que también le gustaría ver en la realidad. Se trata de una preferencia perfectamente comprensible. A todos nos atrae lo bello en la naturaleza y agradecemos a los artistas que lo recojan en sus obras. Esos mismos artistas no nos censurarían por nuestros gustos. Cuando el gran artista flamenco Rubens dibujó a su hijo, estaba orgulloso de sus agradables facciones y deseaba que también nosotros admiráramos al pequeño. Pero esta inclinación a los temas bonitos y atractivos puede convertirse en nociva si nos conduce a rechazar obras que representan asuntos menos agradables. El gran pintor alemán Alberto Durero seguramente dibujó a su madre con tanta devoción y cariño como Rubens a su hijo. Su verista estudio de la vejez y la decrepitud puede producirnos tan viva impresión que nos haga apartar los ojos de él y, sin embargo, si reaccionamos contra esta primera aversión, quedaremos recompensados con creces, pues el dibujo de Durero, en su tremenda sinceridad, es una gran obra. En efecto, de pronto descubrimos que la hermosura de un cuadro no reside realmente en la belleza de su tema. No sé si los golfillos que el pintor español Murillo se complacía en pintar eran estrictamente bellos o no, pero tal como fueron pintados por él, poseen desde luego gran encanto.",

                listOf(
                    "Los golfillos del pintor español Murillo tienen gran encanto.",
                    "Rubens estaba orgulloso de su hijo y deseaba que lo admiráramos.",
                    "Para el público la hermosura de un cuadro reside en la belleza de su tema..",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "¿Cuál de los siguientes títulos sería el más adecuado para el texto anterior?",

                "A mucha gente le gusta ver en los cuadros lo que también le gustaría ver en la realidad. Se trata de una preferencia perfectamente comprensible. A todos nos atrae lo bello en la naturaleza y agradecemos a los artistas que lo recojan en sus obras. Esos mismos artistas no nos censurarían por nuestros gustos. Cuando el gran artista flamenco Rubens dibujó a su hijo, estaba orgulloso de sus agradables facciones y deseaba que también nosotros admiráramos al pequeño. Pero esta inclinación a los temas bonitos y atractivos puede convertirse en nociva si nos conduce a rechazar obras que representan asuntos menos agradables. El gran pintor alemán Alberto Durero seguramente dibujó a su madre con tanta devoción y cariño como Rubens a su hijo. Su verista estudio de la vejez y la decrepitud puede producirnos tan viva impresión que nos haga apartar los ojos de él y, sin embargo, si reaccionamos contra esta primera aversión, quedaremos recompensados con creces, pues el dibujo de Durero, en su tremenda sinceridad, es una gran obra. En efecto, de pronto descubrimos que la hermosura de un cuadro no reside realmente en la belleza de su tema. No sé si los golfillos que el pintor español Murillo se complacía en pintar eran estrictamente bellos o no, pero tal como fueron pintados por él, poseen desde luego gran encanto.",

                listOf(
                    "El arte como modelo de la realidad.",
                    "En defensa del mal gusto en el arte.",
                    "La representación de la belleza en el arte.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "Para el autor, el amor o el enamoramiento son",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "las bases fundamentales del matrimonio y de la familia.",
                    "ideas solo recientemente vinculadas al matrimonio y a la familia.",
                    "sentimientos irracionales que contradicen el deber ser del matrimonio.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "La función del conector “sin embargo” del penúltimo párrafo es:",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "negar información suministrada previamente.",
                    "introducir un nuevo tema de reflexión.",
                    "contrastar la información anterior sin llegar a invalidarla.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "La palabra “dote” del segundo párrafo puede remplazarse, sin que la frase pierda su significado, por:",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "aporte patrimonial",
                    "ceremonia matrimonial",
                    "dinero de los familiares ",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "El tercer párrafo del texto ",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "presenta un paralelo entre las concepciones del amor y el matrimonio en la China tradicional y en Occidente.",
                    "provee un ejemplo de que la asociación entre el amor y el matrimonio no es algo propio de todos los tiempos y culturas.",
                    "demuestra que en China el enamoramiento entre esposos era una amenaza al respeto y la solidaridad de la familia.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "¿Cuál de los siguientes enunciados apoya la idea de que el amor maduro y sincero no siempre ha sido considerado como la base de la familia?",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "En los años 50 se produjo una marcada distinción entre los roles masculino y femenino en la familia.",
                    "La idea del amor como la razón que ha de llevar al matrimonio surgió con el movimiento romántico en el siglo XVIII.",
                    "El matrimonio se consolidó en el siglo XIX como la principal forma de institucionalización del amor conyugal.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "¿Cuál de los siguientes ejemplos ilustra la idea de la familia como una institución política y económica?",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "En la Edad Media la mujer aportaba una dote en el momento de casarse.",
                    "En los siglos XVIII y XIX cambió la idea sobre cuál es la base que sostiene la familia.",
                    "En la sociedad china solo hasta la década de 1920 se acuñó un término para designar el cariño entre esposos.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "¿Qué implicación sobre el matrimonio entre los fulbes africanos puede derivarse a partir de lo dicho por el autor?",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "Que las mujeres de esa comunidad sienten temor a enamorarse de sus esposos.",
                    "algunos artistas plasman en sus obras lo que nos gusta ver en la realidad.",
                    " Que las mujeres de esa comunidad no ven su amor correspondido por sus esposos.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "De acuerdo con el texto, ¿qué se puede concluir acerca del matrimonio?",

                "En nuestra sociedad, se tiende a pensar que el matrimonio, la base de la familia, se sostiene si hay confianza mutua y buena comunicación, así como si ambos miembros de la pareja trabajan unidos para resolver los conflictos y pasan tiempo juntos. En resumen, su piedra angular es un amor maduro y sincero. No obstante, la idea de que este deba ser la razón última del enlace es bastante reciente: aparece en el siglo XVIII y se afianza en el XIX, con el movimiento romántico. Hasta entonces, el matrimonio era ante todo una institución económica y política demasiado trascendente como para dejarla en manos de los dos individuos implicados. En general, resultaba inconcebible que semejante acuerdo se basara en algo tan irracional como el enamoramiento. De hecho, no se inventó ni para que los hombres protegieran a las mujeres ni para que las explotaran. Se trataba de una alianza entre grupos que iba más allá de los familiares más cercanos o incluso los pequeños grupos. Para las élites, era una manera excelente de consolidar la riqueza, fusionar recursos y forjar uniones políticas. Desde la Edad Media, la dote de boda de la mujer constituía el mayor ingreso de dinero, bienes o tierras que un hombre iba a recibir en toda su vida. Para los más pobres, también suponía una transacción económica que debía ser beneficiosa para la familia. Así, se solía casar al hijo con la hija de quien tenía un campo colindante. El matrimonio se convirtió en la estructura que garantizaba la supervivencia de la familia extendida, que incluye abuelos, hermanos, sobrinos… Al contrario de lo que solemos creer, la imagen del marido trabajando fuera de la casa y la mujer haciéndose cargo de la misma es un producto reciente, de los años 50. Hasta entonces, la familia no se sostenía con un único proveedor, sino que todos sus integrantes contribuían al único negocio de la que esta dependía. Que el matrimonio no se basara en el amor no quiere decir que las personas no se enamoraran. Sin embargo, en algunas culturas se trata de algo incompatible con el matrimonio. En la China tradicional, por ejemplo, una atracción excesiva entre los esposos era tenida como una amenaza al respeto y solidaridad debida a la familia. Es más, en tal ambiente, la palabra amor solo se aplicaba para describir las relaciones ilícitas. Fue en la década de 1920 cuando se inventó un término para designar el cariño entre cónyuges. Una idea tan radicalmente nueva exigía un vocabulario especial. Aún hoy, muchas sociedades desaprueban la idea de que el amor sea el centro del matrimonio. Es el caso de los fulbes africanos, del norte de Camerún. “Muchas de sus mujeres niegan vehementemente cualquier apego hacia el marido”, asegura Helen A. Regis, del Departamento de Geografía y Antropología de la Universidad Estatal de Luisiana. Otras, en cambio, aprueban el amor entre esposos, pero nunca antes de que el matrimonio haya cumplido su objetivo primordial.",

                listOf(
                    "Que es una institución que varía dependiendo del contexto histórico y social.",
                    "Que es un pacto entre dos individuos que debe basarse en el amor y la confianza.",
                    "Que es una institución que tiene únicamente propósitos económicos y políticos.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De los siguientes enunciados, el que mejor contradice el planteamiento general del autor es:",

                "William Ospina BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística”. La estadística, que sin duda es un instrumento valioso para entender ciertos fenómenos, se ha vuelto en nuestra época la piedra filosofal. Antes todo querían convertirlo en oro, ahora todo lo convierten en cifras. Todos los días nos llevan y nos traen con cifras que nos producen la ilusión de que todo es medible, de que todo es contable, y a veces perdemos la visión de la complejidad de los hechos gracias a la ilusión de que entendemos el mundo sólo porque conocemos sus porcentajes. Cifras llenas de importancia que, por lo demás, cambian de día en día. Los gobernantes suben y bajan en popularidad como en una montaña rusa al empuje de los acontecimientos, y están aprendiendo que a punta de escándalos, de riesgos y alarmas, es posible mantener el interés y hasta la aprobación de la comunidad. Nadie parece preguntarse si detrás de esas cifras hay hechos profundos y datos verdaderos, si detrás de esas alarmas cotidianas hay cambios reales, si detrás de esos éxitos atronadores hay verdaderas transformaciones históricas. Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan. Vivimos en la edad del espectáculo, en la edad de la satisfacción inmediata, ya quieren que nadie se pregunte de dónde viene ni para dónde va sino sólo cuál es el próximo movimiento, cuál es el último acontecimiento. Las modas han reemplazado a las costumbres, las noticias a las tradiciones, los fanatismos a las religiones, la farándula a la política. Paul Valery decía que llamamos civilización a un proceso cultural por el cual la humanidad tiende a ponerse de acuerdo sobre valores cada vez más abstractos. Y es verdad que allí donde las sociedades primitivas luchan por la tierra, por el oro, por la acumulación personal, las sociedades organizadas luchan por la libertad, por la justicia, por la igualdad de oportunidades, por la dignidad, por la legalidad. En una sociedad primitiva, si la ley es un estorbo para alcanzar un fruto concreto, se viola la ley con arrogancia y con descaro. Ello permite logros inmediatos pero vulnera ampliamente el pacto social, deja a algunos protagonistas más fuertes pero a la comunidad inevitablemente más débil. Hay una conspiración en el mundo contra la lucidez, contra la lentitud, contra las serenas maduraciones, contra los ritmos naturales, contra el esfuerzo, contra la responsabilidad. La inteligencia, por ejemplo, es estorbosa a la hora de lograr la unanimidad: es mucho mejor la disciplina y la sumisión. Las cosas profundas maduran lentamente, pero ahora se quiere que todo sea útil enseguida, no viajar sino llegar, no aprender sino saber, no estudiar sino graduarse, y terminamos creyendo que vale más el resultado que el proceso. Si las semillas tardan en retoñar, piensan que hay que intervenir los procesos para que las semillas revienten antes, para que la planta brote más pronto, para que la tierra extreme su trabajo y las cosechas se multipliquen.", 
                listOf(
                    "La estadística es la primera de las ciencias inexactas (Edmond y Jules De Goncourt).",
                    "La estadística es una herramienta de medición objetiva que no admite duda en su interpretación (George Stephen Leacock).",
                    "La estadística es una ciencia según la cual todas las mentiras se tornan cuadros (Dino Segre Pitigrilli).",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "El argumento “Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan”, es pertinente en el texto porque",

                "William Ospina BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística”. La estadística, que sin duda es un instrumento valioso para entender ciertos fenómenos, se ha vuelto en nuestra época la piedra filosofal. Antes todo querían convertirlo en oro, ahora todo lo convierten en cifras. Todos los días nos llevan y nos traen con cifras que nos producen la ilusión de que todo es medible, de que todo es contable, y a veces perdemos la visión de la complejidad de los hechos gracias a la ilusión de que entendemos el mundo sólo porque conocemos sus porcentajes. Cifras llenas de importancia que, por lo demás, cambian de día en día. Los gobernantes suben y bajan en popularidad como en una montaña rusa al empuje de los acontecimientos, y están aprendiendo que a punta de escándalos, de riesgos y alarmas, es posible mantener el interés y hasta la aprobación de la comunidad. Nadie parece preguntarse si detrás de esas cifras hay hechos profundos y datos verdaderos, si detrás de esas alarmas cotidianas hay cambios reales, si detrás de esos éxitos atronadores hay verdaderas transformaciones históricas. Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan. Vivimos en la edad del espectáculo, en la edad de la satisfacción inmediata, ya quieren que nadie se pregunte de dónde viene ni para dónde va sino sólo cuál es el próximo movimiento, cuál es el último acontecimiento. Las modas han reemplazado a las costumbres, las noticias a las tradiciones, los fanatismos a las religiones, la farándula a la política. Paul Valery decía que llamamos civilización a un proceso cultural por el cual la humanidad tiende a ponerse de acuerdo sobre valores cada vez más abstractos. Y es verdad que allí donde las sociedades primitivas luchan por la tierra, por el oro, por la acumulación personal, las sociedades organizadas luchan por la libertad, por la justicia, por la igualdad de oportunidades, por la dignidad, por la legalidad. En una sociedad primitiva, si la ley es un estorbo para alcanzar un fruto concreto, se viola la ley con arrogancia y con descaro. Ello permite logros inmediatos pero vulnera ampliamente el pacto social, deja a algunos protagonistas más fuertes pero a la comunidad inevitablemente más débil. Hay una conspiración en el mundo contra la lucidez, contra la lentitud, contra las serenas maduraciones, contra los ritmos naturales, contra el esfuerzo, contra la responsabilidad. La inteligencia, por ejemplo, es estorbosa a la hora de lograr la unanimidad: es mucho mejor la disciplina y la sumisión. Las cosas profundas maduran lentamente, pero ahora se quiere que todo sea útil enseguida, no viajar sino llegar, no aprender sino saber, no estudiar sino graduarse, y terminamos creyendo que vale más el resultado que el proceso. Si las semillas tardan en retoñar, piensan que hay que intervenir los procesos para que las semillas revienten antes, para que la planta brote más pronto, para que la tierra extreme su trabajo y las cosechas se multipliquen.",

                listOf(
                    "enfatiza la idea sobre la falta de conciencia crítica de de una sociedad que hoy se define como civilizada.",
                    "aborda como problemática fundamental las instituciones que regulan la sociedad, puesto que estas se aprovechan en detrimento de la comunidad.",
                    "afirma que Roma ha dejado un legado positivo a la sociedad actual, dado que aún se puede mantener el control social mediante el entretenimiento.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "Del texto se puede concluir que",

                "William Ospina BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística”. La estadística, que sin duda es un instrumento valioso para entender ciertos fenómenos, se ha vuelto en nuestra época la piedra filosofal. Antes todo querían convertirlo en oro, ahora todo lo convierten en cifras. Todos los días nos llevan y nos traen con cifras que nos producen la ilusión de que todo es medible, de que todo es contable, y a veces perdemos la visión de la complejidad de los hechos gracias a la ilusión de que entendemos el mundo sólo porque conocemos sus porcentajes. Cifras llenas de importancia que, por lo demás, cambian de día en día. Los gobernantes suben y bajan en popularidad como en una montaña rusa al empuje de los acontecimientos, y están aprendiendo que a punta de escándalos, de riesgos y alarmas, es posible mantener el interés y hasta la aprobación de la comunidad. Nadie parece preguntarse si detrás de esas cifras hay hechos profundos y datos verdaderos, si detrás de esas alarmas cotidianas hay cambios reales, si detrás de esos éxitos atronadores hay verdaderas transformaciones históricas. Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan. Vivimos en la edad del espectáculo, en la edad de la satisfacción inmediata, ya quieren que nadie se pregunte de dónde viene ni para dónde va sino sólo cuál es el próximo movimiento, cuál es el último acontecimiento. Las modas han reemplazado a las costumbres, las noticias a las tradiciones, los fanatismos a las religiones, la farándula a la política. Paul Valery decía que llamamos civilización a un proceso cultural por el cual la humanidad tiende a ponerse de acuerdo sobre valores cada vez más abstractos. Y es verdad que allí donde las sociedades primitivas luchan por la tierra, por el oro, por la acumulación personal, las sociedades organizadas luchan por la libertad, por la justicia, por la igualdad de oportunidades, por la dignidad, por la legalidad. En una sociedad primitiva, si la ley es un estorbo para alcanzar un fruto concreto, se viola la ley con arrogancia y con descaro. Ello permite logros inmediatos pero vulnera ampliamente el pacto social, deja a algunos protagonistas más fuertes pero a la comunidad inevitablemente más débil. Hay una conspiración en el mundo contra la lucidez, contra la lentitud, contra las serenas maduraciones, contra los ritmos naturales, contra el esfuerzo, contra la responsabilidad. La inteligencia, por ejemplo, es estorbosa a la hora de lograr la unanimidad: es mucho mejor la disciplina y la sumisión. Las cosas profundas maduran lentamente, pero ahora se quiere que todo sea útil enseguida, no viajar sino llegar, no aprender sino saber, no estudiar sino graduarse, y terminamos creyendo que vale más el resultado que el proceso. Si las semillas tardan en retoñar, piensan que hay que intervenir los procesos para que las semillas revienten antes, para que la planta brote más pronto, para que la tierra extreme su trabajo y las cosechas se multipliquen.",

                listOf(
                    "las sociedades primitivas evolucionaron a una sociedad organizada, al preguntarse por los cambios reales sin hacer uso de la estadística.",
                    "una sociedad democrática, tal como la presenta Borges, es producto de una sociedad organizada y civilizada.",
                    "una sociedad que privilegia la inmediatez de la información, vulnera el derecho a pensar y se aleja del principio básico de una sociedad organizada.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "En el texto, el fragmento BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística” permite ",

                "William Ospina BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística”. La estadística, que sin duda es un instrumento valioso para entender ciertos fenómenos, se ha vuelto en nuestra época la piedra filosofal. Antes todo querían convertirlo en oro, ahora todo lo convierten en cifras. Todos los días nos llevan y nos traen con cifras que nos producen la ilusión de que todo es medible, de que todo es contable, y a veces perdemos la visión de la complejidad de los hechos gracias a la ilusión de que entendemos el mundo sólo porque conocemos sus porcentajes. Cifras llenas de importancia que, por lo demás, cambian de día en día. Los gobernantes suben y bajan en popularidad como en una montaña rusa al empuje de los acontecimientos, y están aprendiendo que a punta de escándalos, de riesgos y alarmas, es posible mantener el interés y hasta la aprobación de la comunidad. Nadie parece preguntarse si detrás de esas cifras hay hechos profundos y datos verdaderos, si detrás de esas alarmas cotidianas hay cambios reales, si detrás de esos éxitos atronadores hay verdaderas transformaciones históricas. Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan. Vivimos en la edad del espectáculo, en la edad de la satisfacción inmediata, ya quieren que nadie se pregunte de dónde viene ni para dónde va sino sólo cuál es el próximo movimiento, cuál es el último acontecimiento. Las modas han reemplazado a las costumbres, las noticias a las tradiciones, los fanatismos a las religiones, la farándula a la política. Paul Valery decía que llamamos civilización a un proceso cultural por el cual la humanidad tiende a ponerse de acuerdo sobre valores cada vez más abstractos. Y es verdad que allí donde las sociedades primitivas luchan por la tierra, por el oro, por la acumulación personal, las sociedades organizadas luchan por la libertad, por la justicia, por la igualdad de oportunidades, por la dignidad, por la legalidad. En una sociedad primitiva, si la ley es un estorbo para alcanzar un fruto concreto, se viola la ley con arrogancia y con descaro. Ello permite logros inmediatos pero vulnera ampliamente el pacto social, deja a algunos protagonistas más fuertes pero a la comunidad inevitablemente más débil. Hay una conspiración en el mundo contra la lucidez, contra la lentitud, contra las serenas maduraciones, contra los ritmos naturales, contra el esfuerzo, contra la responsabilidad. La inteligencia, por ejemplo, es estorbosa a la hora de lograr la unanimidad: es mucho mejor la disciplina y la sumisión. Las cosas profundas maduran lentamente, pero ahora se quiere que todo sea útil enseguida, no viajar sino llegar, no aprender sino saber, no estudiar sino graduarse, y terminamos creyendo que vale más el resultado que el proceso. Si las semillas tardan en retoñar, piensan que hay que intervenir los procesos para que las semillas revienten antes, para que la planta brote más pronto, para que la tierra extreme su trabajo y las cosechas se multipliquen.",

                listOf(
                    "apoyar la tesis del autor porque ironiza la comprensión que la sociedad hace de la estadística como un valor de cambio que refleja toda la verdad.",
                    "apoyar la tesis del autor porque contrapone la estadística y la sociedad, en razón del uso consciente de los datos en política.",
                    "contradecir la tesis del autor porque afirma que la estadística es la solución a los problemas sociales contemporáneos.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De la forma como se enuncia en el texto, se podría afirmar que el autor",

                "William Ospina BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística”. La estadística, que sin duda es un instrumento valioso para entender ciertos fenómenos, se ha vuelto en nuestra época la piedra filosofal. Antes todo querían convertirlo en oro, ahora todo lo convierten en cifras. Todos los días nos llevan y nos traen con cifras que nos producen la ilusión de que todo es medible, de que todo es contable, y a veces perdemos la visión de la complejidad de los hechos gracias a la ilusión de que entendemos el mundo sólo porque conocemos sus porcentajes. Cifras llenas de importancia que, por lo demás, cambian de día en día. Los gobernantes suben y bajan en popularidad como en una montaña rusa al empuje de los acontecimientos, y están aprendiendo que a punta de escándalos, de riesgos y alarmas, es posible mantener el interés y hasta la aprobación de la comunidad. Nadie parece preguntarse si detrás de esas cifras hay hechos profundos y datos verdaderos, si detrás de esas alarmas cotidianas hay cambios reales, si detrás de esos éxitos atronadores hay verdaderas transformaciones históricas. Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan. Vivimos en la edad del espectáculo, en la edad de la satisfacción inmediata, ya quieren que nadie se pregunte de dónde viene ni para dónde va sino sólo cuál es el próximo movimiento, cuál es el último acontecimiento. Las modas han reemplazado a las costumbres, las noticias a las tradiciones, los fanatismos a las religiones, la farándula a la política. Paul Valery decía que llamamos civilización a un proceso cultural por el cual la humanidad tiende a ponerse de acuerdo sobre valores cada vez más abstractos. Y es verdad que allí donde las sociedades primitivas luchan por la tierra, por el oro, por la acumulación personal, las sociedades organizadas luchan por la libertad, por la justicia, por la igualdad de oportunidades, por la dignidad, por la legalidad. En una sociedad primitiva, si la ley es un estorbo para alcanzar un fruto concreto, se viola la ley con arrogancia y con descaro. Ello permite logros inmediatos pero vulnera ampliamente el pacto social, deja a algunos protagonistas más fuertes pero a la comunidad inevitablemente más débil. Hay una conspiración en el mundo contra la lucidez, contra la lentitud, contra las serenas maduraciones, contra los ritmos naturales, contra el esfuerzo, contra la responsabilidad. La inteligencia, por ejemplo, es estorbosa a la hora de lograr la unanimidad: es mucho mejor la disciplina y la sumisión. Las cosas profundas maduran lentamente, pero ahora se quiere que todo sea útil enseguida, no viajar sino llegar, no aprender sino saber, no estudiar sino graduarse, y terminamos creyendo que vale más el resultado que el proceso. Si las semillas tardan en retoñar, piensan que hay que intervenir los procesos para que las semillas revienten antes, para que la planta brote más pronto, para que la tierra extreme su trabajo y las cosechas se multipliquen.",

                listOf(
                    "se incluye dentro de la sociedad que cuestiona, pero se rebela contra ella.",
                    "es ajeno a la sociedad que cuestiona, pero la analiza y comprende.",
                    "conoce la sociedad que cuestiona y comparte su punto de vista.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "Ospina cita a Paul Valery para abordar el concepto de sociedad organizada y contraponerlo, en el siguiente párrafo, con una apreciación sobre la sociedad primitiva; esto le permite",

                "William Ospina BORGES DECÍA QUE LA DEMOCRACIA, tal como hoy la entendemos, es “ese curioso abuso de la estadística”. La estadística, que sin duda es un instrumento valioso para entender ciertos fenómenos, se ha vuelto en nuestra época la piedra filosofal. Antes todo querían convertirlo en oro, ahora todo lo convierten en cifras. Todos los días nos llevan y nos traen con cifras que nos producen la ilusión de que todo es medible, de que todo es contable, y a veces perdemos la visión de la complejidad de los hechos gracias a la ilusión de que entendemos el mundo sólo porque conocemos sus porcentajes. Cifras llenas de importancia que, por lo demás, cambian de día en día. Los gobernantes suben y bajan en popularidad como en una montaña rusa al empuje de los acontecimientos, y están aprendiendo que a punta de escándalos, de riesgos y alarmas, es posible mantener el interés y hasta la aprobación de la comunidad. Nadie parece preguntarse si detrás de esas cifras hay hechos profundos y datos verdaderos, si detrás de esas alarmas cotidianas hay cambios reales, si detrás de esos éxitos atronadores hay verdaderas transformaciones históricas. Roma creyó que era posible gobernar con pan y circo. El mundo contemporáneo le está demostrando que en esa fórmula sobraba el pan. Vivimos en la edad del espectáculo, en la edad de la satisfacción inmediata, ya quieren que nadie se pregunte de dónde viene ni para dónde va sino sólo cuál es el próximo movimiento, cuál es el último acontecimiento. Las modas han reemplazado a las costumbres, las noticias a las tradiciones, los fanatismos a las religiones, la farándula a la política. Paul Valery decía que llamamos civilización a un proceso cultural por el cual la humanidad tiende a ponerse de acuerdo sobre valores cada vez más abstractos. Y es verdad que allí donde las sociedades primitivas luchan por la tierra, por el oro, por la acumulación personal, las sociedades organizadas luchan por la libertad, por la justicia, por la igualdad de oportunidades, por la dignidad, por la legalidad. En una sociedad primitiva, si la ley es un estorbo para alcanzar un fruto concreto, se viola la ley con arrogancia y con descaro. Ello permite logros inmediatos pero vulnera ampliamente el pacto social, deja a algunos protagonistas más fuertes pero a la comunidad inevitablemente más débil. Hay una conspiración en el mundo contra la lucidez, contra la lentitud, contra las serenas maduraciones, contra los ritmos naturales, contra el esfuerzo, contra la responsabilidad. La inteligencia, por ejemplo, es estorbosa a la hora de lograr la unanimidad: es mucho mejor la disciplina y la sumisión. Las cosas profundas maduran lentamente, pero ahora se quiere que todo sea útil enseguida, no viajar sino llegar, no aprender sino saber, no estudiar sino graduarse, y terminamos creyendo que vale más el resultado que el proceso. Si las semillas tardan en retoñar, piensan que hay que intervenir los procesos para que las semillas revienten antes, para que la planta brote más pronto, para que la tierra extreme su trabajo y las cosechas se multipliquen.",

                listOf(
                    "explicar el concepto de sociedad desde una perspectiva histórica que rebate el planteamiento de Borges.",
                    "relacionar el concepto de sociedad con el de cultura que apoya el concepto de democracia de Borges. ",
                    "ampliar su explicación sobre el problema y dar autoridad a la cadena argumental de su planteamiento.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "Gracias a la creatividad del autor, el cuento anterior es una variante del universo ficcional de",

                "Franz Kafka: Existen métodos insuficientes, casi pueriles, que también pueden servir para la salvación. He aquí la prueba: Para protegerse del canto de las sirenas, Ulises tapó sus oídos con cera y se hizo encadenar al mástil de la nave. Aunque todo el mundo sabía que este recurso era ineficaz, muchos navegantes podían haber hecho lo mismo, excepto aquellos que eran atraídos por las sirenas ya desde lejos. El canto de las sirenas lo traspasaba todo, la pasión de los seducidos habría hecho saltar prisiones más fuertes que mástiles y cadenas. Ulises no pensó en eso, si bien quizá alguna vez, algo había llegado a sus oídos. Se confió por completo en aquel puñado de cera y en el manojo de cadenas. Contento con sus pequeñas estratagemas, navegó en pos de las sirenas con alegría inocente. Sin embargo, las sirenas poseen un arma mucho más terrible que el canto: su silencio. No sucedió en realidad, pero es probable que alguien se hubiera salvado alguna vez de sus cantos, aunque nunca de su silencio. Ningún sentimiento terreno puede equipararse a la vanidad de haberlas vencido mediante las propias fuerzas. En efecto, las terribles seductoras no cantaron cuando pasó Ulises; tal vez porque creyeron que a aquel enemigo sólo podía herirlo el silencio, tal vez porque el espectáculo de felicidad en el rostro de Ulises, quien sólo pensaba en ceras y cadenas, les hizo olvidar toda canción. Ulises (para expresarlo de alguna manera) no oyó el silencio. Estaba convencido de que ellas cantaban y que sólo él estaba a salvo. Fugazmente, vio primero las curvas de sus cuellos, la respiración profunda, los ojos llenos de lágrimas, los labios entreabiertos. Creía que todo era parte de la melodía que fluía sorda en torno de él. El espectáculo comenzó a desvanecerse pronto; las sirenas se esfumaron de su horizonte personal, y precisamente cuando se hallaba más próximo, ya no supo más acerca de ellas. Y ellas, más hermosas que nunca, se estiraban, se contoneaban. Desplegaban sus húmedas cabelleras al viento, abrían sus garras acariciando la roca. Ya no pretendían seducir, tan sólo querían atrapar por un momento más el fulgor de los grandes ojos de Ulises. Si las sirenas hubieran tenido conciencia, habrían desaparecido aquel día. Pero ellas permanecieron y Ulises escapó. La tradición añade un comentario a la historia. Se dice que Ulises era tan astuto, tan ladino, que incluso los dioses del destino eran incapaces de penetrar en su fuero interno. Por más que esto sea inconcebible para la mente humana, tal vez Ulises supo del silencio de las sirenas y tan sólo representó tamaña farsa para ellas y para los dioses, en cierta manera a modo de escudo.",

                listOf(
                    "La Odisea.",
                    "El Ulises.",
                    "El legendario Odiseo y Poseidón.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "En el cuento, Kafka propone que ante la actitud de Ulises",

                "Franz Kafka: Existen métodos insuficientes, casi pueriles, que también pueden servir para la salvación. He aquí la prueba: Para protegerse del canto de las sirenas, Ulises tapó sus oídos con cera y se hizo encadenar al mástil de la nave. Aunque todo el mundo sabía que este recurso era ineficaz, muchos navegantes podían haber hecho lo mismo, excepto aquellos que eran atraídos por las sirenas ya desde lejos. El canto de las sirenas lo traspasaba todo, la pasión de los seducidos habría hecho saltar prisiones más fuertes que mástiles y cadenas. Ulises no pensó en eso, si bien quizá alguna vez, algo había llegado a sus oídos. Se confió por completo en aquel puñado de cera y en el manojo de cadenas. Contento con sus pequeñas estratagemas, navegó en pos de las sirenas con alegría inocente. Sin embargo, las sirenas poseen un arma mucho más terrible que el canto: su silencio. No sucedió en realidad, pero es probable que alguien se hubiera salvado alguna vez de sus cantos, aunque nunca de su silencio. Ningún sentimiento terreno puede equipararse a la vanidad de haberlas vencido mediante las propias fuerzas. En efecto, las terribles seductoras no cantaron cuando pasó Ulises; tal vez porque creyeron que a aquel enemigo sólo podía herirlo el silencio, tal vez porque el espectáculo de felicidad en el rostro de Ulises, quien sólo pensaba en ceras y cadenas, les hizo olvidar toda canción. Ulises (para expresarlo de alguna manera) no oyó el silencio. Estaba convencido de que ellas cantaban y que sólo él estaba a salvo. Fugazmente, vio primero las curvas de sus cuellos, la respiración profunda, los ojos llenos de lágrimas, los labios entreabiertos. Creía que todo era parte de la melodía que fluía sorda en torno de él. El espectáculo comenzó a desvanecerse pronto; las sirenas se esfumaron de su horizonte personal, y precisamente cuando se hallaba más próximo, ya no supo más acerca de ellas. Y ellas, más hermosas que nunca, se estiraban, se contoneaban. Desplegaban sus húmedas cabelleras al viento, abrían sus garras acariciando la roca. Ya no pretendían seducir, tan sólo querían atrapar por un momento más el fulgor de los grandes ojos de Ulises. Si las sirenas hubieran tenido conciencia, habrían desaparecido aquel día. Pero ellas permanecieron y Ulises escapó. La tradición añade un comentario a la historia. Se dice que Ulises era tan astuto, tan ladino, que incluso los dioses del destino eran incapaces de penetrar en su fuero interno. Por más que esto sea inconcebible para la mente humana, tal vez Ulises supo del silencio de las sirenas y tan sólo representó tamaña farsa para ellas y para los dioses, en cierta manera a modo de escudo.",

                listOf(
                    "las hermosas sirenas retozaban en el mar para darle la bienvenida al Rey de Ítaca.",
                    "las inteligentes sirenas se abstienen de cantar en correspondencia a la indiferencia del astuto rey.",
                    "las sirenas tienen el afán de realizar su Eros pero saben que el truco de Ulises es poderoso.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "Del texto de Kafka se puede afirmar que Ulises engañó a los dioses porque",

                "Franz Kafka: Existen métodos insuficientes, casi pueriles, que también pueden servir para la salvación. He aquí la prueba: Para protegerse del canto de las sirenas, Ulises tapó sus oídos con cera y se hizo encadenar al mástil de la nave. Aunque todo el mundo sabía que este recurso era ineficaz, muchos navegantes podían haber hecho lo mismo, excepto aquellos que eran atraídos por las sirenas ya desde lejos. El canto de las sirenas lo traspasaba todo, la pasión de los seducidos habría hecho saltar prisiones más fuertes que mástiles y cadenas. Ulises no pensó en eso, si bien quizá alguna vez, algo había llegado a sus oídos. Se confió por completo en aquel puñado de cera y en el manojo de cadenas. Contento con sus pequeñas estratagemas, navegó en pos de las sirenas con alegría inocente. Sin embargo, las sirenas poseen un arma mucho más terrible que el canto: su silencio. No sucedió en realidad, pero es probable que alguien se hubiera salvado alguna vez de sus cantos, aunque nunca de su silencio. Ningún sentimiento terreno puede equipararse a la vanidad de haberlas vencido mediante las propias fuerzas. En efecto, las terribles seductoras no cantaron cuando pasó Ulises; tal vez porque creyeron que a aquel enemigo sólo podía herirlo el silencio, tal vez porque el espectáculo de felicidad en el rostro de Ulises, quien sólo pensaba en ceras y cadenas, les hizo olvidar toda canción. Ulises (para expresarlo de alguna manera) no oyó el silencio. Estaba convencido de que ellas cantaban y que sólo él estaba a salvo. Fugazmente, vio primero las curvas de sus cuellos, la respiración profunda, los ojos llenos de lágrimas, los labios entreabiertos. Creía que todo era parte de la melodía que fluía sorda en torno de él. El espectáculo comenzó a desvanecerse pronto; las sirenas se esfumaron de su horizonte personal, y precisamente cuando se hallaba más próximo, ya no supo más acerca de ellas. Y ellas, más hermosas que nunca, se estiraban, se contoneaban. Desplegaban sus húmedas cabelleras al viento, abrían sus garras acariciando la roca. Ya no pretendían seducir, tan sólo querían atrapar por un momento más el fulgor de los grandes ojos de Ulises. Si las sirenas hubieran tenido conciencia, habrían desaparecido aquel día. Pero ellas permanecieron y Ulises escapó. La tradición añade un comentario a la historia. Se dice que Ulises era tan astuto, tan ladino, que incluso los dioses del destino eran incapaces de penetrar en su fuero interno. Por más que esto sea inconcebible para la mente humana, tal vez Ulises supo del silencio de las sirenas y tan sólo representó tamaña farsa para ellas y para los dioses, en cierta manera a modo de escudo.",

                listOf(
                    "creyó escuchar el canto de las sirenas y lucho hasta el final.",
                    "escuchó el canto de las sirenas pero el truco funcionó.",
                    "las sirenas nunca cantaron y él se hizo el que se protegía.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "En el texto original de La Odisea, las sirenas cantaron al paso de Ulises, tratando de seducir a su tripulación; en la versión de Kafka, el silencio de las sirenas es sinónimo de",

                "Franz Kafka: Existen métodos insuficientes, casi pueriles, que también pueden servir para la salvación. He aquí la prueba: Para protegerse del canto de las sirenas, Ulises tapó sus oídos con cera y se hizo encadenar al mástil de la nave. Aunque todo el mundo sabía que este recurso era ineficaz, muchos navegantes podían haber hecho lo mismo, excepto aquellos que eran atraídos por las sirenas ya desde lejos. El canto de las sirenas lo traspasaba todo, la pasión de los seducidos habría hecho saltar prisiones más fuertes que mástiles y cadenas. Ulises no pensó en eso, si bien quizá alguna vez, algo había llegado a sus oídos. Se confió por completo en aquel puñado de cera y en el manojo de cadenas. Contento con sus pequeñas estratagemas, navegó en pos de las sirenas con alegría inocente. Sin embargo, las sirenas poseen un arma mucho más terrible que el canto: su silencio. No sucedió en realidad, pero es probable que alguien se hubiera salvado alguna vez de sus cantos, aunque nunca de su silencio. Ningún sentimiento terreno puede equipararse a la vanidad de haberlas vencido mediante las propias fuerzas. En efecto, las terribles seductoras no cantaron cuando pasó Ulises; tal vez porque creyeron que a aquel enemigo sólo podía herirlo el silencio, tal vez porque el espectáculo de felicidad en el rostro de Ulises, quien sólo pensaba en ceras y cadenas, les hizo olvidar toda canción. Ulises (para expresarlo de alguna manera) no oyó el silencio. Estaba convencido de que ellas cantaban y que sólo él estaba a salvo. Fugazmente, vio primero las curvas de sus cuellos, la respiración profunda, los ojos llenos de lágrimas, los labios entreabiertos. Creía que todo era parte de la melodía que fluía sorda en torno de él. El espectáculo comenzó a desvanecerse pronto; las sirenas se esfumaron de su horizonte personal, y precisamente cuando se hallaba más próximo, ya no supo más acerca de ellas. Y ellas, más hermosas que nunca, se estiraban, se contoneaban. Desplegaban sus húmedas cabelleras al viento, abrían sus garras acariciando la roca. Ya no pretendían seducir, tan sólo querían atrapar por un momento más el fulgor de los grandes ojos de Ulises. Si las sirenas hubieran tenido conciencia, habrían desaparecido aquel día. Pero ellas permanecieron y Ulises escapó. La tradición añade un comentario a la historia. Se dice que Ulises era tan astuto, tan ladino, que incluso los dioses del destino eran incapaces de penetrar en su fuero interno. Por más que esto sea inconcebible para la mente humana, tal vez Ulises supo del silencio de las sirenas y tan sólo representó tamaña farsa para ellas y para los dioses, en cierta manera a modo de escudo.",

                listOf(
                    "indiferencia.",
                    "poder.",
                    "agrado.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "En el texto de Kafka compiten",

                "Franz Kafka: Existen métodos insuficientes, casi pueriles, que también pueden servir para la salvación. He aquí la prueba: Para protegerse del canto de las sirenas, Ulises tapó sus oídos con cera y se hizo encadenar al mástil de la nave. Aunque todo el mundo sabía que este recurso era ineficaz, muchos navegantes podían haber hecho lo mismo, excepto aquellos que eran atraídos por las sirenas ya desde lejos. El canto de las sirenas lo traspasaba todo, la pasión de los seducidos habría hecho saltar prisiones más fuertes que mástiles y cadenas. Ulises no pensó en eso, si bien quizá alguna vez, algo había llegado a sus oídos. Se confió por completo en aquel puñado de cera y en el manojo de cadenas. Contento con sus pequeñas estratagemas, navegó en pos de las sirenas con alegría inocente. Sin embargo, las sirenas poseen un arma mucho más terrible que el canto: su silencio. No sucedió en realidad, pero es probable que alguien se hubiera salvado alguna vez de sus cantos, aunque nunca de su silencio. Ningún sentimiento terreno puede equipararse a la vanidad de haberlas vencido mediante las propias fuerzas. En efecto, las terribles seductoras no cantaron cuando pasó Ulises; tal vez porque creyeron que a aquel enemigo sólo podía herirlo el silencio, tal vez porque el espectáculo de felicidad en el rostro de Ulises, quien sólo pensaba en ceras y cadenas, les hizo olvidar toda canción. Ulises (para expresarlo de alguna manera) no oyó el silencio. Estaba convencido de que ellas cantaban y que sólo él estaba a salvo. Fugazmente, vio primero las curvas de sus cuellos, la respiración profunda, los ojos llenos de lágrimas, los labios entreabiertos. Creía que todo era parte de la melodía que fluía sorda en torno de él. El espectáculo comenzó a desvanecerse pronto; las sirenas se esfumaron de su horizonte personal, y precisamente cuando se hallaba más próximo, ya no supo más acerca de ellas. Y ellas, más hermosas que nunca, se estiraban, se contoneaban. Desplegaban sus húmedas cabelleras al viento, abrían sus garras acariciando la roca. Ya no pretendían seducir, tan sólo querían atrapar por un momento más el fulgor de los grandes ojos de Ulises. Si las sirenas hubieran tenido conciencia, habrían desaparecido aquel día. Pero ellas permanecieron y Ulises escapó. La tradición añade un comentario a la historia. Se dice que Ulises era tan astuto, tan ladino, que incluso los dioses del destino eran incapaces de penetrar en su fuero interno. Por más que esto sea inconcebible para la mente humana, tal vez Ulises supo del silencio de las sirenas y tan sólo representó tamaña farsa para ellas y para los dioses, en cierta manera a modo de escudo.",

                listOf(
                    "la sabiduría de las sirenas y el orgullo del guerrero.",
                    "el orgullo de las sirenas y la astucia de Ulises.",
                    "el orgullo del guerrero y el poder de los dioses",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "En el texto, la expresión “para expresarlo de alguna manera” permite",

                "Franz Kafka: Existen métodos insuficientes, casi pueriles, que también pueden servir para la salvación. He aquí la prueba: Para protegerse del canto de las sirenas, Ulises tapó sus oídos con cera y se hizo encadenar al mástil de la nave. Aunque todo el mundo sabía que este recurso era ineficaz, muchos navegantes podían haber hecho lo mismo, excepto aquellos que eran atraídos por las sirenas ya desde lejos. El canto de las sirenas lo traspasaba todo, la pasión de los seducidos habría hecho saltar prisiones más fuertes que mástiles y cadenas. Ulises no pensó en eso, si bien quizá alguna vez, algo había llegado a sus oídos. Se confió por completo en aquel puñado de cera y en el manojo de cadenas. Contento con sus pequeñas estratagemas, navegó en pos de las sirenas con alegría inocente. Sin embargo, las sirenas poseen un arma mucho más terrible que el canto: su silencio. No sucedió en realidad, pero es probable que alguien se hubiera salvado alguna vez de sus cantos, aunque nunca de su silencio. Ningún sentimiento terreno puede equipararse a la vanidad de haberlas vencido mediante las propias fuerzas. En efecto, las terribles seductoras no cantaron cuando pasó Ulises; tal vez porque creyeron que a aquel enemigo sólo podía herirlo el silencio, tal vez porque el espectáculo de felicidad en el rostro de Ulises, quien sólo pensaba en ceras y cadenas, les hizo olvidar toda canción. Ulises (para expresarlo de alguna manera) no oyó el silencio. Estaba convencido de que ellas cantaban y que sólo él estaba a salvo. Fugazmente, vio primero las curvas de sus cuellos, la respiración profunda, los ojos llenos de lágrimas, los labios entreabiertos. Creía que todo era parte de la melodía que fluía sorda en torno de él. El espectáculo comenzó a desvanecerse pronto; las sirenas se esfumaron de su horizonte personal, y precisamente cuando se hallaba más próximo, ya no supo más acerca de ellas. Y ellas, más hermosas que nunca, se estiraban, se contoneaban. Desplegaban sus húmedas cabelleras al viento, abrían sus garras acariciando la roca. Ya no pretendían seducir, tan sólo querían atrapar por un momento más el fulgor de los grandes ojos de Ulises. Si las sirenas hubieran tenido conciencia, habrían desaparecido aquel día. Pero ellas permanecieron y Ulises escapó. La tradición añade un comentario a la historia. Se dice que Ulises era tan astuto, tan ladino, que incluso los dioses del destino eran incapaces de penetrar en su fuero interno. Por más que esto sea inconcebible para la mente humana, tal vez Ulises supo del silencio de las sirenas y tan sólo representó tamaña farsa para ellas y para los dioses, en cierta manera a modo de escudo.",

                listOf(
                    "proponer un significado.",
                    "explicar una palabra.",
                    "justificar una duda.",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "A partir de lo expresado en la segunda estrofa y en relación con el sentido global del poema, se puede inferir que, para el autor, el temor de la muerte es",

                "ARTE POÉTICA Mirar el río hecho de tiempo y agua y recordar que el tiempo es otro río, saber que nos perdemos como el río y que los rostros pasan como el agua. Sentir que la vigilia es otro sueño que sueña no soñar y que la muerte que teme nuestra carne es esa muerte de cada noche, que se llama sueño. Ver en el día o en el año un símbolo de los días del hombre y de sus años, convertir el ultraje de los años en una música, un rumor y un símbolo, ver en la muerte el sueño, en el ocaso un triste oro, tal es la poesía que es inmortal y pobre. La poesía vuelve como la aurora y el ocaso. A veces en las tardes una cara nos mira desde el fondo de un espejo; el arte debe ser como ese espejo que nos revela nuestra propia cara. Cuentan que Ulises, harto de prodigios, lloró de amor al divisar su Ítaca verde y humilde. El arte es esa Ítaca de verde eternidad, no de prodigios. También es como el río interminable que pasa y queda y es cristal de un mismo Heráclito inconstante, que es el mismo y es otro, como el río interminable. Tomado de: García Maffla, Jaime. Antología de poesía colombiana e hispanoamericana. Jorge Luis Borges. Bogotá, Colombia: Editorial Panamericana. pp. 240-241.",

                listOf(
                    "infundado, porque el ser humano permanentemente vive sumido en un sueño ilusorio.",
                    "idealista, pues tanto el cuerpo como el alma se necesitan mutuamente.",
                    "inevitable, ya que todos los seres humanos viven en un estado de vigilia permanente.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De los siguientes fragmentos, el que guarda mayor relación con la concepción del tiempo en la vida, manifestada en la primera estrofa, es:",

                "ARTE POÉTICA Mirar el río hecho de tiempo y agua y recordar que el tiempo es otro río, saber que nos perdemos como el río y que los rostros pasan como el agua. Sentir que la vigilia es otro sueño que sueña no soñar y que la muerte que teme nuestra carne es esa muerte de cada noche, que se llama sueño. Ver en el día o en el año un símbolo de los días del hombre y de sus años, convertir el ultraje de los años en una música, un rumor y un símbolo, ver en la muerte el sueño, en el ocaso un triste oro, tal es la poesía que es inmortal y pobre. La poesía vuelve como la aurora y el ocaso. A veces en las tardes una cara nos mira desde el fondo de un espejo; el arte debe ser como ese espejo que nos revela nuestra propia cara. Cuentan que Ulises, harto de prodigios, lloró de amor al divisar su Ítaca verde y humilde. El arte es esa Ítaca de verde eternidad, no de prodigios. También es como el río interminable que pasa y queda y es cristal de un mismo Heráclito inconstante, que es el mismo y es otro, como el río interminable. Tomado de: García Maffla, Jaime. Antología de poesía colombiana e hispanoamericana. Jorge Luis Borges. Bogotá, Colombia: Editorial Panamericana. pp. 240-241.",

                listOf(
                    "“Yo no sé mañana, yo no sé mañana / si estaremos juntos si se acaba el mundo / yo no sé si soy para ti, si serás para mí / si lleguemos amarnos o a odiarnos…”(Luis Enrique).",
                    "“Vida, devuélveme mis fantasías / mis ganas de vivir la vida / devuélveme el aire…” (Sin Bandera).",
                    "“Sueño contigo / no me conformo con seguir siendo tu amigo / andar a solas preguntándole a mi soledad …”(Alejandro Fernández).",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "La definición de poesía que mejor se relaciona con la concepción poética que expresa Borges en su Arte poética, es:",

                "ARTE POÉTICA Mirar el río hecho de tiempo y agua y recordar que el tiempo es otro río, saber que nos perdemos como el río y que los rostros pasan como el agua. Sentir que la vigilia es otro sueño que sueña no soñar y que la muerte que teme nuestra carne es esa muerte de cada noche, que se llama sueño. Ver en el día o en el año un símbolo de los días del hombre y de sus años, convertir el ultraje de los años en una música, un rumor y un símbolo, ver en la muerte el sueño, en el ocaso un triste oro, tal es la poesía que es inmortal y pobre. La poesía vuelve como la aurora y el ocaso. A veces en las tardes una cara nos mira desde el fondo de un espejo; el arte debe ser como ese espejo que nos revela nuestra propia cara. Cuentan que Ulises, harto de prodigios, lloró de amor al divisar su Ítaca verde y humilde. El arte es esa Ítaca de verde eternidad, no de prodigios. También es como el río interminable que pasa y queda y es cristal de un mismo Heráclito inconstante, que es el mismo y es otro, como el río interminable. Tomado de: García Maffla, Jaime. Antología de poesía colombiana e hispanoamericana. Jorge Luis Borges. Bogotá, Colombia: Editorial Panamericana. pp. 240-241.",

                listOf(
                    "“La poesía, señor hidalgo, a mi parecer, es como una doncella tierna y de poca edad, y en todo extremo hermosa” (Miguel de Cervantes Saavedra).",
                    "“La pintura es poesía muda” (Leonardo Da Vinci).",
                    "“Cada poema es único, en cada obra late, con mayor o menor grado, toda la poesía. Cada lector busca algo en el poema y no es insólito que lo encuentre: ya lo llevaba dentro” (Octavio Paz).",
                ),
                2
            )
        )
        questionList.add(
            Question(
                "Dentro del texto, las palabras que se pueden asociar con la noción de -tiempo- que se desarrolla en el poema, son",

                "ARTE POÉTICA Mirar el río hecho de tiempo y agua y recordar que el tiempo es otro río, saber que nos perdemos como el río y que los rostros pasan como el agua. Sentir que la vigilia es otro sueño que sueña no soñar y que la muerte que teme nuestra carne es esa muerte de cada noche, que se llama sueño. Ver en el día o en el año un símbolo de los días del hombre y de sus años, convertir el ultraje de los años en una música, un rumor y un símbolo, ver en la muerte el sueño, en el ocaso un triste oro, tal es la poesía que es inmortal y pobre. La poesía vuelve como la aurora y el ocaso. A veces en las tardes una cara nos mira desde el fondo de un espejo; el arte debe ser como ese espejo que nos revela nuestra propia cara. Cuentan que Ulises, harto de prodigios, lloró de amor al divisar su Ítaca verde y humilde. El arte es esa Ítaca de verde eternidad, no de prodigios. También es como el río interminable que pasa y queda y es cristal de un mismo Heráclito inconstante, que es el mismo y es otro, como el río interminable. Tomado de: García Maffla, Jaime. Antología de poesía colombiana e hispanoamericana. Jorge Luis Borges. Bogotá, Colombia: Editorial Panamericana. pp. 240-241.",

                listOf(
                    "río, sueño, eternidad.",
                    "años, prodigios, cristal.",
                    "agua, música, humildad.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De acuerdo con la forma como están construidos los versos de las tres primeras estrofas, el poeta reafirma el sentido del arte poético usando",

                "ARTE POÉTICA Mirar el río hecho de tiempo y agua y recordar que el tiempo es otro río, saber que nos perdemos como el río y que los rostros pasan como el agua. Sentir que la vigilia es otro sueño que sueña no soñar y que la muerte que teme nuestra carne es esa muerte de cada noche, que se llama sueño. Ver en el día o en el año un símbolo de los días del hombre y de sus años, convertir el ultraje de los años en una música, un rumor y un símbolo, ver en la muerte el sueño, en el ocaso un triste oro, tal es la poesía que es inmortal y pobre. La poesía vuelve como la aurora y el ocaso. A veces en las tardes una cara nos mira desde el fondo de un espejo; el arte debe ser como ese espejo que nos revela nuestra propia cara. Cuentan que Ulises, harto de prodigios, lloró de amor al divisar su Ítaca verde y humilde. El arte es esa Ítaca de verde eternidad, no de prodigios. También es como el río interminable que pasa y queda y es cristal de un mismo Heráclito inconstante, que es el mismo y es otro, como el río interminable. Tomado de: García Maffla, Jaime. Antología de poesía colombiana e hispanoamericana. Jorge Luis Borges. Bogotá, Colombia: Editorial Panamericana. pp. 240-241.",

                listOf(
                    "adverbios de tiempo, porque señalan la duración de cada obra de arte.",
                    "sustantivos propios, porque definen claramente qué es el arte poético.",
                    "Que es una institución que tiene únicamente propósitos económicos y políticos.",
                ),
                1
            )
        )
        questionList.add(
            Question(
                "En el poema, el autor aborda principalmente el tema de la",

                "ARTE POÉTICA Mirar el río hecho de tiempo y agua y recordar que el tiempo es otro río, saber que nos perdemos como el río y que los rostros pasan como el agua. Sentir que la vigilia es otro sueño que sueña no soñar y que la muerte que teme nuestra carne es esa muerte de cada noche, que se llama sueño. Ver en el día o en el año un símbolo de los días del hombre y de sus años, convertir el ultraje de los años en una música, un rumor y un símbolo, ver en la muerte el sueño, en el ocaso un triste oro, tal es la poesía que es inmortal y pobre. La poesía vuelve como la aurora y el ocaso. A veces en las tardes una cara nos mira desde el fondo de un espejo; el arte debe ser como ese espejo que nos revela nuestra propia cara. Cuentan que Ulises, harto de prodigios, lloró de amor al divisar su Ítaca verde y humilde. El arte es esa Ítaca de verde eternidad, no de prodigios. También es como el río interminable que pasa y queda y es cristal de un mismo Heráclito inconstante, que es el mismo y es otro, como el río interminable. Tomado de: García Maffla, Jaime. Antología de poesía colombiana e hispanoamericana. Jorge Luis Borges. Bogotá, Colombia: Editorial Panamericana. pp. 240-241.",

                listOf(
                    "creación artística.",
                    "inmortalidad del sueño.",
                    "fugacidad del tiempo.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "De las siguientes ideas, la que se opone a la idea central defendida por el autor es:",

                "EN CONTRA (Y A FAVOR) DE LAS CORRIDAS Por: Héctor Abad Faciolince Estoy en contra de las corridas de toros, pero también en contra de su prohibición. Si uno acepta que una mayoría puede prohibir los toros por compasión animal, tendrá que aceptar que un día otra mayoría prohíba a todos los ciudadanos matar animales para comer carne. La tolerancia consiste en no prohibir lo que no nos gusta. Tolero las peleas de boxeo o la prostitución: no me gustan, pero tampoco las prohibiría. El argumento más fuerte de los antitaurinos es que en las corridas se tortura a muerte a un animal. No pongo en duda que el animal sufre horriblemente. Pongo en duda la consciencia plena de ese dolor, porque no sabemos cómo funciona la mente animal. Es una hipocresía discurrir contra las corridas de toros por la mañana y al mediodía comerse un sanguinolento filete de res. Me dirán: ese lomito no se lo obtuvo con tortura. ¿Cómo saben? Los criamos para montarlos o para comerlos. Olvidar esto es hipocresía. No voy a corridas. Me parecen un espectáculo primitivo. Quizás en eso consiste su encanto y su horror. Pero soy carnívoro. No veo que haya acuerdo entre las personas sensatas y morales sobre si las corridas deban prohibirse o no.",

                listOf(
                    "Las corridas de toros deben prohibirse. ",
                    "La tolerancia es el medio para superar el desacuerdo.",
                    "Las fiestas taurinas son rituales de tortura.",
                ),
                0
            )
        )
        questionList.add(
            Question(
                "La afirmación “La era de la mencionada sociedad de la información es también la de la producción de estados mentales” es",

                "EL CONSUMIDOR DEL “AJUSTE” Luis Enrique Alonso, autor español reconocido por sus estudios sociológicos sobre el nuevo consumidor, afirma que los consumidores del cambio del milenio superaron la llamada cultura light posmoderna y que hoy estamos frente al consumidor del ajuste; uno con fuerte tendencia a la personalización de las referencias y la individualización de los argumentos en las presentaciones de la identidad en la vida cotidiana. Dice, además, que la cultura de masas se ha vuelto más selectiva y el consumo se convierte en testigo de la afirmación de la personalidad, siguiendo pautas no tanto de adhesión a macrogrupos abstractos e indiferenciados, como a círculos, relatos y símbolos fuertemente particularistas. Ese nuevo consumidor socializado exige y escoge con mayor libertad e inteligencia, es una mezcla de convicción, impulso de compra y reflexión; su compra está determinada por las percepciones, las representaciones y los valores que conforman su estilo de vida, su ámbito privado y este en razón de su pertenencia a un grupo que legitima su actuar. Bien decía Mattelart que “la era de la mencionada sociedad de la información es también la de la producción de estados mentales”. Y es que este consumidor, compra y consume de acuerdo con su estado mental. Por eso, cada día con más fuerza, es necesario alcanzar a este consumidor en su cotidianidad y sorprenderlo no solo con la fuerza del mensaje sino con la novedad del medio: altas dosis de sorpresa y sentido de oportunidad. Lo ingenioso son los nuevos canales, las formas de entrometerse en su cotidianidad, generando percepciones favorables, amigables, positivas. Hoy la producción de “estados mentales” es garantía de posicionamiento, de recordación, de percepciones acordes al producto y la marca; porque en definitiva las personas no actúan por lo que oyen, sino por lo que “ven” en su imaginación cuando oyen, como lo dice Santiago Rodríguez, “la palabra mar no ahoga a nadie. El concepto que lleva dentro, sí”.",

                listOf(
                    "una conclusión a la que llega la autora del texto después de reconocer que hay un nuevo tipo de consumidor.",
                    "una idea que se supone verdadera así no se planteen evidencias para comprobarla.",
                    "un argumento sustentado desde el concepto de sociedad de la información asumido en el texto.",
                ),
                1
            )
        )

    }
}

