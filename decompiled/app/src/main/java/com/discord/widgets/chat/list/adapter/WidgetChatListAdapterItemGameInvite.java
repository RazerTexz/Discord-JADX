package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.databinding.WidgetChatListAdapterItemGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGameInviteBinding binding;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<View, ViewEmbedGameInvite.Model, Unit> {
        public final /* synthetic */ GameInviteEntry $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GameInviteEntry gameInviteEntry) {
            super(2);
            this.$item = gameInviteEntry;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, ViewEmbedGameInvite.Model model) {
            invoke2(view, model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, ViewEmbedGameInvite.Model model) {
            m.checkNotNullParameter(view, "<anonymous parameter 0>");
            m.checkNotNullParameter(model, "model");
            Activity activity = model.getActivity();
            if (activity != null) {
                WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).onUserActivityAction(this.$item.getAuthorId(), this.$item.getMessageId(), this.$item.getActivity().getType(), activity, this.$item.getApplication());
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ViewEmbedGameInvite.Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewEmbedGameInvite.Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewEmbedGameInvite.Model model) {
            m.checkNotNullParameter(model, "it");
            WidgetChatListAdapterItemGameInvite.access$getBinding$p(WidgetChatListAdapterItemGameInvite.this).f2319b.bind(model, WidgetChatListAdapterItemGameInvite.access$getAdapter$p(WidgetChatListAdapterItemGameInvite.this).getClock());
        }
    }

    /* compiled from: WidgetChatListAdapterItemGameInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGameInvite$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGameInvite.access$setSubscription$p(WidgetChatListAdapterItemGameInvite.this, subscription);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_game_invite, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(R.id.item_game_invite);
        if (viewEmbedGameInvite == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.item_game_invite)));
        }
        WidgetChatListAdapterItemGameInviteBinding widgetChatListAdapterItemGameInviteBinding = new WidgetChatListAdapterItemGameInviteBinding((CardView) view, viewEmbedGameInvite);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemGameInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
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
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GameInviteEntry gameInviteEntry = (GameInviteEntry) data;
        this.binding.f2319b.setOnActionButtonClick(new AnonymousClass1(gameInviteEntry));
        Observable observableUi = ObservableExtensionsKt.ui(ViewEmbedGameInvite.Model.INSTANCE.get(gameInviteEntry));
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        String simpleName = WidgetChatListAdapterItemGameInvite.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        ObservableExtensionsKt.appSubscribe$default(observableUi, (Context) null, simpleName, new AnonymousClass3(), anonymousClass2, (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
    }
}
