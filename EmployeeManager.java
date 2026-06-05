import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {

    private ArrayList<Employee> employees = new ArrayList<>();
    private final String FILE_NAME = "employees.txt";

    public EmployeeManager() {
        loadEmployees();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showEmployees() {

        if (employees.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void deleteEmployee(int id) {

        employees.removeIf(employee ->
                employee.getId() == id);
    }

    public void findEmployee(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }

        System.out.println("Сотрудник не найден");
    }

    public void saveEmployees() {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Employee employee : employees) {

                writer.println(
                        employee.getId() + "," +
                                employee.getName() + "," +
                                employee.getPosition() + "," +
                                employee.getSalary()
                );
            }

        } catch (IOException e) {
            System.out.println("Ошибка сохранения");
        }
    }

    public void loadEmployees() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                employees.add(
                        new Employee(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                Double.parseDouble(data[3])
                        )
                );
            }

        } catch (IOException e) {
            System.out.println("Ошибка загрузки");
        }
    }
}