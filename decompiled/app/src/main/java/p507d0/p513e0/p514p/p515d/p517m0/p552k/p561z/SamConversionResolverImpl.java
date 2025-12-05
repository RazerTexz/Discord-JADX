package p507d0.p513e0.p514p.p515d.p517m0.p552k.p561z;

import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SamConversionResolverImpl.kt */
/* renamed from: d0.e0.p.d.m0.k.z.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class SamConversionResolverImpl implements SamConversionResolver {

    /* renamed from: a */
    public final Iterable<Object> f24477a;

    public SamConversionResolverImpl(StorageManager storageManager, Iterable<? extends Object> iterable) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(iterable, "samWithReceiverResolvers");
        this.f24477a = iterable;
        storageManager.createCacheWithNullableValues();
    }
}
