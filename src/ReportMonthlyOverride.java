public class ReportMonthlyOverride {
    public String nameMonthly;
    public String nameProfitableCommodity;
    public Double priceProfitableCommodity = 0d;
    public String nameMaxSpending;
    public Double priceMaxSpending = 0d;

    @Override
    public String toString() {
        return "Месячный отчёт {" +
                " Название месяца ='" + nameMonthly + '\'' +
                ", Название самой прибыльной категории ='" + nameProfitableCommodity + '\'' +
                ", Стоимость самой прибыльной категории =" + priceProfitableCommodity +
                ", Название большей траты ='" + nameMaxSpending + '\'' +
                ", Сумма большей траты=" + priceMaxSpending +
                '}';
    }
}
