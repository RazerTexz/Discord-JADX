package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.views.CheckedSetting;
import com.discord.views.ScreenTitleView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsCommunityFirstStep2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsCommunitySetupFirstStepBinding> {
    public static final WidgetServerSettingsCommunityFirstStep2 INSTANCE = new WidgetServerSettingsCommunityFirstStep2();

    public WidgetServerSettingsCommunityFirstStep2() {
        super(1, WidgetServerSettingsCommunitySetupFirstStepBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsCommunitySetupFirstStepBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsCommunitySetupFirstStepBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ScrollView scrollView = (ScrollView) view;
        int i = C5419R.id.community_get_started_header_image;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.community_get_started_header_image);
        if (imageView != null) {
            i = C5419R.id.community_settings_scan_messages_switch;
            CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.community_settings_scan_messages_switch);
            if (checkedSetting != null) {
                i = C5419R.id.community_settings_verified_emailed_switch;
                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.community_settings_verified_emailed_switch);
                if (checkedSetting2 != null) {
                    i = C5419R.id.community_step_header;
                    ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.community_step_header);
                    if (screenTitleView != null) {
                        return new WidgetServerSettingsCommunitySetupFirstStepBinding((ScrollView) view, scrollView, imageView, checkedSetting, checkedSetting2, screenTitleView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
