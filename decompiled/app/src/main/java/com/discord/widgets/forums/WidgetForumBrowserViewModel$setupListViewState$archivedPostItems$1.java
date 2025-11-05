package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumBrowserViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1 extends o implements Function1<Channel, ForumBrowserItem.PostItem> {
    public final /* synthetic */ WidgetForumBrowserViewModel.AnonymousClass1 $convertChannelToPostItem$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1(WidgetForumBrowserViewModel.AnonymousClass1 anonymousClass1) {
        super(1);
        this.$convertChannelToPostItem$1 = anonymousClass1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ForumBrowserItem.PostItem invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ForumBrowserItem.PostItem invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        return this.$convertChannelToPostItem$1.invoke2(channel);
    }
}
