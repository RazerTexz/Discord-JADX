package com.discord.stores;

import com.discord.widgets.chat.input.MentionUtils;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreGatewayConnection.kt */
/* renamed from: com.discord.stores.StoreGatewayConnection$buildGatewaySocket$gatewayUrlTransform$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGatewayConnection3 extends Lambda implements Function1<String, String> {
    public static final StoreGatewayConnection3 INSTANCE = new StoreGatewayConnection3();

    public StoreGatewayConnection3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(String str) {
        return invoke2(str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "gatewayUrl");
        return outline.m883w("ws://:", Strings4.substringAfterLast$default(str, MentionUtils.EMOJIS_AND_STICKERS_CHAR, null, 2, null));
    }
}
