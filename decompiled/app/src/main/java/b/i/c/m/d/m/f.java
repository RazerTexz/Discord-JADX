package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session.java */
/* loaded from: classes3.dex */
public final class f extends v.d {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1718b;
    public final long c;
    public final Long d;
    public final boolean e;
    public final v.d.a f;
    public final v.d.f g;
    public final v.d.e h;
    public final v.d.c i;
    public final w<v.d.AbstractC0143d> j;
    public final int k;

    /* compiled from: AutoValue_CrashlyticsReport_Session.java */
    public static final class b extends v.d.b {
        public String a;

        /* renamed from: b, reason: collision with root package name */
        public String f1719b;
        public Long c;
        public Long d;
        public Boolean e;
        public v.d.a f;
        public v.d.f g;
        public v.d.e h;
        public v.d.c i;
        public w<v.d.AbstractC0143d> j;
        public Integer k;

        public b() {
        }

        @Override // b.i.c.m.d.m.v.d.b
        public v.d a() {
            String strW = this.a == null ? " generator" : "";
            if (this.f1719b == null) {
                strW = b.d.b.a.a.w(strW, " identifier");
            }
            if (this.c == null) {
                strW = b.d.b.a.a.w(strW, " startedAt");
            }
            if (this.e == null) {
                strW = b.d.b.a.a.w(strW, " crashed");
            }
            if (this.f == null) {
                strW = b.d.b.a.a.w(strW, " app");
            }
            if (this.k == null) {
                strW = b.d.b.a.a.w(strW, " generatorType");
            }
            if (strW.isEmpty()) {
                return new f(this.a, this.f1719b, this.c.longValue(), this.d, this.e.booleanValue(), this.f, this.g, this.h, this.i, this.j, this.k.intValue(), null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }

        public v.d.b b(boolean z2) {
            this.e = Boolean.valueOf(z2);
            return this;
        }

        public b(v.d dVar, a aVar) {
            f fVar = (f) dVar;
            this.a = fVar.a;
            this.f1719b = fVar.f1718b;
            this.c = Long.valueOf(fVar.c);
            this.d = fVar.d;
            this.e = Boolean.valueOf(fVar.e);
            this.f = fVar.f;
            this.g = fVar.g;
            this.h = fVar.h;
            this.i = fVar.i;
            this.j = fVar.j;
            this.k = Integer.valueOf(fVar.k);
        }
    }

    public f(String str, String str2, long j, Long l, boolean z2, v.d.a aVar, v.d.f fVar, v.d.e eVar, v.d.c cVar, w wVar, int i, a aVar2) {
        this.a = str;
        this.f1718b = str2;
        this.c = j;
        this.d = l;
        this.e = z2;
        this.f = aVar;
        this.g = fVar;
        this.h = eVar;
        this.i = cVar;
        this.j = wVar;
        this.k = i;
    }

    @Override // b.i.c.m.d.m.v.d
    @NonNull
    public v.d.a a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.v.d
    @Nullable
    public v.d.c b() {
        return this.i;
    }

    @Override // b.i.c.m.d.m.v.d
    @Nullable
    public Long c() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v.d
    @Nullable
    public w<v.d.AbstractC0143d> d() {
        return this.j;
    }

    @Override // b.i.c.m.d.m.v.d
    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        Long l;
        v.d.f fVar;
        v.d.e eVar;
        v.d.c cVar;
        w<v.d.AbstractC0143d> wVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d)) {
            return false;
        }
        v.d dVar = (v.d) obj;
        return this.a.equals(dVar.e()) && this.f1718b.equals(dVar.g()) && this.c == dVar.i() && ((l = this.d) != null ? l.equals(dVar.c()) : dVar.c() == null) && this.e == dVar.k() && this.f.equals(dVar.a()) && ((fVar = this.g) != null ? fVar.equals(dVar.j()) : dVar.j() == null) && ((eVar = this.h) != null ? eVar.equals(dVar.h()) : dVar.h() == null) && ((cVar = this.i) != null ? cVar.equals(dVar.b()) : dVar.b() == null) && ((wVar = this.j) != null ? wVar.equals(dVar.d()) : dVar.d() == null) && this.k == dVar.f();
    }

    @Override // b.i.c.m.d.m.v.d
    public int f() {
        return this.k;
    }

    @Override // b.i.c.m.d.m.v.d
    @NonNull
    public String g() {
        return this.f1718b;
    }

    @Override // b.i.c.m.d.m.v.d
    @Nullable
    public v.d.e h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1718b.hashCode()) * 1000003;
        long j = this.c;
        int i = (iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.d;
        int iHashCode2 = (((((i ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.e ? 1231 : 1237)) * 1000003) ^ this.f.hashCode()) * 1000003;
        v.d.f fVar = this.g;
        int iHashCode3 = (iHashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        v.d.e eVar = this.h;
        int iHashCode4 = (iHashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        v.d.c cVar = this.i;
        int iHashCode5 = (iHashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        w<v.d.AbstractC0143d> wVar = this.j;
        return ((iHashCode5 ^ (wVar != null ? wVar.hashCode() : 0)) * 1000003) ^ this.k;
    }

    @Override // b.i.c.m.d.m.v.d
    public long i() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d
    @Nullable
    public v.d.f j() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.v.d
    public boolean k() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v.d
    public v.d.b l() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Session{generator=");
        sbU.append(this.a);
        sbU.append(", identifier=");
        sbU.append(this.f1718b);
        sbU.append(", startedAt=");
        sbU.append(this.c);
        sbU.append(", endedAt=");
        sbU.append(this.d);
        sbU.append(", crashed=");
        sbU.append(this.e);
        sbU.append(", app=");
        sbU.append(this.f);
        sbU.append(", user=");
        sbU.append(this.g);
        sbU.append(", os=");
        sbU.append(this.h);
        sbU.append(", device=");
        sbU.append(this.i);
        sbU.append(", events=");
        sbU.append(this.j);
        sbU.append(", generatorType=");
        return b.d.b.a.a.B(sbU, this.k, "}");
    }
}
