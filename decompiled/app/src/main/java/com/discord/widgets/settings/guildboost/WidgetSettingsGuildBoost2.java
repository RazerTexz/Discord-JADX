package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ViewSettingsPremiumGuildNoGuildsBinding;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGuildBoost2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsBoostBinding> {
    public static final WidgetSettingsGuildBoost2 INSTANCE = new WidgetSettingsGuildBoost2();

    public WidgetSettingsGuildBoost2() {
        super(1, WidgetSettingsBoostBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsBoostBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBoostBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.no_guilds;
        View viewFindViewById = view.findViewById(C5419R.id.no_guilds);
        if (viewFindViewById != null) {
            int i2 = C5419R.id.settings_boost_no_guilds_image;
            ImageView imageView = (ImageView) viewFindViewById.findViewById(C5419R.id.settings_boost_no_guilds_image);
            if (imageView != null) {
                i2 = C5419R.id.settings_boost_no_guilds_subtitle;
                TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.settings_boost_no_guilds_subtitle);
                if (textView != null) {
                    i2 = C5419R.id.settings_boost_no_guilds_title;
                    TextView textView2 = (TextView) viewFindViewById.findViewById(C5419R.id.settings_boost_no_guilds_title);
                    if (textView2 != null) {
                        ViewSettingsPremiumGuildNoGuildsBinding viewSettingsPremiumGuildNoGuildsBinding = new ViewSettingsPremiumGuildNoGuildsBinding((LinearLayoutCompat) viewFindViewById, imageView, textView, textView2);
                        i = C5419R.id.settings_boost_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.settings_boost_flipper);
                        if (appViewFlipper != null) {
                            i = C5419R.id.settings_boost_marketing_view;
                            GuildBoostMarketingView guildBoostMarketingView = (GuildBoostMarketingView) view.findViewById(C5419R.id.settings_boost_marketing_view);
                            if (guildBoostMarketingView != null) {
                                i = C5419R.id.settings_boost_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.settings_boost_recycler);
                                if (recyclerView != null) {
                                    i = C5419R.id.settings_boost_retry;
                                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.settings_boost_retry);
                                    if (materialButton != null) {
                                        i = C5419R.id.settings_boost_sample_guilds;
                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(C5419R.id.settings_boost_sample_guilds);
                                        if (recyclerView2 != null) {
                                            i = C5419R.id.settings_boost_subtext;
                                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.settings_boost_subtext);
                                            if (linkifiedTextView != null) {
                                                i = C5419R.id.settings_boost_subtext_container;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.settings_boost_subtext_container);
                                                if (linearLayout != null) {
                                                    i = C5419R.id.settings_boost_upsell_view;
                                                    GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView = (GuildBoostSubscriptionUpsellView) view.findViewById(C5419R.id.settings_boost_upsell_view);
                                                    if (guildBoostSubscriptionUpsellView != null) {
                                                        return new WidgetSettingsBoostBinding((CoordinatorLayout) view, viewSettingsPremiumGuildNoGuildsBinding, appViewFlipper, guildBoostMarketingView, recyclerView, materialButton, recyclerView2, linkifiedTextView, linearLayout, guildBoostSubscriptionUpsellView);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
