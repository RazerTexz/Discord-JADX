package com.discord.utilities.message;

import java.util.Comparator;

/* compiled from: MessageUtils.kt */
/* renamed from: com.discord.utilities.message.MessageUtils$SORT_BY_IDS_COMPARATOR$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageUtils2<T> implements Comparator<Long> {
    public static final MessageUtils2 INSTANCE = new MessageUtils2();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return MessageUtils.compareMessages(l, l2);
    }
}
