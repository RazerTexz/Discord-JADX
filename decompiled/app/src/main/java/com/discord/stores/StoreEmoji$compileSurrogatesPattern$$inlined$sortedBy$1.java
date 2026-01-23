package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$compileSurrogatesPattern$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Integer.valueOf(-((String) t).length()), Integer.valueOf(-((String) t2).length()));
    }
}
