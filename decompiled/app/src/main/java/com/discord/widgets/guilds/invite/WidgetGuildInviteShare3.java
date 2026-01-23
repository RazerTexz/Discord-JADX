package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion$launch$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare3 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ Intent $arguments;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $source;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare3(String str, Context context, Intent intent) {
        super(1);
        this.$source = str;
        this.$context = context;
        this.$arguments = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        AnalyticsTracker.openModal$default("Instant Invite Modal", this.$source, null, 4, null);
        AppScreen2.m156d(this.$context, WidgetGuildInviteShareEmptySuggestions.class, this.$arguments);
    }
}
