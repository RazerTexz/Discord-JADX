package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1<T> implements Comparator {
    public final /* synthetic */ WidgetGlobalSearchModel.SearchContext $searchContext$inlined;

    public WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1(WidgetGlobalSearchModel.SearchContext searchContext) {
        this.$searchContext$inlined = searchContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int compare(T t, T t2) {
        int iIntValue;
        Channel channel = ((WidgetGlobalSearchModel.ItemDataPayload) t).getChannel();
        int iIntValue2 = Integer.MAX_VALUE;
        if (channel != null) {
            Integer numValueOf = Integer.valueOf(this.$searchContext$inlined.getRecentGuildIds().indexOf(Long.valueOf(channel.getGuildId())));
            if (!(numValueOf.intValue() != -1)) {
                numValueOf = null;
            }
            iIntValue = numValueOf != null ? numValueOf.intValue() : Integer.MAX_VALUE;
        }
        Integer numValueOf2 = Integer.valueOf(iIntValue);
        Channel channel2 = ((WidgetGlobalSearchModel.ItemDataPayload) t2).getChannel();
        if (channel2 != null) {
            Integer numValueOf3 = Integer.valueOf(this.$searchContext$inlined.getRecentGuildIds().indexOf(Long.valueOf(channel2.getGuildId())));
            Integer num = numValueOf3.intValue() != -1 ? numValueOf3 : null;
            if (num != null) {
                iIntValue2 = num.intValue();
            }
        }
        return C12169a.compareValues(numValueOf2, Integer.valueOf(iIntValue2));
    }
}
