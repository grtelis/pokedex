package pokedex

class Pokemones {

    Entrenadores entrenadores
    int id
    String nombre
    String numero
    String descripcion
    String categoria
    String altura
    String peso
    String habilidad
    String tipo
    String debilidad

    static constraints = {

        id(unique: true, nullable: false, blank: false)
        nombre(nullable: false, blank: false)
        numero(nullable: false, blank: false)
        descripcion(nullable: false, blank: false)
        categoria(nullable: false, blank: false)
        altura(nullable: false, blank: false)
        peso(nullable: false, blank: false)
        habilidad(nullable: false, blank: false)
        tipo inList: ["Veneno", "Planta", "Fuego", "Agua"]
        debilidad inList: ["FUego", "Psíquico", "Volador", "Hielo", "Agua", "Tierra", "Roca", "Planta", "Eléctrico"]

    }

    static mapping = {

        table 'pokemon'
        nombre column: 'nombre'
        numero column: 'numero'
        descripcion column: 'descripcion'
        categoria column: 'categoria'
        altura column: 'altura'
        peso column: 'peso'
        habilidad column: 'habilidad'
        tipo column: 'tipo'
        debilidad column: 'debilidad'
        entrenadores column: 'idEntrenadores'
    }
}
