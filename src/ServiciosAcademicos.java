public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteInscrito;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscrito;
}
