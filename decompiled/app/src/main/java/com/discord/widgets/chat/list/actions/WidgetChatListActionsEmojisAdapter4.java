package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* renamed from: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter4 extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, WidgetChatListActionsEmojisAdapter2> {

    /* compiled from: WidgetChatListActionsEmojisAdapter.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.MoreEmojisViewHolder$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActionsEmojisAdapter4.access$getAdapter$p(WidgetChatListActionsEmojisAdapter4.this).getOnClickMoreEmojis().invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter4(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(R.layout.view_chat_list_actions_emoji_item_more, widgetChatListActionsEmojisAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(WidgetChatListActionsEmojisAdapter4 widgetChatListActionsEmojisAdapter4) {
        return (WidgetChatListActionsEmojisAdapter) widgetChatListActionsEmojisAdapter4.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChatListActionsEmojisAdapter2 widgetChatListActionsEmojisAdapter2) {
        onConfigure2(i, widgetChatListActionsEmojisAdapter2);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChatListActionsEmojisAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        this.itemView.setOnClickListener(new AnonymousClass1());
    }
}
