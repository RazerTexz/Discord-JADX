package com.discord.widgets.user;

import b.a.d.AppViewModel;
import com.discord.widgets.user.WidgetUserMentions;
import kotlin.Unit;

/* compiled from: WidgetUserMentionsViewModel.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentionsViewModel extends AppViewModel<Unit> {
    private WidgetUserMentions.Model model;

    public WidgetUserMentionsViewModel() {
        super(null, 1, null);
    }

    /* renamed from: getModel$app_productionGoogleRelease, reason: from getter */
    public final WidgetUserMentions.Model getModel() {
        return this.model;
    }

    public final void setModel$app_productionGoogleRelease(WidgetUserMentions.Model model) {
        this.model = model;
    }
}
