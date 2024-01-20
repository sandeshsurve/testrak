// EmployeeServiceImpl.java
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
    
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    @Override
    public Optional<Employee> updateEmployee(Long employeeId, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setEmail(employeeDetails.getEmail());
            return Optional.of(employeeRepository.save(employee));
        } else {
            return Optional.empty();
        }
    }
    
    @Override
    public boolean deleteEmployee(Long employeeId) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        } else {
            return false;
        }
    }
}