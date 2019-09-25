package enums;

import helpers.LangHelper;

public enum TimeZone {
    NOT_SET("EMPTY"),
    UTCP0_AC("UTCP0_AC"),
    UTCP0_EL("UTCP0_EL"),
    UTCP1_EA("UTCP1_EA");

    String symbol;

    TimeZone(String sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.time_zone."+this.symbol.toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
