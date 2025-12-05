package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p333j.p334b.C4322f;

/* loaded from: classes3.dex */
public class Message extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Message> CREATOR = new C4322f();

    /* renamed from: j */
    public static final zzgs[] f20711j = {zzgs.f20644j};

    /* renamed from: k */
    public final int f20712k;

    /* renamed from: l */
    public final byte[] f20713l;

    /* renamed from: m */
    public final String f20714m;

    /* renamed from: n */
    public final String f20715n;

    /* renamed from: o */
    @Deprecated
    public final zzgs[] f20716o;

    /* renamed from: p */
    public final long f20717p;

    public Message(int i, @Nullable byte[] bArr, @Nullable String str, String str2, @Nullable zzgs[] zzgsVarArr, long j) {
        this.f20712k = i;
        Objects.requireNonNull(str2, "null reference");
        this.f20714m = str2;
        this.f20715n = str == null ? "" : str;
        this.f20717p = j;
        Objects.requireNonNull(bArr, "null reference");
        AnimatableValueParser.m547n(bArr.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(bArr.length), 102400);
        this.f20713l = bArr;
        this.f20716o = (zzgsVarArr == null || zzgsVarArr.length == 0) ? f20711j : zzgsVarArr;
        AnimatableValueParser.m547n(str2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(str2.length()), 32);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        return TextUtils.equals(this.f20715n, message.f20715n) && TextUtils.equals(this.f20714m, message.f20714m) && Arrays.equals(this.f20713l, message.f20713l) && this.f20717p == message.f20717p;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20715n, this.f20714m, Integer.valueOf(Arrays.hashCode(this.f20713l)), Long.valueOf(this.f20717p)});
    }

    public String toString() {
        String str = this.f20715n;
        String str2 = this.f20714m;
        byte[] bArr = this.f20713l;
        int length = bArr == null ? 0 : bArr.length;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str2, outline.m841b(str, 59)), "Message{namespace='", str, "', type='", str2);
        sbM831S.append("', content=[");
        sbM831S.append(length);
        sbM831S.append(" bytes]}");
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m562q2(parcel, 1, this.f20713l, false);
        AnimatableValueParser.m574t2(parcel, 2, this.f20714m, false);
        AnimatableValueParser.m574t2(parcel, 3, this.f20715n, false);
        AnimatableValueParser.m582v2(parcel, 4, this.f20716o, i, false);
        long j = this.f20717p;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        int i2 = this.f20712k;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
