package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: View.kt */
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareSheet$configureEmptyStateUI$$inlined$doOnLayout$1 */
/* loaded from: classes2.dex */
public final class ViewOnLayoutChangeListenerC8696x3bab2b2c implements View.OnLayoutChangeListener {
    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.height = -1;
        view.setLayoutParams(layoutParams2);
    }
}
