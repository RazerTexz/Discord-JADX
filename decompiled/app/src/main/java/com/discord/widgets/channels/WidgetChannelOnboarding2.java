package com.discord.widgets.channels;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.R;
import com.discord.databinding.WidgetChannelOnboardingBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelOnboarding.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelOnboarding$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelOnboarding2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelOnboardingBinding> {
    public static final WidgetChannelOnboarding2 INSTANCE = new WidgetChannelOnboarding2();

    public WidgetChannelOnboarding2() {
        super(1, WidgetChannelOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelOnboardingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelOnboardingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.channel_actions_view);
        if (materialButton != null) {
            return new WidgetChannelOnboardingBinding((LinearLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.channel_actions_view)));
    }
}
