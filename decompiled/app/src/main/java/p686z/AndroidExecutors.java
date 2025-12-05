package p686z;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: AndroidExecutors.java */
/* renamed from: z.a, reason: use source file name */
/* loaded from: classes.dex */
public final class AndroidExecutors {

    /* renamed from: a */
    public static final AndroidExecutors f27960a = new AndroidExecutors();

    /* renamed from: b */
    public static final int f27961b;

    /* renamed from: c */
    public static final int f27962c;

    /* renamed from: d */
    public static final int f27963d;

    /* renamed from: e */
    public final Executor f27964e = new b(null);

    /* compiled from: AndroidExecutors.java */
    /* renamed from: z.a$b */
    public static class b implements Executor {
        public b(a aVar) {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f27961b = iAvailableProcessors;
        f27962c = iAvailableProcessors + 1;
        f27963d = (iAvailableProcessors * 2) + 1;
    }
}
