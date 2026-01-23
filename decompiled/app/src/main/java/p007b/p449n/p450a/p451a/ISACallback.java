package p007b.p449n.p450a.p451a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.widgets.chat.input.MentionUtils;
import p007b.p008a.p048r.SamsungConnectActivity3;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p579g0._Strings;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.n.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: ISACallback.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ISACallback extends IInterface {

    /* JADX INFO: renamed from: b.n.a.a.a$a */
    /* JADX INFO: compiled from: ISACallback.java */
    public static abstract class a extends Binder implements ISACallback {
        public a() {
            attachInterface(this, "com.msc.sa.aidl.ISACallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
        @Override // android.os.Binder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.msc.sa.aidl.ISACallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceiveAccessToken");
                case 2:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceiveAccessToken");
                case 3:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceiveDisclaimerAgreement");
                case 4:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    boolean z2 = parcel.readInt() != 0;
                    Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                    SamsungConnectActivity3 samsungConnectActivity3 = (SamsungConnectActivity3) this;
                    String string = bundle != null ? bundle.getString("authcode") : null;
                    String string2 = bundle != null ? bundle.getString("auth_server_url") : null;
                    Log.i("Discord", "Samsung onReceiveAuthCode=" + z2);
                    if (z2) {
                        if (string == null || StringsJVM.isBlank(string)) {
                        }
                    } else {
                        String string3 = bundle != null ? bundle.getString("error_code") : null;
                        String string4 = bundle != null ? bundle.getString("error_message") : null;
                        StringBuilder sbM833U = outline.m833U("Samsung Account link failure ");
                        StringBuilder sb = new StringBuilder();
                        sb.append('[');
                        sb.append(string3);
                        sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                        sb.append(string != null ? _Strings.takeLast(string, 4) : null);
                        sb.append("]: ");
                        sb.append(string4);
                        sbM833U.append(sb.toString());
                        String string5 = sbM833U.toString();
                        Intrinsics3.checkNotNullExpressionValue(string5, "StringBuilder()\n        …              .toString()");
                        Log.w("Discord", string5);
                    }
                    SamsungConnectActivity.m8503a(samsungConnectActivity3.f1876a, string, string2);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceiveSCloudAccessToken");
                case 6:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceivePasswordConfirmation");
                case 7:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceiveRLControlFMM");
                case 8:
                    parcel.enforceInterface("com.msc.sa.aidl.ISACallback");
                    parcel.readInt();
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                    }
                    throw new IllegalStateException("Unexpected call to onReceiveRubinRequest");
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
