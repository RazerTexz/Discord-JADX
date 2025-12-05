package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildBoostTransfer.kt */
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostTransfer2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildBoostTransferBinding> {
    public static final WidgetGuildBoostTransfer2 INSTANCE = new WidgetGuildBoostTransfer2();

    public WidgetGuildBoostTransfer2() {
        super(1, WidgetGuildBoostTransferBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildBoostTransferBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildBoostTransferBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.guild_boost_transfer_confirmation_blurb;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_boost_transfer_confirmation_blurb);
            if (textView != null) {
                i = C5419R.id.guild_boost_transfer_error;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_boost_transfer_error);
                if (textView2 != null) {
                    i = C5419R.id.guild_boost_transfer_previous_guild;
                    GuildBoostConfirmationView guildBoostConfirmationView = (GuildBoostConfirmationView) view.findViewById(C5419R.id.guild_boost_transfer_previous_guild);
                    if (guildBoostConfirmationView != null) {
                        i = C5419R.id.guild_boost_transfer_previous_guild_header;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_boost_transfer_previous_guild_header);
                        if (textView3 != null) {
                            i = C5419R.id.guild_boost_transfer_select;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_boost_transfer_select);
                            if (materialButton != null) {
                                i = C5419R.id.guild_boost_transfer_target_guild;
                                GuildBoostConfirmationView guildBoostConfirmationView2 = (GuildBoostConfirmationView) view.findViewById(C5419R.id.guild_boost_transfer_target_guild);
                                if (guildBoostConfirmationView2 != null) {
                                    i = C5419R.id.guild_boost_transfer_target_guild_header;
                                    TextView textView4 = (TextView) view.findViewById(C5419R.id.guild_boost_transfer_target_guild_header);
                                    if (textView4 != null) {
                                        return new WidgetGuildBoostTransferBinding((CoordinatorLayout) view, dimmerView, textView, textView2, guildBoostConfirmationView, textView3, materialButton, guildBoostConfirmationView2, textView4);
                                    }
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
