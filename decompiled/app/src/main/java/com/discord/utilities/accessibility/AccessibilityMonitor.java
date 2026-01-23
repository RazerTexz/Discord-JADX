package com.discord.utilities.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: AccessibilityMonitor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityMonitor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(AccessibilityMonitor2.INSTANCE);
    private AccessibilityManager accessibilityManager;
    private AccessibilityMonitor4 accessibilityState;
    private final SerializedSubject<AccessibilityMonitor4, AccessibilityMonitor4> accessibilityStateSubject;
    private final ContentObserver animationScaleObserver = new AccessibilityMonitor3(this, new Handler(Looper.getMainLooper()));
    private ContentResolver contentResolver;

    /* JADX INFO: compiled from: AccessibilityMonitor.kt */
    public static final class Companion {
        private Companion() {
        }

        public final AccessibilityMonitor getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = AccessibilityMonitor.access$getINSTANCE$cp();
            Companion companion = AccessibilityMonitor.INSTANCE;
            return (AccessibilityMonitor) lazyAccess$getINSTANCE$cp.getValue();
        }

        public final void initialize(Application application) {
            Intrinsics3.checkNotNullParameter(application, "application");
            getINSTANCE().bindContext(application);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.accessibility.AccessibilityMonitor$handleInitialState$1 */
    /* JADX INFO: compiled from: AccessibilityMonitor.kt */
    public static final class AccessibilityManagerAccessibilityStateChangeListenerC66641 implements AccessibilityManager.AccessibilityStateChangeListener {

        /* JADX INFO: renamed from: com.discord.utilities.accessibility.AccessibilityMonitor$handleInitialState$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: AccessibilityMonitor.kt */
        public static final class AnonymousClass1<T> implements Action1<Unit> {
            public final /* synthetic */ boolean $enabled;

            public AnonymousClass1(boolean z2) {
                this.$enabled = z2;
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Unit unit) {
                call2(unit);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Unit unit) {
                AccessibilityMonitor.access$handleScreenreaderEnabledUpdate(AccessibilityMonitor.this, this.$enabled);
            }
        }

        public AccessibilityManagerAccessibilityStateChangeListenerC66641() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean z2) {
            new ScalarSynchronousObservable(Unit.f27425a).m11111q(200L, TimeUnit.MILLISECONDS).m11096V(new AnonymousClass1(z2));
        }
    }

    public AccessibilityMonitor() {
        AccessibilityMonitor4 accessibilityMonitor4 = new AccessibilityMonitor4(null, 1, null);
        this.accessibilityState = accessibilityMonitor4;
        this.accessibilityStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(accessibilityMonitor4));
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ void access$handleReduceMotionUpdated(AccessibilityMonitor accessibilityMonitor) {
        accessibilityMonitor.handleReduceMotionUpdated();
    }

    public static final /* synthetic */ void access$handleScreenreaderEnabledUpdate(AccessibilityMonitor accessibilityMonitor, boolean z2) {
        accessibilityMonitor.handleScreenreaderEnabledUpdate(z2);
    }

    private final synchronized void handleInitialState(Context context) {
        Object systemService = context.getSystemService("accessibility");
        if (!(systemService instanceof AccessibilityManager)) {
            systemService = null;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        if (accessibilityManager != null) {
            this.accessibilityManager = accessibilityManager;
            if (accessibilityManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            accessibilityManager.addAccessibilityStateChangeListener(new AccessibilityManagerAccessibilityStateChangeListenerC66641());
            AccessibilityManager accessibilityManager2 = this.accessibilityManager;
            if (accessibilityManager2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
            }
            handleScreenreaderEnabledUpdate(accessibilityManager2.isEnabled());
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            this.contentResolver = contentResolver;
            Uri uriFor = Settings.Global.getUriFor("transition_animation_scale");
            ContentResolver contentResolver2 = this.contentResolver;
            if (contentResolver2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("contentResolver");
            }
            contentResolver2.registerContentObserver(uriFor, false, this.animationScaleObserver);
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
            handleUIModeUpdate(resources.getConfiguration().uiMode);
        }
    }

    private final void handleReduceMotionUpdated() {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        ContentResolver contentResolver = this.contentResolver;
        if (contentResolver == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("contentResolver");
        }
        String string = Settings.Global.getString(contentResolver, "transition_animation_scale");
        if (Intrinsics3.areEqual(string, "0.0") || Intrinsics3.areEqual(string, "0")) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.REDUCED_MOTION);
        } else {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.REDUCED_MOTION);
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleScreenreaderEnabledUpdate(boolean enabled) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("accessibilityManager");
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabled) {
            Intrinsics3.checkNotNullExpressionValue(enabledAccessibilityServiceList, "services");
            if (!enabledAccessibilityServiceList.isEmpty()) {
                enumSetCopyOf.add(AccessibilityFeatureFlags.SCREENREADER);
            } else {
                enumSetCopyOf.remove(AccessibilityFeatureFlags.SCREENREADER);
            }
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    private final void handleUIModeUpdate(int uiMode) {
        EnumSet<AccessibilityFeatureFlags> enumSetCopyOf = EnumSet.copyOf((EnumSet) this.accessibilityState.getFeatures());
        int i = uiMode & 48;
        if (i == 16) {
            enumSetCopyOf.add(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
        } else if (i != 32) {
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
        } else {
            enumSetCopyOf.add(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_DARK);
            enumSetCopyOf.remove(AccessibilityFeatureFlags.PREFERS_COLOR_SCHEME_LIGHT);
        }
        AccessibilityMonitor4 accessibilityMonitor4 = this.accessibilityState;
        Intrinsics3.checkNotNullExpressionValue(enumSetCopyOf, "features");
        updateAccessibilityState(accessibilityMonitor4.copy(enumSetCopyOf));
    }

    private final void updateAccessibilityState(AccessibilityMonitor4 newState) {
        this.accessibilityState = newState;
        this.accessibilityStateSubject.f27653k.onNext(newState);
    }

    public final void bindContext(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        handleInitialState(context);
    }

    public final Observable<AccessibilityMonitor4> observeAccessibilityState() {
        Observable<AccessibilityMonitor4> observableM11112r = this.accessibilityStateSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "accessibilityStateSubject.distinctUntilChanged()");
        return observableM11112r;
    }
}
