package enums;

import helpers.LangHelper;

public enum RoleType {
    ADMINISTRATOR('A'),
    MODERATOR('L'),
    TEAM_MEMBER('T'),
    PROJECT_MANAGER('M'),
    PROJECT_OWNER('O');

    Character symbol;

    RoleType(Character sign) {
        this.symbol = sign;
    }

    public String toString(){
        return LangHelper.getLang("enum.role_type."+this.symbol.toString().toLowerCase());
        //TODO ADD RESOURCE BUNDLE FOR LANG HERE
    }
}
