package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import b.i.c.m.d.m.v;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
/* loaded from: classes3.dex */
public final class s extends v.d.AbstractC0143d.c {
    public final String a;

    public s(String str, a aVar) {
        this.a = str;
    }

    @Override // b.i.c.m.d.m.v.d.AbstractC0143d.c
    @NonNull
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.AbstractC0143d.c) {
            return this.a.equals(((v.d.AbstractC0143d.c) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return b.d.b.a.a.J(b.d.b.a.a.U("Log{content="), this.a, "}");
    }
}
