package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* renamed from: b.i.c.m.d.m.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.d.AbstractC13233d.a {

    /* renamed from: a */
    public final CrashlyticsReport.d.AbstractC13233d.a.b f12592a;

    /* renamed from: b */
    public final ImmutableList3<CrashlyticsReport.b> f12593b;

    /* renamed from: c */
    public final Boolean f12594c;

    /* renamed from: d */
    public final int f12595d;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
    /* renamed from: b.i.c.m.d.m.k$b */
    public static final class b extends CrashlyticsReport.d.AbstractC13233d.a.AbstractC13234a {

        /* renamed from: a */
        public CrashlyticsReport.d.AbstractC13233d.a.b f12596a;

        /* renamed from: b */
        public ImmutableList3<CrashlyticsReport.b> f12597b;

        /* renamed from: c */
        public Boolean f12598c;

        /* renamed from: d */
        public Integer f12599d;

        public b() {
        }

        /* renamed from: a */
        public CrashlyticsReport.d.AbstractC13233d.a m6573a() {
            String strM883w = this.f12596a == null ? " execution" : "";
            if (this.f12599d == null) {
                strM883w = outline.m883w(strM883w, " uiOrientation");
            }
            if (strM883w.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.f12596a, this.f12597b, this.f12598c, this.f12599d.intValue(), null);
            }
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }

        public b(CrashlyticsReport.d.AbstractC13233d.a aVar, a aVar2) {
            AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = (AutoValue_CrashlyticsReport_Session_Event_Application) aVar;
            this.f12596a = autoValue_CrashlyticsReport_Session_Event_Application.f12592a;
            this.f12597b = autoValue_CrashlyticsReport_Session_Event_Application.f12593b;
            this.f12598c = autoValue_CrashlyticsReport_Session_Event_Application.f12594c;
            this.f12599d = Integer.valueOf(autoValue_CrashlyticsReport_Session_Event_Application.f12595d);
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.d.AbstractC13233d.a.b bVar, ImmutableList3 immutableList3, Boolean bool, int i, a aVar) {
        this.f12592a = bVar;
        this.f12593b = immutableList3;
        this.f12594c = bool;
        this.f12595d = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a
    @Nullable
    /* renamed from: a */
    public Boolean mo6568a() {
        return this.f12594c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a
    @Nullable
    /* renamed from: b */
    public ImmutableList3<CrashlyticsReport.b> mo6569b() {
        return this.f12593b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a
    @NonNull
    /* renamed from: c */
    public CrashlyticsReport.d.AbstractC13233d.a.b mo6570c() {
        return this.f12592a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport.d.AbstractC13233d.a
    /* renamed from: d */
    public int mo6571d() {
        return this.f12595d;
    }

    /* renamed from: e */
    public CrashlyticsReport.d.AbstractC13233d.a.AbstractC13234a m6572e() {
        return new b(this, null);
    }

    public boolean equals(Object obj) {
        ImmutableList3<CrashlyticsReport.b> immutableList3;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.d.AbstractC13233d.a)) {
            return false;
        }
        CrashlyticsReport.d.AbstractC13233d.a aVar = (CrashlyticsReport.d.AbstractC13233d.a) obj;
        return this.f12592a.equals(aVar.mo6570c()) && ((immutableList3 = this.f12593b) != null ? immutableList3.equals(aVar.mo6569b()) : aVar.mo6569b() == null) && ((bool = this.f12594c) != null ? bool.equals(aVar.mo6568a()) : aVar.mo6568a() == null) && this.f12595d == aVar.mo6571d();
    }

    public int hashCode() {
        int iHashCode = (this.f12592a.hashCode() ^ 1000003) * 1000003;
        ImmutableList3<CrashlyticsReport.b> immutableList3 = this.f12593b;
        int iHashCode2 = (iHashCode ^ (immutableList3 == null ? 0 : immutableList3.hashCode())) * 1000003;
        Boolean bool = this.f12594c;
        return ((iHashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f12595d;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Application{execution=");
        sbM833U.append(this.f12592a);
        sbM833U.append(", customAttributes=");
        sbM833U.append(this.f12593b);
        sbM833U.append(", background=");
        sbM833U.append(this.f12594c);
        sbM833U.append(", uiOrientation=");
        return outline.m814B(sbM833U, this.f12595d, "}");
    }
}
