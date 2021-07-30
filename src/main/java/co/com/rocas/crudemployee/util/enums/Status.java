package co.com.rocas.crudemployee.util.enums;

public enum Status {
    ACTIVE('A'),
    RETIRED('R');

    private final Character value;

    Status(char value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }
}
