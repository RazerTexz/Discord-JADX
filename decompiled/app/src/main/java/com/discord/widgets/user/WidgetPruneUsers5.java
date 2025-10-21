package com.discord.widgets.user;

import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.t.Collections2;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetPruneUsers.kt */
/* renamed from: com.discord.widgets.user.WidgetPruneUsers$radioManager$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPruneUsers5 extends Lambda implements Function0<RadioManager> {
    public final /* synthetic */ WidgetPruneUsers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsers5(WidgetPruneUsers widgetPruneUsers) {
        super(0);
        this.this$0 = widgetPruneUsers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RadioManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RadioManager invoke() {
        return new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{WidgetPruneUsers.access$getBinding$p(this.this$0).f, WidgetPruneUsers.access$getBinding$p(this.this$0).g}));
    }
}
