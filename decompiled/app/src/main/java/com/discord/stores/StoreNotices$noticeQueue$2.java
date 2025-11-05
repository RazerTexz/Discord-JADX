package com.discord.stores;

import com.discord.stores.StoreNotices;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreNotices.kt */
/* loaded from: classes2.dex */
public final class StoreNotices$noticeQueue$2 extends o implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices$noticeQueue$2 INSTANCE = new StoreNotices$noticeQueue$2();

    public StoreNotices$noticeQueue$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(StoreNotices.Notice notice) {
        return invoke2(notice);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(StoreNotices.Notice notice) {
        return Integer.valueOf(-notice.getPriority());
    }
}
