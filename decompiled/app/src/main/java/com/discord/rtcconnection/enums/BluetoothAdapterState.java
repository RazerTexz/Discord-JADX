package com.discord.rtcconnection.enums;


/* compiled from: BluetoothAdapterState.kt */
/* loaded from: classes.dex */
public enum BluetoothAdapterState {
    Off(10),
    On(12),
    TurningOff(13),
    TurningOn(11);

    private final int value;

    BluetoothAdapterState(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
