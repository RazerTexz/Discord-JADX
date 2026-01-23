package com.discord.widgets.voice.fullscreen;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel$handleStoreState$$inlined$sortedBy$1 */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10512x2d7d0c8f<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(((GuildScheduledEvent) t).getScheduledStartTime(), ((GuildScheduledEvent) t2).getScheduledStartTime());
    }
}
