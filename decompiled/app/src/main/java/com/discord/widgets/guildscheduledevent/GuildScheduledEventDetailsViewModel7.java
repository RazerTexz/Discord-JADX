package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildScheduledEventDetailsViewModel.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$onDeleteButtonClicked$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel7 extends Lambda implements Function1<Void, Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function0 $onSuccess$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel7(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel, Context context, Function0 function0) {
        super(1);
        this.this$0 = guildScheduledEventDetailsViewModel;
        this.$context$inlined = context;
        this.$onSuccess$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        this.$onSuccess$inlined.invoke();
    }
}
