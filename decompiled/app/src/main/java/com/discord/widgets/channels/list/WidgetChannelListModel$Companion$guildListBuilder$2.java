package com.discord.widgets.channels.list;

import com.discord.widgets.channels.list.items.ChannelListItem;
import com.discord.widgets.channels.list.items.ChannelListItemCategory;
import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelListModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Set $collapsedCategories;
    public final /* synthetic */ HashSet $forceViewCategories;
    public final /* synthetic */ ArrayList $items;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$2(ArrayList arrayList, HashSet hashSet, Set set) {
        super(0);
        this.$items = arrayList;
        this.$forceViewCategories = hashSet;
        this.$collapsedCategories = set;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ChannelListItem channelListItem = (ChannelListItem) _Collections.lastOrNull((List) this.$items);
        if (channelListItem != null && channelListItem.getType() == 8 && (channelListItem instanceof ChannelListItemCategory)) {
            long id2 = ((ChannelListItemCategory) channelListItem).getChannel().getId();
            if (this.$forceViewCategories.contains(Long.valueOf(id2)) || this.$collapsedCategories.contains(Long.valueOf(id2))) {
                return;
            }
            this.$items.remove(r0.size() - 1);
        }
    }
}
