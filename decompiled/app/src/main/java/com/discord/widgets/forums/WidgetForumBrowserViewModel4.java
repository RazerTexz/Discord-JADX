package com.discord.widgets.forums;

import com.discord.api.channel.Channel;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel4 extends Lambda implements Function1<Channel, ForumBrowserItem.PostItem> {
    public final /* synthetic */ WidgetForumBrowserViewModel.C83511 $convertChannelToPostItem$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel4(WidgetForumBrowserViewModel.C83511 c83511) {
        super(1);
        this.$convertChannelToPostItem$1 = c83511;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ForumBrowserItem.PostItem invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ForumBrowserItem.PostItem invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return this.$convertChannelToPostItem$1.invoke2(channel);
    }
}
