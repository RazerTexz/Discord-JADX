package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsActivityStatusBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsActivityStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsActivityStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsActivityStatusBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsActivityStatus.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsActivityStatus$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
    public static final class C96251<T> implements Action1<Boolean> {
        public C96251() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
            AppActivity appActivity = WidgetSettingsActivityStatus.this.getAppActivity();
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            userSettings.setIsShowCurrentGameEnabled(appActivity, bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsActivityStatus$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsActivityStatus.kt */
    public static final class C96261 extends Lambda implements Function1<Boolean, Unit> {
        public C96261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetSettingsActivityStatus.access$configureUI(WidgetSettingsActivityStatus.this, z2);
        }
    }

    public WidgetSettingsActivityStatus() {
        super(C5419R.layout.widget_settings_activity_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsActivityStatus2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsActivityStatus widgetSettingsActivityStatus, boolean z2) {
        widgetSettingsActivityStatus.configureUI(z2);
    }

    private final void configureUI(boolean showCurrentGame) {
        CheckedSetting checkedSetting = getBinding().f17847b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.showCurrentActivity");
        checkedSetting.setChecked(showCurrentGame);
        getBinding().f17847b.setOnCheckedListener(new C96251());
    }

    private final WidgetSettingsActivityStatusBinding getBinding() {
        return (WidgetSettingsActivityStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.activity_status);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUserSettings().observeIsShowCurrentGameEnabled(), this, null, 2, null), WidgetSettingsActivityStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96261(), 62, (Object) null);
    }
}
