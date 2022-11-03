import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonthlyReport {

    public Map<Integer, List<MonthlyStat>> parsingReport(Map<Integer, List<MonthlyStat>> map) {
        for (int j = 1; j < 4; j++) {
            List<MonthlyStat> list = new ArrayList<>();
            String path = "resources\\m.20210" + j + ".csv";
            String content = Utils.readFileContentsOrNull(path);
            String[] lines = content.split("\n");
            for (int i = 1; i < lines.length; i++) {
                String[] parts = lines[i].split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                double sumOfOne = Double.parseDouble(parts[3]);
                MonthlyStat monthlyStat = new MonthlyStat(itemName, isExpense, quantity, sumOfOne);
                list.add(monthlyStat);
            }
            map.put(j, list);
        }
        return map;
    }

    public void printReport(Map<Integer, List<MonthlyStat>> map) {
        List<ReportMonthlyOverride> reportMList = new ArrayList<>();
        for (int i = 1; i < map.values().size() + 1; i++) {
            List<MonthlyStat> monthlyStats = map.get(i);
            ReportMonthlyOverride reportM = new ReportMonthlyOverride();
            reportM.nameMonthly = parsingMonthly(i);
            for (MonthlyStat monthlyStat : monthlyStats) {
                if (!monthlyStat.isExpense) {
                    double profit = monthlyStat.quantity * monthlyStat.sumOfOne;
                    if (profit > reportM.priceProfitableCommodity) {
                        reportM.priceProfitableCommodity = profit;
                        reportM.nameProfitableCommodity = monthlyStat.name;
                    }
                } else {
                    double spending = monthlyStat.quantity * monthlyStat.sumOfOne;
                    if (spending > reportM.priceMaxSpending) {
                        reportM.priceMaxSpending = spending;
                        reportM.nameMaxSpending = monthlyStat.name;
                    }
                }
            }
            reportMList.add(reportM);
        }
        reportMList.forEach(System.out::println);
    }

    public static String parsingMonthly(int i) {
        String monthly;
        switch (i) {
            case 1:
                monthly = "Январь";
                break;
            case 2:
                monthly = "Февраль";
                break;
            case 3:
                monthly = "Март";
                break;
            default:
                monthly = "Нет такого месяца";
        }
        return monthly;
    }
}
