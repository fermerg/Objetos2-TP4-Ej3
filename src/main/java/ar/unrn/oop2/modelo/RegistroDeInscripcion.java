package ar.unrn.oop2.modelo;

import java.io.IOException;
import java.util.List;

public interface RegistroDeInscripcion {
    public List<Concurso> getConcursos() throws IOException;
    public boolean inscribirAEn(Participante participante, Concurso concurso) throws IOException;
}
