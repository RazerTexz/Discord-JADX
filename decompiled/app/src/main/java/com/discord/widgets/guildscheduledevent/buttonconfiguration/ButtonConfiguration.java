package com.discord.widgets.guildscheduledevent.buttonconfiguration;

import android.content.Context;
import android.view.View;

/* compiled from: ButtonConfiguration.kt */
/* loaded from: classes2.dex */
public interface ButtonConfiguration {
    View.OnClickListener getExtrasButtonOnClickListener();

    View.OnClickListener getPrimaryButtonOnClickListener();

    boolean getPrimaryButtonVisible();

    int getSecondaryButtonBackground();

    boolean getSecondaryButtonEnabled();

    View.OnClickListener getSecondaryButtonOnClickListener();

    int getSecondaryButtonTextDrawableRes();

    boolean getSecondaryButtonVisible();

    View.OnClickListener getShareButtonOnClickListener();

    boolean isAnyButtonVisible();

    boolean isExtrasVisible();

    boolean isShareVisible();

    CharSequence primaryButtonText(Context context);

    CharSequence secondaryButtonText(Context context);

    int secondaryButtonTextColor(Context context);
}
