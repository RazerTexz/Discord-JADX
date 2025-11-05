package com.discord.widgets.channels.list;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemChannelCategory$onConfigure$3 extends AccessibilityDelegateCompat {
    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        Intrinsics3.checkNotNullParameter(host, "host");
        Intrinsics3.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        info.setHeading(true);
    }
}
