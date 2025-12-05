package p007b.p225i.p226a.p228b.p231j.p232q;

import android.content.Context;
import p496c0.p497a.Provider3;

/* compiled from: MetadataBackendRegistry_Factory.java */
/* renamed from: b.i.a.b.j.q.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class MetadataBackendRegistry_Factory implements Provider3 {

    /* renamed from: a */
    public final Provider3<Context> f5323a;

    /* renamed from: b */
    public final Provider3<CreationContextFactory> f5324b;

    public MetadataBackendRegistry_Factory(Provider3<Context> provider3, Provider3<CreationContextFactory> provider32) {
        this.f5323a = provider3;
        this.f5324b = provider32;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new MetadataBackendRegistry(this.f5323a.get(), this.f5324b.get());
    }
}
