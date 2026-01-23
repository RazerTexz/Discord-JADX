package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* JADX INFO: renamed from: b.i.c.m.d.m.n, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b {

    /* JADX INFO: renamed from: a */
    public final String f12608a;

    /* JADX INFO: renamed from: b */
    public final String f12609b;

    /* JADX INFO: renamed from: c */
    public final ImmutableList3<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> f12610c;

    /* JADX INFO: renamed from: d */
    public final CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b f12611d;

    /* JADX INFO: renamed from: e */
    public final int f12612e;

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, String str2, ImmutableList3 immutableList3, CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b, int i, a aVar) {
        this.f12608a = str;
        this.f12609b = str2;
        this.f12610c = immutableList3;
        this.f12611d = abstractC13236b;
        this.f12612e = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b
    @Nullable
    /* JADX INFO: renamed from: a */
    public CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b mo6582a() {
        return this.f12611d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b
    @NonNull
    /* JADX INFO: renamed from: b */
    public ImmutableList3<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> mo6583b() {
        return this.f12610c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b
    /* JADX INFO: renamed from: c */
    public int mo6584c() {
        return this.f12612e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b
    @Nullable
    /* JADX INFO: renamed from: d */
    public String mo6585d() {
        return this.f12609b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b
    @NonNull
    /* JADX INFO: renamed from: e */
    public String mo6586e() {
        return this.f12608a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b2 = (CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b) obj;
        return this.f12608a.equals(abstractC13236b2.mo6586e()) && ((str = this.f12609b) != null ? str.equals(abstractC13236b2.mo6585d()) : abstractC13236b2.mo6585d() == null) && this.f12610c.equals(abstractC13236b2.mo6583b()) && ((abstractC13236b = this.f12611d) != null ? abstractC13236b.equals(abstractC13236b2.mo6582a()) : abstractC13236b2.mo6582a() == null) && this.f12612e == abstractC13236b2.mo6584c();
    }

    public int hashCode() {
        int iHashCode = (this.f12608a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12609b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f12610c.hashCode()) * 1000003;
        CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b = this.f12611d;
        return ((iHashCode2 ^ (abstractC13236b != null ? abstractC13236b.hashCode() : 0)) * 1000003) ^ this.f12612e;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Exception{type=");
        sbM833U.append(this.f12608a);
        sbM833U.append(", reason=");
        sbM833U.append(this.f12609b);
        sbM833U.append(", frames=");
        sbM833U.append(this.f12610c);
        sbM833U.append(", causedBy=");
        sbM833U.append(this.f12611d);
        sbM833U.append(", overflowCount=");
        return outline.m814B(sbM833U, this.f12612e, "}");
    }
}
