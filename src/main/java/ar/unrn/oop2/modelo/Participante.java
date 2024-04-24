package ar.unrn.oop2.modelo;

public class Participante {
    private String nombre;
    private String apellido;
    private String dni;
    private Email email;
    private Telefono telefono;

    public Participante(String nombre, String apellido, String dni, Email email, Telefono telefono) {
        if (validarDato(nombre)){
            throw new RuntimeException("Nombre no puede ser vacio");}
        if (validarDato(apellido)){
            throw new RuntimeException("Apellido no puede ser vacio");}
        if (validarDato(dni)){
            throw new RuntimeException("Dni no puede ser vacio");}

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    private boolean validarDato(String dato){
        return dato.isEmpty();
    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String dni() {
        return dni;
    }

    public Email email() {
        return email;
    }

    public Telefono telefono() {
        return telefono;
    }
}
