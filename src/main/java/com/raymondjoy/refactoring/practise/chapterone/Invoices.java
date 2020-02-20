package com.raymondjoy.refactoring.practise.chapterone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Invoices {

    private final String playID;
    private final Integer audience;

    public String getPlayID() {
        return playID;
    }
}
