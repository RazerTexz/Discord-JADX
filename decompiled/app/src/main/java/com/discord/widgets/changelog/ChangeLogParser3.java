package com.discord.widgets.changelog;

import b.a.d.AppToast;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ChangeLogParser.kt */
/* renamed from: com.discord.widgets.changelog.ChangeLogParser$parse$renderContext$1$onLongPressUrl$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChangeLogParser3 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ ChangeLogParser2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeLogParser3(ChangeLogParser2 changeLogParser2) {
        super(1);
        this.this$0 = changeLogParser2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        AppToast.c(this.this$0.$context, str, 0, 4);
    }
}
