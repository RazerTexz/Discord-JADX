package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.expression.ExpressionTrayTab;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreExpressionPickerNavigation.kt */
/* loaded from: classes2.dex */
public final class StoreExpressionPickerNavigation extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private ExpressionTrayTab selectedTab;
    private final Persister<ExpressionTrayTab> selectedTabPersister;

    /* compiled from: StoreExpressionPickerNavigation.kt */
    /* renamed from: com.discord.stores.StoreExpressionPickerNavigation$observeSelectedTab$1 */
    public static final class C59271 extends Lambda implements Function0<ExpressionTrayTab> {
        public C59271() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ExpressionTrayTab invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExpressionTrayTab invoke() {
            return StoreExpressionPickerNavigation.access$getSelectedTab$p(StoreExpressionPickerNavigation.this);
        }
    }

    /* compiled from: StoreExpressionPickerNavigation.kt */
    /* renamed from: com.discord.stores.StoreExpressionPickerNavigation$onSelectTab$1 */
    public static final class C59281 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ExpressionTrayTab $expressionTrayTab;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59281(ExpressionTrayTab expressionTrayTab) {
            super(0);
            this.$expressionTrayTab = expressionTrayTab;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpressionPickerNavigation.access$setSelectedTab$p(StoreExpressionPickerNavigation.this, this.$expressionTrayTab);
            StoreExpressionPickerNavigation.this.markChanged();
        }
    }

    public StoreExpressionPickerNavigation(ObservationDeck observationDeck, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.selectedTab = ExpressionTrayTab.EMOJI;
        Persister<ExpressionTrayTab> persister = new Persister<>("CACHE_KEY_SELECTED_EXPRESSION_TRAY_TAB", this.selectedTab);
        this.selectedTabPersister = persister;
        this.selectedTab = persister.get();
    }

    public static final /* synthetic */ ExpressionTrayTab access$getSelectedTab$p(StoreExpressionPickerNavigation storeExpressionPickerNavigation) {
        return storeExpressionPickerNavigation.selectedTab;
    }

    public static final /* synthetic */ void access$setSelectedTab$p(StoreExpressionPickerNavigation storeExpressionPickerNavigation, ExpressionTrayTab expressionTrayTab) {
        storeExpressionPickerNavigation.selectedTab = expressionTrayTab;
    }

    public final Observable<ExpressionTrayTab> observeSelectedTab() {
        Observable<ExpressionTrayTab> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59271(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void onSelectTab(ExpressionTrayTab expressionTrayTab) {
        Intrinsics3.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.dispatcher.schedule(new C59281(expressionTrayTab));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        this.selectedTabPersister.set(this.selectedTab, true);
    }
}
