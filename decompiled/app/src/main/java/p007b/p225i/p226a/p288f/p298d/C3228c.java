package p007b.p225i.p226a.p288f.p298d;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cloudmessaging.CloudMessage;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.c */
/* loaded from: classes3.dex */
public final class C3228c implements Parcelable.Creator<CloudMessage> {
    @Override // android.os.Parcelable.Creator
    public final CloudMessage createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 1) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                intent = (Intent) AnimatableValueParser.m465Q(parcel, i, Intent.CREATOR);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new CloudMessage(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage[] newArray(int i) {
        return new CloudMessage[i];
    }
}
