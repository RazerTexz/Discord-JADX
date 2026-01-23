package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.AutoValue_SchedulerConfig;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.AutoValue_SchedulerConfig_ConfigValue;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.f, reason: use source file name */
/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchedulingConfigModule_ConfigFactory implements Provider3 {

    /* JADX INFO: renamed from: a */
    public final Provider3<Clock3> f5347a;

    public SchedulingConfigModule_ConfigFactory(Provider3<Clock3> provider3) {
        this.f5347a = provider3;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        Clock3 clock3 = this.f5347a.get();
        HashMap map = new HashMap();
        Priority3 priority3 = Priority3.DEFAULT;
        SchedulerConfig.a.AbstractC13221a abstractC13221aM2384a = SchedulerConfig.a.m2384a();
        abstractC13221aM2384a.mo2380b(30000L);
        abstractC13221aM2384a.mo2381c(86400000L);
        map.put(priority3, abstractC13221aM2384a.mo2379a());
        Priority3 priority32 = Priority3.HIGHEST;
        SchedulerConfig.a.AbstractC13221a abstractC13221aM2384a2 = SchedulerConfig.a.m2384a();
        abstractC13221aM2384a2.mo2380b(1000L);
        abstractC13221aM2384a2.mo2381c(86400000L);
        map.put(priority32, abstractC13221aM2384a2.mo2379a());
        Priority3 priority33 = Priority3.VERY_LOW;
        SchedulerConfig.a.AbstractC13221a abstractC13221aM2384a3 = SchedulerConfig.a.m2384a();
        abstractC13221aM2384a3.mo2380b(86400000L);
        abstractC13221aM2384a3.mo2381c(86400000L);
        Set<SchedulerConfig.b> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig.b.NETWORK_UNMETERED, SchedulerConfig.b.DEVICE_IDLE)));
        AutoValue_SchedulerConfig_ConfigValue.b bVar = (AutoValue_SchedulerConfig_ConfigValue.b) abstractC13221aM2384a3;
        Objects.requireNonNull(setUnmodifiableSet, "Null flags");
        bVar.f5360c = setUnmodifiableSet;
        map.put(priority33, bVar.mo2379a());
        Objects.requireNonNull(clock3, "missing required property: clock");
        int size = map.keySet().size();
        Priority3.values();
        if (size < 3) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new AutoValue_SchedulerConfig(clock3, map);
    }
}
