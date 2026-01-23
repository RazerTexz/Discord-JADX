package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.Map;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* JADX INFO: renamed from: a */
    public final Clock3 f5353a;

    /* JADX INFO: renamed from: b */
    public final Map<Priority3, SchedulerConfig.a> f5354b;

    public AutoValue_SchedulerConfig(Clock3 clock3, Map<Priority3, SchedulerConfig.a> map) {
        Objects.requireNonNull(clock3, "Null clock");
        this.f5353a = clock3;
        Objects.requireNonNull(map, "Null values");
        this.f5354b = map;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig
    /* JADX INFO: renamed from: a */
    public Clock3 mo2374a() {
        return this.f5353a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig
    /* JADX INFO: renamed from: c */
    public Map<Priority3, SchedulerConfig.a> mo2375c() {
        return this.f5354b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f5353a.equals(schedulerConfig.mo2374a()) && this.f5354b.equals(schedulerConfig.mo2375c());
    }

    public int hashCode() {
        return ((this.f5353a.hashCode() ^ 1000003) * 1000003) ^ this.f5354b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("SchedulerConfig{clock=");
        sbM833U.append(this.f5353a);
        sbM833U.append(", values=");
        return outline.m825M(sbM833U, this.f5354b, "}");
    }
}
