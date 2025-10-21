package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsActivityStatus.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsActivityStatus$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsActivityStatus2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsActivityStatusBinding> {
    public static final WidgetSettingsActivityStatus2 INSTANCE = new WidgetSettingsActivityStatus2();

    public WidgetSettingsActivityStatus2() {
        super(1, WidgetSettingsActivityStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsActivityStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsActivityStatusBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.show_current_activity);
        if (checkedSetting != null) {
            return new WidgetSettingsActivityStatusBinding((CoordinatorLayout) view, checkedSetting);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.show_current_activity)));
    }
}
