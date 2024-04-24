package ar.unrn.oop2.modelo;

public class Email {
    private String email;

    public Email(String email) {
        if(validarEmail(email)){
            throw new RuntimeException("Email no puede ser vacio");
        }
        if(checkEmail(email)){
            throw new RuntimeException("email debe ser válido");
        }
        this.email = email;
    }

    private boolean validarEmail(String email){
        return email.isEmpty();
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public String email() {
        return email;
    }
}
