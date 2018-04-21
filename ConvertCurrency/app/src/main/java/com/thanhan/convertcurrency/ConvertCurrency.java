package com.thanhan.convertcurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tptha on 18/04/18.
 */

public class ConvertCurrency {
    private Map<String, Double> currencyRate;

    public ConvertCurrency() {
        this.currencyRate = new HashMap<String, Double>();
        initCurrencyRate();
    }

    private void initCurrencyRate() {
        getCurrencyRate().put("USD", 1.0);
        getCurrencyRate().put("EUR", 0.8086);
        getCurrencyRate().put("VND", 22774.0);
        getCurrencyRate().put("JPY", 107.224);
        getCurrencyRate().put("CNY", 6.2854);
        getCurrencyRate().put("GBP", 0.704);

    }

    public double convert(Double in, String a, String b) {
        double mon_1 = this.getCurrencyRate().get(a);
        double mon_2 = this.getCurrencyRate().get(b);
        return (in * mon_2) / mon_1;
    }

    public Map<String,Double> getCurrencyRate() {
        return currencyRate;
    }
}