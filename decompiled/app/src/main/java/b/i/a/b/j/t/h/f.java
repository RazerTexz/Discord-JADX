package b.i.a.b.j.t.h;

import b.i.a.b.j.t.h.c;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: SchedulerConfig.java */
@AutoValue
/* loaded from: classes3.dex */
public abstract class f {

    /* compiled from: SchedulerConfig.java */
    @AutoValue
    public static abstract class a {

        /* compiled from: SchedulerConfig.java */
        @AutoValue.Builder
        /* renamed from: b.i.a.b.j.t.h.f$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0089a {
            public abstract a a();

            public abstract AbstractC0089a b(long j);

            public abstract AbstractC0089a c(long j);
        }

        public static AbstractC0089a a() {
            c.b bVar = new c.b();
            Set<b> setEmptySet = Collections.emptySet();
            Objects.requireNonNull(setEmptySet, "Null flags");
            bVar.c = setEmptySet;
            return bVar;
        }

        public abstract long b();

        public abstract Set<b> c();

        public abstract long d();
    }

    /* compiled from: SchedulerConfig.java */
    public enum b {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public abstract b.i.a.b.j.v.a a();

    public long b(b.i.a.b.d dVar, long j, int i) {
        long jA = j - a().a();
        a aVar = c().get(dVar);
        long jB = aVar.b();
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * jB * Math.max(1.0d, Math.log(10000.0d) / Math.log((jB > 1 ? jB : 2L) * r12))), jA), aVar.d());
    }

    public abstract Map<b.i.a.b.d, a> c();
}
