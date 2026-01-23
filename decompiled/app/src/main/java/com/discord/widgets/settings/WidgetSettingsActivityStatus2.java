package com.discord.widgets.settings;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsActivityStatus$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsActivityStatus2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsActivityStatusBinding> {
    public static final WidgetSettingsActivityStatus2 INSTANCE = new WidgetSettingsActivityStatus2();

    public WidgetSettingsActivityStatus2() {
        super(1, WidgetSettingsActivityStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsActivityStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsActivityStatusBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.show_current_activity);
        if (checkedSetting != null) {
            return new WidgetSettingsActivityStatusBinding((CoordinatorLayout) view, checkedSetting);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.show_current_activity)));
    }
}
