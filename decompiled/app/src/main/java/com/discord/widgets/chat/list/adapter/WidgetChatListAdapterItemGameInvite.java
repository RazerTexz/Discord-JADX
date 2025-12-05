package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.databinding.WidgetChatListAdapterItemGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGameInviteBinding binding;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$1 */
    public static final class C80621 extends Lambda implements Function2<View, ViewEmbedGameInvite.Model, Unit> {
        public final /* synthetic */ GameInviteEntry $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80621(GameInviteEntry gameInviteEntry) {
            super(2);
            this.$item = gameInviteEntry;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, ViewEmbedGameInvite.Model model) {
            invoke2(view, model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, ViewEmbedGameInvite.Model model) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(model, "model");
            Activity activity = model.getActivity();
            if (activity != null) {
                WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).onUserActivityAction(this.$item.getAuthorId(), this.$item.getMessageId(), this.$item.getActivity().getType(), activity, this.$item.getApplication());
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$2 */
    public static final class C80632 extends Lambda implements Function1<ViewEmbedGameInvite.Model, Unit> {
        public C80632() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewEmbedGameInvite.Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewEmbedGameInvite.Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemGameInvite.access$getBinding$p(WidgetChatListAdapterItemGameInvite.this).f16208b.bind(model, WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).getClock());
        }
    }

    /* compiled from: WidgetChatListAdapterItemGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$3 */
    public static final class C80643 extends Lambda implements Function1<Subscription, Unit> {
        public C80643() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGameInvite.access$setSubscription$p(WidgetChatListAdapterItemGameInvite.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_game_invite, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(C5419R.id.item_game_invite);
        if (viewEmbedGameInvite == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.item_game_invite)));
        }
        WidgetChatListAdapterItemGameInviteBinding widgetChatListAdapterItemGameInviteBinding = new WidgetChatListAdapterItemGameInviteBinding((CardView) view, viewEmbedGameInvite);
        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemGameInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGameInviteBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGameInvite.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemGameInviteBinding access$getBinding$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return widgetChatListAdapterItemGameInvite.binding;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return widgetChatListAdapterItemGameInvite.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite, Subscription subscription) {
        widgetChatListAdapterItemGameInvite.subscription = subscription;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
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
        GameInviteEntry gameInviteEntry = (GameInviteEntry) data;
        this.binding.f16208b.setOnActionButtonClick(new C80621(gameInviteEntry));
        Observable observableM8518ui = ObservableExtensionsKt.m8518ui(ViewEmbedGameInvite.Model.INSTANCE.get(gameInviteEntry));
        C80632 c80632 = new C80632();
        String simpleName = WidgetChatListAdapterItemGameInvite.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        ObservableExtensionsKt.appSubscribe$default(observableM8518ui, (Context) null, simpleName, new C80643(), c80632, (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
    }
}
