package p007b.p225i.p226a.p228b.p231j.p240v;

import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.v.c, reason: use source file name */
/* JADX INFO: compiled from: TimeModule_UptimeClockFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeModule_UptimeClockFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.v.c$a */
    /* JADX INFO: compiled from: TimeModule_UptimeClockFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final TimeModule_UptimeClockFactory f5460a = new TimeModule_UptimeClockFactory();
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new UptimeClock();
    }
}
