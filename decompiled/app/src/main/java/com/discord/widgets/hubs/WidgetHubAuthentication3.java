package com.discord.widgets.hubs;

import com.discord.stores.StoreNux;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1$1$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication3 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
    public static final WidgetHubAuthentication3 INSTANCE = new WidgetHubAuthentication3();

    public WidgetHubAuthentication3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
        return invoke2(nuxState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
        Intrinsics3.checkNotNullParameter(nuxState, "it");
        return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
    }
}
