package com.discord.utilities.toolbar;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.discord.utilities.dimen.DimenUtils;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ToolbarUtils.kt */
/* renamed from: com.discord.utilities.toolbar.ToolbarUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ToolbarUtils2 {
    public static final View getNavigationIconView(Toolbar toolbar) {
        Intrinsics3.checkNotNullParameter(toolbar, "$this$getNavigationIconView");
        CharSequence navigationContentDescription = toolbar.getNavigationContentDescription();
        boolean z2 = false;
        if (navigationContentDescription != null) {
            if (navigationContentDescription.length() > 0) {
                z2 = true;
            }
        }
        String navigationContentDescription2 = z2 ? toolbar.getNavigationContentDescription() : "navigationIcon";
        toolbar.setNavigationContentDescription(navigationContentDescription2);
        ArrayList<View> arrayList = new ArrayList<>();
        toolbar.findViewsWithText(arrayList, navigationContentDescription2, 2);
        if (!z2) {
            toolbar.setNavigationContentDescription((CharSequence) null);
        }
        return (View) _Collections.firstOrNull((List) arrayList);
    }

    public static final void positionUnreadCountView(Toolbar toolbar, View view) {
        Intrinsics3.checkNotNullParameter(toolbar, "$this$positionUnreadCountView");
        Intrinsics3.checkNotNullParameter(view, "view");
        View navigationIconView = getNavigationIconView(toolbar);
        if (navigationIconView != null) {
            if (!ViewCompat.isLaidOut(navigationIconView) || navigationIconView.isLayoutRequested()) {
                navigationIconView.addOnLayoutChangeListener(new ToolbarUtilsKt$positionUnreadCountView$$inlined$doOnLayout$1(view));
                return;
            }
            int iDpToPixels = DimenUtils.dpToPixels(2);
            int right = navigationIconView.getRight();
            int bottom = navigationIconView.getBottom();
            float f = 2;
            float f2 = iDpToPixels;
            view.setX((right / f) + f2);
            view.setY((bottom / f) + f2);
        }
    }
}
