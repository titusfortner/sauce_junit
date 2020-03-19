package test.java.tests.watchers;

public class TestContext {
    public static BaseTestWatcher implementation() {
        if (System.getProperty("USE_SAUCE") != null) {
            return new SauceTestWatcher();
        } else {
            return new LocalTestWatcher();
        }
    }
}

