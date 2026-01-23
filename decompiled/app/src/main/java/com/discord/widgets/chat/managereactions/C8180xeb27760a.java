package com.discord.widgets.chat.managereactions;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.message.reaction.MessageReaction;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1 */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8180xeb27760a<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Integer.valueOf(((MessageReaction) t2).getCount()), Integer.valueOf(((MessageReaction) t).getCount()));
    }
}
