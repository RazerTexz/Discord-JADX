package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelPaymentSource3;
import d0.u.a;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class StorePaymentSources$ensureDefaultPaymentSource$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Integer.valueOf(!((ModelPaymentSource3) t).getDefault() ? 1 : 0), Integer.valueOf(!((ModelPaymentSource3) t2).getDefault() ? 1 : 0));
    }
}
