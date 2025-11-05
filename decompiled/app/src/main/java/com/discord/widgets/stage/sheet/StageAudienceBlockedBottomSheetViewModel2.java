package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel;
import com.discord.widgets.voice.model.CallModel;
import d0.t.Maps6;
import java.util.Map;
import java.util.Set;
import rx.functions.Func3;

/* compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* renamed from: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel2<T1, T2, T3, R> implements Func3<CallModel, Map<Long, ? extends Integer>, Map<Long, ? extends StageRoles>, StageAudienceBlockedBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $channelId;

    public StageAudienceBlockedBottomSheetViewModel2(long j) {
        this.$channelId = j;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StageAudienceBlockedBottomSheetViewModel.StoreState call(CallModel callModel, Map<Long, ? extends Integer> map, Map<Long, ? extends StageRoles> map2) {
        return call2(callModel, (Map<Long, Integer>) map, (Map<Long, StageRoles>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final StageAudienceBlockedBottomSheetViewModel.StoreState call2(CallModel callModel, Map<Long, Integer> map, Map<Long, StageRoles> map2) {
        long j = this.$channelId;
        Set<Long> setKeySet = map.keySet();
        if (map2 == null) {
            map2 = Maps6.emptyMap();
        }
        return new StageAudienceBlockedBottomSheetViewModel.StoreState(j, callModel, setKeySet, map2);
    }
}
