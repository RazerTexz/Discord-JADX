package com.discord.widgets.user.search;

import d0.z.d.Lambda;
import java.util.HashSet;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$1 extends Lambda implements Function1<Long, Boolean> {
    public final /* synthetic */ HashSet $seenUsersIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$1(HashSet hashSet) {
        super(1);
        this.$seenUsersIds = hashSet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        return this.$seenUsersIds.contains(Long.valueOf(j));
    }
}
