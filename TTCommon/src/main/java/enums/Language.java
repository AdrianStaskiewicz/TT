package enums;

import helpers.LangHelper;

public enum Language {
    NOT_SET("EMPTY"),
    POLAND("PL-pl"),
    ENGLAND("GB-gb");

    String symbol;

    Language(String sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.language."+this.symbol.toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
