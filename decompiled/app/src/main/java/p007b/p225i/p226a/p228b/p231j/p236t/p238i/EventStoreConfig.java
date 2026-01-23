package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import com.google.auto.value.AutoValue;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.d, reason: use source file name */
/* JADX INFO: compiled from: EventStoreConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class EventStoreConfig {

    /* JADX INFO: renamed from: a */
    public static final EventStoreConfig f5420a;

    static {
        Long l = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long l2 = 604800000L;
        Integer num3 = 81920;
        String strM883w = l == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            strM883w = outline.m883w(strM883w, " loadBatchSize");
        }
        if (num2 == null) {
            strM883w = outline.m883w(strM883w, " criticalSectionEnterTimeoutMs");
        }
        if (l2 == null) {
            strM883w = outline.m883w(strM883w, " eventCleanUpAge");
        }
        if (num3 == null) {
            strM883w = outline.m883w(strM883w, " maxBlobByteSizePerRow");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }
        f5420a = new AutoValue_EventStoreConfig(l.longValue(), num.intValue(), num2.intValue(), l2.longValue(), num3.intValue(), null);
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo2386a();

    /* JADX INFO: renamed from: b */
    public abstract long mo2387b();

    /* JADX INFO: renamed from: c */
    public abstract int mo2388c();

    /* JADX INFO: renamed from: d */
    public abstract int mo2389d();

    /* JADX INFO: renamed from: e */
    public abstract long mo2390e();
}
