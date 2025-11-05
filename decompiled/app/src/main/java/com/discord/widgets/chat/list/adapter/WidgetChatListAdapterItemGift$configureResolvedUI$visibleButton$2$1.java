package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import d0.z.d.m;

/* compiled from: WidgetChatListAdapterItemGift.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1 implements View.OnClickListener {
    public static final WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1 INSTANCE = new WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsAccount.Companion.launch$default(companion, context, false, null, 6, null);
    }
}
