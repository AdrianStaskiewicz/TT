package enums;

import helpers.LangHelper;

public enum TaskStatus {
    OPEN('O'),
    CLOSED('C');

    Character symbol;

    TaskStatus(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.task_status."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
