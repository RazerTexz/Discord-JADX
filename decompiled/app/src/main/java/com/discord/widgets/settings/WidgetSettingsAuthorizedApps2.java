package com.discord.widgets.settings;

import android.view.View;
import com.discord.models.domain.ModelOAuth2Token;
import com.discord.widgets.settings.WidgetSettingsAuthorizedApps;

/* compiled from: WidgetSettingsAuthorizedApps.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsAuthorizedApps$AuthorizedAppViewHolder$bind$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAuthorizedApps2 implements View.OnClickListener {
    public final /* synthetic */ ModelOAuth2Token $data;
    public final /* synthetic */ WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder this$0;

    public WidgetSettingsAuthorizedApps2(WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder authorizedAppViewHolder, ModelOAuth2Token modelOAuth2Token) {
        this.this$0 = authorizedAppViewHolder;
        this.$data = modelOAuth2Token;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAuthorizedApps.AuthorizedAppViewHolder.access$getOnDeauthorizeClick$p(this.this$0).invoke(this.$data);
    }
}
