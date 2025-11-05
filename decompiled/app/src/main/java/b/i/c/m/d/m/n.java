package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
/* loaded from: classes3.dex */
public final class n extends v.d.AbstractC0143d.a.b.AbstractC0146b {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1728b;
    public final w<v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a> c;
    public final v.d.AbstractC0143d.a.b.AbstractC0146b d;
    public final int e;

    public n(String str, String str2, w wVar, v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146b, int i, a aVar) {
        this.a = str;
        this.f1728b = str2;
        this.c = wVar;
        this.d = abstractC0146b;
        this.e = i;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0146b
    @Nullable
    public v.d.AbstractC0143d.a.b.AbstractC0146b a() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0146b
    @NonNull
    public w<v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a> b() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0146b
    public int c() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0146b
    @Nullable
    public String d() {
        return this.f1728b;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0146b
    @NonNull
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146b;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d.a.b.AbstractC0146b)) {
            return false;
        }
        v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146b2 = (v.d.AbstractC0143d.a.b.AbstractC0146b) obj;
        return this.a.equals(abstractC0146b2.e()) && ((str = this.f1728b) != null ? str.equals(abstractC0146b2.d()) : abstractC0146b2.d() == null) && this.c.equals(abstractC0146b2.b()) && ((abstractC0146b = this.d) != null ? abstractC0146b.equals(abstractC0146b2.a()) : abstractC0146b2.a() == null) && this.e == abstractC0146b2.c();
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f1728b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.c.hashCode()) * 1000003;
        v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146b = this.d;
        return ((iHashCode2 ^ (abstractC0146b != null ? abstractC0146b.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Exception{type=");
        sbU.append(this.a);
        sbU.append(", reason=");
        sbU.append(this.f1728b);
        sbU.append(", frames=");
        sbU.append(this.c);
        sbU.append(", causedBy=");
        sbU.append(this.d);
        sbU.append(", overflowCount=");
        return b.d.b.a.a.B(sbU, this.e, "}");
    }
}
