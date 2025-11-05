package s.a.b2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import d0.k;
import d0.l;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class c {
    static {
        Object objM97constructorimpl;
        try {
            k.a aVar = k.j;
            objM97constructorimpl = k.m97constructorimpl(new a(a(Looper.getMainLooper(), true), null, false));
        } catch (Throwable th) {
            k.a aVar2 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
        }
    }

    @VisibleForTesting
    public static final Handler a(Looper looper, boolean z2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!z2) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        Objects.requireNonNull(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
