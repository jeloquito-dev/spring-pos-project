package com.playground.springposproject.Enums;

public enum Modules {

    DASHBOARD("dashboard", "dashboard.html"),
    PRODUCTS("products", "products.html"),
    ORDER("order", "order.html"),
    INVENTORY("inventory", "inventory.html"),
    SALES_REPORT("sales report", "sales_report.html"),
    ACCOUNT("account", "account.html"),
    DEFAULT("default", "default.html");

    String value;
    String name;
    Modules(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public static String getValueByName(String name) {

        for(Modules module : Modules.values())
        {
            System.out.println(module.value);
            if(module.getName().equals(name)) {
                return module.getValue();
            }
        }
        return null;
    }

}
