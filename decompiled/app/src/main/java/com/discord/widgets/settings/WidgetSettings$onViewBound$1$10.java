package com.discord.widgets.settings;

import android.view.View;
import com.discord.app.AppTransitionActivity;
import com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$10 implements View.OnClickListener {
    public static final WidgetSettings$onViewBound$1$10 INSTANCE = new WidgetSettings$onViewBound$1$10();

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile.Companion.launch$default(WidgetEditUserOrGuildMemberProfile.INSTANCE, outline.m885x(view, "it", "it.context"), AppTransitionActivity.Transition.TYPE_SLIDE_HORIZONTAL, null, 4, null);
    }
}
