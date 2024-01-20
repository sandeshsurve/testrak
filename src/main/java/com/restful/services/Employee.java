// Employee.java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;
    
    @Email
    private String email;
    
    // Constructors, getters, and setters
}