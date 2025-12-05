package p007b.p195g.p196a.p198b.p204t;

import java.lang.ref.SoftReference;
import p007b.p195g.p196a.p198b.p204t.ThreadLocalBufferManager;

/* compiled from: BufferRecyclers.java */
/* renamed from: b.g.a.b.t.b, reason: use source file name */
/* loaded from: classes3.dex */
public class BufferRecyclers {

    /* renamed from: a */
    public static final ThreadLocalBufferManager f4595a;

    /* renamed from: b */
    public static final ThreadLocal<SoftReference<BufferRecycler>> f4596b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        f4595a = zEquals ? ThreadLocalBufferManager.a.f4616a : null;
        f4596b = new ThreadLocal<>();
    }
}
