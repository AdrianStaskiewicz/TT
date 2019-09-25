package enums;

import helpers.LangHelper;

public enum TaskType {
    ENHANCEMENT('E'),
    FEATURE('F'),
    FIX('B'),
    OTHER('O');

    Character symbol;

    TaskType(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.task_type."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
