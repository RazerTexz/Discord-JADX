package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.navigation.SystemSettingNavigators;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
public final class WidgetSettingsNotificationsOs extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsNotificationsOs.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetSettingsNotificationsOs().show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class C96541 extends Lambda implements Function1<NotificationClient.SettingsV2, Unit> {
        public C96541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NotificationClient.SettingsV2 settingsV2) {
            invoke2(settingsV2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NotificationClient.SettingsV2 settingsV2) {
            Intrinsics3.checkNotNullParameter(settingsV2, "settings");
            CheckedSetting checkedSetting = WidgetSettingsNotificationsOs.access$getBinding$p(WidgetSettingsNotificationsOs.this).f18021d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationSwitch");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotificationsOs.access$getBinding$p(WidgetSettingsNotificationsOs.this).f18019b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class C96551<T> implements Action1<Boolean> {
        public static final C96551 INSTANCE = new C96551();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
            Intrinsics3.checkNotNullExpressionValue(bool, "it");
            notifications.setEnabled(bool.booleanValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class C96562<T> implements Action1<Boolean> {
        public static final C96562 INSTANCE = new C96562();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
            Intrinsics3.checkNotNullExpressionValue(bool, "it");
            StoreNotifications.setEnabledInApp$default(notifications, bool.booleanValue(), false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class ViewOnClickListenerC96573 implements View.OnClickListener {
        public ViewOnClickListenerC96573() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            systemSettingNavigators.openSystemNotification(context);
            WidgetSettingsNotificationsOs.this.dismiss();
        }
    }

    public WidgetSettingsNotificationsOs() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsNotificationsOs2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetSettingsNotificationOsBinding access$getBinding$p(WidgetSettingsNotificationsOs widgetSettingsNotificationsOs) {
        return widgetSettingsNotificationsOs.getBinding();
    }

    private final WidgetSettingsNotificationOsBinding getBinding() {
        return (WidgetSettingsNotificationOsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager) {
        INSTANCE.show(fragmentManager);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_settings_notification_os;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), WidgetSettingsNotificationsOs.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96541(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f18021d.setOnCheckedListener(C96551.INSTANCE);
        getBinding().f18019b.setOnCheckedListener(C96562.INSTANCE);
        getBinding().f18020c.setOnClickListener(new ViewOnClickListenerC96573());
    }
}
