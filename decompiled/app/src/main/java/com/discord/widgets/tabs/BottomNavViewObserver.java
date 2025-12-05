package com.discord.widgets.tabs;

import com.discord.widgets.tabs.TabsHostBottomNavigationView;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: BottomNavViewObserver.kt */
/* loaded from: classes.dex */
public final class BottomNavViewObserver implements TabsHostBottomNavigationView.HeightChangedListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(BottomNavViewObserver2.INSTANCE);
    private final BehaviorSubject<Integer> heightSubject = BehaviorSubject.m11130l0(0);

    /* compiled from: BottomNavViewObserver.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BottomNavViewObserver getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = BottomNavViewObserver.access$getINSTANCE$cp();
            Companion companion = BottomNavViewObserver.INSTANCE;
            return (BottomNavViewObserver) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final Observable<Integer> observeHeight() {
        BehaviorSubject<Integer> behaviorSubject = this.heightSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "heightSubject");
        return behaviorSubject;
    }

    @Override // com.discord.widgets.tabs.TabsHostBottomNavigationView.HeightChangedListener
    public void onHeightChanged(int height) {
        this.heightSubject.onNext(Integer.valueOf(height));
    }
}
