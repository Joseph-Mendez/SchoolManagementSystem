public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        Estudiante student1 = new Estudiante(1, "Joseph", "Mendez", "2010-05-03", "Matriculado");
        Estudiante student2 = new Estudiante(2, "Jorge", "Vital", "2015-10-12", "Matriculado");
        Estudiante student3 = new Estudiante(3, "Lourdes", "Estrada", "2017-01-02", "Matriculado");
        Estudiante student4 = new Estudiante(4, "Danny", "Garcia", "2011-05-15", "Matriculado");

        gestor.matricularEstudiante(student1);
        gestor.matricularEstudiante(student2);
        gestor.matricularEstudiante(student3);
        gestor.matricularEstudiante(student4);


        Curso curso1 = new Curso(1, "Programación en C#", "Curso basico de C#", 4, "1.0");
        Curso curso2 = new Curso(2, "Curso de CSS y HTML", "Introduccion de CSS y HTML", 4, "1.0");
        Curso curso3 = new Curso(3, "Inteligencia Artificial", "Introducción en IA", 5, "1.0");


        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);
        gestor.agregarCurso(curso3);

        try {
            gestor.inscribirEstudianteCurso(student1, curso1.getId());
            gestor.inscribirEstudianteCurso(student1, curso2.getId());
            gestor.inscribirEstudianteCurso(student2, curso1.getId());
            gestor.inscribirEstudianteCurso(student3, curso3.getId());
            gestor.inscribirEstudianteCurso(student4, curso2.getId());
            gestor.inscribirEstudianteCurso(student3, curso3.getId());

        } catch (EstudianteInscrito e) {
            System.out.println(e.getMessage());
        }

        gestor.imprimirEstudiantes();

        gestor.imprimirCursos();

        gestor.imprimirEstudiantesPorCurso();

        try {
            gestor.desinscribirEstudianteCurso(student1.id, curso1.getId());
        } catch (EstudianteNoInscrito e) {
            System.out.println(e.getMessage());
        }
    }
}