package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationData.kt */
/* loaded from: classes2.dex */
public enum NotificationType {
    Reminder(NotificationCompat.CATEGORY_REMINDER);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* compiled from: NotificationData.kt */
    public static final class Companion {
        private Companion() {
        }

        public final NotificationType parse(String value) {
            NotificationType[] notificationTypeArrValues = NotificationType.values();
            for (int i = 0; i < 1; i++) {
                NotificationType notificationType = notificationTypeArrValues[i];
                if (m.areEqual(notificationType.getValue(), value)) {
                    return notificationType;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    NotificationType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
