package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventCreateSuccess2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildScheduledEventCreateSuccessBinding> {
    public static final WidgetGuildScheduledEventCreateSuccess2 INSTANCE = new WidgetGuildScheduledEventCreateSuccess2();

    public WidgetGuildScheduledEventCreateSuccess2() {
        super(1, WidgetGuildScheduledEventCreateSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventCreateSuccessBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildScheduledEventCreateSuccessBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.close_button;
        ImageView imageView = (ImageView) view.findViewById(R.id.close_button);
        if (imageView != null) {
            i = R.id.guild_invite_link;
            TextView textView = (TextView) view.findViewById(R.id.guild_invite_link);
            if (textView != null) {
                i = R.id.guild_invite_never_expire;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.guild_invite_never_expire);
                if (checkedSetting != null) {
                    i = R.id.guild_invite_share_btn;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_invite_share_btn);
                    if (materialButton != null) {
                        i = R.id.guild_scheduled_event_success_image;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.guild_scheduled_event_success_image);
                        if (imageView2 != null) {
                            i = R.id.guild_scheduled_event_success_subtitle;
                            TextView textView2 = (TextView) view.findViewById(R.id.guild_scheduled_event_success_subtitle);
                            if (textView2 != null) {
                                i = R.id.guild_scheduled_event_success_title;
                                TextView textView3 = (TextView) view.findViewById(R.id.guild_scheduled_event_success_title);
                                if (textView3 != null) {
                                    return new WidgetGuildScheduledEventCreateSuccessBinding((ConstraintLayout) view, imageView, textView, checkedSetting, materialButton, imageView2, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
