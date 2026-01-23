package p007b.p195g.p196a.p205c.p209b0;

import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.b0.a, reason: use source file name */
/* JADX INFO: compiled from: Java7Handlers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Java7Handlers {

    /* JADX INFO: renamed from: a */
    public static final Java7Handlers f4620a;

    static {
        Java7Handlers java7Handlers;
        try {
            java7Handlers = (Java7Handlers) ClassUtil.m2175g(Class.forName("b.g.a.c.b0.b"), false);
        } catch (Throwable unused) {
            java7Handlers = null;
        }
        f4620a = java7Handlers;
    }

    /* JADX INFO: renamed from: a */
    public abstract JsonSerializer<?> mo1803a(Class<?> cls);
}
