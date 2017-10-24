package my.lib.serenity.primefaces.sars;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by michael on 29/09/2016.
 */
public class TestContext {
    private static TestContext _instance;
    private static Object lockObj = new Object();
    private final Properties properties;

    public static TestContext get() {
        if (_instance == null) {
            synchronized (lockObj) {
                if (_instance == null) {
                    _instance = new TestContext();
                }
            }
        }

        return _instance;
    }

    private TestContext() {
        this.properties = new Properties();
        try (InputStream in = TestContext.class.getClassLoader().getResourceAsStream("test.properties")) {
            this.properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProp(Object key) {
        return (String) this.properties.get(key);
    }
}
