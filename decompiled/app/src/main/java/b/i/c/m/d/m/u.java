package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_User.java */
/* loaded from: classes3.dex */
public final class u extends v.d.f {
    public final String a;

    public u(String str, a aVar) {
        this.a = str;
    }

    @Override // b.i.c.m.d.m.v.d.f
    @NonNull
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.f) {
            return this.a.equals(((v.d.f) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("User{identifier="), this.a, "}");
    }
}
