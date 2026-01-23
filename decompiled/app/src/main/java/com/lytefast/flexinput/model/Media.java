package com.lytefast.flexinput.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: Media.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Media extends Attachment<String> {
    public static final Parcelable.Creator<Media> CREATOR = new C11190a();

    /* JADX INFO: renamed from: j */
    public boolean f22082j;

    /* JADX INFO: renamed from: k */
    public Long f22083k;

    /* JADX INFO: renamed from: com.lytefast.flexinput.model.Media$a */
    /* JADX INFO: compiled from: Media.kt */
    public static final class C11190a implements Parcelable.Creator<Media> {
        @Override // android.os.Parcelable.Creator
        public Media createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            return new Media(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public Media[] newArray(int i) {
            return new Media[i];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Media(long j, Uri uri, String str, String str2, boolean z2, Long l) {
        super(j, uri, str, str2, false, 16, null);
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(str, "displayName");
        this.f22082j = z2;
        this.f22083k = l;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("MediaAttachment(uri=");
        sbM833U.append(getUri());
        sbM833U.append(", duration=");
        sbM833U.append(this.f22083k);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Media(Parcel parcel) {
        super(parcel);
        Intrinsics3.checkNotNullParameter(parcel, "parcelIn");
    }
}
