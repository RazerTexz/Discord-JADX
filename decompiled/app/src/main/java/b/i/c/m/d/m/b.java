package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport.java */
/* loaded from: classes3.dex */
public final class b extends v {

    /* renamed from: b, reason: collision with root package name */
    public final String f1713b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final String g;
    public final v.d h;
    public final v.c i;

    /* compiled from: AutoValue_CrashlyticsReport.java */
    /* renamed from: b.i.c.m.d.m.b$b, reason: collision with other inner class name */
    public static final class C0141b extends v.a {
        public String a;

        /* renamed from: b, reason: collision with root package name */
        public String f1714b;
        public Integer c;
        public String d;
        public String e;
        public String f;
        public v.d g;
        public v.c h;

        public C0141b() {
        }

        @Override // b.i.c.m.d.m.v.a
        public v a() {
            String strW = this.a == null ? " sdkVersion" : "";
            if (this.f1714b == null) {
                strW = b.d.b.a.a.w(strW, " gmpAppId");
            }
            if (this.c == null) {
                strW = b.d.b.a.a.w(strW, " platform");
            }
            if (this.d == null) {
                strW = b.d.b.a.a.w(strW, " installationUuid");
            }
            if (this.e == null) {
                strW = b.d.b.a.a.w(strW, " buildVersion");
            }
            if (this.f == null) {
                strW = b.d.b.a.a.w(strW, " displayVersion");
            }
            if (strW.isEmpty()) {
                return new b(this.a, this.f1714b, this.c.intValue(), this.d, this.e, this.f, this.g, this.h, null);
            }
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }

        public C0141b(v vVar, a aVar) {
            b bVar = (b) vVar;
            this.a = bVar.f1713b;
            this.f1714b = bVar.c;
            this.c = Integer.valueOf(bVar.d);
            this.d = bVar.e;
            this.e = bVar.f;
            this.f = bVar.g;
            this.g = bVar.h;
            this.h = bVar.i;
        }
    }

    public b(String str, String str2, int i, String str3, String str4, String str5, v.d dVar, v.c cVar, a aVar) {
        this.f1713b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = dVar;
        this.i = cVar;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String a() {
        return this.f;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String b() {
        return this.g;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String c() {
        return this.c;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String d() {
        return this.e;
    }

    @Override // b.i.c.m.d.m.v
    @Nullable
    public v.c e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        v.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (this.f1713b.equals(vVar.g()) && this.c.equals(vVar.c()) && this.d == vVar.f() && this.e.equals(vVar.d()) && this.f.equals(vVar.a()) && this.g.equals(vVar.b()) && ((dVar = this.h) != null ? dVar.equals(vVar.h()) : vVar.h() == null)) {
            v.c cVar = this.i;
            if (cVar == null) {
                if (vVar.e() == null) {
                    return true;
                }
            } else if (cVar.equals(vVar.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.c.m.d.m.v
    public int f() {
        return this.d;
    }

    @Override // b.i.c.m.d.m.v
    @NonNull
    public String g() {
        return this.f1713b;
    }

    @Override // b.i.c.m.d.m.v
    @Nullable
    public v.d h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f1713b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003;
        v.d dVar = this.h;
        int iHashCode2 = (iHashCode ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        v.c cVar = this.i;
        return iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0);
    }

    @Override // b.i.c.m.d.m.v
    public v.a i() {
        return new C0141b(this, null);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CrashlyticsReport{sdkVersion=");
        sbU.append(this.f1713b);
        sbU.append(", gmpAppId=");
        sbU.append(this.c);
        sbU.append(", platform=");
        sbU.append(this.d);
        sbU.append(", installationUuid=");
        sbU.append(this.e);
        sbU.append(", buildVersion=");
        sbU.append(this.f);
        sbU.append(", displayVersion=");
        sbU.append(this.g);
        sbU.append(", session=");
        sbU.append(this.h);
        sbU.append(", ndkPayload=");
        sbU.append(this.i);
        sbU.append("}");
        return sbU.toString();
    }
}
