package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.esotericsoftware.kryo.Kryo;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p326m.C3928e;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4291k0;

/* loaded from: classes3.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new C4291k0();

    /* renamed from: j */
    public final int f20764j;

    /* renamed from: k */
    public final int f20765k;

    /* renamed from: l */
    public final Message f20766l;

    /* renamed from: m */
    @Nullable
    public final zze f20767m;

    /* renamed from: n */
    @Nullable
    public final zza f20768n;

    /* renamed from: o */
    @Nullable
    public final zzgs f20769o;

    /* renamed from: p */
    @Nullable
    public final byte[] f20770p;

    public Update(int i, int i2, Message message, @Nullable zze zzeVar, @Nullable zza zzaVar, @Nullable zzgs zzgsVar, @Nullable byte[] bArr) {
        this.f20764j = i;
        if ((i2 & 2) != 0) {
            i2 = 2;
            zzeVar = null;
            zzaVar = null;
            zzgsVar = null;
            bArr = null;
        }
        this.f20765k = i2;
        this.f20766l = message;
        this.f20767m = zzeVar;
        this.f20768n = zzaVar;
        this.f20769o = zzgsVar;
        this.f20770p = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.f20765k == update.f20765k && AnimatableValueParser.m524h0(this.f20766l, update.f20766l) && AnimatableValueParser.m524h0(this.f20767m, update.f20767m) && AnimatableValueParser.m524h0(this.f20768n, update.f20768n) && AnimatableValueParser.m524h0(this.f20769o, update.f20769o) && Arrays.equals(this.f20770p, update.f20770p);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20765k), this.f20766l, this.f20767m, this.f20768n, this.f20769o, this.f20770p});
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x00af. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String str;
        byte[] bArr;
        ArraySet arraySet = new ArraySet();
        if (m9123w0(1)) {
            arraySet.add("FOUND");
        }
        if (m9123w0(2)) {
            arraySet.add("LOST");
        }
        if (m9123w0(4)) {
            arraySet.add("DISTANCE");
        }
        if (m9123w0(8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (m9123w0(16)) {
            arraySet.add("DEVICE");
        }
        if (m9123w0(32)) {
            arraySet.add("BLE_RECORD");
        }
        String strValueOf = String.valueOf(arraySet);
        String strValueOf2 = String.valueOf(this.f20766l);
        String strValueOf3 = String.valueOf(this.f20767m);
        String strValueOf4 = String.valueOf(this.f20768n);
        String strValueOf5 = String.valueOf(this.f20769o);
        byte[] bArr2 = this.f20770p;
        ParcelUuid parcelUuid = C3928e.f10450a;
        C3928e c3928e = null;
        if (bArr2 == null) {
            str = strValueOf5;
        } else {
            int i = 0;
            ArrayList arrayList = new ArrayList();
            SparseArray sparseArray = new SparseArray();
            HashMap map = new HashMap();
            String str2 = null;
            int i2 = -1;
            byte b2 = Kryo.NULL;
            try {
                while (i < bArr2.length) {
                    try {
                        int i3 = i + 1;
                        int i4 = bArr2[i] & 255;
                        if (i4 != 0) {
                            int i5 = i4 - 1;
                            int i6 = i3 + 1;
                            int i7 = bArr2[i3] & 255;
                            str = strValueOf5;
                            if (i7 == 22) {
                                map.put(C3928e.m5405c(C3928e.m5404b(bArr2, i6, 2)), C3928e.m5404b(bArr2, i6 + 2, i5 - 2));
                            } else if (i7 != 255) {
                                switch (i7) {
                                    case 1:
                                        i2 = bArr2[i6] & 255;
                                        break;
                                    case 2:
                                    case 3:
                                        C3928e.m5403a(bArr2, i6, i5, 2, arrayList);
                                        break;
                                    case 4:
                                    case 5:
                                        C3928e.m5403a(bArr2, i6, i5, 4, arrayList);
                                        break;
                                    case 6:
                                    case 7:
                                        C3928e.m5403a(bArr2, i6, i5, 16, arrayList);
                                        break;
                                    case 8:
                                    case 9:
                                        str2 = new String(C3928e.m5404b(bArr2, i6, i5));
                                        break;
                                    case 10:
                                        try {
                                            b2 = bArr2[i6];
                                        } catch (Exception e) {
                                            e = e;
                                            bArr = bArr2;
                                            String strValueOf6 = String.valueOf(Arrays.toString(bArr));
                                            Log.w("BleRecord", strValueOf6.length() == 0 ? "Unable to parse scan record: ".concat(strValueOf6) : new String("Unable to parse scan record: "), e);
                                            String strValueOf7 = String.valueOf(c3928e);
                                            StringBuilder sbM831S = outline.m831S(strValueOf7.length() + str.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 68, "Update{types=", strValueOf, ", message=", strValueOf2);
                                            outline.m876s0(sbM831S, ", distance=", strValueOf3, ", bleSignal=", strValueOf4);
                                            outline.m876s0(sbM831S, ", device=", str, ", bleRecord=", strValueOf7);
                                            sbM831S.append("}");
                                            return sbM831S.toString();
                                        }
                                        break;
                                }
                            } else {
                                sparseArray.put(((bArr2[i6 + 1] & 255) << 8) + (bArr2[i6] & 255), C3928e.m5404b(bArr2, i6 + 2, i5 - 2));
                            }
                            i = i5 + i6;
                            strValueOf5 = str;
                        } else {
                            str = strValueOf5;
                            bArr = bArr2;
                            c3928e = new C3928e(!arrayList.isEmpty() ? null : arrayList, sparseArray, map, i2, b2, str2, bArr2);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = strValueOf5;
                    }
                }
                c3928e = new C3928e(!arrayList.isEmpty() ? null : arrayList, sparseArray, map, i2, b2, str2, bArr2);
            } catch (Exception e3) {
                e = e3;
                String strValueOf62 = String.valueOf(Arrays.toString(bArr));
                Log.w("BleRecord", strValueOf62.length() == 0 ? "Unable to parse scan record: ".concat(strValueOf62) : new String("Unable to parse scan record: "), e);
                String strValueOf72 = String.valueOf(c3928e);
                StringBuilder sbM831S2 = outline.m831S(strValueOf72.length() + str.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 68, "Update{types=", strValueOf, ", message=", strValueOf2);
                outline.m876s0(sbM831S2, ", distance=", strValueOf3, ", bleSignal=", strValueOf4);
                outline.m876s0(sbM831S2, ", device=", str, ", bleRecord=", strValueOf72);
                sbM831S2.append("}");
                return sbM831S2.toString();
            }
            str = strValueOf5;
            bArr = bArr2;
        }
        String strValueOf722 = String.valueOf(c3928e);
        StringBuilder sbM831S22 = outline.m831S(strValueOf722.length() + str.length() + strValueOf4.length() + strValueOf3.length() + strValueOf2.length() + strValueOf.length() + 68, "Update{types=", strValueOf, ", message=", strValueOf2);
        outline.m876s0(sbM831S22, ", distance=", strValueOf3, ", bleSignal=", strValueOf4);
        outline.m876s0(sbM831S22, ", device=", str, ", bleRecord=", strValueOf722);
        sbM831S22.append("}");
        return sbM831S22.toString();
    }

    /* renamed from: w0 */
    public final boolean m9123w0(int i) {
        return (i & this.f20765k) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        int i2 = this.f20764j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = this.f20765k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        AnimatableValueParser.m570s2(parcel, 3, this.f20766l, i, false);
        AnimatableValueParser.m570s2(parcel, 4, this.f20767m, i, false);
        AnimatableValueParser.m570s2(parcel, 5, this.f20768n, i, false);
        AnimatableValueParser.m570s2(parcel, 6, this.f20769o, i, false);
        AnimatableValueParser.m562q2(parcel, 7, this.f20770p, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
