package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.content.Context;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.a0, reason: use source file name */
/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchemaManager_Factory implements Provider3 {

    /* JADX INFO: renamed from: a */
    public final Provider3<Context> f5414a;

    /* JADX INFO: renamed from: b */
    public final Provider3<String> f5415b;

    /* JADX INFO: renamed from: c */
    public final Provider3<Integer> f5416c;

    public SchemaManager_Factory(Provider3<Context> provider3, Provider3<String> provider32, Provider3<Integer> provider33) {
        this.f5414a = provider3;
        this.f5415b = provider32;
        this.f5416c = provider33;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new SchemaManager5(this.f5414a.get(), this.f5415b.get(), this.f5416c.get().intValue());
    }
}
