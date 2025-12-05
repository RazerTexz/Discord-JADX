package p007b.p008a.p041q.p042k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;

/* compiled from: OnBluetoothBroadcastListener.kt */
@MainThread
/* renamed from: b.a.q.k0.i, reason: use source file name */
/* loaded from: classes.dex */
public interface OnBluetoothBroadcastListener {
    /* renamed from: a */
    void mo286a(Context context, BluetoothHeadsetAudioState.C5633b c5633b);

    /* renamed from: b */
    void mo287b(BluetoothDevice bluetoothDevice);

    /* renamed from: c */
    void mo288c(BluetoothHeadset bluetoothHeadset);

    /* renamed from: d */
    void mo289d(Context context, BluetoothProfileConnectionState.C5635b c5635b);
}
