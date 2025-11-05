package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* loaded from: classes3.dex */
public final class q extends v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a {
    public final long a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1731b;
    public final String c;
    public final long d;
    public final int e;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
    public static final class b extends v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a.AbstractC0149a {
        public Long a;

        /* renamed from: b, reason: collision with root package name */
        public String f1732b;
        public String c;
        public Long d;
        public Integer e;

        public v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a a() {
            String strW = this.a == null ? " pc" : "";
            if (this.f1732b == null) {
                strW = b.d.b.a.a.w(strW, " symbol");
            }
            if (this.d == null) {
                strW = b.d.b.a.a.w(strW, " offset");
            }
            if (this.e == null) {
                strW = b.d.b.a.a.w(strW, " importance");
            }
            if (strW.isEmpty()) {
                return new q(this.a.longValue(), this.f1732b, this.c, this.d.longValue(), this.e.intValue(), null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
    }

    public q(long j, String str, String str2, long j2, int i, a aVar) {
        this.a = j;
        this.f1731b = str;
        this.c = str2;
        this.d = j2;
        this.e = i;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a
    @Nullable
    public String a() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a
    public int b() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a
    public long c() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a
    public long d() {
        return this.a;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a
    @NonNull
    public String e() {
        return this.f1731b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a)) {
            return false;
        }
        v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a abstractC0148a = (v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a) obj;
        return this.a == abstractC0148a.d() && this.f1731b.equals(abstractC0148a.e()) && ((str = this.c) != null ? str.equals(abstractC0148a.a()) : abstractC0148a.a() == null) && this.d == abstractC0148a.c() && this.e == abstractC0148a.b();
    }

    public int hashCode() {
        long j = this.a;
        int iHashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1731b.hashCode()) * 1000003;
        String str = this.c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j2 = this.d;
        return this.e ^ ((iHashCode2 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Frame{pc=");
        sbU.append(this.a);
        sbU.append(", symbol=");
        sbU.append(this.f1731b);
        sbU.append(", file=");
        sbU.append(this.c);
        sbU.append(", offset=");
        sbU.append(this.d);
        sbU.append(", importance=");
        return b.d.b.a.a.B(sbU, this.e, "}");
    }
}
