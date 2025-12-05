package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import java.util.Objects;
import p496c0.p497a.Provider3;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* renamed from: b.i.a.b.j.t.i.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventStoreModule_StoreConfigFactory implements Provider3 {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    /* renamed from: b.i.a.b.j.t.i.g$a */
    public static final class a {

        /* renamed from: a */
        public static final EventStoreModule_StoreConfigFactory f5423a = new EventStoreModule_StoreConfigFactory();
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        EventStoreConfig eventStoreConfig = EventStoreConfig.f5420a;
        Objects.requireNonNull(eventStoreConfig, "Cannot return null from a non-@Nullable @Provides method");
        return eventStoreConfig;
    }
}
