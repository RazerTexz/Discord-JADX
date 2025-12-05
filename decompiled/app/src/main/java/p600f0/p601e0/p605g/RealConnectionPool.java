package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import java.lang.ref.Reference;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Address;
import p600f0.Route;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.Task2;
import p600f0.p601e0.p604f.TaskQueue2;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p605g.RealCall;
import p600f0.p601e0.p609k.Platform2;

/* compiled from: RealConnectionPool.kt */
/* renamed from: f0.e0.g.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealConnectionPool {

    /* renamed from: a */
    public final long f25507a;

    /* renamed from: b */
    public final TaskQueue2 f25508b;

    /* renamed from: c */
    public final a f25509c;

    /* renamed from: d */
    public final ConcurrentLinkedQueue<RealConnection4> f25510d;

    /* renamed from: e */
    public final int f25511e;

    /* compiled from: RealConnectionPool.kt */
    /* renamed from: f0.e0.g.k$a */
    public static final class a extends Task2 {
        public a(String str) {
            super(str, true);
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* renamed from: a */
        public long mo10150a() {
            RealConnectionPool realConnectionPool = RealConnectionPool.this;
            long jNanoTime = System.nanoTime();
            RealConnection4 realConnection4 = null;
            long j = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (RealConnection4 realConnection42 : realConnectionPool.f25510d) {
                Intrinsics3.checkExpressionValueIsNotNull(realConnection42, "connection");
                synchronized (realConnection42) {
                    if (realConnectionPool.m10208b(realConnection42, jNanoTime) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j2 = jNanoTime - realConnection42.f25505p;
                        if (j2 > j) {
                            realConnection4 = realConnection42;
                            j = j2;
                        }
                    }
                }
            }
            long j3 = realConnectionPool.f25507a;
            if (j < j3 && i <= realConnectionPool.f25511e) {
                if (i > 0) {
                    return j3 - j;
                }
                if (i2 > 0) {
                    return j3;
                }
                return -1L;
            }
            if (realConnection4 == null) {
                Intrinsics3.throwNpe();
            }
            synchronized (realConnection4) {
                if (!realConnection4.f25504o.isEmpty()) {
                    return 0L;
                }
                if (realConnection4.f25505p + j != jNanoTime) {
                    return 0L;
                }
                realConnection4.f25498i = true;
                realConnectionPool.f25510d.remove(realConnection4);
                Util7.m10124e(realConnection4.m10205n());
                if (!realConnectionPool.f25510d.isEmpty()) {
                    return 0L;
                }
                realConnectionPool.f25508b.m10152a();
                return 0L;
            }
        }
    }

    public RealConnectionPool(TaskRunner taskRunner, int i, long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        this.f25511e = i;
        this.f25507a = timeUnit.toNanos(j);
        this.f25508b = taskRunner.m10162f();
        this.f25509c = new a(outline.m822J(new StringBuilder(), Util7.f25403g, " ConnectionPool"));
        this.f25510d = new ConcurrentLinkedQueue<>();
        if (!(j > 0)) {
            throw new IllegalArgumentException(outline.m877t("keepAliveDuration <= 0: ", j).toString());
        }
    }

    /* renamed from: a */
    public final boolean m10207a(Address address, RealCall realCall, List<Route> list, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(address, "address");
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        for (RealConnection4 realConnection4 : this.f25510d) {
            Intrinsics3.checkExpressionValueIsNotNull(realConnection4, "connection");
            synchronized (realConnection4) {
                if (z2) {
                    if (!realConnection4.m10201j()) {
                    }
                }
                if (realConnection4.m10199h(address, list)) {
                    realCall.m10181f(realConnection4);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public final int m10208b(RealConnection4 realConnection4, long j) {
        byte[] bArr = Util7.f25397a;
        List<Reference<RealCall>> list = realConnection4.f25504o;
        int i = 0;
        while (i < list.size()) {
            Reference<RealCall> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder sbM833U = outline.m833U("A connection to ");
                sbM833U.append(realConnection4.f25506q.f25370a.f25353a);
                sbM833U.append(" was leaked. ");
                sbM833U.append("Did you forget to close a response body?");
                String string = sbM833U.toString();
                Platform2.a aVar = Platform2.f25785c;
                Platform2.f25783a.mo10322k(string, ((RealCall.b) reference).f25485a);
                list.remove(i);
                realConnection4.f25498i = true;
                if (list.isEmpty()) {
                    realConnection4.f25505p = j - this.f25507a;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
