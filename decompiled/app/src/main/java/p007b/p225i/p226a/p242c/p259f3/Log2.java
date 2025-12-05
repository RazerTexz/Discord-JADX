package p007b.p225i.p226a.p242c.p259f3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: Log.java */
/* renamed from: b.i.a.c.f3.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class Log2 {
    @Pure
    /* renamed from: a */
    public static String m3038a(String str, @Nullable Throwable th) {
        boolean z2;
        String strReplace;
        if (th == null) {
            strReplace = null;
        } else {
            Throwable cause = th;
            while (true) {
                if (cause == null) {
                    z2 = false;
                    break;
                }
                if (cause instanceof UnknownHostException) {
                    z2 = true;
                    break;
                }
                cause = cause.getCause();
            }
            strReplace = z2 ? "UnknownHostException (no network)" : Log.getStackTraceString(th).trim().replace("\t", "    ");
        }
        if (TextUtils.isEmpty(strReplace)) {
            return str;
        }
        String strValueOf = String.valueOf(str);
        String strReplace2 = strReplace.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(String.valueOf(strReplace2).length() + strValueOf.length() + 4);
        sb.append(strValueOf);
        sb.append("\n  ");
        sb.append(strReplace2);
        sb.append('\n');
        return sb.toString();
    }

    @Pure
    /* renamed from: b */
    public static void m3039b(String str, String str2, @Nullable Throwable th) {
        Log.e(str, m3038a(str2, th));
    }

    @Pure
    /* renamed from: c */
    public static void m3040c(String str, String str2, @Nullable Throwable th) {
        Log.w(str, m3038a(str2, th));
    }
}
