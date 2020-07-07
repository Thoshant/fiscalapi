package com.code.fiscalapi.enums;

public enum Month {
    January(1), February(2), March(3), April(4), May(5), June(6), July(7), August(8), September(9), October(10), November(11), December(12);

    private int value;
    private String character;

    static {
        January.character = "A";
        February.character = "B";
        March.character = "C";
        April.character = "D";
        May.character = "E";
        June.character = "H";
        July.character = "L";
        August.character = "M";
        September.character = "P";
        October.character = "R";
        November.character = "S";
        December.character = "T";
    }

    Month(int value) {
        this.value = value;
    }

    public String getCharacter(){
        return this.character;
    }
}
