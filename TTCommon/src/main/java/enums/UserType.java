package enums;

import helpers.LangHelper;

public enum UserType {
    ADMINISTRATOR('A'),
    CONTRIBUTOR('C');

    Character symbol;

    UserType(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.user_type."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
