package com.discord.widgets.user.account;

import android.content.Context;
import android.view.View;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import d0.z.d.m;

/* compiled from: WidgetUserAccountVerify.kt */
/* loaded from: classes.dex */
public final class WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserAccountVerify this$0;

    public WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1(WidgetUserAccountVerify widgetUserAccountVerify) {
        this.this$0 = widgetUserAccountVerify;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m.checkNotNullParameter(view, "v");
        WidgetUserEmailVerify.Companion companion = WidgetUserEmailVerify.INSTANCE;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        companion.launch(context, this.this$0.getMode());
    }
}
