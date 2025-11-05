package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreAutocomplete.kt */
/* loaded from: classes2.dex */
public final class StoreAutocomplete extends StoreV2 {
    private boolean autocompleteVisible;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreAutocomplete.kt */
    /* renamed from: com.discord.stores.StoreAutocomplete$observeAutocompleteVisibility$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreAutocomplete.access$getAutocompleteVisible$p(StoreAutocomplete.this);
        }
    }

    /* compiled from: StoreAutocomplete.kt */
    /* renamed from: com.discord.stores.StoreAutocomplete$setAutocompleteVisible$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ boolean $visible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$visible = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAutocomplete.access$setAutocompleteVisible$p(StoreAutocomplete.this, this.$visible);
            StoreAutocomplete.this.markChanged();
        }
    }

    public StoreAutocomplete(ObservationDeck observationDeck, Dispatcher dispatcher) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ boolean access$getAutocompleteVisible$p(StoreAutocomplete storeAutocomplete) {
        return storeAutocomplete.autocompleteVisible;
    }

    public static final /* synthetic */ void access$setAutocompleteVisible$p(StoreAutocomplete storeAutocomplete, boolean z2) {
        storeAutocomplete.autocompleteVisible = z2;
    }

    public final Observable<Boolean> observeAutocompleteVisibility() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setAutocompleteVisible(boolean visible) {
        this.dispatcher.schedule(new AnonymousClass1(visible));
    }
}
