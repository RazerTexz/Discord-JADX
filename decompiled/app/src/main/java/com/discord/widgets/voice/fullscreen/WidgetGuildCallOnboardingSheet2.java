package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildCallOnboardingBinding;
import com.discord.views.JoinVoiceChannelButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildCallOnboardingSheet.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetGuildCallOnboardingSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildCallOnboardingBinding> {
    public static final WidgetGuildCallOnboardingSheet2 INSTANCE = new WidgetGuildCallOnboardingSheet2();

    public WidgetGuildCallOnboardingSheet2() {
        super(1, WidgetGuildCallOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildCallOnboardingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildCallOnboardingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        JoinVoiceChannelButton joinVoiceChannelButton = (JoinVoiceChannelButton) view.findViewById(R.id.guild_call_onboarding_connect);
        if (joinVoiceChannelButton != null) {
            return new WidgetGuildCallOnboardingBinding((LinearLayout) view, joinVoiceChannelButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.guild_call_onboarding_connect)));
    }
}
