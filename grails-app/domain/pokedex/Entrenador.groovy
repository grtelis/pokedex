package pokedex

class Entrenador {

    int id
    String nombre
    String apellido
    String descripcion
    String tipoEntrenador
    String claseEntrenador
    Date fechaNacimiento

    static constraints = {

        id(unique: true, nulleable: false, blank: false)
        nombre(nullable: false, blank: false)
        apellido(nullable: false, blank: false)
        descripcion(nullable: false, blank: false)
        tipoEntrenador inList: ["Líder de gimnasio", "Alto mando", "Campeón de liga pokémon", "As del frente batalla"]
        claseEntrenador inList: ["Clase principal", "Clase secundaria"]
        fechaNacimiento(nullable: false, blank: false)
    }

    static mapping = {

        table "entrenador"
        id column: 'id'
        nombre column: 'nombre'
        apellido column: 'apellido'
        descripcion column: 'descripcion'
        tipoEntrenador column: 'tipoEntrenador'
        claseEntrenador column: 'claseEntrenador'
        fechaNacimiento column: 'fechaNacimiento'
    }

    String toString() {

        "${nombre + " " + apellido}"
    }
}
