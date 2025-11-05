package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreEmoji.kt */
/* renamed from: com.discord.stores.StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreEmoji2 extends Lambda implements Function1<String, CharSequence> {
    public static final StoreEmoji2 INSTANCE = new StoreEmoji2();

    public StoreEmoji2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(String str) {
        return invoke2(str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        String strQuote = Pattern.quote(str);
        Intrinsics3.checkNotNullExpressionValue(strQuote, "Pattern.quote(it)");
        return strQuote;
    }
}
