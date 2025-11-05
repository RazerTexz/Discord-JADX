package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* loaded from: classes3.dex */
public final class k extends v.d.AbstractC0143d.a {
    public final v.d.AbstractC0143d.a.b a;

    /* renamed from: b, reason: collision with root package name */
    public final w<v.b> f1724b;
    public final Boolean c;
    public final int d;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
    public static final class b extends v.d.AbstractC0143d.a.AbstractC0144a {
        public v.d.AbstractC0143d.a.b a;

        /* renamed from: b, reason: collision with root package name */
        public w<v.b> f1725b;
        public Boolean c;
        public Integer d;

        public b() {
        }

        public v.d.AbstractC0143d.a a() {
            String strW = this.a == null ? " execution" : "";
            if (this.d == null) {
                strW = b.d.b.a.a.w(strW, " uiOrientation");
            }
            if (strW.isEmpty()) {
                return new k(this.a, this.f1725b, this.c, this.d.intValue(), null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }

        public b(v.d.AbstractC0143d.a aVar, a aVar2) {
            k kVar = (k) aVar;
            this.a = kVar.a;
            this.f1725b = kVar.f1724b;
            this.c = kVar.c;
            this.d = Integer.valueOf(kVar.d);
        }
    }

    public k(v.d.AbstractC0143d.a.b bVar, w wVar, Boolean bool, int i, a aVar) {
        this.a = bVar;
        this.f1724b = wVar;
        this.c = bool;
        this.d = i;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a
    @Nullable
    public Boolean a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a
    @Nullable
    public w<v.b> b() {
        return this.f1724b;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a
    @NonNull
    public v.d.AbstractC0143d.a.b c() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a
    public int d() {
        return this.d;
    }

    public v.d.AbstractC0143d.a.AbstractC0144a e() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        w<v.b> wVar;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d.a)) {
            return false;
        }
        v.d.AbstractC0143d.a aVar = (v.d.AbstractC0143d.a) obj;
        return this.a.equals(aVar.c()) && ((wVar = this.f1724b) != null ? wVar.equals(aVar.b()) : aVar.b() == null) && ((bool = this.c) != null ? bool.equals(aVar.a()) : aVar.a() == null) && this.d == aVar.d();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        w<v.b> wVar = this.f1724b;
        int iHashCode2 = (iHashCode ^ (wVar == null ? 0 : wVar.hashCode())) * 1000003;
        Boolean bool = this.c;
        return ((iHashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.d;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Application{execution=");
        sbU.append(this.a);
        sbU.append(", customAttributes=");
        sbU.append(this.f1724b);
        sbU.append(", background=");
        sbU.append(this.c);
        sbU.append(", uiOrientation=");
        return b.d.b.a.a.B(sbU, this.d, "}");
    }
}
