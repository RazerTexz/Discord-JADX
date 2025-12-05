package com.discord.widgets.user.search;

import java.util.HashSet;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchModel.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$1 */
/* loaded from: classes.dex */
public final class C10333x15369a2b extends Lambda implements Function1<Long, Boolean> {
    public final /* synthetic */ HashSet $seenUsersIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10333x15369a2b(HashSet hashSet) {
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
