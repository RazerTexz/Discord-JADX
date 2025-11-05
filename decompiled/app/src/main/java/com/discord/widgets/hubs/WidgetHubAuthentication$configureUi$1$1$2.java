package com.discord.widgets.hubs;

import com.discord.stores.StoreNux;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubAuthentication.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAuthentication$configureUi$1$1$2 extends o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
    public static final WidgetHubAuthentication$configureUi$1$1$2 INSTANCE = new WidgetHubAuthentication$configureUi$1$1$2();

    public WidgetHubAuthentication$configureUi$1$1$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
        return invoke2(nuxState);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
        m.checkNotNullParameter(nuxState, "it");
        return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
    }
}
