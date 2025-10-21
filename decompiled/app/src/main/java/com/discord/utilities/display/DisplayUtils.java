package com.discord.utilities.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.OnApplyWindowInsetsListener;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* compiled from: DisplayUtils.kt */
/* loaded from: classes2.dex */
public final class DisplayUtils {
    private static final OnApplyWindowInsetsListener NO_OP_WINDOW_INSETS_LISTENER = DisplayUtils2.INSTANCE;

    public static final void drawUnderSystemBars(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.setFitsSystemWindows(true);
        view.setSystemUiVisibility(view.getSystemUiVisibility() | 1792);
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private static final Display getDisplayCompat(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = context.getDisplay();
            Intrinsics3.checkNotNull(display);
            Intrinsics3.checkNotNullExpressionValue(display, "display!!");
            return display;
        }
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics3.checkNotNullExpressionValue(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return defaultDisplay;
    }

    public static final OnApplyWindowInsetsListener getNO_OP_WINDOW_INSETS_LISTENER() {
        return NO_OP_WINDOW_INSETS_LISTENER;
    }

    public static final int getNavigationBarHeight(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final float getScreenRefreshRate(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return getDisplayCompat(context).getRefreshRate();
    }

    public static final Rect getScreenSize(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
        int i = resources.getDisplayMetrics().widthPixels;
        Resources resources2 = context.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "context.resources");
        return new Rect(0, 0, i, resources2.getDisplayMetrics().heightPixels);
    }

    public static final int getStatusBarHeight(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final boolean hasNavigationBar(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        return identifier > 0 && resources.getBoolean(identifier);
    }

    public static final boolean isGestureNavigationEnabled(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        int identifier = resources.getIdentifier("config_navBarInteractionMode", "integer", "android");
        Integer numValueOf = identifier > 0 ? Integer.valueOf(resources.getInteger(identifier)) : null;
        return numValueOf != null && numValueOf.intValue() == 2;
    }

    public static final Rect resizeToFit(Rect rect, Rect rect2) {
        Intrinsics3.checkNotNullParameter(rect, "in");
        Intrinsics3.checkNotNullParameter(rect2, "bounds");
        int iWidth = rect.width();
        int iHeight = rect.height();
        if (iWidth > rect2.width()) {
            iHeight = (int) ((rect2.width() / iWidth) * iHeight);
            iWidth = rect2.width();
        }
        if (iHeight > rect2.height()) {
            iWidth = (int) ((rect2.height() / iHeight) * iWidth);
            iHeight = rect2.height();
        }
        return new Rect(0, 0, iWidth, iHeight);
    }

    public static final Rect resizeToFitScreen(Context context, Rect rect) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(rect, "in");
        return resizeToFit(rect, getScreenSize(context));
    }
}
