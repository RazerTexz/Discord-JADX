package p659s.p660a.p661a;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: Concurrent.kt */
/* renamed from: s.a.a.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Concurrent {

    /* renamed from: a */
    public static final Method f27673a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f27673a = method;
    }
}
