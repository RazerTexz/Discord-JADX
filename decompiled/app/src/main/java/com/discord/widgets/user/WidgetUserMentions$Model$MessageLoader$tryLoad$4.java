package com.discord.widgets.user;

import com.discord.models.message.Message;
import com.discord.widgets.user.WidgetUserMentions;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$4 extends Lambda implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$tryLoad$4(WidgetUserMentions.Model.MessageLoader messageLoader) {
        super(1);
        this.this$0 = messageLoader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        WidgetUserMentions.Model.MessageLoader messageLoader = this.this$0;
        Intrinsics3.checkNotNullExpressionValue(list, "it");
        WidgetUserMentions.Model.MessageLoader.access$handleLoaded(messageLoader, list);
    }
}
