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
import d0.z.d.m;

/* compiled from: AppScrollingViewBehavior.kt */
/* loaded from: classes.dex */
public final class AppScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* renamed from: a, reason: from kotlin metadata */
    public final a onApplyWindowInsetsListener;

    /* compiled from: AppScrollingViewBehavior.kt */
    public static final class a implements OnApplyWindowInsetsListener {
        public Rect a;

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            m.checkNotNullParameter(view, "v");
            m.checkNotNullParameter(windowInsetsCompat, "insets");
            if (this.a == null) {
                this.a = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            }
            Rect rect = this.a;
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
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.onApplyWindowInsetsListener = new a();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        m.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        m.checkNotNullParameter(child, "child");
        m.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        this.onApplyWindowInsetsListener.onApplyWindowInsets(child, insets);
        return insets;
    }
}
