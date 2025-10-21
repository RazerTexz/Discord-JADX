package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class StoreEmoji$buildUsableEmojiSet$5$processGuildEmojis$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String name = ((ModelEmojiCustom) t2).getName();
        Intrinsics3.checkNotNullExpressionValue(name, "it.name");
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String name2 = ((ModelEmojiCustom) t).getName();
        Intrinsics3.checkNotNullExpressionValue(name2, "it.name");
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(name2, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = name2.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        return a.compareValues(lowerCase, lowerCase2);
    }
}
