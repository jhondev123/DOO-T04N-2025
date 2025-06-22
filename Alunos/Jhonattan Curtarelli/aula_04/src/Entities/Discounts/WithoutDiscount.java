package src.Entities.Discounts;

import src.Entities.Order.Order;

import java.math.BigDecimal;

public class WithoutDiscount extends Discount
{
    public WithoutDiscount ()
    {
        super(null);
    }

    @Override
    public BigDecimal calculate(Order value) {
        return null;
    }

}
