package p007b.p225i.p226a.p242c.p243a3.p244p0;

import android.os.Bundle;
import java.util.ArrayList;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p243a3.p244p0.AdPlaybackState;

/* compiled from: lambda */
/* renamed from: b.i.a.c.a3.p0.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2561b implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2561b f5679a = new C2561b();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        AdPlaybackState.a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(AdPlaybackState.m2577b(1));
        if (parcelableArrayList == null) {
            aVarArr = new AdPlaybackState.a[0];
        } else {
            AdPlaybackState.a[] aVarArr2 = new AdPlaybackState.a[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                int i2 = AdPlaybackState.a.f5689j;
                aVarArr2[i] = (AdPlaybackState.a) C2560a.f5678a.mo2576a((Bundle) parcelableArrayList.get(i));
            }
            aVarArr = aVarArr2;
        }
        return new AdPlaybackState(null, aVarArr, bundle.getLong(AdPlaybackState.m2577b(2), 0L), bundle.getLong(AdPlaybackState.m2577b(3), -9223372036854775807L), bundle.getInt(AdPlaybackState.m2577b(4)));
    }
}
