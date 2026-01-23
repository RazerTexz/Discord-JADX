package com.discord.widgets.guildscheduledevent;

import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView$descriptionParser$2, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventItemView2 extends Lambda implements Function0<GuildScheduledEventDescriptionParser> {
    public final /* synthetic */ GuildScheduledEventItemView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventItemView2(GuildScheduledEventItemView guildScheduledEventItemView) {
        super(0);
        this.this$0 = guildScheduledEventItemView;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildScheduledEventDescriptionParser invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildScheduledEventDescriptionParser invoke() {
        LinkifiedTextView linkifiedTextView = GuildScheduledEventItemView.access$getBinding$p(this.this$0).f15141f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventListItemDescText");
        return new GuildScheduledEventDescriptionParser(linkifiedTextView);
    }
}
