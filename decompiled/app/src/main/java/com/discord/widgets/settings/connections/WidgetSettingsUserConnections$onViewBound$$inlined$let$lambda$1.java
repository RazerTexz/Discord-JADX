package com.discord.widgets.settings.connections;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsUserConnections.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1 extends Lambda implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSettingsUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        super(1);
        this.this$0 = widgetSettingsUserConnections;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        WidgetSettingsUserConnections.access$getViewModel$p(this.this$0).joinConnectionIntegrationGuild(str);
    }
}
