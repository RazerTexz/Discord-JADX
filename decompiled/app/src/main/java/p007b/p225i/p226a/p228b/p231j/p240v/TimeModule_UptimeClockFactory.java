package p007b.p225i.p226a.p228b.p231j.p240v;

import p496c0.p497a.Provider3;

/* compiled from: TimeModule_UptimeClockFactory.java */
/* renamed from: b.i.a.b.j.v.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class TimeModule_UptimeClockFactory implements Provider3 {

    /* compiled from: TimeModule_UptimeClockFactory.java */
    /* renamed from: b.i.a.b.j.v.c$a */
    public static final class a {

        /* renamed from: a */
        public static final TimeModule_UptimeClockFactory f5460a = new TimeModule_UptimeClockFactory();
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new UptimeClock();
    }
}
