import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ReportGenerator reportGenerator = new ReportGenerator();
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equals("0")) {
            System.out.println("Программа завершена");
        }
        while (!input.equals("0")) {
            switch (input) {
                case "1": {
                    reportGenerator.countAllMonthlyReports();
                    System.out.println("Месячные отчёты загружены");
                }
                break;
                case "2": {
                    reportGenerator.countAnnualReport();
                    System.out.println("Годовой отчёт загружен");
                }
                break;
                case "3":
                    reportGenerator.checkReports();
                    break;
                case "4":
                    reportGenerator.printAllInfoMonthlyReports();
                    break;
                case "5":
                    reportGenerator.printInfoYearReports();
                    break;
                default:
                    System.out.println("Нет команды: " + input);
            }
            printMenu();
            input = scanner.next();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите цифру команды, которую хотите запустить");
        System.out.println("1 : Считать все месячные отчёты\n" +
                "2 : Считать годовой отчёт\n" +
                "3 : Сверить отчёты\n" +
                "4 : Вывести информацию о всех месячных отчётах\n" +
                "5 : Вывести информацию о годовом отчёте\n");
    }
}

