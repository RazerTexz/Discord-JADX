package com.discord.utilities.views;

import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ViewVisibilityObserver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewVisibilityObserver {
    private final BehaviorSubject<Boolean> isVisibleSubject = BehaviorSubject.m11129k0();

    public final Observable<Boolean> observeIsVisible() {
        Observable<Boolean> observableM11112r = this.isVisibleSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "isVisibleSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void updateVisibility(boolean isVisible) {
        this.isVisibleSubject.onNext(Boolean.valueOf(isVisible));
    }
}
