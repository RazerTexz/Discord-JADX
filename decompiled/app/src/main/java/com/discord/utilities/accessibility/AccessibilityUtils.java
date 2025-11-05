package com.discord.utilities.accessibility;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.StringRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;

/* compiled from: AccessibilityUtils.kt */
/* loaded from: classes2.dex */
public final class AccessibilityUtils {
    public static final AccessibilityUtils INSTANCE = new AccessibilityUtils();

    /* compiled from: AccessibilityUtils.kt */
    /* renamed from: com.discord.utilities.accessibility.AccessibilityUtils$setViewIsHeading$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            Intrinsics3.checkNotNullParameter(host, "host");
            Intrinsics3.checkNotNullParameter(info, "info");
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setHeading(true);
        }
    }

    private AccessibilityUtils() {
    }

    public final boolean isReducedMotionEnabled() {
        return StoreStream.INSTANCE.getAccessibility().getReducedMotionEnabled();
    }

    public final void sendAnnouncement(Context context, @StringRes int message) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(message);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(message)");
        sendAnnouncement(context, string);
    }

    public final void setViewIsHeading(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        ViewCompat.setAccessibilityDelegate(view, new AnonymousClass1());
    }

    public final void sendAnnouncement(Context context, String message) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            Intrinsics3.checkNotNullExpressionValue(accessibilityEventObtain, "event");
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.getText().add(message);
            try {
                accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
            } catch (IllegalStateException unused) {
            }
        }
    }
}
