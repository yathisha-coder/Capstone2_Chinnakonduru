package org.example;

public class GarlicKnots extends MenuItem {
    public GarlicKnots(String name) {
        super(name);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public String getReceiptText() {
        return "=====GARLIC KNOTS=====\\n" +
                "Price: $1.50";
    }
}
