package com.discord.widgets.chat.input.autocomplete;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import kotlin.ranges.Ranges2;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.AutocompleteExtensionsKt$replaceAutocompleteDataWithServerValues$$inlined$sortedByDescending$1 */
/* loaded from: classes2.dex */
public final class C7762xcb37dea4<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Integer.valueOf(((Ranges2) t2).getFirst()), Integer.valueOf(((Ranges2) t).getFirst()));
    }
}
