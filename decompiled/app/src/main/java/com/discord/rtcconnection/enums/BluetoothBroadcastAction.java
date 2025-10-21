package com.discord.rtcconnection.enums;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BluetoothBroadcastAction.kt */
/* loaded from: classes.dex */
public enum BluetoothBroadcastAction {
    HeadsetConnectionStateChanged("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"),
    HeadsetAudioStateChanged("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"),
    AdapterConnectionStateChanged("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED"),
    AdapterStateChanged("android.bluetooth.adapter.action.STATE_CHANGED"),
    ActiveDeviceChanged("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String action;

    /* compiled from: BluetoothBroadcastAction.kt */
    /* renamed from: com.discord.rtcconnection.enums.BluetoothBroadcastAction$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    BluetoothBroadcastAction(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}
