import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicos{

    private ArrayList<Estudiante>estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Integer>> estudiantesPorCurso;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.estudiantesPorCurso = new HashMap<>();
    }
    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteInscrito {
        if (!estudiantes.contains(estudiante)) {
            throw new IllegalArgumentException("El estudiante no esta matriculado.");
        }

        if (estudiantesPorCurso.containsKey(idCurso) && estudiantesPorCurso.get(idCurso).contains(estudiante.id)) {
            throw new EstudianteInscrito("El estudiante esta inscrito en el curso.");
        }

        if (!estudiantesPorCurso.containsKey(idCurso)) {
            estudiantesPorCurso.put(idCurso, new ArrayList<>());
        }
        estudiantesPorCurso.get(idCurso).add(estudiante.id);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscrito {
        if (!estudiantesPorCurso.containsKey(idCurso) || !estudiantesPorCurso.get(idCurso).contains(idEstudiante)) {
            throw new EstudianteNoInscrito("El estudiante aun no está inscrito en el curso o el ID del curso no es valido.");
        }

        estudiantesPorCurso.get(idCurso).remove(Integer.valueOf(idEstudiante));
    }

    // Método para imprimir estudiantes
    public void imprimirEstudiantes() {
        System.out.println("Los estudiantes inscritos son: ");
        for (Estudiante estudiante : estudiantes) {
            System.out.println("- " + estudiante.getNombre()); // Accede al nombre usando getNombre()
        }
    }

    // Método para imprimir cursos
    public void imprimirCursos() {
        System.out.println("Los cursos que estan disponibles son: ");
        for (Curso curso : cursos) {
            System.out.println("- " + curso.getNombre());
        }
    }

    public void imprimirEstudiantesPorCurso() {
        for (Curso curso : cursos) {
            System.out.println("Curso " + curso.getNombre() + ":");
            ArrayList<Integer> estudiantesID = estudiantesPorCurso.get(curso.getId());
            if (estudiantesID != null) {
                for (Integer estudianteId : estudiantesID) {
                    for (Estudiante estudiante : estudiantes) {
                        if (estudiante.id == estudianteId) {
                            System.out.println("- " + estudiante.getNombre());
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
