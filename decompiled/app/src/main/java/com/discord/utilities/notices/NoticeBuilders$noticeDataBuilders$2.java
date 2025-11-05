package com.discord.utilities.notices;

import android.content.Context;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* compiled from: NoticeBuilders.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class NoticeBuilders$noticeDataBuilders$2 extends k implements Function2<Context, StoreNotices.Dialog, NoticeBuilders.DialogData> {
    public NoticeBuilders$noticeDataBuilders$2(NoticeBuilders noticeBuilders) {
        super(2, noticeBuilders, NoticeBuilders.class, "deleteConnectionModalBuilder", "deleteConnectionModalBuilder(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ NoticeBuilders.DialogData invoke(Context context, StoreNotices.Dialog dialog) {
        return invoke2(context, dialog);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NoticeBuilders.DialogData invoke2(Context context, StoreNotices.Dialog dialog) {
        m.checkNotNullParameter(context, "p1");
        m.checkNotNullParameter(dialog, "p2");
        return NoticeBuilders.access$deleteConnectionModalBuilder((NoticeBuilders) this.receiver, context, dialog);
    }
}
