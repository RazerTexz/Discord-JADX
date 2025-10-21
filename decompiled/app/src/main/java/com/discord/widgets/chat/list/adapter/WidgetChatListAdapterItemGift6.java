package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetChatListAdapterItemGift.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift6 implements View.OnClickListener {
    public static final WidgetChatListAdapterItemGift6 INSTANCE = new WidgetChatListAdapterItemGift6();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        WidgetSettingsAccount.Companion.launch$default(companion, context, false, null, 6, null);
    }
}
