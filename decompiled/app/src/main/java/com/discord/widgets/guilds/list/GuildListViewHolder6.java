package com.discord.widgets.guilds.list;

import android.view.View;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.GuildListViewHolder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.GuildListViewHolder$GuildViewHolder$configure$2, reason: use source file name */
/* JADX INFO: compiled from: GuildListViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildListViewHolder6 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ GuildListItem.GuildItem $data;
    public final /* synthetic */ GuildListViewHolder.GuildViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildListViewHolder6(GuildListViewHolder.GuildViewHolder guildViewHolder, GuildListItem.GuildItem guildItem) {
        super(1);
        this.this$0 = guildViewHolder;
        this.$data = guildItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        GuildListViewHolder.GuildViewHolder.access$getOnLongPressed$p(this.this$0).invoke(this.$data);
    }
}
