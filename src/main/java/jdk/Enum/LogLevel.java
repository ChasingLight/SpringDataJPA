package jdk.Enum;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    FATAL(4);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static LogLevel findByValue(int value) {
        switch(value) {
            case 0:
                return DEBUG;
            case 1:
                return INFO;
            case 2:
                return WARN;
            case 3:
                return ERROR;
            case 4:
                return FATAL;
            default:
                return null;
        }
    }

    public static void main(String[] args) {

        String input = "INFOO";

        for (LogLevel element : LogLevel.values()) {

            if (element.name().equals(input)) {

            }
        }


        LogLevel res = LogLevel.valueOf("INFOO");

        System.out.println(res);
    }


}