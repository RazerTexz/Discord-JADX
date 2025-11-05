package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.WidgetChatListAdapterItemBlockedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;

/* compiled from: WidgetChatListAdapterItemBlocked.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemBlockedBinding binding;

    /* compiled from: WidgetChatListAdapterItemBlocked.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBlocked$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Message $message;

        public AnonymousClass1(Message message) {
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemBlocked.access$getAdapter$p(WidgetChatListAdapterItemBlocked.this).getEventHandler().onMessageBlockedGroupClicked(this.$message);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_blocked, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_blocked);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.chat_list_adapter_item_blocked)));
        }
        WidgetChatListAdapterItemBlockedBinding widgetChatListAdapterItemBlockedBinding = new WidgetChatListAdapterItemBlockedBinding((RelativeLayout) view, textView);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemBlockedBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemBlocked widgetChatListAdapterItemBlocked) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemBlocked.adapter;
    }

    private final CharSequence getBlockedText(Resources resources, Context context, int i) {
        return b.i(resources, R.string.blocked_messages, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R.plurals.blocked_messages_count, i, Integer.valueOf(i))}, null, 4);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) data;
        Message messageComponent1 = blockedMessagesEntry.getMessage();
        int iComponent2 = blockedMessagesEntry.getBlockedCount();
        TextView textView = this.binding.f2312b;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemBlocked");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getBlockedText(resources, a.x(this.itemView, "itemView", "itemView.context"), iComponent2));
        this.binding.a.setOnClickListener(new AnonymousClass1(messageComponent1));
    }
}
