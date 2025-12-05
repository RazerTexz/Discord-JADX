package com.discord.stores;

import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import p507d0.Tuples;
import p507d0.p578f0._Sequences2;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreCollapsedChannelCategories.kt */
/* renamed from: com.discord.stores.StoreCollapsedChannelCategories$Companion$fromCache$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories2 extends Lambda implements Function2<String, String, Tuples2<? extends Long, ? extends Set<Long>>> {
    public static final StoreCollapsedChannelCategories2 INSTANCE = new StoreCollapsedChannelCategories2();

    public StoreCollapsedChannelCategories2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Tuples2<? extends Long, ? extends Set<Long>> invoke(String str, String str2) {
        return invoke2(str, str2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Tuples2<Long, Set<Long>> invoke2(String str, String str2) throws NumberFormatException {
        Intrinsics3.checkNotNullParameter(str, "key");
        Intrinsics3.checkNotNullParameter(str2, "value");
        long j = Long.parseLong(str);
        return Tuples.m10073to(Long.valueOf(j), _Sequences2.toHashSet(_Sequences2.map(Strings4.splitToSequence$default(str2, new String[]{","}, false, 0, 6, null), StoreCollapsedChannelCategories3.INSTANCE)));
    }
}
