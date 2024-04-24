package ar.unrn.oop2;

import ar.unrn.oop2.modelo.Concurso;
import ar.unrn.oop2.modelo.RegistroDeInscripcion;
import ar.unrn.oop2.persistencia.Disco;
import ar.unrn.oop2.ui.UserInterface;

import javax.swing.SwingUtilities;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        RegistroDeInscripcion registro = new Disco();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start(registro);
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }
    private void start(RegistroDeInscripcion registro) {
        new UserInterface(registro);
    }
}