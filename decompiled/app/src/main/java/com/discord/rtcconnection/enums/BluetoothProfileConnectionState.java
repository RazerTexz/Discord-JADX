package com.discord.rtcconnection.enums;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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

        /* renamed from: a */
        public final BluetoothProfileConnectionState m8496a(int i) {
            BluetoothProfileConnectionState[] bluetoothProfileConnectionStateArrValues = BluetoothProfileConnectionState.values();
            for (int i2 = 0; i2 < 4; i2++) {
                BluetoothProfileConnectionState bluetoothProfileConnectionState = bluetoothProfileConnectionStateArrValues[i2];
                if (bluetoothProfileConnectionState.getValue() == i) {
                    return bluetoothProfileConnectionState;
                }
            }
            return null;
        }

        /* renamed from: b */
        public final C5635b m8497b(Intent intent) {
            Intrinsics3.checkNotNullParameter(intent, "intent");
            if (!Intrinsics3.areEqual(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Integer numM588x0 = AnimatableValueParser.m588x0(intent, "android.bluetooth.profile.extra.PREVIOUS_STATE");
            BluetoothProfileConnectionState bluetoothProfileConnectionStateM8496a = numM588x0 != null ? BluetoothProfileConnectionState.INSTANCE.m8496a(numM588x0.intValue()) : null;
            Integer numM588x02 = AnimatableValueParser.m588x0(intent, "android.bluetooth.profile.extra.STATE");
            return new C5635b(bluetoothProfileConnectionStateM8496a, numM588x02 != null ? BluetoothProfileConnectionState.INSTANCE.m8496a(numM588x02.intValue()) : null, (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
        }
    }

    /* compiled from: BluetoothProfileConnectionState.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothProfileConnectionState$b */
    public static final class C5635b {

        /* renamed from: a */
        public final BluetoothProfileConnectionState f18871a;

        /* renamed from: b */
        public final BluetoothProfileConnectionState f18872b;

        /* renamed from: c */
        public final BluetoothDevice f18873c;

        public C5635b(BluetoothProfileConnectionState bluetoothProfileConnectionState, BluetoothProfileConnectionState bluetoothProfileConnectionState2, BluetoothDevice bluetoothDevice) {
            this.f18871a = bluetoothProfileConnectionState;
            this.f18872b = bluetoothProfileConnectionState2;
            this.f18873c = bluetoothDevice;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C5635b)) {
                return false;
            }
            C5635b c5635b = (C5635b) obj;
            return Intrinsics3.areEqual(this.f18871a, c5635b.f18871a) && Intrinsics3.areEqual(this.f18872b, c5635b.f18872b) && Intrinsics3.areEqual(this.f18873c, c5635b.f18873c);
        }

        public int hashCode() {
            BluetoothProfileConnectionState bluetoothProfileConnectionState = this.f18871a;
            int iHashCode = (bluetoothProfileConnectionState != null ? bluetoothProfileConnectionState.hashCode() : 0) * 31;
            BluetoothProfileConnectionState bluetoothProfileConnectionState2 = this.f18872b;
            int iHashCode2 = (iHashCode + (bluetoothProfileConnectionState2 != null ? bluetoothProfileConnectionState2.hashCode() : 0)) * 31;
            BluetoothDevice bluetoothDevice = this.f18873c;
            return iHashCode2 + (bluetoothDevice != null ? bluetoothDevice.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Update(previous=");
            sbM833U.append(this.f18871a);
            sbM833U.append(", current=");
            sbM833U.append(this.f18872b);
            sbM833U.append(", device=");
            sbM833U.append(this.f18873c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    BluetoothProfileConnectionState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
