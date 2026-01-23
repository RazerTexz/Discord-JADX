package p007b.p225i.p226a.p228b.p231j.p240v;

import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.v.b, reason: use source file name */
/* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeModule_EventClockFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.v.b$a */
    /* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final TimeModule_EventClockFactory f5459a = new TimeModule_EventClockFactory();
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new WallTimeClock();
    }
}
