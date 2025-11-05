package com.discord.utilities.message;

import java.util.Comparator;

/* compiled from: MessageUtils.kt */
/* loaded from: classes2.dex */
public final class MessageUtils$SORT_BY_IDS_COMPARATOR$1<T> implements Comparator<Long> {
    public static final MessageUtils$SORT_BY_IDS_COMPARATOR$1 INSTANCE = new MessageUtils$SORT_BY_IDS_COMPARATOR$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return MessageUtils.compareMessages(l, l2);
    }
}
