package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
/* loaded from: classes3.dex */
public final class l extends v.d.AbstractC0143d.a.b {
    public final w<v.d.AbstractC0143d.a.b.AbstractC0147d> a;

    /* renamed from: b, reason: collision with root package name */
    public final v.d.AbstractC0143d.a.b.AbstractC0146b f1726b;
    public final v.d.AbstractC0143d.a.b.c c;
    public final w<v.d.AbstractC0143d.a.b.AbstractC0145a> d;

    public l(w wVar, v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146b, v.d.AbstractC0143d.a.b.c cVar, w wVar2, a aVar) {
        this.a = wVar;
        this.f1726b = abstractC0146b;
        this.c = cVar;
        this.d = wVar2;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b
    @NonNull
    public w<v.d.AbstractC0143d.a.b.AbstractC0145a> a() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b
    @NonNull
    public v.d.AbstractC0143d.a.b.AbstractC0146b b() {
        return this.f1726b;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b
    @NonNull
    public v.d.AbstractC0143d.a.b.c c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b
    @NonNull
    public w<v.d.AbstractC0143d.a.b.AbstractC0147d> d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d.a.b)) {
            return false;
        }
        v.d.AbstractC0143d.a.b bVar = (v.d.AbstractC0143d.a.b) obj;
        return this.a.equals(bVar.d()) && this.f1726b.equals(bVar.b()) && this.c.equals(bVar.c()) && this.d.equals(bVar.a());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1726b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Execution{threads=");
        sbU.append(this.a);
        sbU.append(", exception=");
        sbU.append(this.f1726b);
        sbU.append(", signal=");
        sbU.append(this.c);
        sbU.append(", binaries=");
        sbU.append(this.d);
        sbU.append("}");
        return sbU.toString();
    }
}
