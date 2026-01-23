package p007b.p008a.p041q.p042k0;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.discord.rtcconnection.enums.BluetoothBroadcastAction;
import com.discord.rtcconnection.enums.BluetoothHeadsetAudioState;
import com.discord.rtcconnection.enums.BluetoothProfileConnectionState;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.ThreadUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.k0.c, reason: use source file name */
/* JADX INFO: compiled from: BluetoothBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BluetoothBroadcastReceiver extends BroadcastReceiver implements BluetoothProfile.ServiceListener {

    /* JADX INFO: renamed from: l */
    public boolean f1649l;

    /* JADX INFO: renamed from: m */
    public BluetoothHeadset f1650m;

    /* JADX INFO: renamed from: n */
    public final Context f1651n;

    /* JADX INFO: renamed from: o */
    public final OnBluetoothBroadcastListener f1652o;

    /* JADX INFO: renamed from: k */
    public static final a f1648k = new a(null);

    /* JADX INFO: renamed from: j */
    public static final Set<BluetoothBroadcastAction> f1647j = Sets5.setOf((Object[]) new BluetoothBroadcastAction[]{BluetoothBroadcastAction.HeadsetConnectionStateChanged, BluetoothBroadcastAction.HeadsetAudioStateChanged});

    /* JADX INFO: renamed from: b.a.q.k0.c$a */
    /* JADX INFO: compiled from: BluetoothBroadcastReceiver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public BluetoothBroadcastReceiver(Context context, OnBluetoothBroadcastListener onBluetoothBroadcastListener) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onBluetoothBroadcastListener, "listener");
        this.f1651n = context;
        this.f1652o = onBluetoothBroadcastListener;
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        BluetoothBroadcastAction bluetoothBroadcastAction;
        Intrinsics3.checkNotNullParameter(context, "context");
        ThreadUtils.checkIsOnMainThread();
        if (intent == null) {
            return;
        }
        BluetoothBroadcastAction.Companion companion = BluetoothBroadcastAction.INSTANCE;
        String action = intent.getAction();
        Intrinsics3.checkNotNull(action);
        Intrinsics3.checkNotNullExpressionValue(action, "intent.action!!");
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(action, "action");
        BluetoothBroadcastAction[] bluetoothBroadcastActionArrValues = BluetoothBroadcastAction.values();
        int i = 0;
        while (true) {
            if (i >= 5) {
                bluetoothBroadcastAction = null;
                break;
            }
            bluetoothBroadcastAction = bluetoothBroadcastActionArrValues[i];
            if (Intrinsics3.areEqual(bluetoothBroadcastAction.getAction(), action)) {
                break;
            } else {
                i++;
            }
        }
        if (bluetoothBroadcastAction == null) {
            StringBuilder sbM833U = outline.m833U("unable to parse BluetoothBroadcastAction for action: ");
            sbM833U.append(intent.getAction());
            AnimatableValueParser.m517f1("BluetoothBroadcastReceiver", sbM833U.toString());
            return;
        }
        AnimatableValueParser.m513e1("BluetoothBroadcastReceiver", "onReceive: action = " + bluetoothBroadcastAction);
        try {
            OnBluetoothBroadcastListener onBluetoothBroadcastListener = this.f1652o;
            int iOrdinal = bluetoothBroadcastAction.ordinal();
            if (iOrdinal == 0) {
                onBluetoothBroadcastListener.mo289d(context, BluetoothProfileConnectionState.INSTANCE.m8497b(intent));
            } else if (iOrdinal == 1) {
                onBluetoothBroadcastListener.mo286a(context, BluetoothHeadsetAudioState.INSTANCE.m8495b(intent));
            } else if (iOrdinal != 4) {
                AnimatableValueParser.m517f1("BluetoothBroadcastReceiver", "unexpected " + bluetoothBroadcastAction);
            } else {
                Intrinsics3.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
                onBluetoothBroadcastListener.mo287b((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
            }
        } catch (Throwable th) {
            AnimatableValueParser.m505c1("BluetoothBroadcastReceiver", "error handling " + bluetoothBroadcastAction, th);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        ThreadUtils.checkIsOnMainThread();
        if (i == 1 && this.f1649l) {
            AnimatableValueParser.m501b1("BluetoothBroadcastReceiver", "BluetoothProfile.ServiceListener.onServiceConnected");
            if (!(bluetoothProfile instanceof BluetoothHeadset)) {
                bluetoothProfile = null;
            }
            BluetoothHeadset bluetoothHeadset = (BluetoothHeadset) bluetoothProfile;
            this.f1650m = bluetoothHeadset;
            this.f1652o.mo288c(bluetoothHeadset);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i) {
        ThreadUtils.checkIsOnMainThread();
        if (i == 1 && this.f1649l) {
            AnimatableValueParser.m501b1("BluetoothBroadcastReceiver", "BluetoothProfile.ServiceListener.onServiceDisconnected");
            this.f1650m = null;
            this.f1652o.mo288c(null);
        }
    }
}
