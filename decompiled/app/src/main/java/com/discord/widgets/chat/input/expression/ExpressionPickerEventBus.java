package com.discord.widgets.chat.input.expression;

import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: ExpressionPickerEventBus.kt */
/* loaded from: classes2.dex */
public final class ExpressionPickerEventBus {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(ExpressionPickerEventBus2.INSTANCE);
    private final PublishSubject<ExpressionPickerEvent> expressionPickerEventSubject = PublishSubject.m11133k0();

    /* compiled from: ExpressionPickerEventBus.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ExpressionPickerEventBus getINSTANCE() {
            Lazy lazyAccess$getINSTANCE$cp = ExpressionPickerEventBus.access$getINSTANCE$cp();
            Companion companion = ExpressionPickerEventBus.INSTANCE;
            return (ExpressionPickerEventBus) lazyAccess$getINSTANCE$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public final void emitEvent(ExpressionPickerEvent expressionPickerEvent) {
        Intrinsics3.checkNotNullParameter(expressionPickerEvent, "expressionPickerEvent");
        this.expressionPickerEventSubject.f27650k.onNext(expressionPickerEvent);
    }

    public final Observable<ExpressionPickerEvent> observeExpressionPickerEvents() {
        PublishSubject<ExpressionPickerEvent> publishSubject = this.expressionPickerEventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "expressionPickerEventSubject");
        return publishSubject;
    }
}
