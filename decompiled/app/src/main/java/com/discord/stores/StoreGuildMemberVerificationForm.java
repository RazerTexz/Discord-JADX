package com.discord.stores;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGuildMemberVerificationForm.kt */
/* loaded from: classes2.dex */
public final class StoreGuildMemberVerificationForm extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, MemberVerificationFormData> memberVerificationFormSnapshot;
    private final HashMap<Long, MemberVerificationFormData> memberVerificationFormState;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    public enum FetchStates {
        FETCHING,
        FAILED,
        SUCCEEDED
    }

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    public static final /* data */ class MemberVerificationFormData {
        private final FetchStates fetchState;
        private final ModelMemberVerificationForm form;

        public MemberVerificationFormData(FetchStates fetchStates, ModelMemberVerificationForm modelMemberVerificationForm) {
            Intrinsics3.checkNotNullParameter(fetchStates, "fetchState");
            this.fetchState = fetchStates;
            this.form = modelMemberVerificationForm;
        }

        public static /* synthetic */ MemberVerificationFormData copy$default(MemberVerificationFormData memberVerificationFormData, FetchStates fetchStates, ModelMemberVerificationForm modelMemberVerificationForm, int i, Object obj) {
            if ((i & 1) != 0) {
                fetchStates = memberVerificationFormData.fetchState;
            }
            if ((i & 2) != 0) {
                modelMemberVerificationForm = memberVerificationFormData.form;
            }
            return memberVerificationFormData.copy(fetchStates, modelMemberVerificationForm);
        }

        /* renamed from: component1, reason: from getter */
        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelMemberVerificationForm getForm() {
            return this.form;
        }

        public final MemberVerificationFormData copy(FetchStates fetchState, ModelMemberVerificationForm form) {
            Intrinsics3.checkNotNullParameter(fetchState, "fetchState");
            return new MemberVerificationFormData(fetchState, form);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberVerificationFormData)) {
                return false;
            }
            MemberVerificationFormData memberVerificationFormData = (MemberVerificationFormData) other;
            return Intrinsics3.areEqual(this.fetchState, memberVerificationFormData.fetchState) && Intrinsics3.areEqual(this.form, memberVerificationFormData.form);
        }

        public final FetchStates getFetchState() {
            return this.fetchState;
        }

        public final ModelMemberVerificationForm getForm() {
            return this.form;
        }

        public int hashCode() {
            FetchStates fetchStates = this.fetchState;
            int iHashCode = (fetchStates != null ? fetchStates.hashCode() : 0) * 31;
            ModelMemberVerificationForm modelMemberVerificationForm = this.form;
            return iHashCode + (modelMemberVerificationForm != null ? modelMemberVerificationForm.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberVerificationFormData(fetchState=");
            sbU.append(this.fetchState);
            sbU.append(", form=");
            sbU.append(this.form);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildMemberVerificationForm.kt */
        /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01211 extends Lambda implements Function1<ModelMemberVerificationForm, Unit> {

            /* compiled from: StoreGuildMemberVerificationForm.kt */
            /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01221 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelMemberVerificationForm $memberVerificationForm;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01221(ModelMemberVerificationForm modelMemberVerificationForm) {
                    super(0);
                    this.$memberVerificationForm = modelMemberVerificationForm;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchSuccess(StoreGuildMemberVerificationForm.this, anonymousClass1.$guildId, this.$memberVerificationForm);
                }
            }

            public C01211() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationForm modelMemberVerificationForm) {
                invoke2(modelMemberVerificationForm);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelMemberVerificationForm modelMemberVerificationForm) {
                Intrinsics3.checkNotNullParameter(modelMemberVerificationForm, "memberVerificationForm");
                StoreGuildMemberVerificationForm.access$getDispatcher$p(StoreGuildMemberVerificationForm.this).schedule(new C01221(modelMemberVerificationForm));
            }
        }

        /* compiled from: StoreGuildMemberVerificationForm.kt */
        /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildMemberVerificationForm.kt */
            /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$fetchMemberVerificationForm$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01231 extends Lambda implements Function0<Unit> {
                public C01231() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchFailed(StoreGuildMemberVerificationForm.this, anonymousClass1.$guildId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreGuildMemberVerificationForm.access$getDispatcher$p(StoreGuildMemberVerificationForm.this).schedule(new C01231());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MemberVerificationFormData memberVerificationFormData = (MemberVerificationFormData) StoreGuildMemberVerificationForm.access$getMemberVerificationFormState$p(StoreGuildMemberVerificationForm.this).get(Long.valueOf(this.$guildId));
            if ((memberVerificationFormData != null ? memberVerificationFormData.getFetchState() : null) == FetchStates.FETCHING) {
                return;
            }
            StoreGuildMemberVerificationForm.access$handleMemberVerificationFormFetchStart(StoreGuildMemberVerificationForm.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreGuildMemberVerificationForm.access$getRestAPI$p(StoreGuildMemberVerificationForm.this).getGuildMemberVerificationForm(this.$guildId), false, 1, null), StoreGuildMemberVerificationForm.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01211(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildMemberVerificationForm.kt */
    /* renamed from: com.discord.stores.StoreGuildMemberVerificationForm$observeMemberVerificationFormData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<MemberVerificationFormData> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MemberVerificationFormData invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberVerificationFormData invoke() {
            return StoreGuildMemberVerificationForm.this.getMemberVerificationFormData(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getMemberVerificationFormState$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.memberVerificationFormState;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm) {
        return storeGuildMemberVerificationForm.restAPI;
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchFailed(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchStart(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchStart(j);
    }

    public static final /* synthetic */ void access$handleMemberVerificationFormFetchSuccess(StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, long j, ModelMemberVerificationForm modelMemberVerificationForm) {
        storeGuildMemberVerificationForm.handleMemberVerificationFormFetchSuccess(j, modelMemberVerificationForm);
    }

    @Store3
    private final void handleMemberVerificationFormFetchFailed(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.FAILED, null));
        markChanged();
    }

    @Store3
    private final void handleMemberVerificationFormFetchStart(long guildId) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.FETCHING, null));
        markChanged();
    }

    @Store3
    private final void handleMemberVerificationFormFetchSuccess(long guildId, ModelMemberVerificationForm memberVerificationForm) {
        this.memberVerificationFormState.put(Long.valueOf(guildId), new MemberVerificationFormData(FetchStates.SUCCEEDED, memberVerificationForm));
        markChanged();
    }

    public final void fetchMemberVerificationForm(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final MemberVerificationFormData getMemberVerificationFormData(long guildId) {
        return this.memberVerificationFormSnapshot.get(Long.valueOf(guildId));
    }

    public final Observable<MemberVerificationFormData> observeMemberVerificationFormData(long guildId) {
        Observable<MemberVerificationFormData> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.memberVerificationFormSnapshot = new HashMap(this.memberVerificationFormState);
    }

    public StoreGuildMemberVerificationForm(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.memberVerificationFormSnapshot = Maps6.emptyMap();
        this.memberVerificationFormState = new HashMap<>();
    }
}
