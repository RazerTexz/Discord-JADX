package com.discord.stores;

import com.discord.stores.StoreNotices;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreNotices.kt */
/* renamed from: com.discord.stores.StoreNotices$noticeQueue$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreNotices4 extends Lambda implements Function1<StoreNotices.Notice, Comparable<?>> {
    public static final StoreNotices4 INSTANCE = new StoreNotices4();

    public StoreNotices4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(StoreNotices.Notice notice) {
        return invoke2(notice);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(StoreNotices.Notice notice) {
        return Boolean.valueOf(notice instanceof StoreNotices.PassiveNotice);
    }
}
