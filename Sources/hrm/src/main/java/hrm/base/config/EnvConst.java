package hrm.base.config;

import java.util.Map;

public class EnvConst {
    public static String DATABASE_URL;
    public static String DATABASE_USERNAME;
    public static String  DATABASE_PASSWORD;
    public static String JWT_SECRET;
    public static Long JWT_EXPIRATION;
    public static Integer SERVER_PORT;
    static {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n", envName, env.get(envName));
        }

        // DATABASE_URL = (System.getenv("DATABASE_URL"));
        // DATABASE_USERNAME = (System.getenv("DATABASE_USERNAME"));
        // DATABASE_PASSWORD = (System.getenv("DATABASE_PASSWORD"));
        // JWT_SECRET = (System.getenv("JWT_SECRET"));
        // JWT_EXPIRATION =
        // Long.parseLong(Objects.requireNonNull(System.getenv("JWT_EXPIRATION")));
        // SERVER_PORT =
        // Integer.parseInt(Objects.requireNonNull(System.getenv("SERVER_PORT")));
        DATABASE_URL = "jdbc:mysql:/35.240.198.195:33306/hrm?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true";
        DATABASE_USERNAME = "menu";
        DATABASE_PASSWORD = "1234";
        JWT_SECRET = "secret";
        JWT_EXPIRATION = 604800000L;
        SERVER_PORT = 3323;
    }

    EnvConst() {
    }
}
