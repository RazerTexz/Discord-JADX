package com.discord.widgets.user.search;

import kotlin.Unit;
import p007b.p008a.p018d.AppViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetGlobalSearchDismissModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchDismissModel extends AppViewModel<Unit> {
    private final PublishSubject<Unit> dismissEventsSubject;

    public WidgetGlobalSearchDismissModel() {
        super(null, 1, null);
        this.dismissEventsSubject = PublishSubject.m11133k0();
    }

    public final void dismiss() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        publishSubject.f27650k.onNext(Unit.f27425a);
    }

    public final Observable<Unit> getDismissEvents() {
        PublishSubject<Unit> publishSubject = this.dismissEventsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "dismissEventsSubject");
        return publishSubject;
    }
}
