/**
 * Clase Classroom
 * Fernando Rueda - 23748
 * Descripción: Representa el laboratorio de computación avanzada CIT 411.
 * Fecha de creación: [08/09/2023]
 * Fecha de última modificación: [12/09/2023]
 */
import java.util.HashMap;
import java.util.Map;


public class Classroom {
    private int capacity;
    private Map<String, Course> schedule = new HashMap<>();

    /**
     * Constructor para inicializar el laboratorio con una capacidad dada.
     *
     * @param capacity Capacidad del laboratorio.
     */   
    public Classroom(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Asigna un curso al horario del laboratorio.
     *
     * @param course Curso a asignar.
     * @param day Día en que se imparte el curso.
     * @param time Horario en que se imparte el curso.
     */
    public void assignCourse(Course course, String day, String time) {
        String key = day + "-" + time;
        if (!schedule.containsKey(key)) {
            if (course.getStudentCount() <= capacity) {
                schedule.put(key, course);
            } else {
                System.out.println("Error: La cantidad de estudiantes excede la capacidad del aula.");
            }
        } else {
            System.out.println("Error: Ya hay un curso asignado en ese horario.");
        }
    }

    public void removeCourse(String day, String time) {
        String key = day + "-" + time;
        if (schedule.containsKey(key)) {
            schedule.remove(key);
        } else {
            System.out.println("Error: No hay un curso asignado en ese horario.");
        }
    }

    public void viewCourseInfo(String day, String time) {
        String key = day + "-" + time;
        if (schedule.containsKey(key)) {
            Course course = schedule.get(key);
            course.displayCourseInfo();
        } else {
            System.out.println("Error: No hay un curso asignado en ese horario.");
        }
    }

    /**
     * Resetea el horario del laboratorio para un nuevo semestre.
     */
    public void resetForNewSemester() {
        schedule.clear();
    }

    public Teacher getTeacherForTime(String day, String time) {
        String key = day + "-" + time;
        if (schedule.containsKey(key)) {
            return schedule.get(key).getTeacher();
        } else {
            System.out.println("Error: No hay un curso asignado en ese horario.");
            return null;
        }
    }

    public void displayTeacherSchedule(String teacherName) {
        boolean found = false;
        for (Map.Entry<String, Course> entry : schedule.entrySet()) {
            Course course = entry.getValue();
            if (course.getTeacher().getFullName().equals(teacherName)) {
                found = true;
                System.out.println("Día y hora: " + entry.getKey());
                course.displayCourseInfo();
            }
        }
        if (!found) {
            System.out.println("El profesor no tiene cursos asignados.");
        }
    }

    public int countTeacherOccurrences(String teacherName) {
        int count = 0;
        for (Course course : schedule.values()) {
            if (course.getTeacher().getFullName().equals(teacherName)) {
                count++;
            }
        }
        return count;
    }

    public double teacherResponsibilityPercentage(String teacherName) {
        int totalSlots = 14 * 5; // 7am-9pm = 14 horas, 5 días a la semana
        int teacherSlots = countTeacherOccurrences(teacherName);
        return (double) teacherSlots / totalSlots * 100;
    }
}

