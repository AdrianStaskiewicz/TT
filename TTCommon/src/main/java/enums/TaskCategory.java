package enums;

import helpers.LangHelper;

public enum TaskCategory {
    FUNCTIONALITY('F'),
    COMPATIBILITY('C'),
    USABILITY('U'),
    SECURITY('S'),
    PERFORMANCE('P'),
    INTEGRATION('I'),
    NONE('N');

    Character symbol;

    TaskCategory(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.task_category."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
