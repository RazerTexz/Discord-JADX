package com.discord.stores;

import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$toCache$1$1, reason: use source file name */
/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories4 extends Lambda implements Function1<Set<Long>, String> {
    public static final StoreCollapsedChannelCategories4 INSTANCE = new StoreCollapsedChannelCategories4();

    public StoreCollapsedChannelCategories4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Set<Long> set) {
        return invoke2(set);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Set<Long> set) {
        Intrinsics3.checkNotNullParameter(set, "value");
        return _Collections.joinToString$default(set, ",", null, null, 0, null, null, 62, null);
    }
}
