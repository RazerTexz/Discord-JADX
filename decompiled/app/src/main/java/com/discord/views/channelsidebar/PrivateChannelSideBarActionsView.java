package com.discord.views.channelsidebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.material.button.MaterialButton;
import p000.ViewOnClickListenerC11208d;
import p007b.p008a.p025i.PrivateChannelSideBarActionsViewBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PrivateChannelSideBarActionsView.kt */
/* loaded from: classes2.dex */
public final class PrivateChannelSideBarActionsView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final PrivateChannelSideBarActionsViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateChannelSideBarActionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.private_channel_side_bar_actions_view, this);
        int i = C5419R.id.private_channel_sidebar_actions_call;
        MaterialButton materialButton = (MaterialButton) findViewById(C5419R.id.private_channel_sidebar_actions_call);
        if (materialButton != null) {
            i = C5419R.id.private_channel_sidebar_actions_notifications;
            MaterialButton materialButton2 = (MaterialButton) findViewById(C5419R.id.private_channel_sidebar_actions_notifications);
            if (materialButton2 != null) {
                i = C5419R.id.private_channel_sidebar_actions_search;
                MaterialButton materialButton3 = (MaterialButton) findViewById(C5419R.id.private_channel_sidebar_actions_search);
                if (materialButton3 != null) {
                    i = C5419R.id.private_channel_sidebar_actions_video;
                    MaterialButton materialButton4 = (MaterialButton) findViewById(C5419R.id.private_channel_sidebar_actions_video);
                    if (materialButton4 != null) {
                        PrivateChannelSideBarActionsViewBinding privateChannelSideBarActionsViewBinding = new PrivateChannelSideBarActionsViewBinding(this, materialButton, materialButton2, materialButton3, materialButton4);
                        Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsViewBinding, "PrivateChannelSideBarAct…ater.from(context), this)");
                        this.binding = privateChannelSideBarActionsViewBinding;
                        m8590a(ViewOnClickListenerC11208d.f22261j, ViewOnClickListenerC11208d.f22262k, ViewOnClickListenerC11208d.f22263l, ViewOnClickListenerC11208d.f22264m, false);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* renamed from: a */
    public final void m8590a(View.OnClickListener onCallClicked, View.OnClickListener onVideoClicked, View.OnClickListener onNotificationsClicked, View.OnClickListener onSearchClicked, boolean channelIsMuted) {
        Intrinsics3.checkNotNullParameter(onCallClicked, "onCallClicked");
        Intrinsics3.checkNotNullParameter(onVideoClicked, "onVideoClicked");
        Intrinsics3.checkNotNullParameter(onNotificationsClicked, "onNotificationsClicked");
        Intrinsics3.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        int themedDrawableRes$default = channelIsMuted ? DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_sidebar_notifications_off_24dp, 0, 2, (Object) null) : DrawableCompat.getThemedDrawableRes$default(this, C5419R.attr.ic_sidebar_notifications_on_24dp, 0, 2, (Object) null);
        this.binding.f862b.setOnClickListener(onCallClicked);
        this.binding.f865e.setOnClickListener(onVideoClicked);
        MaterialButton materialButton = this.binding.f863c;
        DrawableCompat.setCompoundDrawablesCompat(materialButton, (Drawable) null, ContextCompat.getDrawable(materialButton.getContext(), themedDrawableRes$default), (Drawable) null, (Drawable) null);
        materialButton.setOnClickListener(onNotificationsClicked);
        this.binding.f864d.setOnClickListener(onSearchClicked);
    }
}
