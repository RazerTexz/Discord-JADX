package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event.java */
/* loaded from: classes3.dex */
public final class j extends v.d.AbstractC0143d {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1723b;
    public final v.d.AbstractC0143d.a c;
    public final v.d.AbstractC0143d.b d;
    public final v.d.AbstractC0143d.c e;

    public j(long j, String str, v.d.AbstractC0143d.a aVar, v.d.AbstractC0143d.b bVar, v.d.AbstractC0143d.c cVar, a aVar2) {
        this.a = j;
        this.f1723b = str;
        this.c = aVar;
        this.d = bVar;
        this.e = cVar;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d
    @NonNull
    public v.d.AbstractC0143d.a a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d
    @NonNull
    public v.d.AbstractC0143d.b b() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d
    @Nullable
    public v.d.AbstractC0143d.c c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d
    public long d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d
    @NonNull
    public String e() {
        return this.f1723b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d)) {
            return false;
        }
        v.d.AbstractC0143d abstractC0143d = (v.d.AbstractC0143d) obj;
        if (this.a == abstractC0143d.d() && this.f1723b.equals(abstractC0143d.e()) && this.c.equals(abstractC0143d.a()) && this.d.equals(abstractC0143d.b())) {
            v.d.AbstractC0143d.c cVar = this.e;
            if (cVar == null) {
                if (abstractC0143d.c() == null) {
                    return true;
                }
            } else if (cVar.equals(abstractC0143d.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1723b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        v.d.AbstractC0143d.c cVar = this.e;
        return (cVar == null ? 0 : cVar.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Event{timestamp=");
        sbU.append(this.a);
        sbU.append(", type=");
        sbU.append(this.f1723b);
        sbU.append(", app=");
        sbU.append(this.c);
        sbU.append(", device=");
        sbU.append(this.d);
        sbU.append(", log=");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
