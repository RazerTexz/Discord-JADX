package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* compiled from: AutoValue_CrashlyticsReportWithSessionId.java */
/* renamed from: b.i.c.m.d.k.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {

    /* renamed from: a */
    public final CrashlyticsReport f12268a;

    /* renamed from: b */
    public final String f12269b;

    public AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str) {
        Objects.requireNonNull(crashlyticsReport, "Null report");
        this.f12268a = crashlyticsReport;
        Objects.requireNonNull(str, "Null sessionId");
        this.f12269b = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsReportWithSessionId
    /* renamed from: a */
    public CrashlyticsReport mo6396a() {
        return this.f12268a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsReportWithSessionId
    /* renamed from: b */
    public String mo6397b() {
        return this.f12269b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        return this.f12268a.equals(crashlyticsReportWithSessionId.mo6396a()) && this.f12269b.equals(crashlyticsReportWithSessionId.mo6397b());
    }

    public int hashCode() {
        return ((this.f12268a.hashCode() ^ 1000003) * 1000003) ^ this.f12269b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CrashlyticsReportWithSessionId{report=");
        sbM833U.append(this.f12268a);
        sbM833U.append(", sessionId=");
        return outline.m822J(sbM833U, this.f12269b, "}");
    }
}
