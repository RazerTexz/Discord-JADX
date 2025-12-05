package p007b.p225i.p226a.p242c.p255c3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionOverrides;
import p007b.p225i.p226a.p242c.p259f3.BundleableUtil;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;
import p007b.p225i.p355b.p358c.Ints;

/* compiled from: lambda */
/* renamed from: b.i.a.c.c3.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2639e implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2639e f6181a = new C2639e();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        int i = TrackSelectionOverrides.a.f6273j;
        Bundle bundle2 = bundle.getBundle(Integer.toString(0, 36));
        Objects.requireNonNull(bundle2);
        int i2 = TrackGroup.f5660j;
        Bundleable.a<Format2> aVar = Format2.f7126k;
        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(Integer.toString(0, 36));
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        TrackGroup trackGroup = new TrackGroup((Format2[]) BundleableUtil.m3020b(aVar, parcelableArrayList, RegularImmutableList.f12012l).toArray(new Format2[0]));
        int[] intArray = bundle.getIntArray(Integer.toString(1, 36));
        if (intArray == null) {
            return new TrackSelectionOverrides.a(trackGroup);
        }
        return new TrackSelectionOverrides.a(trackGroup, intArray.length == 0 ? Collections.emptyList() : new Ints(intArray));
    }
}
