package b.a.q.k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;

/* compiled from: OnBluetoothBroadcastListener.kt */
@MainThread
/* loaded from: classes.dex */
public interface i {
    void a(Context context, BluetoothHeadsetAudioState.b bVar);

    void b(BluetoothDevice bluetoothDevice);

    void c(BluetoothHeadset bluetoothHeadset);

    void d(Context context, BluetoothProfileConnectionState.b bVar);
}
