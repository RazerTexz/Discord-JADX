package com.discord.rtcconnection.enums;

import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ThermalStatus.kt */
@RequiresApi(29)
/* loaded from: classes.dex */
public enum ThermalStatus {
    None(0),
    Light(1),
    Moderate(2),
    Severe(3),
    Critical(4),
    Emergency(5),
    Shutdown(6);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: ThermalStatus.kt */
    /* renamed from: com.discord.rtcconnection.enums.ThermalStatus$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final ThermalStatus m8500a(int i) {
            ThermalStatus thermalStatus;
            ThermalStatus[] thermalStatusArrValues = ThermalStatus.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 7) {
                    thermalStatus = null;
                    break;
                }
                thermalStatus = thermalStatusArrValues[i2];
                if (thermalStatus.getValue() == i) {
                    break;
                }
                i2++;
            }
            return thermalStatus != null ? thermalStatus : ThermalStatus.None;
        }
    }

    ThermalStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
