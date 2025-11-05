package b.i.a.b.j.t.i;

import java.util.Objects;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* loaded from: classes3.dex */
public final class g implements c0.a.a {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    public static final class a {
        public static final g a = new g();
    }

    @Override // c0.a.a
    public Object get() {
        d dVar = d.a;
        Objects.requireNonNull(dVar, "Cannot return null from a non-@Nullable @Provides method");
        return dVar;
    }
}
