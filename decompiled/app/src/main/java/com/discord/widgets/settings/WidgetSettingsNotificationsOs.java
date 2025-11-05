package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSettingsNotificationOsBinding;
import com.discord.stores.StoreNotifications;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.navigation.SystemSettingNavigators;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* compiled from: WidgetSettingsNotificationsOs.kt */
@RequiresApi(26)
/* loaded from: classes2.dex */
public final class WidgetSettingsNotificationsOs extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsNotificationsOs.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsNotificationOsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsNotificationsOs.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            new WidgetSettingsNotificationsOs().show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsNotificationsOs.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<NotificationClient.SettingsV2, Unit> {
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
            m.checkNotNullParameter(settingsV2, "settings");
            CheckedSetting checkedSetting = WidgetSettingsNotificationsOs.access$getBinding$p(WidgetSettingsNotificationsOs.this).d;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsNotificationSwitch");
            checkedSetting.setChecked(settingsV2.isEnabled());
            CheckedSetting checkedSetting2 = WidgetSettingsNotificationsOs.access$getBinding$p(WidgetSettingsNotificationsOs.this).f2631b;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsInappNotifsSwitch");
            checkedSetting2.setChecked(settingsV2.isEnabledInApp());
        }
    }

    /* compiled from: WidgetSettingsNotificationsOs.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
            m.checkNotNullExpressionValue(bool, "it");
            notifications.setEnabled(bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsNotificationsOs.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreNotifications notifications = StoreStream.INSTANCE.getNotifications();
            m.checkNotNullExpressionValue(bool, "it");
            StoreNotifications.setEnabledInApp$default(notifications, bool.booleanValue(), false, 2, null);
        }
    }

    /* compiled from: WidgetSettingsNotificationsOs.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsNotificationsOs$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SystemSettingNavigators systemSettingNavigators = SystemSettingNavigators.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            systemSettingNavigators.openSystemNotification(context);
            WidgetSettingsNotificationsOs.this.dismiss();
        }
    }

    public WidgetSettingsNotificationsOs() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsNotificationsOs$binding$2.INSTANCE, null, 2, null);
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
        return R.layout.widget_settings_notification_os;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getNotifications().getSettings(), this, null, 2, null), WidgetSettingsNotificationsOs.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().d.setOnCheckedListener(AnonymousClass1.INSTANCE);
        getBinding().f2631b.setOnCheckedListener(AnonymousClass2.INSTANCE);
        getBinding().c.setOnClickListener(new AnonymousClass3());
    }
}
