package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action0;

/* compiled from: WidgetAuthLandingViewModel.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel2<T, R> implements Func1<String, Observable<? extends StoreGuildTemplates.GuildTemplateState>> {
    public final /* synthetic */ StoreGuildTemplates $storeGuildTemplates;

    /* compiled from: WidgetAuthLandingViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1$1 */
    public static final class C71811 implements Action0 {
        public final /* synthetic */ String $guildTemplateCode;

        public C71811(String str) {
            this.$guildTemplateCode = str;
        }

        @Override // p658rx.functions.Action0
        public final void call() {
            WidgetAuthLandingViewModel2.this.$storeGuildTemplates.maybeInitTemplateState(this.$guildTemplateCode);
        }
    }

    public WidgetAuthLandingViewModel2(StoreGuildTemplates storeGuildTemplates) {
        this.$storeGuildTemplates = storeGuildTemplates;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends StoreGuildTemplates.GuildTemplateState> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreGuildTemplates.GuildTemplateState> call2(String str) {
        return str != null ? this.$storeGuildTemplates.observeGuildTemplate(str).m11116v(new C71811(str)) : new ScalarSynchronousObservable(StoreGuildTemplates.GuildTemplateState.None.INSTANCE);
    }
}
