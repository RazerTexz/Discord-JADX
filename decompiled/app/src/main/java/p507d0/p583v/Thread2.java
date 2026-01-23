package p507d0.p583v;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.v.a, reason: use source file name */
/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Thread2 {

    /* JADX INFO: renamed from: d0.v.a$a */
    /* JADX INFO: compiled from: Thread.kt */
    public static final class a extends Thread {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Function0 f25231j;

        public a(Function0 function0) {
            this.f25231j = function0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f25231j.invoke();
        }
    }

    public static final Thread thread(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(function0, "block");
        a aVar = new a(function0);
        if (z3) {
            aVar.setDaemon(true);
        }
        if (i > 0) {
            aVar.setPriority(i);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z2) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread thread$default(boolean z2, boolean z3, ClassLoader classLoader, String str, int i, Function0 function0, int i2, Object obj) {
        return thread((i2 & 1) != 0 ? true : z2, (i2 & 2) != 0 ? false : z3, (i2 & 4) != 0 ? null : classLoader, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? -1 : i, function0);
    }
}
