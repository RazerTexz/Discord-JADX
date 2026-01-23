package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsCommunitySetupSecondStepBinding;
import com.discord.views.ScreenTitleView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunitySecondStep2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCommunitySetupSecondStepBinding> {
    public static final WidgetServerSettingsCommunitySecondStep2 INSTANCE = new WidgetServerSettingsCommunitySecondStep2();

    public WidgetServerSettingsCommunitySecondStep2() {
        super(1, WidgetServerSettingsCommunitySetupSecondStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunitySetupSecondStepBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunitySetupSecondStepBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = C5419R.id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.community_get_started_header_image);
        if (imageView != null) {
            i = C5419R.id.community_guidelines_channel;
            CommunitySelectorView communitySelectorView = (CommunitySelectorView) view.findViewById(C5419R.id.community_guidelines_channel);
            if (communitySelectorView != null) {
                i = C5419R.id.community_step_header;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.community_step_header);
                if (screenTitleView != null) {
                    i = C5419R.id.community_updates_channel;
                    CommunitySelectorView communitySelectorView2 = (CommunitySelectorView) view.findViewById(C5419R.id.community_updates_channel);
                    if (communitySelectorView2 != null) {
                        return new WidgetServerSettingsCommunitySetupSecondStepBinding((ScrollView) view, scrollView, imageView, communitySelectorView, screenTitleView, communitySelectorView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
