package ndkutils;

/**
 * Created by vtg on 2017/5/25.
 */
public class JniUtils {
    static {
        System.loadLibrary("HelloJni");
    }

    public native String getStringFromNative();
}
