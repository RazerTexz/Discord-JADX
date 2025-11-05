package com.discord.stores;

import com.discord.api.requiredaction.UserRequiredActionUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreUserRequiredActions.kt */
/* loaded from: classes2.dex */
public final class StoreUserRequiredActions extends StoreV2 {
    private final ObservationDeck observationDeck;
    private RequiredAction userRequiredAction;

    /* compiled from: StoreUserRequiredActions.kt */
    /* renamed from: com.discord.stores.StoreUserRequiredActions$observeUserRequiredAction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<RequiredAction> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ RequiredAction invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RequiredAction invoke() {
            return StoreUserRequiredActions.access$getUserRequiredAction$p(StoreUserRequiredActions.this);
        }
    }

    public StoreUserRequiredActions(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.userRequiredAction = RequiredAction.NONE;
    }

    public static final /* synthetic */ RequiredAction access$getUserRequiredAction$p(StoreUserRequiredActions storeUserRequiredActions) {
        return storeUserRequiredActions.userRequiredAction;
    }

    public static final /* synthetic */ void access$setUserRequiredAction$p(StoreUserRequiredActions storeUserRequiredActions, RequiredAction requiredAction) {
        storeUserRequiredActions.userRequiredAction = requiredAction;
    }

    @StoreThread
    private final void updateUserRequiredAction(RequiredAction userRequiredAction) {
        if (userRequiredAction == RequiredAction.REQUIRE_CAPTCHA) {
            userRequiredAction = RequiredAction.REQUIRE_VERIFIED_PHONE;
        }
        this.userRequiredAction = userRequiredAction;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        updateUserRequiredAction(RequiredAction.INSTANCE.fromApiString(payload != null ? payload.getRequiredAction() : null));
        markChanged();
    }

    @StoreThread
    public final void handleUserRequiredActionUpdate(UserRequiredActionUpdate userRequiredActionUpdate) {
        m.checkNotNullParameter(userRequiredActionUpdate, "userRequiredActionUpdate");
        updateUserRequiredAction(RequiredAction.INSTANCE.fromApiString(userRequiredActionUpdate.getRequiredAction()));
        markChanged();
    }

    public final Observable<RequiredAction> observeUserRequiredAction() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }
}
