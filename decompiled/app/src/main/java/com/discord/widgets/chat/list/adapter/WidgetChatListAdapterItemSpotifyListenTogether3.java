package com.discord.widgets.chat.list.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSpotifyListenTogether$userAdapter$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether3 extends Lambda implements Function0<WidgetCollapsedUsersListAdapter> {
    public final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether3(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        super(0);
        this.this$0 = widgetChatListAdapterItemSpotifyListenTogether;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetCollapsedUsersListAdapter invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCollapsedUsersListAdapter invoke() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = WidgetChatListAdapterItemSpotifyListenTogether.access$getBinding$p(this.this$0).f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.itemListenTogetherRecycler");
        return (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }
}
