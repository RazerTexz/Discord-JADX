package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetChangeLogSpecial.kt */
/* renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$thumbnailControllerListener$1$onFinalImageSet$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeLogSpecial5 implements View.OnClickListener {
    public final /* synthetic */ WidgetChangeLogSpecial4 this$0;

    public WidgetChangeLogSpecial5(WidgetChangeLogSpecial4 widgetChangeLogSpecial4) {
        this.this$0 = widgetChangeLogSpecial4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Animatable animatableC;
        WidgetChangeLogSpecial.access$hideVideoOverlay(this.this$0.this$0);
        SimpleDraweeView simpleDraweeView = WidgetChangeLogSpecial.access$getBinding$p(this.this$0.this$0).h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogThumbnail");
        DraweeController controller = simpleDraweeView.getController();
        if (controller == null || (animatableC = controller.c()) == null) {
            return;
        }
        animatableC.start();
    }
}
