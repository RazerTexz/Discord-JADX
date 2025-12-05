package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.premium.ShinyButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChangeGuildIdentity.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeGuildIdentity3 extends FunctionReferenceImpl implements Function1<View, WidgetChangeGuildIdentityBinding> {
    public static final WidgetChangeGuildIdentity3 INSTANCE = new WidgetChangeGuildIdentity3();

    public WidgetChangeGuildIdentity3() {
        super(1, WidgetChangeGuildIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChangeGuildIdentityBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.avatar_header;
        TextView textView = (TextView) view.findViewById(C5419R.id.avatar_header);
        if (textView != null) {
            i = C5419R.id.banner_edit;
            CardView cardView = (CardView) view.findViewById(C5419R.id.banner_edit);
            if (cardView != null) {
                i = C5419R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                if (dimmerView != null) {
                    i = C5419R.id.get_premium_button;
                    ShinyButton shinyButton = (ShinyButton) view.findViewById(C5419R.id.get_premium_button);
                    if (shinyButton != null) {
                        i = C5419R.id.guild_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.guild_avatar);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.guild_avatar_card;
                            CardView cardView2 = (CardView) view.findViewById(C5419R.id.guild_avatar_card);
                            if (cardView2 != null) {
                                i = C5419R.id.guild_avatar_container;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.guild_avatar_container);
                                if (relativeLayout != null) {
                                    i = C5419R.id.nickname_editor_card;
                                    CardView cardView3 = (CardView) view.findViewById(C5419R.id.nickname_editor_card);
                                    if (cardView3 != null) {
                                        i = C5419R.id.save_fab;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.save_fab);
                                        if (floatingActionButton != null) {
                                            i = C5419R.id.set_nickname_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.set_nickname_text);
                                            if (textInputLayout != null) {
                                                i = C5419R.id.upsell_section;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.upsell_section);
                                                if (linearLayout != null) {
                                                    return new WidgetChangeGuildIdentityBinding((CoordinatorLayout) view, textView, cardView, dimmerView, shinyButton, simpleDraweeView, cardView2, relativeLayout, cardView3, floatingActionButton, textInputLayout, linearLayout);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
