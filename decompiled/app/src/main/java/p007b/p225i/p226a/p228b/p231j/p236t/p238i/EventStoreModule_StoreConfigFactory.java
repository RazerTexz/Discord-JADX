package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import java.util.Objects;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.g, reason: use source file name */
/* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EventStoreModule_StoreConfigFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.t.i.g$a */
    /* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final EventStoreModule_StoreConfigFactory f5423a = new EventStoreModule_StoreConfigFactory();
    }

    @Override // p496c0.p497a.Provider3
    public Object get() {
        EventStoreConfig eventStoreConfig = EventStoreConfig.f5420a;
        Objects.requireNonNull(eventStoreConfig, "Cannot return null from a non-@Nullable @Provides method");
        return eventStoreConfig;
    }
}
