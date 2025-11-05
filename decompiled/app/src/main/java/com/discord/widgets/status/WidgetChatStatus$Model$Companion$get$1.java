package com.discord.widgets.status;

import com.discord.models.application.Unread;
import com.discord.widgets.status.WidgetChatStatus;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Set;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetChatStatus.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus$Model$Companion$get$1 extends k implements Function3<Boolean, Set<? extends Long>, Unread, WidgetChatStatus.Model> {
    public WidgetChatStatus$Model$Companion$get$1(WidgetChatStatus.Model.Companion companion) {
        super(3, companion, WidgetChatStatus.Model.Companion.class, "createModel", "createModel(ZLjava/util/Set;Lcom/discord/models/application/Unread;)Lcom/discord/widgets/status/WidgetChatStatus$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetChatStatus.Model invoke(Boolean bool, Set<? extends Long> set, Unread unread) {
        return invoke(bool.booleanValue(), (Set<Long>) set, unread);
    }

    public final WidgetChatStatus.Model invoke(boolean z2, Set<Long> set, Unread unread) {
        m.checkNotNullParameter(set, "p2");
        m.checkNotNullParameter(unread, "p3");
        return WidgetChatStatus.Model.Companion.access$createModel((WidgetChatStatus.Model.Companion) this.receiver, z2, set, unread);
    }
}
