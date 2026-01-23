package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelPaymentSource3;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: com.discord.stores.StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1 */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6322xd4d62789<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Integer.valueOf(!((ModelPaymentSource3) t).getDefault() ? 1 : 0), Integer.valueOf(!((ModelPaymentSource3) t2).getDefault() ? 1 : 0));
    }
}
