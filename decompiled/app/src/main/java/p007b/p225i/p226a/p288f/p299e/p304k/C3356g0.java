package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.e.k.g0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3356g0 implements Parcelable.Creator<RootTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final RootTelemetryConfiguration createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E12 = false;
        int iM437G12 = 0;
        int iM437G13 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c == 2) {
                zM431E1 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c == 3) {
                zM431E12 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c == 4) {
                iM437G12 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                iM437G13 = AnimatableValueParser.m437G1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new RootTelemetryConfiguration(iM437G1, zM431E1, zM431E12, iM437G12, iM437G13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ RootTelemetryConfiguration[] newArray(int i) {
        return new RootTelemetryConfiguration[i];
    }
}
