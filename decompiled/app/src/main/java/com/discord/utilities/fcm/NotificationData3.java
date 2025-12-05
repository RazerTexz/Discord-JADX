package com.discord.utilities.fcm;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NotificationData.kt */
/* renamed from: com.discord.utilities.fcm.NotificationType, reason: use source file name */
/* loaded from: classes2.dex */
public enum NotificationData3 {
    Reminder(NotificationCompat.CATEGORY_REMINDER);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String value;

    /* compiled from: NotificationData.kt */
    /* renamed from: com.discord.utilities.fcm.NotificationType$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final NotificationData3 parse(String value) {
            NotificationData3[] notificationData3ArrValues = NotificationData3.values();
            for (int i = 0; i < 1; i++) {
                NotificationData3 notificationData3 = notificationData3ArrValues[i];
                if (Intrinsics3.areEqual(notificationData3.getValue(), value)) {
                    return notificationData3;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    NotificationData3(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
