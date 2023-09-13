/**
 * Clase Teacher
 * Fernando Rueda - 23748
 * Descripción: Representa un profesor en el sistema.
 * Fecha de creación: [08/09/2023]
 * Fecha de última modificación: [12/09/2023]
 */
public class Teacher {
    private String fullName;
    private String idCard;
    private String email;
    private String phoneNumber;

    /**
     * Constructor para inicializar un profesor.
     *
     * @param fullName Nombre completo del profesor.
     * @param idCard Carné del profesor.
     * @param email Correo electrónico del profesor.
     * @param phoneNumber Teléfono del profesor.
     */
    public Teacher(String fullName, String idCard, String email, String phoneNumber) {
        this.fullName = fullName;
        this.idCard = idCard;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Muestra la información del profesor.
     */
    public void displayTeacherInfo() {
        System.out.println("Nombre: " + fullName);
        System.out.println("Carné: " + idCard);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + phoneNumber);
    }
    
    /**
     * Obtiene el nombre completo del profesor.
     *
     * @return Nombre completo del profesor.
     */
    public String getFullName() {
    return fullName;
    }

}
