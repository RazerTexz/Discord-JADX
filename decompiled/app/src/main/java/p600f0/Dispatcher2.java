package p600f0;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util6;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.RealCall;

/* compiled from: Dispatcher.kt */
/* renamed from: f0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class Dispatcher2 {

    /* renamed from: a */
    public ExecutorService f25957a;

    /* renamed from: b */
    public final ArrayDeque<RealCall.a> f25958b = new ArrayDeque<>();

    /* renamed from: c */
    public final ArrayDeque<RealCall.a> f25959c = new ArrayDeque<>();

    /* renamed from: d */
    public final ArrayDeque<RealCall> f25960d = new ArrayDeque<>();

    /* renamed from: a */
    public final synchronized void m10388a() {
        Iterator<RealCall.a> it = this.f25958b.iterator();
        while (it.hasNext()) {
            it.next().f25484l.cancel();
        }
        Iterator<RealCall.a> it2 = this.f25959c.iterator();
        while (it2.hasNext()) {
            it2.next().f25484l.cancel();
        }
        Iterator<RealCall> it3 = this.f25960d.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    /* renamed from: b */
    public final <T> void m10389b(Deque<T> deque, T t) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        m10391d();
    }

    /* renamed from: c */
    public final void m10390c(RealCall.a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        aVar.f25482j.decrementAndGet();
        m10389b(this.f25959c, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m10391d() {
        int size;
        int size2;
        int i;
        ExecutorService executorService;
        byte[] bArr = Util7.f25397a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.a> it = this.f25958b.iterator();
            Intrinsics3.checkExpressionValueIsNotNull(it, "readyAsyncCalls.iterator()");
            while (it.hasNext()) {
                RealCall.a next = it.next();
                if (this.f25959c.size() >= 64) {
                    break;
                }
                if (next.f25482j.get() < 5) {
                    it.remove();
                    next.f25482j.incrementAndGet();
                    Intrinsics3.checkExpressionValueIsNotNull(next, "asyncCall");
                    arrayList.add(next);
                    this.f25959c.add(next);
                }
            }
            synchronized (this) {
                size = this.f25959c.size() + this.f25960d.size();
            }
            size2 = arrayList.size();
            for (i = 0; i < size2; i++) {
                RealCall.a aVar = (RealCall.a) arrayList.get(i);
                synchronized (this) {
                    if (this.f25957a == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        String str = Util7.f25403g + " Dispatcher";
                        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        this.f25957a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new Util6(str, false));
                    }
                    executorService = this.f25957a;
                    if (executorService == null) {
                        Intrinsics3.throwNpe();
                    }
                }
                Objects.requireNonNull(aVar);
                Intrinsics3.checkParameterIsNotNull(executorService, "executorService");
                Dispatcher2 dispatcher2 = aVar.f25484l.f25480y.f26012m;
                byte[] bArr2 = Util7.f25397a;
                try {
                    try {
                        executorService.execute(aVar);
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        aVar.f25484l.m10187l(interruptedIOException);
                        aVar.f25483k.mo10359b(aVar.f25484l, interruptedIOException);
                        aVar.f25484l.f25480y.f26012m.m10390c(aVar);
                    }
                } catch (Throwable th) {
                    aVar.f25484l.f25480y.f26012m.m10390c(aVar);
                    throw th;
                }
            }
            return z;
        }
        boolean z2 = size > 0;
        size2 = arrayList.size();
        while (i < size2) {
        }
        return z2;
    }
}
