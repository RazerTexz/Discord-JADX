package p007b.p195g.p196a.p205c.p211d0;

import java.lang.reflect.Method;

/* compiled from: JDK14Util.java */
/* renamed from: b.g.a.c.d0.a, reason: use source file name */
/* loaded from: classes3.dex */
public class JDK14Util {

    /* renamed from: a */
    public static final JDK14Util f4766a;

    /* renamed from: b */
    public static final RuntimeException f4767b;

    /* renamed from: c */
    public final Method f4768c;

    /* renamed from: d */
    public final Method f4769d;

    static {
        JDK14Util jDK14Util = null;
        try {
            e = null;
            jDK14Util = new JDK14Util();
        } catch (RuntimeException e) {
            e = e;
        }
        f4766a = jDK14Util;
        f4767b = e;
    }

    public JDK14Util() throws RuntimeException {
        try {
            this.f4768c = Class.class.getMethod("getRecordComponents", new Class[0]);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f4769d = cls.getMethod("getName", new Class[0]);
            cls.getMethod("getType", new Class[0]);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e.getClass().getName(), e.getMessage()), e);
        }
    }
}
