package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* compiled from: AutoValue_CrashlyticsReport_Session_User.java */
/* renamed from: b.i.c.m.d.m.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.d.f {

    /* renamed from: a */
    public final String f12646a;

    public AutoValue_CrashlyticsReport_Session_User(String str, a aVar) {
        this.f12646a = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.f
    @NonNull
    /* renamed from: a */
    public String mo6611a() {
        return this.f12646a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.d.f) {
            return this.f12646a.equals(((CrashlyticsReport.d.f) obj).mo6611a());
        }
        return false;
    }

    public int hashCode() {
        return this.f12646a.hashCode() ^ 1000003;
    }

    public String toString() {
        return outline.m822J(outline.m833U("User{identifier="), this.f12646a, "}");
    }
}
