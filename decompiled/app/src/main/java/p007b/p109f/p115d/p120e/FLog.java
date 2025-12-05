package p007b.p109f.p115d.p120e;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import java.io.PrintWriter;
import java.io.StringWriter;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: FLog.java */
/* renamed from: b.f.d.e.a, reason: use source file name */
/* loaded from: classes.dex */
public class FLog {

    /* renamed from: a */
    public static final /* synthetic */ int f3102a = 0;

    /* renamed from: a */
    public static void m973a(Class<?> cls, String str) {
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + cls.getSimpleName(), str);
    }

    /* renamed from: b */
    public static void m974b(Class<?> cls, String str, Throwable th) {
        String strM886y = outline.m886y(EnvironmentCompat.MEDIA_UNKNOWN, ":", cls.getSimpleName());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        Log.println(6, strM886y, sb.toString());
    }

    /* renamed from: c */
    public static void m975c(Class<?> cls, String str, Object... objArr) {
        String simpleName = cls.getSimpleName();
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + simpleName, m979g(str, objArr));
    }

    /* renamed from: d */
    public static void m976d(Class<?> cls, Throwable th, String str, Object... objArr) {
        String simpleName = cls.getSimpleName();
        String strM979g = m979g(str, objArr);
        String strM886y = outline.m886y(EnvironmentCompat.MEDIA_UNKNOWN, ":", simpleName);
        StringBuilder sb = new StringBuilder();
        sb.append(strM979g);
        sb.append('\n');
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        sb.append(stringWriter.toString());
        Log.println(6, strM886y, sb.toString());
    }

    /* renamed from: e */
    public static void m977e(String str, String str2) {
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + str, str2);
    }

    /* renamed from: f */
    public static void m978f(String str, String str2, Throwable th) {
        String string;
        String strM886y = outline.m886y(EnvironmentCompat.MEDIA_UNKNOWN, ":", str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('\n');
        if (th == null) {
            string = "";
        } else {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        }
        sb.append(string);
        Log.println(6, strM886y, sb.toString());
    }

    /* renamed from: g */
    public static String m979g(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    /* renamed from: h */
    public static boolean m980h(int i) {
        return 5 <= i;
    }

    /* renamed from: i */
    public static void m981i(Class<?> cls, String str) {
        if (0 != 0) {
            Log.println(2, EnvironmentCompat.MEDIA_UNKNOWN + ":" + cls.getSimpleName(), str);
        }
    }

    /* renamed from: j */
    public static void m982j(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (m980h(2)) {
            m981i(cls, m979g(str, obj, obj2, obj3));
        }
    }

    /* renamed from: k */
    public static void m983k(Class<?> cls, String str) {
        Log.println(5, EnvironmentCompat.MEDIA_UNKNOWN + ":" + cls.getSimpleName(), str);
    }

    /* renamed from: l */
    public static void m984l(Class<?> cls, String str, Throwable th) {
        String string;
        if (1 != 0) {
            String strM886y = outline.m886y(EnvironmentCompat.MEDIA_UNKNOWN, ":", cls.getSimpleName());
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('\n');
            if (th == null) {
                string = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                string = stringWriter.toString();
            }
            sb.append(string);
            Log.println(5, strM886y, sb.toString());
        }
    }

    /* renamed from: m */
    public static void m985m(Class<?> cls, String str, Object... objArr) {
        String simpleName = cls.getSimpleName();
        Log.println(5, EnvironmentCompat.MEDIA_UNKNOWN + ":" + simpleName, m979g(str, objArr));
    }

    /* renamed from: n */
    public static void m986n(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (m980h(5)) {
            m984l(cls, m979g(str, objArr), th);
        }
    }

    /* renamed from: o */
    public static void m987o(String str, String str2, Object... objArr) {
        Log.println(5, EnvironmentCompat.MEDIA_UNKNOWN + ":" + str, m979g(str2, objArr));
    }

    /* renamed from: p */
    public static void m988p(String str, String str2, Object... objArr) {
        Log.println(6, EnvironmentCompat.MEDIA_UNKNOWN + ":" + str, m979g(str2, objArr));
    }
}
