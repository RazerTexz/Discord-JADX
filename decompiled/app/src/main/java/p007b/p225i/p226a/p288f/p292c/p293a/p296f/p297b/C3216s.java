package p007b.p225i.p226a.p288f.p292c.p293a.p296f.p297b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: b.i.a.f.c.a.f.b.s */
/* loaded from: classes3.dex */
public final class C3216s implements Parcelable.Creator<SignInConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final SignInConfiguration createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                googleSignInOptions = (GoogleSignInOptions) AnimatableValueParser.m465Q(parcel, i, GoogleSignInOptions.CREATOR);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new SignInConfiguration(strM468R, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
