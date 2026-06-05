import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Показать сотрудников");
            System.out.println("3. Найти сотрудника");
            System.out.println("4. Удалить сотрудника");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Имя: ");
                    String name = scanner.nextLine();

                    System.out.print("Должность: ");
                    String position = scanner.nextLine();

                    System.out.print("Зарплата: ");
                    double salary = scanner.nextDouble();

                    manager.addEmployee(
                            new Employee(
                                    id,
                                    name,
                                    position,
                                    salary
                            )
                    );

                    System.out.println("Сотрудник добавлен");
                    break;

                case 2:

                    manager.showEmployees();
                    break;

                case 3:

                    System.out.print("Введите ID: ");
                    int searchId = scanner.nextInt();

                    manager.findEmployee(searchId);
                    break;

                case 4:

                    System.out.print("Введите ID: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteEmployee(deleteId);

                    System.out.println("Сотрудник удалён");
                    break;

                case 5:

                    manager.saveEmployees();

                    System.out.println("Данные сохранены");
                    return;

                default:

                    System.out.println("Неверный выбор");
            }
        }
    }
}