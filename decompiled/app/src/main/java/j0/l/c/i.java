package j0.l.c;

import java.util.concurrent.TimeUnit;

/* compiled from: SchedulePeriodicHelper.java */
/* loaded from: classes3.dex */
public final class i {
    public static final long a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3791b = 0;

    /* compiled from: SchedulePeriodicHelper.java */
    public interface a {
        long a();
    }
}
