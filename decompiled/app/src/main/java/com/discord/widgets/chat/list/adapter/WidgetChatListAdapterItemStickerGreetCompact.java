package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetCompactBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetCompactEntry;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreetCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreetCompact extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetCompactBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStickerGreetCompact$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStickerGreetCompact.kt */
    public static final class ViewOnClickListenerC81291 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $channelType;
        public final /* synthetic */ Sticker $sticker;

        public ViewOnClickListenerC81291(long j, int i, Sticker sticker) {
            this.$channelId = j;
            this.$channelType = i;
            this.$sticker = sticker;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemStickerGreetCompact.access$getAdapter$p(WidgetChatListAdapterItemStickerGreetCompact.this).getEventHandler().onSendGreetMessageClicked(this.$channelId, this.$channelType, this.$sticker);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreetCompact(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_sticker_greet_compact, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = C5419R.id.chat_list_adapter_item_sticker_greet_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker_greet_text);
            if (textView != null) {
                i = C5419R.id.send_sticker_greet_button;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.send_sticker_greet_button);
                if (linearLayout != null) {
                    WidgetChatListAdapterItemStickerGreetCompactBinding widgetChatListAdapterItemStickerGreetCompactBinding = new WidgetChatListAdapterItemStickerGreetCompactBinding((ConstraintLayout) view, stickerView, textView, linearLayout);
                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetCompactBinding, "WidgetChatListAdapterIte…actBinding.bind(itemView)");
                    this.binding = widgetChatListAdapterItemStickerGreetCompactBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStickerGreetCompact widgetChatListAdapterItemStickerGreetCompact) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStickerGreetCompact.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f16303b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
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
        StickerGreetCompactEntry stickerGreetCompactEntry = (StickerGreetCompactEntry) data;
        Sticker stickerComponent1 = stickerGreetCompactEntry.getSticker();
        long jComponent2 = stickerGreetCompactEntry.getChannelId();
        String strComponent3 = stickerGreetCompactEntry.getChannelName();
        int iComponent4 = stickerGreetCompactEntry.getChannelType();
        StickerView.m8613e(this.binding.f16303b, stickerComponent1, null, 2);
        this.binding.f16305d.setOnClickListener(new ViewOnClickListenerC81291(jComponent2, iComponent4, stickerComponent1));
        TextView textView = this.binding.f16304c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemStickerGreetText");
        FormatUtils.m222n(textView, C5419R.string.wave_to, new Object[]{strComponent3}, null, 4);
    }
}
