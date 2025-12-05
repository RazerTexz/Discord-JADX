package p007b.p225i.p226a.p288f.p292c.p293a.p294d;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: b.i.a.f.c.a.d.f */
/* loaded from: classes3.dex */
public final class C3191f implements Parcelable.Creator<CredentialPickerConfig> {
    @Override // android.os.Parcelable.Creator
    public final CredentialPickerConfig createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        int iM437G1 = 0;
        boolean zM431E1 = false;
        boolean zM431E12 = false;
        boolean zM431E13 = false;
        int iM437G12 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zM431E1 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c == 2) {
                zM431E12 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c == 3) {
                zM431E13 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c == 4) {
                iM437G12 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c != 1000) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new CredentialPickerConfig(iM437G1, zM431E1, zM431E12, zM431E13, iM437G12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
