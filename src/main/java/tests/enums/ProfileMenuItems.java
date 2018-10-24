package tests.enums;

public enum ProfileMenuItems {
    MAIL("Почта"),
    HELP("Помощь");

    private String value;

    ProfileMenuItems(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
