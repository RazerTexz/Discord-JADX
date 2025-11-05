package d0.y;

import d0.z.d.m;
import java.io.File;

/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final String access$constructMessage(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }
}
