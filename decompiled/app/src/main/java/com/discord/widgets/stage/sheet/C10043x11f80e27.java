package com.discord.widgets.stage.sheet;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetAdapter;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$$special$$inlined$sortedBy$1 */
/* loaded from: classes2.dex */
public final class C10043x11f80e27<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(((WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant) t).getRequestToSpeakTimestamp(), ((WidgetStageRaisedHandsBottomSheetAdapter.ListItem.Participant) t2).getRequestToSpeakTimestamp());
    }
}
