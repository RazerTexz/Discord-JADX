package com.discord.widgets.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.views.CheckedSetting;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsBehavior$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsBehavior2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsBehaviorBinding> {
    public static final WidgetSettingsBehavior2 INSTANCE = new WidgetSettingsBehavior2();

    public WidgetSettingsBehavior2() {
        super(1, WidgetSettingsBehaviorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsBehaviorBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBehaviorBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.settings_behavior_browser_switch;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.settings_behavior_browser_switch);
        if (checkedSetting != null) {
            i = C5419R.id.settings_behavior_chat_header;
            TextView textView = (TextView) view.findViewById(C5419R.id.settings_behavior_chat_header);
            if (textView != null) {
                i = C5419R.id.settings_behavior_dev_mode_switch;
                CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.settings_behavior_dev_mode_switch);
                if (checkedSetting2 != null) {
                    i = C5419R.id.settings_behavior_keyboard_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.settings_behavior_keyboard_header);
                    if (textView2 != null) {
                        i = C5419R.id.settings_behavior_shift_send_toggle;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.settings_behavior_shift_send_toggle);
                        if (checkedSetting3 != null) {
                            return new WidgetSettingsBehaviorBinding((CoordinatorLayout) view, checkedSetting, textView, checkedSetting2, textView2, checkedSetting3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
