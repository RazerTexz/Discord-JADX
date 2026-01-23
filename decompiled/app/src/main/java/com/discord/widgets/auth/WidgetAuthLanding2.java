package com.discord.widgets.auth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLanding$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLanding2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthLandingBinding> {
    public static final WidgetAuthLanding2 INSTANCE = new WidgetAuthLanding2();

    public WidgetAuthLanding2() {
        super(1, WidgetAuthLandingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLandingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthLandingBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthLandingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_bottom_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.auth_bottom_container);
        if (linearLayout != null) {
            i = C5419R.id.auth_landing_invite_info;
            AuthInviteInfoView authInviteInfoView = (AuthInviteInfoView) view.findViewById(C5419R.id.auth_landing_invite_info);
            if (authInviteInfoView != null) {
                i = C5419R.id.auth_landing_login;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_landing_login);
                if (materialButton != null) {
                    i = C5419R.id.auth_landing_logo;
                    ImageView imageView = (ImageView) view.findViewById(C5419R.id.auth_landing_logo);
                    if (imageView != null) {
                        i = C5419R.id.auth_landing_register;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.auth_landing_register);
                        if (materialButton2 != null) {
                            i = C5419R.id.auth_landing_switch_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.auth_landing_switch_flipper);
                            if (appViewFlipper != null) {
                                i = C5419R.id.auth_landing_title;
                                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.auth_landing_title);
                                if (screenTitleView != null) {
                                    return new WidgetAuthLandingBinding((RelativeLayout) view, linearLayout, authInviteInfoView, materialButton, imageView, materialButton2, appViewFlipper, screenTitleView);
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
