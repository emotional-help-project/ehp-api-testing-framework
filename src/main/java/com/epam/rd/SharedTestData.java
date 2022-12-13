package com.epam.rd;

public class SharedTestData {

    private static int testId;
    private static int testTypeId;

    public static int getTestId() {
        return testId;
    }

    public static void setTestId(int testId) {
        SharedTestData.testId = testId;
    }

    public static int getTestTypeId() {
        return testTypeId;
    }

    public static void setTestTypeId(int testTypeId) {
        SharedTestData.testTypeId = testTypeId;
    }
}
