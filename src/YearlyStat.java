public class YearlyStat {
    public String nameMonthly;
    public Double expenses = 0d;
    public Double profit = 0d;

    public YearlyStat() {
    }

    public YearlyStat(String nameMonthly, Double expenses, Double profit) {
        this.nameMonthly = nameMonthly;
        this.expenses = expenses;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "YearlyStat{" +
                " Расходы =" + expenses +
                ", Прибыль =" + profit +
                '}';
    }
}
