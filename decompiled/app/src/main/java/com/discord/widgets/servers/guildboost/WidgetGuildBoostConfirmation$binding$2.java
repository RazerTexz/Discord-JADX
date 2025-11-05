package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetServerBoostConfirmationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildBoostConfirmation.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostConfirmation$binding$2 extends k implements Function1<View, WidgetServerBoostConfirmationBinding> {
    public static final WidgetGuildBoostConfirmation$binding$2 INSTANCE = new WidgetGuildBoostConfirmation$binding$2();

    public WidgetGuildBoostConfirmation$binding$2() {
        super(1, WidgetServerBoostConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerBoostConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerBoostConfirmationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.boost_confirmation_button_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.boost_confirmation_button_container);
        if (linearLayout != null) {
            i = R.id.boost_confirmation_confirmation_view;
            GuildBoostConfirmationView guildBoostConfirmationView = (GuildBoostConfirmationView) view.findViewById(R.id.boost_confirmation_confirmation_view);
            if (guildBoostConfirmationView != null) {
                i = R.id.boost_confirmation_cooldown_warning;
                TextView textView = (TextView) view.findViewById(R.id.boost_confirmation_cooldown_warning);
                if (textView != null) {
                    i = R.id.boost_confirmation_error;
                    TextView textView2 = (TextView) view.findViewById(R.id.boost_confirmation_error);
                    if (textView2 != null) {
                        i = R.id.boost_confirmation_select;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.boost_confirmation_select);
                        if (materialButton != null) {
                            i = R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                            if (dimmerView != null) {
                                return new WidgetServerBoostConfirmationBinding((CoordinatorLayout) view, linearLayout, guildBoostConfirmationView, textView, textView2, materialButton, dimmerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
