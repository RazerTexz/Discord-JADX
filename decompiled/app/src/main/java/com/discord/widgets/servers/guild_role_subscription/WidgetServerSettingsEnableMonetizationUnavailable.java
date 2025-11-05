package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import b.a.d.j;
import com.discord.R;
import com.discord.app.AppFragment;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetServerSettingsEnableMonetizationUnavailable.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableMonetizationUnavailable extends AppFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetServerSettingsEnableMonetizationUnavailable.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetServerSettingsEnableMonetizationUnavailable.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetServerSettingsEnableMonetizationUnavailable() {
        super(R.layout.view_server_settings_guild_role_subscription_unavailable_notice);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
