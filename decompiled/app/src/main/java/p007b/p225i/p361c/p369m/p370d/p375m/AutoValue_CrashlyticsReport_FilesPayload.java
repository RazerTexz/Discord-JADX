package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
/* renamed from: b.i.c.m.d.m.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.c {

    /* renamed from: a */
    public final ImmutableList3<CrashlyticsReport.c.a> f12536a;

    /* renamed from: b */
    public final String f12537b;

    public AutoValue_CrashlyticsReport_FilesPayload(ImmutableList3 immutableList3, String str, a aVar) {
        this.f12536a = immutableList3;
        this.f12537b = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.c
    @NonNull
    /* renamed from: a */
    public ImmutableList3<CrashlyticsReport.c.a> mo6527a() {
        return this.f12536a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.c
    @Nullable
    /* renamed from: b */
    public String mo6528b() {
        return this.f12537b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.c)) {
            return false;
        }
        CrashlyticsReport.c cVar = (CrashlyticsReport.c) obj;
        if (this.f12536a.equals(cVar.mo6527a())) {
            String str = this.f12537b;
            if (str == null) {
                if (cVar.mo6528b() == null) {
                    return true;
                }
            } else if (str.equals(cVar.mo6528b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f12536a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12537b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("FilesPayload{files=");
        sbM833U.append(this.f12536a);
        sbM833U.append(", orgId=");
        return outline.m822J(sbM833U, this.f12537b, "}");
    }
}
