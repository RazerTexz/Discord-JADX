package com.discord.widgets.channels.list;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChannelListModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$6$7$1 extends o implements Function2<Integer, Integer, WidgetChannelListModel.ThreadSpineType> {
    public static final WidgetChannelListModel$Companion$guildListBuilder$6$7$1 INSTANCE = new WidgetChannelListModel$Companion$guildListBuilder$6$7$1();

    public WidgetChannelListModel$Companion$guildListBuilder$6$7$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetChannelListModel.ThreadSpineType invoke(Integer num, Integer num2) {
        return invoke(num.intValue(), num2.intValue());
    }

    public final WidgetChannelListModel.ThreadSpineType invoke(int i, int i2) {
        return i2 == 1 ? WidgetChannelListModel.ThreadSpineType.Single.INSTANCE : i == 0 ? WidgetChannelListModel.ThreadSpineType.Start.INSTANCE : i == i2 - 1 ? WidgetChannelListModel.ThreadSpineType.End.INSTANCE : WidgetChannelListModel.ThreadSpineType.Middle.INSTANCE;
    }
}
