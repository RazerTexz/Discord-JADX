package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreInviteSettings;
import com.discord.widgets.auth.WidgetAuthLandingViewModel;
import d0.z.d.Intrinsics3;
import rx.functions.Func4;

/* compiled from: WidgetAuthLandingViewModel.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel3<T1, T2, T3, T4, R> implements Func4<StoreInviteSettings.InviteCode, ModelInvite, StoreGuildTemplates.GuildTemplateState, String, WidgetAuthLandingViewModel.StoreState> {
    public static final WidgetAuthLandingViewModel3 INSTANCE = new WidgetAuthLandingViewModel3();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetAuthLandingViewModel.StoreState call(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
        return call2(inviteCode, modelInvite, guildTemplateState, str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetAuthLandingViewModel.StoreState call2(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
        Intrinsics3.checkNotNullExpressionValue(guildTemplateState, "guildTemplate");
        return new WidgetAuthLandingViewModel.StoreState(inviteCode, modelInvite, guildTemplateState, str);
    }
}
