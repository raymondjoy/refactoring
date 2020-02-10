package com.raymondjoy.refactoring.practise.chapterone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practise {

    public static String statement(Map<String, Plays> playsMap, Map<String, Object> invoicesMap) {
        int totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoicesMap.get("customer") + "\n";

        for (Invoices perf : (List<Invoices>) invoicesMap.get("performances")) {
            Plays play = playsMap.get(perf.getPlayID());
            int thisAmount = 0;
            thisAmount = amountFor(perf, play);
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            if ("comedy".equals(play.getType())) volumeCredits += Math.floor(perf.getAudience() / 5);
            result += "  " + play.getName() + ": " + thisAmount / 100 + "￥(" + perf.getAudience() + " seats)\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + totalAmount / 100 + "￥ \n";
        result += "You earned " + volumeCredits + " credits\n";
        return result;
    }

    private static int amountFor(Invoices perf, Plays play) {
        int thisAmount;
        switch (play.getType()) {
            case "tragedy":
                thisAmount = 40000;
                if (perf.getAudience() > 30) {
                    thisAmount += 1000 * (perf.getAudience() - 30);
                }
                break;
            case "comedy":
                thisAmount = 30000;
                if (perf.getAudience() > 20) {
                    thisAmount += 10000 + 500 * (perf.getAudience() - 20);
                }
                thisAmount += 300 * perf.getAudience();
                break;
            default:
                throw new Error("unknown type");
        }
        return thisAmount;
    }
}
