package d0.v;

import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Thread.kt */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: Thread.kt */
    /* renamed from: d0.v.a$a, reason: collision with other inner class name */
    public static final class C0598a extends Thread {
        public final /* synthetic */ Function0 j;

        public C0598a(Function0 function0) {
            this.j = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.j.invoke();
        }
    }

    public static final Thread thread(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "block");
        C0598a c0598a = new C0598a(function0);
        if (z3) {
            c0598a.setDaemon(true);
        }
        if (i > 0) {
            c0598a.setPriority(i);
        }
        if (str != null) {
            c0598a.setName(str);
        }
        if (classLoader != null) {
            c0598a.setContextClassLoader(classLoader);
        }
        if (z2) {
            c0598a.start();
        }
        return c0598a;
    }

    public static /* synthetic */ Thread thread$default(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        return thread((i2 & 1) != 0 ? true : z2, (i2 & 2) != 0 ? false : z3, (i2 & 4) != 0 ? null : classLoader, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? -1 : i, function0);
    }
}
