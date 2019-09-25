package enums;

import helpers.LangHelper;

public enum TaskPriority {
    CRITICAL('C'),
    HIGH('H'),
    NORMAL('N'),
    LOW('L');

    Character symbol;

    TaskPriority(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.task_priority."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
