package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
/* loaded from: classes3.dex */
public final class p extends v.d.AbstractC0143d.a.b.AbstractC0147d {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1730b;
    public final w<v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a> c;

    public p(String str, int i, w wVar, a aVar) {
        this.a = str;
        this.f1730b = i;
        this.c = wVar;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d
    @NonNull
    public w<v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a> a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d
    public int b() {
        return this.f1730b;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d
    @NonNull
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d.a.b.AbstractC0147d)) {
            return false;
        }
        v.d.AbstractC0143d.a.b.AbstractC0147d abstractC0147d = (v.d.AbstractC0143d.a.b.AbstractC0147d) obj;
        return this.a.equals(abstractC0147d.c()) && this.f1730b == abstractC0147d.b() && this.c.equals(abstractC0147d.a());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1730b) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Thread{name=");
        sbU.append(this.a);
        sbU.append(", importance=");
        sbU.append(this.f1730b);
        sbU.append(", frames=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
