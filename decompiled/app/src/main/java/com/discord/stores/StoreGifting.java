package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreGifting.kt */
/* loaded from: classes2.dex */
public final class StoreGifting {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private HashMap<String, GiftState> knownGifts;
    private final BehaviorSubject<Map<String, GiftState>> knownGiftsSubject;

    /* compiled from: StoreGifting.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String makeComboId(long skuId, Long planId) {
            StringBuilder sb = new StringBuilder();
            sb.append(skuId);
            sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
            sb.append(planId);
            return sb.toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGifting.kt */
    public static abstract class GiftState {

        /* compiled from: StoreGifting.kt */
        public static final class Invalid extends GiftState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StoreGifting.kt */
        public static final class LoadFailed extends GiftState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* compiled from: StoreGifting.kt */
        public static final class Loading extends GiftState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreGifting.kt */
        public static final /* data */ class RedeemedFailed extends GiftState implements HasGift {
            private final boolean canRetry;
            private final Integer errorCode;
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RedeemedFailed(ModelGift modelGift, boolean z2, Integer num) {
                super(null);
                m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
                this.canRetry = z2;
                this.errorCode = num;
            }

            public static /* synthetic */ RedeemedFailed copy$default(RedeemedFailed redeemedFailed, ModelGift modelGift, boolean z2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = redeemedFailed.getGift();
                }
                if ((i & 2) != 0) {
                    z2 = redeemedFailed.canRetry;
                }
                if ((i & 4) != 0) {
                    num = redeemedFailed.errorCode;
                }
                return redeemedFailed.copy(modelGift, z2, num);
            }

            public final ModelGift component1() {
                return getGift();
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanRetry() {
                return this.canRetry;
            }

            /* renamed from: component3, reason: from getter */
            public final Integer getErrorCode() {
                return this.errorCode;
            }

            public final RedeemedFailed copy(ModelGift gift, boolean canRetry, Integer errorCode) {
                m.checkNotNullParameter(gift, "gift");
                return new RedeemedFailed(gift, canRetry, errorCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RedeemedFailed)) {
                    return false;
                }
                RedeemedFailed redeemedFailed = (RedeemedFailed) other;
                return m.areEqual(getGift(), redeemedFailed.getGift()) && this.canRetry == redeemedFailed.canRetry && m.areEqual(this.errorCode, redeemedFailed.errorCode);
            }

            public final boolean getCanRetry() {
                return this.canRetry;
            }

            public final Integer getErrorCode() {
                return this.errorCode;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                ModelGift gift = getGift();
                int iHashCode = (gift != null ? gift.hashCode() : 0) * 31;
                boolean z2 = this.canRetry;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Integer num = this.errorCode;
                return i2 + (num != null ? num.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("RedeemedFailed(gift=");
                sbU.append(getGift());
                sbU.append(", canRetry=");
                sbU.append(this.canRetry);
                sbU.append(", errorCode=");
                return a.F(sbU, this.errorCode, ")");
            }
        }

        /* compiled from: StoreGifting.kt */
        public static final /* data */ class Redeeming extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Redeeming(ModelGift modelGift) {
                super(null);
                m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Redeeming copy$default(Redeeming redeeming, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = redeeming.getGift();
                }
                return redeeming.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Redeeming copy(ModelGift gift) {
                m.checkNotNullParameter(gift, "gift");
                return new Redeeming(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Redeeming) && m.areEqual(getGift(), ((Redeeming) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Redeeming(gift=");
                sbU.append(getGift());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreGifting.kt */
        public static final /* data */ class Resolved extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelGift modelGift) {
                super(null);
                m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = resolved.getGift();
                }
                return resolved.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Resolved copy(ModelGift gift) {
                m.checkNotNullParameter(gift, "gift");
                return new Resolved(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && m.areEqual(getGift(), ((Resolved) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Resolved(gift=");
                sbU.append(getGift());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreGifting.kt */
        public static final /* data */ class Revoking extends GiftState implements HasGift {
            private final ModelGift gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Revoking(ModelGift modelGift) {
                super(null);
                m.checkNotNullParameter(modelGift, "gift");
                this.gift = modelGift;
            }

            public static /* synthetic */ Revoking copy$default(Revoking revoking, ModelGift modelGift, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGift = revoking.getGift();
                }
                return revoking.copy(modelGift);
            }

            public final ModelGift component1() {
                return getGift();
            }

            public final Revoking copy(ModelGift gift) {
                m.checkNotNullParameter(gift, "gift");
                return new Revoking(gift);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Revoking) && m.areEqual(getGift(), ((Revoking) other).getGift());
                }
                return true;
            }

            @Override // com.discord.stores.StoreGifting.HasGift
            public ModelGift getGift() {
                return this.gift;
            }

            public int hashCode() {
                ModelGift gift = getGift();
                if (gift != null) {
                    return gift.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Revoking(gift=");
                sbU.append(getGift());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private GiftState() {
        }

        public /* synthetic */ GiftState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGifting.kt */
    public interface HasGift {
        ModelGift getGift();
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            Error.Type type = Error.Type.DISCORD_REQUEST_ERROR;
            iArr[type.ordinal()] = 1;
            Error.Type type2 = Error.Type.NETWORK;
            iArr[type2.ordinal()] = 2;
            Error.Type.values();
            int[] iArr2 = new int[18];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[type.ordinal()] = 1;
            iArr2[type2.ordinal()] = 2;
            Error.Type.values();
            int[] iArr3 = new int[18];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[type.ordinal()] = 1;
            iArr3[type2.ordinal()] = 2;
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$acceptGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02321 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreGifting.kt */
            /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02331 extends o implements Function0<Unit> {
                public final /* synthetic */ Error $error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02331(Error error) {
                    super(0);
                    this.$error = error;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (this.$error.getType() != Error.Type.DISCORD_BAD_REQUEST) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        StoreGifting.access$setGifts(StoreGifting.this, anonymousClass1.$gift.getCode(), new GiftState.RedeemedFailed(AnonymousClass1.this.$gift, true, null));
                    }
                    this.$error.setShowErrorToasts(false);
                    Error.Response response = this.$error.getResponse();
                    m.checkNotNullExpressionValue(response, "error.response");
                    switch (response.getCode()) {
                        case RestAPIAbortCodes.GIFTING_ALREADY_USED_ERROR_CODE /* 50050 */:
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            StoreGifting storeGifting = StoreGifting.this;
                            String code = anonymousClass12.$gift.getCode();
                            ModelGift modelGift = AnonymousClass1.this.$gift;
                            StoreGifting.access$setGifts(storeGifting, code, new GiftState.Resolved(ModelGift.copy$default(modelGift, 0L, false, null, null, modelGift.getMaxUses(), null, 0, null, null, null, null, 2031, null)));
                            break;
                        case RestAPIAbortCodes.GIFTING_ALREADY_OWNED_ERROR_CODE /* 50051 */:
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            StoreGifting.access$setGifts(StoreGifting.this, anonymousClass13.$gift.getCode(), new GiftState.Resolved(ModelGift.copy$default(AnonymousClass1.this.$gift, 0L, true, null, null, 0, null, 0, null, null, null, null, 2045, null)));
                            break;
                        default:
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            StoreGifting storeGifting2 = StoreGifting.this;
                            String code2 = anonymousClass14.$gift.getCode();
                            ModelGift modelGift2 = AnonymousClass1.this.$gift;
                            Error.Response response2 = this.$error.getResponse();
                            m.checkNotNullExpressionValue(response2, "error.response");
                            StoreGifting.access$setGifts(storeGifting2, code2, new GiftState.RedeemedFailed(modelGift2, false, Integer.valueOf(response2.getCode())));
                            break;
                    }
                }
            }

            public C02321() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                m.checkNotNullParameter(error, "error");
                StoreGifting.this.getDispatcher().schedule(new C02331(error));
            }
        }

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Void, Unit> {

            /* compiled from: StoreGifting.kt */
            /* renamed from: com.discord.stores.StoreGifting$acceptGift$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02341 extends o implements Function0<Unit> {
                public C02341() {
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
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass1.$gift.getCode(), new GiftState.Resolved(ModelGift.copy$default(AnonymousClass1.this.$gift, 0L, true, null, null, 0, null, 0, null, null, null, null, 2045, null)));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r2) {
                StoreGifting.this.getDispatcher().schedule(new C02341());
                StoreStream.INSTANCE.getLibrary().fetchApplications();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGift modelGift) {
            super(0);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$gift.getCode(), new GiftState.Redeeming(this.$gift));
            Observable<Void> observableX = RestAPI.INSTANCE.getApi().acceptGift(this.$gift.getCode()).X(j0.p.a.c());
            m.checkNotNullExpressionValue(observableX, "RestAPI\n        .api\n   …scribeOn(Schedulers.io())");
            ObservableExtensionsKt.appSubscribe$default(observableX, StoreGifting.this.getClass(), (Context) null, (Function1) null, new C02321(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$fetchGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelGift, Unit> {
        public final /* synthetic */ String $giftCode;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$fetchGift$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02351 extends o implements Function0<Unit> {
            public final /* synthetic */ ModelGift $gift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02351(ModelGift modelGift) {
                super(0);
                this.$gift = modelGift;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.giftResolved(this.$gift);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGifting.access$setGifts(StoreGifting.this, anonymousClass1.$giftCode, new GiftState.Resolved(this.$gift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            m.checkNotNullParameter(modelGift, "gift");
            StoreGifting.this.getDispatcher().schedule(new C02351(modelGift));
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$fetchGift$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $giftCode;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$fetchGift$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.giftResolvedFailed(AnonymousClass2.this.$giftCode);
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$giftCode, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal != 11) {
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass22.$giftCode, GiftState.LoadFailed.INSTANCE);
                } else {
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass23.$giftCode, GiftState.LoadFailed.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$comboId, GiftState.Loading.INSTANCE);
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $comboId;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$comboId, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal == 11) {
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass22.$comboId, GiftState.LoadFailed.INSTANCE);
                } else {
                    Logger.e$default(AppLog.g, "Fetching Gift Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass23.$comboId, GiftState.LoadFailed.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<List<? extends ModelGift>, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Long $planId;
        public final /* synthetic */ long $skuId;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$fetchMyGiftsForSku$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ List $gifts;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$gifts = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifting.access$removeGiftCode(StoreGifting.this, anonymousClass3.$comboId);
                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                StoreGifting.access$clearGiftsForSku(StoreGifting.this, anonymousClass32.$skuId, anonymousClass32.$planId);
                for (ModelGift modelGift : this.$gifts) {
                    StoreGifting.access$setGifts(StoreGifting.this, modelGift.getCode(), new GiftState.Resolved(modelGift));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, long j, Long l) {
            super(1);
            this.$comboId = str;
            this.$skuId = j;
            this.$planId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGift> list) {
            invoke2((List<ModelGift>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGift> list) {
            m.checkNotNullParameter(list, "gifts");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $comboId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$comboId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$comboId, GiftState.Loading.INSTANCE);
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Function1 $onError;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int iOrdinal = this.$error.getType().ordinal();
                if (iOrdinal == 3) {
                    this.$error.setShowErrorToasts(false);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$comboId, GiftState.Invalid.INSTANCE);
                } else if (iOrdinal != 11) {
                    Logger.e$default(AppLog.g, "Generate Gift Code Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass22.$comboId, GiftState.LoadFailed.INSTANCE);
                } else {
                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                    StoreGifting.access$setGifts(StoreGifting.this, anonymousClass23.$comboId, GiftState.LoadFailed.INSTANCE);
                }
                AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                StoreGifting.access$setGifts(StoreGifting.this, anonymousClass24.$comboId, GiftState.LoadFailed.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Function1 function1) {
            super(1);
            this.$comboId = str;
            this.$onError = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
            Function1 function1 = this.$onError;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<ModelGift, Unit> {
        public final /* synthetic */ String $comboId;
        public final /* synthetic */ Function1 $onSuccess;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$generateGiftCode$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ ModelGift $newGift;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelGift modelGift) {
                super(0);
                this.$newGift = modelGift;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifting.access$removeGiftCode(StoreGifting.this, anonymousClass3.$comboId);
                StoreGifting.access$setGifts(StoreGifting.this, this.$newGift.getCode(), new GiftState.Resolved(this.$newGift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Function1 function1) {
            super(1);
            this.$comboId = str;
            this.$onSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelGift modelGift) {
            invoke2(modelGift);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelGift modelGift) {
            m.checkNotNullParameter(modelGift, "newGift");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(modelGift));
            Function1 function1 = this.$onSuccess;
            if (function1 != null) {
            }
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$getMyResolvedGifts$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<String, ? extends GiftState>, List<? extends ModelGift>> {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends ModelGift> call(Map<String, ? extends GiftState> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGift> call2(Map<String, ? extends GiftState> map) {
            User user;
            Collection<? extends GiftState> collectionValues = map.values();
            ArrayList<GiftState> arrayList = new ArrayList();
            for (T t : collectionValues) {
                GiftState giftState = (GiftState) t;
                if ((giftState instanceof GiftState.Resolved) && (user = ((GiftState.Resolved) giftState).getGift().getUser()) != null && user.getId() == this.$userId) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            for (GiftState giftState2 : arrayList) {
                Objects.requireNonNull(giftState2, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
                arrayList2.add(((GiftState.Resolved) giftState2).getGift());
            }
            return arrayList2;
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$requestGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $giftCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$giftCode = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$fetchGift(StoreGifting.this, this.$giftCode);
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$requestGift$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<String, ? extends GiftState>, GiftState> {
        public final /* synthetic */ String $giftCode;

        public AnonymousClass2(String str) {
            this.$giftCode = str;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ GiftState call(Map<String, ? extends GiftState> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GiftState call2(Map<String, ? extends GiftState> map) {
            GiftState giftState = map.get(this.$giftCode);
            return giftState != null ? giftState : GiftState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelGift modelGift) {
            super(0);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifting.access$setGifts(StoreGifting.this, this.$gift.getCode(), new GiftState.Revoking(this.$gift));
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Logger.e$default(AppLog.g, "Revoking Gift Error", new Exception(String.valueOf(this.$error.getType())), null, 4, null);
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGifting.access$setGifts(StoreGifting.this, anonymousClass2.$gift.getCode(), new GiftState.Resolved(AnonymousClass2.this.$gift));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ModelGift modelGift) {
            super(1);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1(error));
        }
    }

    /* compiled from: StoreGifting.kt */
    /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ ModelGift $gift;

        /* compiled from: StoreGifting.kt */
        /* renamed from: com.discord.stores.StoreGifting$revokeGiftCode$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifting.access$removeGiftCode(StoreGifting.this, anonymousClass3.$gift.getCode());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ModelGift modelGift) {
            super(1);
            this.$gift = modelGift;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreGifting.this.getDispatcher().schedule(new AnonymousClass1());
        }
    }

    public StoreGifting(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.knownGifts = new HashMap<>();
        this.knownGiftsSubject = BehaviorSubject.l0(h0.emptyMap());
    }

    public static final /* synthetic */ void access$clearGiftsForSku(StoreGifting storeGifting, long j, Long l) {
        storeGifting.clearGiftsForSku(j, l);
    }

    public static final /* synthetic */ void access$fetchGift(StoreGifting storeGifting, String str) {
        storeGifting.fetchGift(str);
    }

    public static final /* synthetic */ void access$removeGiftCode(StoreGifting storeGifting, String str) {
        storeGifting.removeGiftCode(str);
    }

    public static final /* synthetic */ void access$setGifts(StoreGifting storeGifting, String str, GiftState giftState) {
        storeGifting.setGifts(str, giftState);
    }

    @StoreThread
    private final void clearGiftsForSku(long skuId, Long subscriptionPlanId) {
        HashMap<String, GiftState> map = this.knownGifts;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, GiftState> entry : map.entrySet()) {
            GiftState value = entry.getValue();
            boolean z2 = true;
            if (value instanceof GiftState.Resolved) {
                if (((GiftState.Resolved) value).getGift().getSkuId() == skuId && subscriptionPlanId != null && !(!m.areEqual(r3.getGift().getSubscriptionPlanId(), subscriptionPlanId))) {
                    z2 = false;
                }
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.knownGifts = new HashMap<>(linkedHashMap);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @StoreThread
    private final void fetchGift(String giftCode) {
        if (this.knownGifts.containsKey(giftCode) && !(this.knownGifts.get(giftCode) instanceof GiftState.LoadFailed)) {
            if (!(this.knownGifts.get(giftCode) instanceof GiftState.Resolved)) {
                return;
            }
            GiftState giftState = this.knownGifts.get(giftCode);
            Objects.requireNonNull(giftState, "null cannot be cast to non-null type com.discord.stores.StoreGifting.GiftState.Resolved");
            if (((GiftState.Resolved) giftState).getGift().isComplete()) {
                return;
            }
        }
        setGifts(giftCode, GiftState.Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().resolveGiftCode(giftCode, true, true), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(giftCode), (Function0) null, (Function0) null, new AnonymousClass1(giftCode), 54, (Object) null);
    }

    public static /* synthetic */ void generateGiftCode$default(StoreGifting storeGifting, long j, Long l, Function1 function1, Function1 function12, int i, Object obj) {
        storeGifting.generateGiftCode(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12);
    }

    @StoreThread
    private final void removeGiftCode(String code) {
        this.knownGifts.remove(code);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    @StoreThread
    private final void setGifts(String code, GiftState giftState) {
        this.knownGifts.put(code, giftState);
        this.knownGiftsSubject.onNext(new HashMap(this.knownGifts));
    }

    public final void acceptGift(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        this.dispatcher.schedule(new AnonymousClass1(gift));
    }

    public final void fetchMyGiftsForSku(long skuId, Long planId) {
        String strMakeComboId = INSTANCE.makeComboId(skuId, planId);
        if (!this.knownGifts.containsKey(strMakeComboId) || (this.knownGifts.get(strMakeComboId) instanceof GiftState.LoadFailed)) {
            this.dispatcher.schedule(new AnonymousClass1(strMakeComboId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().resolveSkuIdGift(skuId, planId), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(strMakeComboId), (Function0) null, (Function0) null, new AnonymousClass3(strMakeComboId, skuId, planId), 54, (Object) null);
        }
    }

    public final void generateGiftCode(long skuId, Long planId, Function1<? super ModelGift, Unit> onSuccess, Function1<? super Error, Unit> onError) {
        String strMakeComboId = INSTANCE.makeComboId(skuId, planId);
        if (this.knownGifts.get(strMakeComboId) instanceof GiftState.Loading) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(strMakeComboId));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().generateGiftCode(new RestAPIParams.GenerateGiftCode(skuId, planId)), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(strMakeComboId, onError), (Function0) null, (Function0) null, new AnonymousClass3(strMakeComboId, onSuccess), 54, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final HashMap<String, GiftState> getKnownGifts() {
        return this.knownGifts;
    }

    public final Observable<List<ModelGift>> getMyResolvedGifts(long userId) {
        Observable observableG = this.knownGiftsSubject.G(new AnonymousClass1(userId));
        m.checkNotNullExpressionValue(observableG, "knownGiftsSubject\n      …              }\n        }");
        return observableG;
    }

    @StoreThread
    public final void handlePreLogout() {
        this.knownGifts.clear();
    }

    public final Observable<GiftState> requestGift(String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        this.dispatcher.schedule(new AnonymousClass1(giftCode));
        Observable<GiftState> observableR = this.knownGiftsSubject.G(new AnonymousClass2(giftCode)).r();
        m.checkNotNullExpressionValue(observableR, "knownGiftsSubject\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final void revokeGiftCode(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        if (this.knownGifts.containsKey(gift.getCode()) && (this.knownGifts.get(gift.getCode()) instanceof GiftState.Revoking)) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(gift));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().revokeGiftCode(gift.getCode()), false, 1, null), StoreGifting.class, (Context) null, (Function1) null, new AnonymousClass2(gift), (Function0) null, (Function0) null, new AnonymousClass3(gift), 54, (Object) null);
    }

    public final void setKnownGifts(HashMap<String, GiftState> map) {
        m.checkNotNullParameter(map, "<set-?>");
        this.knownGifts = map;
    }
}
