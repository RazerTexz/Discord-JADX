package com.discord.models.domain;

import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;

/* compiled from: NotificationSettingsModelUtils.kt */
/* loaded from: classes.dex */
public final class NotificationSettingsModelUtils {
    public static final NotificationSettingsModelUtils INSTANCE = new NotificationSettingsModelUtils();

    private NotificationSettingsModelUtils() {
    }

    public static final boolean isMuted(boolean muted, ModelMuteConfig muteConfig, Clock clock) {
        Long endTimeMs;
        Intrinsics3.checkNotNullParameter(clock, "clock");
        return muted && !(muteConfig != null && (endTimeMs = muteConfig.getEndTimeMs()) != null && (endTimeMs.longValue() > clock.currentTimeMillis() ? 1 : (endTimeMs.longValue() == clock.currentTimeMillis() ? 0 : -1)) <= 0);
    }
}
