package com.discord.rtcconnection.enums;

import android.os.Build;

/* JADX INFO: compiled from: AudioFocusMode.kt */
/* JADX INFO: loaded from: classes.dex */
public enum AudioFocusMode {
    Gain(1),
    GainTransient(2),
    GainTransientMayDuck(3),
    GainTransientExclusive(4),
    Loss(-1),
    LossTransient(-2),
    LossTransientCanDuck(-3),
    None(0);

    private final int value;

    static {
        int i = Build.VERSION.SDK_INT;
        INSTANCE = new Companion(null);
    }

    AudioFocusMode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
