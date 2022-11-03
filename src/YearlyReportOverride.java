import java.util.HashMap;
import java.util.Map;

public class YearlyReportOverride {
    public int numberMonthly;
    public Map<String, Double> list = new HashMap<>();
    public double avgSpending = 0d;
    public double avgProfit = 0d;

    @Override
    public String toString() {
        return "Годовой отчёт{" +
                "Номер года =" + numberMonthly +
                ", Месяца =" + list +
                ", Траты =" + avgSpending +
                ", Профит =" + avgProfit +
                '}';
    }
}
