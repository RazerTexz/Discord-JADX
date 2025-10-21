package com.discord.utilities.notices;

import android.content.Context;
import com.discord.stores.StoreNotices;
import com.discord.utilities.notices.NoticeBuilders;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function2;

/* compiled from: NoticeBuilders.kt */
/* renamed from: com.discord.utilities.notices.NoticeBuilders$noticeDataBuilders$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class NoticeBuilders2 extends FunctionReferenceImpl implements Function2<Context, StoreNotices.Dialog, NoticeBuilders.DialogData> {
    public NoticeBuilders2(NoticeBuilders noticeBuilders) {
        super(2, noticeBuilders, NoticeBuilders.class, "requestRatingModalBuilder", "requestRatingModalBuilder(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ NoticeBuilders.DialogData invoke(Context context, StoreNotices.Dialog dialog) {
        return invoke2(context, dialog);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NoticeBuilders.DialogData invoke2(Context context, StoreNotices.Dialog dialog) {
        Intrinsics3.checkNotNullParameter(context, "p1");
        Intrinsics3.checkNotNullParameter(dialog, "p2");
        return NoticeBuilders.access$requestRatingModalBuilder((NoticeBuilders) this.receiver, context, dialog);
    }
}
