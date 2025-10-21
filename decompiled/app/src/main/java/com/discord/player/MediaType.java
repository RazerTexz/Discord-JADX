package com.discord.player;

import android.os.Parcel;
import android.os.Parcelable;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MediaType.kt */
/* loaded from: classes.dex */
public enum MediaType implements Parcelable {
    VIDEO,
    GIFV;


    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: MediaType.kt */
    /* renamed from: com.discord.player.MediaType$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<MediaType> {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @Override // android.os.Parcelable.Creator
        public MediaType createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            Intrinsics3.checkNotNull(string);
            Intrinsics3.checkNotNullExpressionValue(string, "parcel.readString()!!");
            return MediaType.valueOf(string);
        }

        @Override // android.os.Parcelable.Creator
        public MediaType[] newArray(int i) {
            return new MediaType[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(name());
    }
}
