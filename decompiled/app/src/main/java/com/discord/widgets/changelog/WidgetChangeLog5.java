package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChangeLog.kt */
/* renamed from: com.discord.widgets.changelog.WidgetChangeLog$thumbnailControllerListener$1$onFinalImageSet$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeLog5 implements View.OnClickListener {
    public final /* synthetic */ WidgetChangeLog4 this$0;

    public WidgetChangeLog5(WidgetChangeLog4 widgetChangeLog4) {
        this.this$0 = widgetChangeLog4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Animatable animatableMo8654c;
        WidgetChangeLog.access$hideVideoOverlay(this.this$0.this$0);
        SimpleDraweeView simpleDraweeView = WidgetChangeLog.access$getBinding$p(this.this$0.this$0).f15816f;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogThumbnail");
        DraweeController controller = simpleDraweeView.getController();
        if (controller == null || (animatableMo8654c = controller.mo8654c()) == null) {
            return;
        }
        animatableMo8654c.start();
    }
}
