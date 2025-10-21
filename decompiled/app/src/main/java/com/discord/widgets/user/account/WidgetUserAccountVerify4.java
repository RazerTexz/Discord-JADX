package com.discord.widgets.user.account;

import android.content.Context;
import android.view.View;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetUserAccountVerify.kt */
/* renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserAccountVerify4 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserAccountVerify this$0;

    public WidgetUserAccountVerify4(WidgetUserAccountVerify widgetUserAccountVerify) {
        this.this$0 = widgetUserAccountVerify;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intrinsics3.checkNotNullParameter(view, "v");
        WidgetUserPhoneManage.Companion companion = WidgetUserPhoneManage.INSTANCE;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "v.context");
        companion.launch(context, this.this$0.getMode(), WidgetUserPhoneManage.Companion.Source.USER_ACTION_REQUIRED);
    }
}
