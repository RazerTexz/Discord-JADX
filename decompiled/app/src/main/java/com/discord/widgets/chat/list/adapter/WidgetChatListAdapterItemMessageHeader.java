package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemMessageHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatListAdapterItemMessageHeader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessageHeader extends WidgetChatListItem {
    private final WidgetChatListAdapterItemMessageHeaderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessageHeader(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_message_header, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_item_message_header_channel;
        TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_item_message_header_channel);
        if (textView != null) {
            i = C5419R.id.chat_list_item_message_header_divider;
            View viewFindViewById = view.findViewById(C5419R.id.chat_list_item_message_header_divider);
            if (viewFindViewById != null) {
                i = C5419R.id.chat_list_item_message_header_guild;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_list_item_message_header_guild);
                if (textView2 != null) {
                    i = C5419R.id.chat_list_item_message_header_spacer;
                    Space space = (Space) view.findViewById(C5419R.id.chat_list_item_message_header_spacer);
                    if (space != null) {
                        WidgetChatListAdapterItemMessageHeaderBinding widgetChatListAdapterItemMessageHeaderBinding = new WidgetChatListAdapterItemMessageHeaderBinding((RelativeLayout) view, textView, viewFindViewById, textView2, space);
                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemMessageHeaderBinding, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemMessageHeaderBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
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
        MessageHeaderEntry messageHeaderEntry = (MessageHeaderEntry) data;
        String strComponent2 = messageHeaderEntry.getText();
        String strComponent3 = messageHeaderEntry.getChannelName();
        View view = this.binding.f16258c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListItemMessageHeaderDivider");
        view.setVisibility(position > 0 ? 0 : 8);
        Space space = this.binding.f16260e;
        Intrinsics3.checkNotNullExpressionValue(space, "binding.chatListItemMessageHeaderSpacer");
        space.setVisibility(position <= 0 ? 0 : 8);
        TextView textView = this.binding.f16257b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListItemMessageHeaderChannel");
        textView.setText(strComponent3);
        TextView textView2 = this.binding.f16259d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListItemMessageHeaderGuild");
        textView2.setText(strComponent2);
    }
}
