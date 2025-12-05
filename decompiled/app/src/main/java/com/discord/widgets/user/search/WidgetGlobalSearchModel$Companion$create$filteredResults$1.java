package com.discord.widgets.user.search;

import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$1 extends Lambda implements Function1<User, WidgetGlobalSearchModel.ItemUser> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$1(WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, String str) {
        super(1);
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemUser invoke(User user) {
        return invoke2(user);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemUser invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        return WidgetGlobalSearchModel$Companion$create$2.invoke$default(this.$toItemUser$2, user, this.$sanitizedFilter, null, 2, null);
    }
}
