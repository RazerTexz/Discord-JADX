package p007b.p225i.p361c.p369m.p370d.p384s.p385h;

/* compiled from: SettingsData.java */
/* renamed from: b.i.c.m.d.s.h.f, reason: use source file name */
/* loaded from: classes3.dex */
public class SettingsData implements Settings2 {

    /* renamed from: a */
    public final AppSettingsData f12759a;

    /* renamed from: b */
    public final SessionSettingsData f12760b;

    /* renamed from: c */
    public final FeaturesSettingsData f12761c;

    /* renamed from: d */
    public final long f12762d;

    public SettingsData(long j, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, FeaturesSettingsData featuresSettingsData, int i, int i2) {
        this.f12762d = j;
        this.f12759a = appSettingsData;
        this.f12760b = sessionSettingsData;
        this.f12761c = featuresSettingsData;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p384s.p385h.Settings2
    /* renamed from: a */
    public FeaturesSettingsData mo6689a() {
        return this.f12761c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p384s.p385h.Settings2
    /* renamed from: b */
    public SessionSettingsData mo6690b() {
        return this.f12760b;
    }
}
