package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.Context;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p496c0.p497a.Provider3;

/* compiled from: CreationContextFactory_Factory.java */
/* renamed from: b.i.a.b.j.q.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class CreationContextFactory_Factory implements Provider3 {

    /* renamed from: a */
    public final Provider3<Context> f5315a;

    /* renamed from: b */
    public final Provider3<Clock3> f5316b;

    /* renamed from: c */
    public final Provider3<Clock3> f5317c;

    public CreationContextFactory_Factory(Provider3<Context> provider3, Provider3<Clock3> provider32, Provider3<Clock3> provider33) {
        this.f5315a = provider3;
        this.f5316b = provider32;
        this.f5317c = provider33;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new CreationContextFactory(this.f5315a.get(), this.f5316b.get(), this.f5317c.get());
    }
}
