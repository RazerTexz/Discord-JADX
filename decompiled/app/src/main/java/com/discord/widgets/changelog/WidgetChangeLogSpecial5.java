package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.changelog.WidgetChangeLogSpecial$thumbnailControllerListener$1$onFinalImageSet$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial5 implements View.OnClickListener {
    public final /* synthetic */ WidgetChangeLogSpecial4 this$0;

    public WidgetChangeLogSpecial5(WidgetChangeLogSpecial4 widgetChangeLogSpecial4) {
        this.this$0 = widgetChangeLogSpecial4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Animatable animatableMo8654c;
        WidgetChangeLogSpecial.access$hideVideoOverlay(this.this$0.this$0);
        SimpleDraweeView simpleDraweeView = WidgetChangeLogSpecial.access$getBinding$p(this.this$0.this$0).f15827h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogThumbnail");
        DraweeController controller = simpleDraweeView.getController();
        if (controller == null || (animatableMo8654c = controller.mo8654c()) == null) {
            return;
        }
        animatableMo8654c.start();
    }
}
