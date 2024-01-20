// EmployeeController.java
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        if (employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, 
                                                   @Valid @RequestBody Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeService.updateEmployee(employeeId, employeeDetails);
        if (optionalEmployee.isPresent()) {
            return ResponseEntity.ok(optionalEmployee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        boolean deleted = employeeService.deleteEmployee(employeeId);
        if (deleted) {
            return "Employee deleted successfully.";
        } else {
            return "Employee not found or could not be deleted.";
        }
    }
}