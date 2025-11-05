package b.g.a.b.t;

import b.g.a.b.t.l;
import java.lang.ref.SoftReference;

/* compiled from: BufferRecyclers.java */
/* loaded from: classes3.dex */
public class b {
    public static final l a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<SoftReference<a>> f677b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        a = zEquals ? l.a.a : null;
        f677b = new ThreadLocal<>();
    }
}
