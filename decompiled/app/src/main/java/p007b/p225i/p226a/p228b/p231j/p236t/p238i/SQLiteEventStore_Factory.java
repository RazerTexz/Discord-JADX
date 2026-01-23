package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.u, reason: use source file name */
/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SQLiteEventStore_Factory implements Provider3 {

    /* JADX INFO: renamed from: a */
    public final Provider3<Clock3> f5448a;

    /* JADX INFO: renamed from: b */
    public final Provider3<Clock3> f5449b;

    /* JADX INFO: renamed from: c */
    public final Provider3<EventStoreConfig> f5450c;

    /* JADX INFO: renamed from: d */
    public final Provider3<SchemaManager5> f5451d;

    public SQLiteEventStore_Factory(Provider3<Clock3> provider3, Provider3<Clock3> provider32, Provider3<EventStoreConfig> provider33, Provider3<SchemaManager5> provider34) {
        this.f5448a = provider3;
        this.f5449b = provider32;
        this.f5450c = provider33;
        this.f5451d = provider34;
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        return new C2511t(this.f5448a.get(), this.f5449b.get(), this.f5450c.get(), this.f5451d.get());
    }
}
