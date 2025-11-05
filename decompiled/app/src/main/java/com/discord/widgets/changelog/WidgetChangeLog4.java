package com.discord.widgets.changelog;

import android.graphics.drawable.Animatable;
import b.f.g.c.BaseControllerListener;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetChangeLog.kt */
/* renamed from: com.discord.widgets.changelog.WidgetChangeLog$thumbnailControllerListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeLog4 extends BaseControllerListener<Object> {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog4(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // b.f.g.c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFinalImageSet(String id2, Object imageInfo, Animatable animatable) {
        super.onFinalImageSet(id2, imageInfo, animatable);
        try {
            SimpleDraweeView simpleDraweeView = WidgetChangeLog.access$getBinding$p(this.this$0).i;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.changeLogVideoOverlay");
            int i = 0;
            if (!(animatable != null)) {
                i = 8;
            }
            simpleDraweeView.setVisibility(i);
            WidgetChangeLog.access$getBinding$p(this.this$0).i.setOnClickListener(new WidgetChangeLog5(this));
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Failed to set changelog thumbnail image.", e, null, 4, null);
        }
    }
}
