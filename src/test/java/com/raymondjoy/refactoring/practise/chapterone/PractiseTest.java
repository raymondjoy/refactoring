package com.raymondjoy.refactoring.practise.chapterone;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PractiseTest {

    @Test
    public void should_return_correct_result_when_input_invoices() {
        Map<String, Play> playsMap = new HashMap<>();
        Map<String, Object> invoicesMap = new HashMap<>();
        playsMap.put("hamlet", new Play("tragedy", "Hamlet"));
        playsMap.put("as-like", new Play("comedy", "As You Like It"));
        playsMap.put("othello", new Play("tragedy", "Othello"));
        invoicesMap.put("customer", "BigCo");
        List<Invoice> invoiceList = Arrays.asList(
                new Invoice("hamlet", 55),
                new Invoice("as-like", 35),
                new Invoice("othello", 40));
        invoicesMap.put("performances", invoiceList);

        String statement = Practise.statement(playsMap, invoicesMap);

        System.out.println(statement);
    }
}