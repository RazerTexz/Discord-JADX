package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BluetoothHeadsetAudioState.kt */
/* loaded from: classes.dex */
public enum BluetoothHeadsetAudioState {
    Disconnected(10),
    Connecting(11),
    Connected(12);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: BluetoothHeadsetAudioState.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final BluetoothHeadsetAudioState m8494a(int i) {
            BluetoothHeadsetAudioState[] bluetoothHeadsetAudioStateArrValues = BluetoothHeadsetAudioState.values();
            for (int i2 = 0; i2 < 3; i2++) {
                BluetoothHeadsetAudioState bluetoothHeadsetAudioState = bluetoothHeadsetAudioStateArrValues[i2];
                if (bluetoothHeadsetAudioState.getValue() == i) {
                    return bluetoothHeadsetAudioState;
                }
            }
            return null;
        }

        /* renamed from: b */
        public final C5633b m8495b(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "intent");
            if (!Intrinsics3.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Intrinsics3.checkNotNullParameter(intent, "$this$getBluetoothDeviceExtra");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            Integer numM588x0 = AnimatableValueParser.m588x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothHeadsetAudioState bluetoothHeadsetAudioStateM8494a = numM588x0 != null ? BluetoothHeadsetAudioState.INSTANCE.m8494a(numM588x0.intValue()) : null;
            Integer numM588x02 = AnimatableValueParser.m588x0(intent, "android.bluetooth.profile.extra.STATE");
            return new C5633b(numM588x02 != null ? BluetoothHeadsetAudioState.INSTANCE.m8494a(numM588x02.intValue()) : null, bluetoothHeadsetAudioStateM8494a, bluetoothDevice);
        }
    }

    /* compiled from: BluetoothHeadsetAudioState.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothHeadsetAudioState$b */
    public static final class C5633b {

        /* renamed from: a */
        public final BluetoothHeadsetAudioState f18868a;

        /* renamed from: b */
        public final BluetoothHeadsetAudioState f18869b;

        /* renamed from: c */
        public final BluetoothDevice f18870c;

        public C5633b(BluetoothHeadsetAudioState bluetoothHeadsetAudioState, BluetoothHeadsetAudioState bluetoothHeadsetAudioState2, BluetoothDevice bluetoothDevice) {
            this.f18868a = bluetoothHeadsetAudioState;
            this.f18869b = bluetoothHeadsetAudioState2;
            this.f18870c = bluetoothDevice;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5633b)) {
                return false;
            }
            C5633b c5633b = (C5633b) obj;
            return Intrinsics3.areEqual(this.f18868a, c5633b.f18868a) && Intrinsics3.areEqual(this.f18869b, c5633b.f18869b) && Intrinsics3.areEqual(this.f18870c, c5633b.f18870c);
        }

        public int hashCode() {
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState = this.f18868a;
            int iHashCode = (bluetoothHeadsetAudioState != null ? bluetoothHeadsetAudioState.hashCode() : 0) * 31;
            BluetoothHeadsetAudioState bluetoothHeadsetAudioState2 = this.f18869b;
            int iHashCode2 = (iHashCode + (bluetoothHeadsetAudioState2 != null ? bluetoothHeadsetAudioState2.hashCode() : 0)) * 31;
            BluetoothDevice bluetoothDevice = this.f18870c;
            return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Update(current=");
            sbM833U.append(this.f18868a);
            sbM833U.append(", previous=");
            sbM833U.append(this.f18869b);
            sbM833U.append(", device=");
            sbM833U.append(this.f18870c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    BluetoothHeadsetAudioState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
