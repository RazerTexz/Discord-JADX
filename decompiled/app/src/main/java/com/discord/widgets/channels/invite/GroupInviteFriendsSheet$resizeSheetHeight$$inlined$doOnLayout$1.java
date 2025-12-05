package com.discord.widgets.channels.invite;

import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: View.kt */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    public GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        this.this$0 = groupInviteFriendsSheet;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        Intrinsics3.checkNotNullExpressionValue(this.this$0.getResources(), "resources");
        layoutParams.height = (int) (r3.getDisplayMetrics().heightPixels * 0.9f);
        view.setLayoutParams(layoutParams);
    }
}
