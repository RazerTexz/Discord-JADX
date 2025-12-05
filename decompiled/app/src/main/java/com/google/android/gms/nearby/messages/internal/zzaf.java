package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4278e;

/* loaded from: classes3.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new C4278e();

    /* renamed from: j */
    public final int f20777j;

    /* renamed from: k */
    public final Message f20778k;

    public zzaf(int i, Message message) {
        this.f20777j = i;
        Objects.requireNonNull(message, "null reference");
        this.f20778k = message;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaf) {
            return AnimatableValueParser.m524h0(this.f20778k, ((zzaf) obj).f20778k);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20778k});
    }

    public final String toString() {
        String string = this.f20778k.toString();
        return outline.m859k(outline.m841b(string, 24), "MessageWrapper{message=", string, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m570s2(parcel, 1, this.f20778k, i, false);
        int i2 = this.f20777j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
