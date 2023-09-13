/**
 * Clase Course
 * Fernando Rueda - 23748
 * Descripción: Representa un curso en el sistema.
 * Fecha de creación: [08/09/2023]
 * Fecha de última modificación: [12/09/2023]
 */
public class Course {
    private String code;
    private String name;
    private int periods;
    private String[] days;
    private String time;
    private int studentCount;
    private Teacher teacher;

       /**
     * Constructor para inicializar un curso.
     *
     * @param code Código del curso.
     * @param name Nombre del curso.
     * @param periods Cantidad de períodos.
     * @param days Días en que se imparte el curso.
     * @param time Horario del curso.
     * @param studentCount Cantidad de estudiantes inscritos.
     * @param teacher Profesor que imparte el curso.
     */

    public Course(String code, String name, int periods, String[] days, String time, int studentCount, Teacher teacher) {
        this.code = code;
        this.name = name;
        this.periods = periods;
        this.days = days;
        this.time = time;
        this.studentCount = studentCount;
        this.teacher = teacher;
    }

    /**
     * Muestra la información del curso.
     */
    public void displayCourseInfo() {
        System.out.println("Código: " + code);
        System.out.println("Nombre: " + name);
        System.out.println("Días: " + String.join(", ", days));
        System.out.println("Horario: " + time);
        System.out.println("Estudiantes: " + studentCount);
        teacher.displayTeacherInfo();
    }

    public int getStudentCount() {
        return studentCount;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public int getPeriods() {
        return periods;
    }
    
}
