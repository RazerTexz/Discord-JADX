package b.i.a.b.j.t.h;

import b.i.a.b.j.t.h.f;
import java.util.Set;

/* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* loaded from: classes3.dex */
public final class c extends f.a {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final long f785b;
    public final Set<f.b> c;

    /* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    public static final class b extends f.a.AbstractC0089a {
        public Long a;

        /* renamed from: b, reason: collision with root package name */
        public Long f786b;
        public Set<f.b> c;

        @Override // b.i.a.b.j.t.h.f.a.AbstractC0089a
        public f.a a() {
            String strW = this.a == null ? " delta" : "";
            if (this.f786b == null) {
                strW = b.d.b.a.a.w(strW, " maxAllowedDelay");
            }
            if (this.c == null) {
                strW = b.d.b.a.a.w(strW, " flags");
            }
            if (strW.isEmpty()) {
                return new c(this.a.longValue(), this.f786b.longValue(), this.c, null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }

        @Override // b.i.a.b.j.t.h.f.a.AbstractC0089a
        public f.a.AbstractC0089a b(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // b.i.a.b.j.t.h.f.a.AbstractC0089a
        public f.a.AbstractC0089a c(long j) {
            this.f786b = Long.valueOf(j);
            return this;
        }
    }

    public c(long j, long j2, Set set, a aVar) {
        this.a = j;
        this.f785b = j2;
        this.c = set;
    }

    @Override // b.i.a.b.j.t.h.f.a
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.h.f.a
    public Set<f.b> c() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.h.f.a
    public long d() {
        return this.f785b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f.a)) {
            return false;
        }
        f.a aVar = (f.a) obj;
        return this.a == aVar.b() && this.f785b == aVar.d() && this.c.equals(aVar.c());
    }

    public int hashCode() {
        long j = this.a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f785b;
        return this.c.hashCode() ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ConfigValue{delta=");
        sbU.append(this.a);
        sbU.append(", maxAllowedDelay=");
        sbU.append(this.f785b);
        sbU.append(", flags=");
        return b.d.b.a.a.N(sbU, this.c, "}");
    }
}
