package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBehaviorBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior extends AppFragment {
    private static final String API_LINK = "https://discord.com/developers/docs/intro";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsBehavior.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBehaviorBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsBehavior.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetSettingsBehavior() {
        super(C5419R.layout.widget_settings_behavior);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsBehavior2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsBehaviorBinding getBinding() {
        return (WidgetSettingsBehaviorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.form_label_mobile_notifications_behavior);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        CheckedSetting checkedSetting = getBinding().f17877f;
        checkedSetting.setChecked(userSettings.getIsShiftEnterToSendEnabled());
        checkedSetting.setOnCheckedListener(new WidgetSettingsBehavior3(userSettings));
        CheckedSetting checkedSetting2 = getBinding().f17875d;
        checkedSetting2.setChecked(userSettings.getIsDeveloperMode());
        Context context = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        FormatUtils.m216h(context, C5419R.string.developer_mode_help_text, new Object[]{API_LINK}, null, 4);
        Context context2 = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.m8530h(FormatUtils.m216h(context2, C5419R.string.developer_mode_help_text, new Object[]{API_LINK}, null, 4), false);
        checkedSetting2.setSubtextOnClickListener(new WidgetSettingsBehavior6(checkedSetting2));
        checkedSetting2.setOnCheckedListener(new WidgetSettingsBehavior4(this, userSettings));
        CheckedSetting checkedSetting3 = getBinding().f17873b;
        checkedSetting3.setChecked(userSettings.getIsChromeCustomTabsEnabled());
        checkedSetting3.setOnCheckedListener(new WidgetSettingsBehavior5(userSettings));
        for (TextView textView : Collections2.listOf((Object[]) new TextView[]{getBinding().f17876e, getBinding().f17874c})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView, "header");
            accessibilityUtils.setViewIsHeading(textView);
        }
    }
}
