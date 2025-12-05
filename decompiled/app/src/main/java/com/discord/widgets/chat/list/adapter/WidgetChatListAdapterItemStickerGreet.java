package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerGreetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerGreetEntry;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Subscription;

/* compiled from: WidgetChatListAdapterItemStickerGreet.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStickerGreet extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerGreetBinding binding;

    /* compiled from: WidgetChatListAdapterItemStickerGreet.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStickerGreet$onConfigure$1 */
    public static final class ViewOnClickListenerC81281 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ int $channelType;
        public final /* synthetic */ Sticker $sticker;

        public ViewOnClickListenerC81281(long j, int i, Sticker sticker) {
            this.$channelId = j;
            this.$channelType = i;
            this.$sticker = sticker;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemStickerGreet.access$getAdapter$p(WidgetChatListAdapterItemStickerGreet.this).getEventHandler().onSendGreetMessageClicked(this.$channelId, this.$channelType, this.$sticker);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStickerGreet(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_sticker_greet, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_sticker_greet;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker_greet);
        if (stickerView != null) {
            i = C5419R.id.send_sticker_greet_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.send_sticker_greet_button);
            if (materialButton != null) {
                WidgetChatListAdapterItemStickerGreetBinding widgetChatListAdapterItemStickerGreetBinding = new WidgetChatListAdapterItemStickerGreetBinding((LinearLayout) view, stickerView, materialButton);
                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerGreetBinding, "WidgetChatListAdapterIte…eetBinding.bind(itemView)");
                this.binding = widgetChatListAdapterItemStickerGreetBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStickerGreet widgetChatListAdapterItemStickerGreet) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStickerGreet.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f16300b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
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
        StickerGreetEntry stickerGreetEntry = (StickerGreetEntry) data;
        Sticker stickerComponent1 = stickerGreetEntry.getSticker();
        long jComponent2 = stickerGreetEntry.getChannelId();
        String strComponent3 = stickerGreetEntry.getChannelName();
        int iComponent4 = stickerGreetEntry.getChannelType();
        StickerView.m8613e(this.binding.f16300b, stickerComponent1, null, 2);
        this.binding.f16301c.setOnClickListener(new ViewOnClickListenerC81281(jComponent2, iComponent4, stickerComponent1));
        MaterialButton materialButton = this.binding.f16301c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.sendStickerGreetButton");
        FormatUtils.m222n(materialButton, C5419R.string.wave_to, new Object[]{strComponent3}, null, 4);
    }
}
