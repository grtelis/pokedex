

package pokedex

class Pokemon {

    Entrenador entrenador
    int id
    String nombre
    String descripcion
    String categoria
    String habilidad
    String tipo
    String debilidad

    static constraints = {

        id(unique: true, nullable: false, blank: false)
        nombre(nullable: false, blank: false)
        descripcion(nullable: false, blank: false)
        categoria(nullable: false, blank: false)
        habilidad(nullable: false, blank: false)
        tipo inList: ["Veneno", "Planta", "Fuego", "Agua", "Eléctrico"]
        debilidad inList: ["Fuego", "Psíquico", "Volador", "Hielo", "Agua", "Tierra", "Roca", "Planta", "Eléctrico"]

    }

    static mapping = {

        table 'pokemon'
        nombre column: 'nombre'
        descripcion column: 'descripcion'
        categoria column: 'categoria'
        habilidad column: 'habilidad'
        tipo column: 'tipo'
        debilidad column: 'debilidad'
        entrenador column: 'idEntrenador'
    }
}