package enums;

import helpers.LangHelper;

public enum TargetReleaseDateType {
    EXACT_DATE('E'),
    APPROXIMATE_DATE('A'),
    MONTH('M'),
    YEAR('Y');

    Character symbol;

    TargetReleaseDateType(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.target_release_date_type."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
