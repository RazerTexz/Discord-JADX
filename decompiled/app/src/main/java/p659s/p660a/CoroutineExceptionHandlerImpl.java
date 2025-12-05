package p659s.p660a;

import java.lang.Thread;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import p000.ServiceLoader;
import p507d0.Exceptions;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* renamed from: s.a.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class CoroutineExceptionHandlerImpl {

    /* renamed from: a */
    public static final List<CoroutineExceptionHandler> f27716a = _Sequences2.toList(C12075n.asSequence(ServiceLoader.m0a()));

    /* renamed from: a */
    public static final void m11192a(CoroutineContext coroutineContext, Throwable th) {
        Throwable runtimeException;
        Iterator<CoroutineExceptionHandler> it = f27716a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    Exceptions.addSuppressed(runtimeException, th);
                }
                uncaughtExceptionHandler.uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
