package enums;

import helpers.LangHelper;

public enum Location {
    NOT_SET("EMPTY"),
    POLAND("PL"),
    ENGLAND("ENG"),
    GERMAN("DE");

    String symbol;

    Location(String sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.location."+this.symbol.toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
