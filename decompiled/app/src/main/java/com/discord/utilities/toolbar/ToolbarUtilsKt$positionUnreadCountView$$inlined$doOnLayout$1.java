package com.discord.utilities.toolbar;

import android.view.View;
import com.discord.utilities.dimen.DimenUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ToolbarUtilsKt$positionUnreadCountView$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ View $view$inlined;

    public ToolbarUtilsKt$positionUnreadCountView$$inlined$doOnLayout$1(View view) {
        this.$view$inlined = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        int iDpToPixels = DimenUtils.dpToPixels(2);
        int right2 = view.getRight();
        int bottom2 = view.getBottom();
        View view2 = this.$view$inlined;
        float f = 2;
        float f2 = iDpToPixels;
        view2.setX((right2 / f) + f2);
        view2.setY((bottom2 / f) + f2);
    }
}
