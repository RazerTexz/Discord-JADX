package com.discord.stores;

import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.discord.api.premium.OutboundPromotion;
import com.discord.models.domain.ModelEntitlement;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2, reason: use source file name */
/* JADX INFO: compiled from: StoreOutboundPromotions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreOutboundPromotions2<T, R> implements Func1<List<? extends OutboundPromotion>, Observable<? extends List<? extends OutboundPromotion>>> {
    public final /* synthetic */ StoreOutboundPromotions this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$1 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class CallableC63131<V> implements Callable<List<? extends OutboundPromotion>> {
        public final /* synthetic */ List $activePromos;

        public CallableC63131(List list) {
            this.$activePromos = list;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<? extends OutboundPromotion> call2() {
            long j = StoreOutboundPromotions2.this.this$0.getPrefs().getLong("CONSUMED_ENTITLEMENT_CODE", -1L);
            List list = this.$activePromos;
            ArrayList arrayListM840a0 = outline.m840a0(list, "activePromos");
            for (T t : list) {
                if (((OutboundPromotion) t).getId() != j) {
                    arrayListM840a0.add(t);
                }
            }
            return arrayListM840a0;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$2 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63142<T, R> implements Func1<List<? extends ModelEntitlement>, Long> {
        public static final C63142 INSTANCE = new C63142();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Long call(List<? extends ModelEntitlement> list) {
            return call2((List<ModelEntitlement>) list);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(List<ModelEntitlement> list) {
            T next;
            Long promotionId;
            Intrinsics3.checkNotNullExpressionValue(list, "entitlements");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                ModelEntitlement modelEntitlement = (ModelEntitlement) next;
                if (Intrinsics3.areEqual(modelEntitlement.getConsumed(), Boolean.TRUE) && modelEntitlement.getPromotionId() != null) {
                    break;
                }
            }
            ModelEntitlement modelEntitlement2 = next;
            return Long.valueOf((modelEntitlement2 == null || (promotionId = modelEntitlement2.getPromotionId()) == null) ? -1L : promotionId.longValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$3 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63153<T> implements Action1<Long> {
        public C63153() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            SharedPreferences.Editor editorEdit = StoreOutboundPromotions2.this.this$0.getPrefs().edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            Intrinsics3.checkNotNullExpressionValue(l, "consumedPromoId");
            editorEdit.putLong("CONSUMED_ENTITLEMENT_CODE", l.longValue());
            editorEdit.apply();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreOutboundPromotions$handleConnectionOpen$2$4 */
    /* JADX INFO: compiled from: StoreOutboundPromotions.kt */
    public static final class C63164<T, R> implements Func1<Long, List<? extends OutboundPromotion>> {
        public final /* synthetic */ List $activePromos;

        public C63164(List list) {
            this.$activePromos = list;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends OutboundPromotion> call(Long l) {
            return call2(l);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<OutboundPromotion> call2(Long l) {
            List list = this.$activePromos;
            ArrayList arrayListM840a0 = outline.m840a0(list, "activePromos");
            for (T t : list) {
                if (l == null || ((OutboundPromotion) t).getId() != l.longValue()) {
                    arrayListM840a0.add(t);
                }
            }
            return arrayListM840a0;
        }
    }

    public StoreOutboundPromotions2(StoreOutboundPromotions storeOutboundPromotions) {
        this.this$0 = storeOutboundPromotions;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends OutboundPromotion>> call(List<? extends OutboundPromotion> list) {
        return call2((List<OutboundPromotion>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<OutboundPromotion>> call2(List<OutboundPromotion> list) {
        if (this.this$0.getPrefs().contains("CONSUMED_ENTITLEMENT_CODE")) {
            return Observable.m11060D(new CallableC63131(list));
        }
        Intrinsics3.checkNotNullExpressionValue(list, "activePromos");
        return list.isEmpty() ^ true ? ObservableExtensionsKt.restSubscribeOn$default(StoreOutboundPromotions.access$getRestAPI$p(this.this$0).getMyEntitlements(521842831262875670L, false), false, 1, null).m11083G(C63142.INSTANCE).m11115u(new C63153()).m11083G(new C63164(list)) : new ScalarSynchronousObservable(list);
    }
}
