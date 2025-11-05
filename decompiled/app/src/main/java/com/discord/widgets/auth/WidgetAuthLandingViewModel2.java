package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;
import rx.functions.Action0;

/* compiled from: WidgetAuthLandingViewModel.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel2<T, R> implements Func1<String, Observable<? extends StoreGuildTemplates.GuildTemplateState>> {
    public final /* synthetic */ StoreGuildTemplates $storeGuildTemplates;

    /* compiled from: WidgetAuthLandingViewModel.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action0 {
        public final /* synthetic */ String $guildTemplateCode;

        public AnonymousClass1(String str) {
            this.$guildTemplateCode = str;
        }

        @Override // rx.functions.Action0
        public final void call() {
            WidgetAuthLandingViewModel2.this.$storeGuildTemplates.maybeInitTemplateState(this.$guildTemplateCode);
        }
    }

    public WidgetAuthLandingViewModel2(StoreGuildTemplates storeGuildTemplates) {
        this.$storeGuildTemplates = storeGuildTemplates;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends StoreGuildTemplates.GuildTemplateState> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends StoreGuildTemplates.GuildTemplateState> call2(String str) {
        return str != null ? this.$storeGuildTemplates.observeGuildTemplate(str).v(new AnonymousClass1(str)) : new ScalarSynchronousObservable(StoreGuildTemplates.GuildTemplateState.None.INSTANCE);
    }
}
