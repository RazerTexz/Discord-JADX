package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemTextDividerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.TimestampEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatListAdapterItemTimestamp.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemTimestamp extends WidgetChatListItem {
    private final WidgetChatListAdapterItemTextDividerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemTimestamp(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_text_divider, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        WidgetChatListAdapterItemTextDividerBinding widgetChatListAdapterItemTextDividerBindingM8410a = WidgetChatListAdapterItemTextDividerBinding.m8410a(this.itemView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemTextDividerBindingM8410a, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemTextDividerBindingM8410a;
        View view = widgetChatListAdapterItemTextDividerBindingM8410a.f16326b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.dividerStrokeLeft");
        view.setBackgroundColor(ColorCompat.getThemedColor(view, C5419R.attr.colorTextMuted));
        View view2 = widgetChatListAdapterItemTextDividerBindingM8410a.f16327c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.dividerStrokeRight");
        view2.setBackgroundColor(ColorCompat.getThemedColor(view2, C5419R.attr.colorTextMuted));
        TextView textView = widgetChatListAdapterItemTextDividerBindingM8410a.f16328d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dividerText");
        textView.setTextColor(ColorCompat.getThemedColor(textView, C5419R.attr.colorTextMuted));
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
        TextView textView = this.binding.f16328d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dividerText");
        textView.setText(TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, ((TimestampEntry) data).getTimestamp(), outline.m821I(this.binding.f16328d, "binding.dividerText", "binding.dividerText.context"), 0, 4, null));
    }
}
