package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.c, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.b {

    /* JADX INFO: renamed from: a */
    public final String f12534a;

    /* JADX INFO: renamed from: b */
    public final String f12535b;

    public AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2, a aVar) {
        this.f12534a = str;
        this.f12535b = str2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.b
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6525a() {
        return this.f12534a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.b
    @NonNull
    /* JADX INFO: renamed from: b */
    public String mo6526b() {
        return this.f12535b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.b)) {
            return false;
        }
        CrashlyticsReport.b bVar = (CrashlyticsReport.b) obj;
        return this.f12534a.equals(bVar.mo6525a()) && this.f12535b.equals(bVar.mo6526b());
    }

    public int hashCode() {
        return ((this.f12534a.hashCode() ^ 1000003) * 1000003) ^ this.f12535b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CustomAttribute{key=");
        sbM833U.append(this.f12534a);
        sbM833U.append(", value=");
        return outline.m822J(sbM833U, this.f12535b, "}");
    }
}
