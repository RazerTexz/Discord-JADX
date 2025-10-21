package com.discord.widgets.accessibility;

import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.WidgetAccessibilityDetectionDialog;
import com.discord.app.AppComponent;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityFeatureFlags;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.accessibility.AccessibilityMonitor4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: AccessibilityDetectionNavigator.kt */
/* loaded from: classes2.dex */
public final class AccessibilityDetectionNavigator {
    public static final AccessibilityDetectionNavigator INSTANCE = new AccessibilityDetectionNavigator();

    /* compiled from: AccessibilityDetectionNavigator.kt */
    /* renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<AccessibilityMonitor4, Unit> {
        public AnonymousClass1(AccessibilityDetectionNavigator accessibilityDetectionNavigator) {
            super(1, accessibilityDetectionNavigator, AccessibilityDetectionNavigator.class, "showAccessibilityDetectionDialog", "showAccessibilityDetectionDialog(Lcom/discord/utilities/accessibility/AccessibilityState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AccessibilityMonitor4 accessibilityMonitor4) {
            invoke2(accessibilityMonitor4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AccessibilityMonitor4 accessibilityMonitor4) {
            Intrinsics3.checkNotNullParameter(accessibilityMonitor4, "p1");
            AccessibilityDetectionNavigator.access$showAccessibilityDetectionDialog((AccessibilityDetectionNavigator) this.receiver, accessibilityMonitor4);
        }
    }

    /* compiled from: AccessibilityDetectionNavigator.kt */
    /* renamed from: com.discord.widgets.accessibility.AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetAccessibilityDetectionDialog.Companion bVar = WidgetAccessibilityDetectionDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(bVar);
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new WidgetAccessibilityDetectionDialog().show(supportFragmentManager, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG");
            return true;
        }
    }

    private AccessibilityDetectionNavigator() {
    }

    public static final /* synthetic */ void access$showAccessibilityDetectionDialog(AccessibilityDetectionNavigator accessibilityDetectionNavigator, AccessibilityMonitor4 accessibilityMonitor4) {
        accessibilityDetectionNavigator.showAccessibilityDetectionDialog(accessibilityMonitor4);
    }

    private final void showAccessibilityDetectionDialog(AccessibilityMonitor4 accessibilityState) {
        if (accessibilityState.getFeatures().contains(AccessibilityFeatureFlags.SCREENREADER)) {
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("ALLOW_ACCESSIBILITY_DETECTION_DIALOG", null, 0L, 0, true, null, 0L, false, 0L, AnonymousClass1.INSTANCE, 486, null));
        }
    }

    public final void enqueueNoticeWhenEnabled(AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(AccessibilityMonitor.INSTANCE.getINSTANCE().observeAccessibilityState(), appComponent, null, 2, null), AccessibilityDetectionNavigator.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
