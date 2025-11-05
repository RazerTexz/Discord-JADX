package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
/* loaded from: classes3.dex */
public final class o extends v.d.AbstractC0143d.a.b.c {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1729b;
    public final long c;

    public o(String str, String str2, long j, a aVar) {
        this.a = str;
        this.f1729b = str2;
        this.c = j;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.c
    @NonNull
    public long a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.c
    @NonNull
    public String b() {
        return this.f1729b;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.c
    @NonNull
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d.a.b.c)) {
            return false;
        }
        v.d.AbstractC0143d.a.b.c cVar = (v.d.AbstractC0143d.a.b.c) obj;
        return this.a.equals(cVar.c()) && this.f1729b.equals(cVar.b()) && this.c == cVar.a();
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1729b.hashCode()) * 1000003;
        long j = this.c;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Signal{name=");
        sbU.append(this.a);
        sbU.append(", code=");
        sbU.append(this.f1729b);
        sbU.append(", address=");
        return b.d.b.a.a.C(sbU, this.c, "}");
    }
}
