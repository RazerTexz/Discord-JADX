package com.discord.utilities.billing;

import com.android.billingclient.api.SkuDetails;
import com.discord.models.domain.ModelSku;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.billing.GooglePlayInAppSkus, reason: use source file name */
/* JADX INFO: compiled from: GooglePlayInAppSku.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GooglePlayInAppSku3 {
    public static final GooglePlayInAppSku3 INSTANCE = new GooglePlayInAppSku3();
    private static final List<GooglePlayInAppSku> skus = GooglePlayInAppSku2.getPremiumGifts();

    private GooglePlayInAppSku3() {
    }

    private final Map<String, GooglePlayInAppSku> getSkusById() {
        List<GooglePlayInAppSku> list = skus;
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(((GooglePlayInAppSku) obj).getPaymentGatewaySkuId(), obj);
        }
        return linkedHashMap;
    }

    public final GooglePlayInAppSku getInAppSku(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().get(paymentGatewaySkuId);
    }

    public final List<GooglePlayInAppSku> getSkus() {
        return skus;
    }

    public final boolean isInAppSku(String paymentGatewaySkuId) {
        Intrinsics3.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        return getSkusById().containsKey(paymentGatewaySkuId);
    }

    public final void populateSkuDetails(Map<String, ? extends SkuDetails> skuDetails) {
        Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
        for (Map.Entry<String, ? extends SkuDetails> entry : skuDetails.entrySet()) {
            GooglePlayInAppSku googlePlayInAppSku = INSTANCE.getSkusById().get(entry.getKey());
            if (googlePlayInAppSku != null) {
                googlePlayInAppSku.setSkuDetails(entry.getValue());
            }
        }
    }

    public final GooglePlayInAppSku getInAppSku(ModelSku sku) {
        Object next;
        Intrinsics3.checkNotNullParameter(sku, "sku");
        Iterator<T> it = GooglePlayInAppSku2.getPremiumGifts().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics3.areEqual(((GooglePlayInAppSku) next).getPaymentGatewaySkuId(), sku.getName())) {
                break;
            }
        }
        return (GooglePlayInAppSku) next;
    }
}
