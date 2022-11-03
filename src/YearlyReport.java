import java.util.HashMap;
import java.util.Map;

public class YearlyReport {
    public Map<Integer, YearlyStat> parsingYear(Map<Integer, YearlyStat> yearlyStatMap) {
        String path = "resources\\y.2021.csv";
        String content = Utils.readFileContentsOrNull(path); //считывание файлов
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {//пропускаем первую строку. т.к. это название
            String[] parts = lines[i].split(","); //String line = lines[i]; String[] parts = line.split(","); разбил строку по запятой
            int month = Integer.parseInt(parts[0]);
            double amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearlyStat yearlyStat = yearlyStatMap.get(month);
            if (yearlyStat == null) {
                yearlyStat = new YearlyStat();
            }
            if (isExpense) {
                yearlyStat.expenses = amount;
            } else {
                yearlyStat.profit = amount;
            }
            yearlyStat.nameMonthly = MonthlyReport.parsingMonthly(month);

            yearlyStatMap.put(month, yearlyStat);
        }
        return yearlyStatMap;
    }

    public void printYearlyReport(Map<Integer, YearlyStat> yearlyStatMap, double countMonthly) {
        double profit = 0.0;
        double expenses = 0.0;
        YearlyReportOverride yearlyM = new YearlyReportOverride();
        HashMap<String, Double> map = new HashMap<>();
        for (YearlyStat yearlyStat : yearlyStatMap.values()) {
            profit += yearlyStat.profit;
            expenses += yearlyStat.expenses;
            map.put(yearlyStat.nameMonthly, yearlyStat.profit - expenses);
        }
        yearlyM.avgProfit = profit / countMonthly;
        System.out.println(profit / countMonthly);
        yearlyM.avgSpending = expenses / countMonthly;
        yearlyM.numberMonthly = 2021;
        yearlyM.list = map;
        System.out.println(yearlyM);
    }
}
