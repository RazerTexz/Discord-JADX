package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$11 extends Lambda implements Function1<Channel, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$11(WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4, String str) {
        super(1);
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemDataPayload invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        return this.$toItemChannel$4.invoke2(channel, this.$sanitizedFilter);
    }
}
