package com.discord.widgets.user.search;

import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$2 extends Lambda implements Function1<Guild, WidgetGlobalSearchModel.ItemGuild> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$3 $toItemGuild$3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$2(WidgetGlobalSearchModel$Companion$create$3 widgetGlobalSearchModel$Companion$create$3, String str) {
        super(1);
        this.$toItemGuild$3 = widgetGlobalSearchModel$Companion$create$3;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemGuild invoke(Guild guild) {
        return invoke2(guild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemGuild invoke2(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "it");
        return this.$toItemGuild$3.invoke2(guild, this.$sanitizedFilter);
    }
}
