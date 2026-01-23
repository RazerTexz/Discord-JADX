package com.discord.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.display.DisplayUtils;
import com.google.android.material.appbar.AppBarLayout;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: AppScrollingViewBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final C5456a onApplyWindowInsetsListener;

    /* JADX INFO: renamed from: com.discord.app.AppScrollingViewBehavior$a */
    /* JADX INFO: compiled from: AppScrollingViewBehavior.kt */
    public static final class C5456a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a */
        public Rect f14962a;

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (this.f14962a == null) {
                this.f14962a = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            }
            Rect rect = this.f14962a;
            if (rect == null) {
                rect = new Rect();
            }
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft() + rect.left, rect.top, windowInsetsCompat.getSystemWindowInsetRight() + rect.right, windowInsetsCompat.getSystemWindowInsetTop() + windowInsetsCompat.getSystemWindowInsetBottom() + rect.bottom);
            return windowInsetsCompat;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.onApplyWindowInsetsListener = new C5456a();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        Intrinsics3.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics3.checkNotNullParameter(child, "child");
        Intrinsics3.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        this.onApplyWindowInsetsListener.onApplyWindowInsets(child, insets);
        return insets;
    }
}
