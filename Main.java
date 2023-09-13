/**
 * Clase Main
 * Fernando Rueda - 23748
 * Descripción: Punto de inicio del programa
 * Fecha de creación: [08/09/2023]
 * Fecha de última modificación: [12/09/2023]
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Classroom classroom = new Classroom(36); 

        /**
         * Bucle principal para mostrar el menú y capturar la selección del usuario.
         */
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar curso");
            System.out.println("2. Ver curso en horario específico");
            System.out.println("3. Eliminar curso");
            System.out.println("4. Ver profesor en horario específico");
            System.out.println("5. Ver horario de un profesor");
            System.out.println("6. Ver responsabilidad de un profesor");
            System.out.println("7. Resetear horario para nuevo semestre");
            System.out.println("8. Salir");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.println("Ingrese el código del curso:");
                    String code = scanner.nextLine();
                    System.out.println("Ingrese el nombre del curso:");
                    String name = scanner.nextLine();
                    System.out.println("Ingrese la cantidad de períodos:");
                    int periods = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese los días (separados por comas):");
                    String[] days = scanner.nextLine().split(",");
                    System.out.println("Ingrese el horario (ejemplo: 8:00 am):");
                    String time = scanner.nextLine();
                    System.out.println("Ingrese la cantidad de estudiantes:");
                    int studentCount = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre completo del profesor:");
                    String fullName = scanner.nextLine();
                    System.out.println("Ingrese el carné del profesor:");
                    String idCard = scanner.nextLine();
                    System.out.println("Ingrese el correo electrónico del profesor:");
                    String email = scanner.nextLine();
                    System.out.println("Ingrese el teléfono del profesor:");
                    String phoneNumber = scanner.nextLine();
                
                    Teacher newTeacher = new Teacher(fullName, idCard, email, phoneNumber);
                    Course course = new Course(code, name, periods, days, time, studentCount, newTeacher);
                    classroom.assignCourse(course, days[0], time); 
                    break;
                
            
                case 2:
                    System.out.println("Ingrese el día:");
                    String day = scanner.nextLine();
                    System.out.println("Ingrese el horario:");
                    time = scanner.nextLine();
                    classroom.viewCourseInfo(day, time);
                    break;
                case 3:
                    System.out.println("Ingrese el día y hora para eliminar el curso (ejemplo: Lunes-8:00 am):");
                    String key = scanner.nextLine();
                    classroom.removeCourse(key.split("-")[0], key.split("-")[1]);
                    break;
                case 4:
                    System.out.println("Ingrese el día y hora para ver el profesor encargado:");
                    key = scanner.nextLine();
                    Teacher teacher = classroom.getTeacherForTime(key.split("-")[0], key.split("-")[1]);
                    if (teacher != null) {
                    teacher.displayTeacherInfo();
                }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del profesor para ver su horario:");
                    String teacherName = scanner.nextLine();
                    classroom.displayTeacherSchedule(teacherName);
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del profesor para ver su responsabilidad:");
                    teacherName = scanner.nextLine();
                    double percentage = classroom.teacherResponsibilityPercentage(teacherName);
                    System.out.println("El profesor " + teacherName + " está al frente del laboratorio el " + percentage + "% del tiempo.");
                    break;
                case 7:
                    classroom.resetForNewSemester();
                    System.out.println("Laboratorio disponible para el nuevo semestre.");
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

