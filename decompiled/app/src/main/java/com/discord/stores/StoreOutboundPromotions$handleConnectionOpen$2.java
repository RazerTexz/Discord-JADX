package com.discord.stores;

import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.premium.OutboundPromotion;
import com.discord.models.domain.ModelEntitlement;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreOutboundPromotions.kt */
/* loaded from: classes2.dex */
public final class StoreOutboundPromotions$handleConnectionOpen$2<T, R> implements b<List<? extends OutboundPromotion>, Observable<? extends List<? extends OutboundPromotion>>> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$1, reason: invalid class name */
    public static final class AnonymousClass1<V> implements Callable<List<? extends OutboundPromotion>> {
        public final /* synthetic */ List $activePromos;

        public AnonymousClass1(List list) {
            this.$activePromos = list;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<? extends OutboundPromotion> call2() {
            long j = StoreOutboundPromotions$handleConnectionOpen$2.this.this$0.getPrefs().getLong("CONSUMED_ENTITLEMENT_CODE", -1L);
            List list = this.$activePromos;
            ArrayList arrayListA0 = a.a0(list, "activePromos");
            for (T t : list) {
                if (((OutboundPromotion) t).getId() != j) {
                    arrayListA0.add(t);
                }
            }
            return arrayListA0;
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<List<? extends ModelEntitlement>, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Long call(List<? extends ModelEntitlement> list) {
            return call2((List<ModelEntitlement>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(List<ModelEntitlement> list) {
            T next;
            Long promotionId;
            m.checkNotNullExpressionValue(list, "entitlements");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                ModelEntitlement modelEntitlement = (ModelEntitlement) next;
                if (m.areEqual(modelEntitlement.getConsumed(), Boolean.TRUE) && modelEntitlement.getPromotionId() != null) {
                    break;
                }
            }
            ModelEntitlement modelEntitlement2 = next;
            return Long.valueOf((modelEntitlement2 == null || (promotionId = modelEntitlement2.getPromotionId()) == null) ? -1L : promotionId.longValue());
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Long> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            SharedPreferences.Editor editorEdit = StoreOutboundPromotions$handleConnectionOpen$2.this.this$0.getPrefs().edit();
            m.checkNotNullExpressionValue(editorEdit, "editor");
            m.checkNotNullExpressionValue(l, "consumedPromoId");
            editorEdit.putLong("CONSUMED_ENTITLEMENT_CODE", l.longValue());
            editorEdit.apply();
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements b<Long, List<? extends OutboundPromotion>> {
        public final /* synthetic */ List $activePromos;

        public AnonymousClass4(List list) {
            this.$activePromos = list;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<OutboundPromotion> call2(Long l) {
            List list = this.$activePromos;
            ArrayList arrayListA0 = a.a0(list, "activePromos");
            for (T t : list) {
                if (l == null || ((OutboundPromotion) t).getId() != l.longValue()) {
                    arrayListA0.add(t);
                }
            }
            return arrayListA0;
        }
    }

    public StoreOutboundPromotions$handleConnectionOpen$2(StoreOutboundPromotions storeOutboundPromotions) {
        this.this$0 = storeOutboundPromotions;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends OutboundPromotion>> call(List<? extends OutboundPromotion> list) {
        return call2((List<OutboundPromotion>) list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<OutboundPromotion>> call2(List<OutboundPromotion> list) {
        if (this.this$0.getPrefs().contains("CONSUMED_ENTITLEMENT_CODE")) {
            return Observable.D(new AnonymousClass1(list));
        }
        m.checkNotNullExpressionValue(list, "activePromos");
        return list.isEmpty() ^ true ? ObservableExtensionsKt.restSubscribeOn$default(StoreOutboundPromotions.access$getRestAPI$p(this.this$0).getMyEntitlements(521842831262875670L, false), false, 1, null).G(AnonymousClass2.INSTANCE).u(new AnonymousClass3()).G(new AnonymousClass4(list)) : new k(list);
    }
}
