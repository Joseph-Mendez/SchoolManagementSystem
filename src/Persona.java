public class Persona {
    protected int id;
    protected String Nombre;
    protected String Apellido;
    protected String FechaNacimiento;

    public Persona(int id, String nombre, String apellido,String fechaNacimiento){
        this.id = id;
        this.Nombre = nombre;
        this.Apellido =  apellido;
        this.FechaNacimiento = fechaNacimiento;

    }
}
