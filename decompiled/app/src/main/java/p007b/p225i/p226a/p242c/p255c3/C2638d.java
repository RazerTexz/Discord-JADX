package p007b.p225i.p226a.p242c.p255c3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionOverrides;
import p007b.p225i.p226a.p242c.p259f3.BundleableUtil;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableMap2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: lambda */
/* renamed from: b.i.a.c.c3.d */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2638d implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2638d f6180a = new C2638d();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        TrackSelectionOverrides trackSelectionOverrides = TrackSelectionOverrides.f6270j;
        int i = TrackSelectionOverrides.a.f6273j;
        C2639e c2639e = C2639e.f6181a;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        List listM3020b = BundleableUtil.m3020b(c2639e, parcelableArrayList, RegularImmutableList.f12012l);
        ImmutableMap2.a aVar = new ImmutableMap2.a(4);
        for (int i2 = 0; i2 < listM3020b.size(); i2++) {
            TrackSelectionOverrides.a aVar2 = (TrackSelectionOverrides.a) listM3020b.get(i2);
            aVar.m6277c(aVar2.f6274k, aVar2);
        }
        return new TrackSelectionOverrides(aVar.m6275a());
    }
}
