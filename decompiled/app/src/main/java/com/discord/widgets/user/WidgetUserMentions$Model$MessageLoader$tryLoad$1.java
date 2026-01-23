package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$1 extends Lambda implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
    public static final WidgetUserMentions$Model$MessageLoader$tryLoad$1 INSTANCE = new WidgetUserMentions$Model$MessageLoader$tryLoad$1();

    public WidgetUserMentions$Model$MessageLoader$tryLoad$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke2(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        Intrinsics3.checkNotNullParameter(loadingState, "it");
        return loadingState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        return invoke2(loadingState);
    }
}
