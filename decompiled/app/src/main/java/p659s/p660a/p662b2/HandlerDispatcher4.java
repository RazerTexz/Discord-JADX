package p659s.p660a.p662b2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import p507d0.Result2;
import p507d0.Result3;

/* JADX INFO: renamed from: s.a.b2.c, reason: use source file name */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HandlerDispatcher4 {
    static {
        Object objM11474constructorimpl;
        try {
            Result2.a aVar = Result2.f25169j;
            objM11474constructorimpl = Result2.m11474constructorimpl(new HandlerDispatcher2(m11197a(Looper.getMainLooper(), true), null, false));
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.f25169j;
            objM11474constructorimpl = Result2.m11474constructorimpl(Result3.createFailure(th));
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public static final Handler m11197a(Looper looper, boolean z2) throws IllegalAccessException, InvocationTargetException {
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
