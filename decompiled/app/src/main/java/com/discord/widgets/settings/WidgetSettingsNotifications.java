package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsNotificationsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsNotifications.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StoreNotifications notificationStore;

    /* compiled from: WidgetSettingsNotifications.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsNotifications.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsNotifications.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsNotifications$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<NotificationClient.SettingsV2, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationClient.SettingsV2 settingsV2) {
            invoke2(settingsV2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "settings");
            LinearLayout linearLayout = WidgetSettingsNotifications.access$getBinding$p(WidgetSettingsNotifications.this).g;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsNotificationsWrap");
            linearLayout.setVisibility(settingsV2.isEnabled() ? 0 : 8);
            CheckedSetting checkedSetting = WidgetSettingsNotifications.access$getBinding$p(WidgetSettingsNotifications.this).d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationsEnabled");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotifications.access$getBinding$p(WidgetSettingsNotifications.this).f2632b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
            CheckedSetting checkedSetting3 = WidgetSettingsNotifications.access$getBinding$p(WidgetSettingsNotifications.this).c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsNotificationsBlink");
            checkedSetting3.setChecked(settingsV2.isDisableBlink());
            CheckedSetting checkedSetting4 = WidgetSettingsNotifications.access$getBinding$p(WidgetSettingsNotifications.this).f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsNotificationsVibrations");
            checkedSetting4.setChecked(settingsV2.isDisableVibrate());
            CheckedSetting checkedSetting5 = WidgetSettingsNotifications.access$getBinding$p(WidgetSettingsNotifications.this).e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsNotificationsMuteAll");
            checkedSetting5.setChecked(settingsV2.isDisableSound());
        }
    }

    public WidgetSettingsNotifications() {
        super(R.layout.widget_settings_notifications);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsNotifications2.INSTANCE, null, 2, null);
        this.notificationStore = StoreStream.INSTANCE.getNotifications();
    }

    public static final /* synthetic */ WidgetSettingsNotificationsBinding access$getBinding$p(WidgetSettingsNotifications widgetSettingsNotifications) {
        return widgetSettingsNotifications.getBinding();
    }

    private final WidgetSettingsNotificationsBinding getBinding() {
        return (WidgetSettingsNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.notifications);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StoreNotifications storeNotifications = this.notificationStore;
        getBinding().d.setOnCheckedListener(new WidgetSettingsNotifications3(storeNotifications));
        getBinding().f2632b.setOnCheckedListener(new WidgetSettingsNotifications4(storeNotifications));
        getBinding().c.setOnCheckedListener(new WidgetSettingsNotifications5(storeNotifications));
        getBinding().f.setOnCheckedListener(new WidgetSettingsNotifications6(storeNotifications));
        getBinding().e.setOnCheckedListener(new WidgetSettingsNotifications7(storeNotifications));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), WidgetSettingsNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
