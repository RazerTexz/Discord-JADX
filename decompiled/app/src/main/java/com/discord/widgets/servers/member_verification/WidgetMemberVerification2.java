package com.discord.widgets.servers.member_verification;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CustomAppBarLayout;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetMemberVerification.kt */
/* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerification2 extends FunctionReferenceImpl implements Function1<View, WidgetMemberVerificationBinding> {
    public static final WidgetMemberVerification2 INSTANCE = new WidgetMemberVerification2();

    public WidgetMemberVerification2() {
        super(1, WidgetMemberVerificationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMemberVerificationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.app_bar_layout;
        CustomAppBarLayout customAppBarLayout = (CustomAppBarLayout) view.findViewById(C5419R.id.app_bar_layout);
        if (customAppBarLayout != null) {
            i = C5419R.id.collapsing_toolbar;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(C5419R.id.collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                i = C5419R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                if (dimmerView != null) {
                    i = C5419R.id.member_verification_container;
                    MemberVerificationView memberVerificationView = (MemberVerificationView) view.findViewById(C5419R.id.member_verification_container);
                    if (memberVerificationView != null) {
                        i = C5419R.id.member_verification_guild_icon;
                        MemberVerificationAvatarView memberVerificationAvatarView = (MemberVerificationAvatarView) view.findViewById(C5419R.id.member_verification_guild_icon);
                        if (memberVerificationAvatarView != null) {
                            i = C5419R.id.member_verification_rules_confirm;
                            LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.member_verification_rules_confirm);
                            if (loadingButton != null) {
                                i = C5419R.id.member_verification_rules_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.member_verification_rules_recycler);
                                if (recyclerView != null) {
                                    i = C5419R.id.member_verification_scrollview;
                                    NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(C5419R.id.member_verification_scrollview);
                                    if (nestedScrollView != null) {
                                        return new WidgetMemberVerificationBinding((CoordinatorLayout) view, customAppBarLayout, collapsingToolbarLayout, dimmerView, memberVerificationView, memberVerificationAvatarView, loadingButton, recyclerView, nestedScrollView);
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
