package com.discord.utilities;

import kotlin.Tuples2;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ShareUtils$updateDirectShareTargets$1$uris$1 extends Lambda implements Function1<Tuples2<? extends ChannelShortcutInfo, ? extends String>, String> {
    public static final ShareUtils$updateDirectShareTargets$1$uris$1 INSTANCE = new ShareUtils$updateDirectShareTargets$1$uris$1();

    public ShareUtils$updateDirectShareTargets$1$uris$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Tuples2<? extends ChannelShortcutInfo, ? extends String> tuples2) {
        return invoke2((Tuples2<ChannelShortcutInfo, String>) tuples2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Tuples2<ChannelShortcutInfo, String> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "<name for destructuring parameter 0>");
        return tuples2.component2();
    }
}
