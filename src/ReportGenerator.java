import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    Map<Integer, List<MonthlyStat>> monthlyStatMap = new HashMap<>();
    Map<Integer, YearlyStat> yearlyStatMap = new HashMap<>();

    public void countAllMonthlyReports() {
        MonthlyReport monthlyReport = new MonthlyReport();
        monthlyReport.parsingReport(monthlyStatMap);
    }

    public void countAnnualReport() {
        YearlyReport yearlyReport = new YearlyReport();
        yearlyReport.parsingYear(yearlyStatMap);
    }

    public void checkReports() {
        if (!(monthlyStatMap.isEmpty() || yearlyStatMap.isEmpty())) {
            int i = 1;
            List<String> errors = new ArrayList<>();
            for (List<MonthlyStat> list : monthlyStatMap.values()) {
                double profit = 0d;
                double expenses = 0d;
                for (MonthlyStat monthlyStat : list) {
                    double sum = monthlyStat.quantity * monthlyStat.sumOfOne;
                    if (monthlyStat.isExpense) {
                        expenses += sum;
                    } else {
                        profit += sum;
                    }
                }
                YearlyStat yearlyStat = yearlyStatMap.get(i);
                if (!(yearlyStat.profit == profit) || !(yearlyStat.expenses == expenses)) {
                    errors.add(yearlyStat.nameMonthly);
                }
                i++;
            }
            if (errors.isEmpty()) {
                System.out.println("Сверка верна");
            } else {
                for (String s : errors) {
                    System.out.println("Ошибка в месяце: " + s.toLowerCase());
                }
            }
        } else {
            if (monthlyStatMap.isEmpty() && yearlyStatMap.isEmpty()) {
                System.out.println("Сверка не возможна потому годовой и месячный отчёт не заполнены");
            } else if (monthlyStatMap.isEmpty()) {
                System.out.println("Сверка не возможна потому что месячные отчёты не заполнены");
            } else {
                System.out.println("Сверка не возможна потому что годовой отчёт не заполнен");
            }


        }
    }

    public void printAllInfoMonthlyReports() {
        if (monthlyStatMap.isEmpty()) {
            System.out.println("Отчёты не загружен");
        } else {
            MonthlyReport monthlyReport = new MonthlyReport();
            monthlyReport.printReport(monthlyStatMap);
        }
    }

    public void printInfoYearReports() {
        if (yearlyStatMap.isEmpty()) {
            System.out.println("Отчёты не загружены");
        } else {
            YearlyReport yearlyReport = new YearlyReport();
            yearlyReport.printYearlyReport(yearlyStatMap, yearlyStatMap.size());
        }
    }
}
