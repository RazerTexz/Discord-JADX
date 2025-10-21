package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$filters$1 extends Lambda implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
    public static final WidgetUserMentions$Model$MessageLoader$filters$1 INSTANCE = new WidgetUserMentions$Model$MessageLoader$filters$1();

    public WidgetUserMentions$Model$MessageLoader$filters$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        return invoke2(loadingState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke2(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        Intrinsics3.checkNotNullParameter(loadingState, "it");
        return new WidgetUserMentions.Model.MessageLoader.LoadingState(false, false, null, 7, null);
    }
}
