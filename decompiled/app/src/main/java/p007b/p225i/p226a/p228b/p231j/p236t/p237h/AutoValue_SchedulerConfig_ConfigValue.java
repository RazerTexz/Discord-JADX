package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig;

/* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* renamed from: b.i.a.b.j.t.h.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.a {

    /* renamed from: a */
    public final long f5355a;

    /* renamed from: b */
    public final long f5356b;

    /* renamed from: c */
    public final Set<SchedulerConfig.b> f5357c;

    /* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    /* renamed from: b.i.a.b.j.t.h.c$b */
    public static final class b extends SchedulerConfig.a.AbstractC13221a {

        /* renamed from: a */
        public Long f5358a;

        /* renamed from: b */
        public Long f5359b;

        /* renamed from: c */
        public Set<SchedulerConfig.b> f5360c;

        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig.a.AbstractC13221a
        /* renamed from: a */
        public SchedulerConfig.a mo2379a() {
            String strM883w = this.f5358a == null ? " delta" : "";
            if (this.f5359b == null) {
                strM883w = outline.m883w(strM883w, " maxAllowedDelay");
            }
            if (this.f5360c == null) {
                strM883w = outline.m883w(strM883w, " flags");
            }
            if (strM883w.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f5358a.longValue(), this.f5359b.longValue(), this.f5360c, null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig.a.AbstractC13221a
        /* renamed from: b */
        public SchedulerConfig.a.AbstractC13221a mo2380b(long j) {
            this.f5358a = Long.valueOf(j);
            return this;
        }

        @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig.a.AbstractC13221a
        /* renamed from: c */
        public SchedulerConfig.a.AbstractC13221a mo2381c(long j) {
            this.f5359b = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set, a aVar) {
        this.f5355a = j;
        this.f5356b = j2;
        this.f5357c = set;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig.a
    /* renamed from: b */
    public long mo2376b() {
        return this.f5355a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig.a
    /* renamed from: c */
    public Set<SchedulerConfig.b> mo2377c() {
        return this.f5357c;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig.a
    /* renamed from: d */
    public long mo2378d() {
        return this.f5356b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.a)) {
            return false;
        }
        SchedulerConfig.a aVar = (SchedulerConfig.a) obj;
        return this.f5355a == aVar.mo2376b() && this.f5356b == aVar.mo2378d() && this.f5357c.equals(aVar.mo2377c());
    }

    public int hashCode() {
        long j = this.f5355a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f5356b;
        return this.f5357c.hashCode() ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ConfigValue{delta=");
        sbM833U.append(this.f5355a);
        sbM833U.append(", maxAllowedDelay=");
        sbM833U.append(this.f5356b);
        sbM833U.append(", flags=");
        return outline.m826N(sbM833U, this.f5357c, "}");
    }
}
