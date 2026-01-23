package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemBlockedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.widgets.chat.list.entries.BlockedMessagesEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBlocked extends WidgetChatListItem {
    private final WidgetChatListAdapterItemBlockedBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemBlocked$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemBlocked.kt */
    public static final class ViewOnClickListenerC80371 implements View.OnClickListener {
        public final /* synthetic */ Message $message;

        public ViewOnClickListenerC80371(Message message) {
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemBlocked.access$getAdapter$p(WidgetChatListAdapterItemBlocked.this).getEventHandler().onMessageBlockedGroupClicked(this.$message);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBlocked(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_blocked, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_blocked);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.chat_list_adapter_item_blocked)));
        }
        WidgetChatListAdapterItemBlockedBinding widgetChatListAdapterItemBlockedBinding = new WidgetChatListAdapterItemBlockedBinding((RelativeLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemBlockedBinding, "WidgetChatListAdapterIte…kedBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemBlockedBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemBlocked widgetChatListAdapterItemBlocked) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemBlocked.adapter;
    }

    private final CharSequence getBlockedText(Resources resources, Context context, int i) {
        return FormatUtils.m217i(resources, C5419R.string.blocked_messages, new Object[]{StringResourceUtils.getI18nPluralString(context, C5419R.plurals.blocked_messages_count, i, Integer.valueOf(i))}, null, 4);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        BlockedMessagesEntry blockedMessagesEntry = (BlockedMessagesEntry) data;
        Message messageComponent1 = blockedMessagesEntry.getMessage();
        int iComponent2 = blockedMessagesEntry.getBlockedCount();
        TextView textView = this.binding.f16168b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemBlocked");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getBlockedText(resources, outline.m885x(this.itemView, "itemView", "itemView.context"), iComponent2));
        this.binding.f16167a.setOnClickListener(new ViewOnClickListenerC80371(messageComponent1));
    }
}
