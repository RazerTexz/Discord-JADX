package p007b.p225i.p361c.p391o.p392b;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.dynamiclinks.internal.zzo;
import com.google.firebase.dynamiclinks.internal.zzr;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* renamed from: b.i.c.o.b.m */
/* loaded from: classes3.dex */
public final class C4780m implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final zzo createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        Uri uri = null;
        Uri uri2 = null;
        ArrayList arrayListM480V = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                uri = (Uri) AnimatableValueParser.m465Q(parcel, i, Uri.CREATOR);
            } else if (c == 2) {
                uri2 = (Uri) AnimatableValueParser.m465Q(parcel, i, Uri.CREATOR);
            } else if (c != 3) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                arrayListM480V = AnimatableValueParser.m480V(parcel, i, zzr.CREATOR);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzo(uri, uri2, arrayListM480V);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
