public class MonthlyStat {

    public String name;
    public boolean isExpense;
    public int quantity;
    public double sumOfOne;

    public MonthlyStat(String name, boolean isExpense, int quantity, double sumOfOne) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }

    @Override
    public String toString() {
        return "MonthlyStat{" +
                "Название месяца ='" + name + '\'' +
                ", Самый прибыльной товар =" + isExpense +
                ", Количество =" + quantity +
                ", Сумма =" + sumOfOne +
                '}';
    }
}
