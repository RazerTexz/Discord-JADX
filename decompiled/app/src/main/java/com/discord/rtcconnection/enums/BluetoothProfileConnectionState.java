package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import b.c.a.a0.d;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BluetoothProfileConnectionState.kt */
/* loaded from: classes.dex */
public enum BluetoothProfileConnectionState {
    Disconnected(0),
    Connecting(1),
    Connected(2),
    Disconnecting(3);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: BluetoothProfileConnectionState.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothProfileConnectionState$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BluetoothProfileConnectionState a(int i) {
            BluetoothProfileConnectionState[] bluetoothProfileConnectionStateArrValues = BluetoothProfileConnectionState.values();
            for (int i2 = 0; i2 < 4; i2++) {
                BluetoothProfileConnectionState bluetoothProfileConnectionState = bluetoothProfileConnectionStateArrValues[i2];
                if (bluetoothProfileConnectionState.getValue() == i) {
                    return bluetoothProfileConnectionState;
                }
            }
            return null;
        }

        public final b b(Intent intent) {
            m.checkNotNullParameter(intent, "intent");
            if (!m.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Integer numX0 = d.x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothProfileConnectionState bluetoothProfileConnectionStateA = numX0 != null ? BluetoothProfileConnectionState.INSTANCE.a(numX0.intValue()) : null;
            Integer numX02 = d.x0(intent, "android.bluetooth.profile.extra.STATE");
            return new b(bluetoothProfileConnectionStateA, numX02 != null ? BluetoothProfileConnectionState.INSTANCE.a(numX02.intValue()) : null, (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
        }
    }

    /* compiled from: BluetoothProfileConnectionState.kt */
    public static final class b {
        public final BluetoothProfileConnectionState a;

        /* renamed from: b, reason: collision with root package name */
        public final BluetoothProfileConnectionState f2791b;
        public final BluetoothDevice c;

        public b(BluetoothProfileConnectionState bluetoothProfileConnectionState, BluetoothProfileConnectionState bluetoothProfileConnectionState2, BluetoothDevice bluetoothDevice) {
            this.a = bluetoothProfileConnectionState;
            this.f2791b = bluetoothProfileConnectionState2;
            this.c = bluetoothDevice;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.areEqual(this.a, bVar.a) && m.areEqual(this.f2791b, bVar.f2791b) && m.areEqual(this.c, bVar.c);
        }

        public int hashCode() {
            BluetoothProfileConnectionState bluetoothProfileConnectionState = this.a;
            int iHashCode = (bluetoothProfileConnectionState != null ? bluetoothProfileConnectionState.hashCode() : 0) * 31;
            BluetoothProfileConnectionState bluetoothProfileConnectionState2 = this.f2791b;
            int iHashCode2 = (iHashCode + (bluetoothProfileConnectionState2 != null ? bluetoothProfileConnectionState2.hashCode() : 0)) * 31;
            BluetoothDevice bluetoothDevice = this.c;
            return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Update(previous=");
            sbU.append(this.a);
            sbU.append(", current=");
            sbU.append(this.f2791b);
            sbU.append(", device=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    BluetoothProfileConnectionState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
