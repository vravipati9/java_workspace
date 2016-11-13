import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public enum EnumJavaVersion {

    JDK1_0 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.0.") >= 0;
        }

        @Override
        public int getID() {
            return 10;
        }
    },
    JDK1_1 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.1.") >= 0;
        }

        @Override
        public int getID() {
            return 11;
        }
    },
    JDK1_2 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.2.") >= 0;
        }

        @Override
        public int getID() {
            return 12;
        }
    },
    JDK1_3 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.3.") >= 0;
        }

        @Override
        public int getID() {
            return 13;
        }
    },
    JDK1_4 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.4.") >= 0;
        }

        @Override
        public int getID() {
            return 14;
        }
    },
    JDK1_5 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.5.") >= 0;
        }

        @Override
        public int getID() {
            return 15;
        }
    },
    JDK1_6 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.6.") >= 0 && !JDK1_6N.isJDK(javaVersion);
        }

        @Override
        public int getID() {
            return 16;
        }
    },
    JDK1_6N {

        @Override
        boolean isJDK(String javaVersion) {
            boolean result = false;
            if (javaVersion.indexOf("1.6.") >= 0) {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel".equals(info.getClassName())) {
                        result = true;
                        break;
                    }
                }
            }
            return result;
        }

        @Override
        public int getID() {
            return 1610;
        }
    },
    JDK1_7 {

        @Override
        boolean isJDK(String javaVersion) {
            return javaVersion.indexOf("1.7.") >= 0;
        }

        @Override
        public int getID() {
            return 17;
        }
    };
    private static final String jdkVersionName;
    private static final Map<Integer, EnumJavaVersion> lookup;

    static {
        jdkVersionName = System.getProperty("java.version");
        System.out.println("jdkVersionName:::::::"+jdkVersionName);
        lookup = new HashMap<Integer, EnumJavaVersion>();
        for (EnumJavaVersion versionNumber : EnumSet.allOf(EnumJavaVersion.class)) {
            lookup.put(versionNumber.getID(), versionNumber);
        }
    }

    abstract boolean isJDK(String javaVersion);

    public abstract int getID();

    public static String getCurrentVersionName() {
        return jdkVersionName;
    }

    public static int getJavaVersion(String javaVersion) {
        int version = 13;
        for (EnumJavaVersion id : EnumSet.allOf(EnumJavaVersion.class)) {
            if (id.isJDK(javaVersion)) {
                version = id.getID();
                break;
            }
        }
        return version;
    }

    public static EnumJavaVersion getField(final Integer versionNumber) {
        return lookup.get(versionNumber);
    }
}