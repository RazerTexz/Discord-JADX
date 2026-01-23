package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.databinding.WidgetChatListAdapterItemStickerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StickerEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSticker extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStickerBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSticker$onConfigure$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
    public static final class C81271 extends Lambda implements Function1<Sticker, Unit> {
        public final /* synthetic */ ChatListEntry $data;
        public final /* synthetic */ StickerEntry $stickerEntry;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSticker$onConfigure$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemSticker.kt */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ BaseSticker $sticker;

            public AnonymousClass1(BaseSticker baseSticker) {
                this.$sticker = baseSticker;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemSticker.access$getAdapter$p(WidgetChatListAdapterItemSticker.this).onStickerClicked(((StickerEntry) C81271.this.$data).getMessage(), this.$sticker);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81271(StickerEntry stickerEntry, ChatListEntry chatListEntry) {
            super(1);
            this.$stickerEntry = stickerEntry;
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            BaseSticker sticker2 = sticker;
            if (sticker == null) {
                sticker2 = this.$stickerEntry.getSticker();
            }
            StickerView.m8613e(WidgetChatListAdapterItemSticker.access$getBinding$p(WidgetChatListAdapterItemSticker.this).f16298b, sticker2, null, 2);
            WidgetChatListAdapterItemSticker.access$getBinding$p(WidgetChatListAdapterItemSticker.this).f16298b.setOnClickListener(new AnonymousClass1(sticker2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSticker(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_sticker, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.chat_list_adapter_item_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.chat_list_adapter_item_sticker)));
        }
        WidgetChatListAdapterItemStickerBinding widgetChatListAdapterItemStickerBinding = new WidgetChatListAdapterItemStickerBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStickerBinding, "WidgetChatListAdapterIte…kerBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemStickerBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemSticker widgetChatListAdapterItemSticker) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemSticker.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemStickerBinding access$getBinding$p(WidgetChatListAdapterItemSticker widgetChatListAdapterItemSticker) {
        return widgetChatListAdapterItemSticker.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.binding.f16298b.getCom.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String();
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
        StickerEntry stickerEntry = (StickerEntry) data;
        Observable observableM11100Z = StickerUtils.getGuildOrStandardSticker$default(StickerUtils.INSTANCE, stickerEntry.getSticker().getId(), false, 2, null).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "StickerUtils.getGuildOrS…kerId())\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableM11100Z, WidgetChatListAdapterItemSticker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C81271(stickerEntry, data), 62, (Object) null);
    }
}
