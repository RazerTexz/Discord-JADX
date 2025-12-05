package com.discord.dialogs;

import android.os.Parcel;
import android.os.Parcelable;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SimpleConfirmationDialog.kt */
/* renamed from: com.discord.dialogs.SimpleConfirmationDialogArgs, reason: use source file name */
/* loaded from: classes.dex */
public final class SimpleConfirmationDialog2 implements Parcelable {
    public static final Parcelable.Creator<SimpleConfirmationDialog2> CREATOR = new C5479a();

    /* renamed from: j */
    public final String f18504j;

    /* renamed from: k */
    public final String f18505k;

    /* renamed from: l */
    public final String f18506l;

    /* renamed from: m */
    public final String f18507m;

    /* renamed from: com.discord.dialogs.SimpleConfirmationDialogArgs$a */
    public static class C5479a implements Parcelable.Creator<SimpleConfirmationDialog2> {
        @Override // android.os.Parcelable.Creator
        public SimpleConfirmationDialog2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new SimpleConfirmationDialog2(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public SimpleConfirmationDialog2[] newArray(int i) {
            return new SimpleConfirmationDialog2[i];
        }
    }

    public SimpleConfirmationDialog2(String str, String str2, String str3, String str4) {
        this.f18504j = str;
        this.f18505k = str2;
        this.f18506l = str3;
        this.f18507m = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleConfirmationDialog2)) {
            return false;
        }
        SimpleConfirmationDialog2 simpleConfirmationDialog2 = (SimpleConfirmationDialog2) obj;
        return Intrinsics3.areEqual(this.f18504j, simpleConfirmationDialog2.f18504j) && Intrinsics3.areEqual(this.f18505k, simpleConfirmationDialog2.f18505k) && Intrinsics3.areEqual(this.f18506l, simpleConfirmationDialog2.f18506l) && Intrinsics3.areEqual(this.f18507m, simpleConfirmationDialog2.f18507m);
    }

    public int hashCode() {
        String str = this.f18504j;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f18505k;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f18506l;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f18507m;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("SimpleConfirmationDialogArgs(title=");
        sbM833U.append(this.f18504j);
        sbM833U.append(", description=");
        sbM833U.append(this.f18505k);
        sbM833U.append(", positiveButtonText=");
        sbM833U.append(this.f18506l);
        sbM833U.append(", negativeButtonText=");
        return outline.m822J(sbM833U, this.f18507m, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.f18504j);
        parcel.writeString(this.f18505k);
        parcel.writeString(this.f18506l);
        parcel.writeString(this.f18507m);
    }

    public SimpleConfirmationDialog2() {
        this(null, null, null, null);
    }
}
