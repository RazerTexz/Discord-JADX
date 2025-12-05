package com.discord.widgets.guilds.create;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.channel.Channel;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildClone$configureUI$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Channel channel = (Channel) t;
        Channel channel2 = (Channel) t2;
        return C12169a.compareValues(Long.valueOf(channel.getParentId() == 0 ? channel.getId() * 10000 : (channel.getParentId() * 10000) + channel.getId()), Long.valueOf(channel2.getParentId() == 0 ? channel2.getId() * 10000 : (channel2.getParentId() * 10000) + channel2.getId()));
    }
}
