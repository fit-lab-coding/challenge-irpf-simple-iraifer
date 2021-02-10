package fit.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IrpfCalculator {
    
    private static Double EXEMPTIONVALUE = 1903.98;

    public static Double calculateBaseSalary(double totalSalary) {
        var tax = totalSalary * 0.11;
        var baseSalary = totalSalary - tax;

        return baseSalary;
    }

    public static Double calculateExemption() {
        return EXEMPTIONVALUE;
    }

    public static Double calculateDiscount(double baseSalary) {
        return (baseSalary - EXEMPTIONVALUE);
    }

    public static Double calculateTaxLayer(double baseSalary) {
        if (baseSalary > EXEMPTIONVALUE && baseSalary <= 2826.65) return 0.075;

        return 0.0;
    }

    public static double calculateIrpf(double totalSalary) {
        var salaryBase = calculateBaseSalary(totalSalary);

        var discountValue = (salaryBase - EXEMPTIONVALUE);

        Double valIrpf = (discountValue * calculateTaxLayer(salaryBase));

        BigDecimal roundIrpf = new BigDecimal(valIrpf).setScale(2, RoundingMode.HALF_UP);

        return roundIrpf.doubleValue();
    }
}
