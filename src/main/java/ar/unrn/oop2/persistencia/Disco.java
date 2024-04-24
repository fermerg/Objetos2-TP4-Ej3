package ar.unrn.oop2.persistencia;

import ar.unrn.oop2.modelo.Concurso;
import ar.unrn.oop2.modelo.Participante;
import ar.unrn.oop2.modelo.RegistroDeInscripcion;

import java.awt.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Disco implements RegistroDeInscripcion {

    private String pathConcursos;
    private String pathInscriptos;

    public Disco() {
        this.pathConcursos = "C:\\Users\\fm\\Desktop\\concursos.txt";
        this.pathInscriptos = "C:\\Users\\fm\\Desktop\\inscriptos.txt";
    }

    public List<Concurso> getConcursos() throws IOException {
        List<String> fileData = Files.readAllLines(Paths.get(pathConcursos));
        fileData.remove(0);
        ArrayList<Concurso> listaConcursos = new ArrayList<>();

        for (String s : fileData) {
            String[] camposFila = s.split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            listaConcursos.add(new Concurso(Integer.parseInt(camposFila[0]), camposFila[1],
                    LocalDate.parse(camposFila[2], formatter), LocalDate.parse(camposFila[3], formatter)));
        }
        return listaConcursos;

    }

    public boolean inscribirAEn(Participante concursante, Concurso concurso) throws IOException {
        FileWriter escritorArchivo = new FileWriter(pathInscriptos);
        escritorArchivo.write(concursante.apellido() + "," + concursante.nombre() + ","
                + concursante.telefono().telefono() + "," + concursante.email().email() + "," + concurso.id());
        escritorArchivo.close();
        return true;
    }

   /* private File fileConcursos;
    private Path pathInscriptos;

    public Disco() {
        this.fileConcursos = new File("C:\\Users\\fm\\Desktop\\concursos.txt");
        this.pathInscriptos = Paths.get("C:\\Users\\fm\\Desktop\\inscriptos.txt");
    }

    public List<Concurso> getConcursos() {
        List<Concurso> concursos= new ArrayList<>() ;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileConcursos));
            for (String concurso : reader.lines().toList()){
                String [] camposFila = concurso.split(", ");
                Concurso con = new Concurso(Integer.parseInt(camposFila[0]), camposFila[1],
                        LocalDate.parse(camposFila[2]), LocalDate.parse(camposFila[3]));
                concursos.add(con);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error de recuperacion del archivo", e);
        }
        return concursos;
    }

    @Override
    public void inscribirAEn(Participante participante, Concurso concurso) {

        try (BufferedWriter writer = Files.newBufferedWriter(pathInscriptos)) {
                writer.write(participante.nombre() + participante.apellido()
                        + participante.email().getEmail() + participante.telefono().getTelefono() +concurso.id());
                writer.newLine();
        } catch (Exception e) {
            throw new RuntimeException("Error de lectura en disco");
        }

    } */
}
