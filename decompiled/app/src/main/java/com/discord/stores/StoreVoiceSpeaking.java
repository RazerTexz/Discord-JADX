package com.discord.stores;

import com.discord.stores.StoreRtcConnection;
import com.discord.stores.updates.ObservationDeck;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreVoiceSpeaking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceSpeaking extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashSet<Long> speakingUsers;
    private Set<Long> speakingUsersSnapshot;

    /* JADX INFO: renamed from: com.discord.stores.StoreVoiceSpeaking$observeSpeakingUsers$1 */
    /* JADX INFO: compiled from: StoreVoiceSpeaking.kt */
    public static final class C66271 extends Lambda implements Function0<Set<? extends Long>> {
        public C66271() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreVoiceSpeaking.this.getSpeakingUsers();
        }
    }

    public StoreVoiceSpeaking(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.speakingUsers = new HashSet<>();
        this.speakingUsersSnapshot = new HashSet();
    }

    public final Set<Long> getSpeakingUsers() {
        return this.speakingUsersSnapshot;
    }

    @Store3
    public final void handleSpeakingUpdates(List<StoreRtcConnection.SpeakingUserUpdate> speakingList) {
        Intrinsics3.checkNotNullParameter(speakingList, "speakingList");
        boolean z2 = false;
        for (StoreRtcConnection.SpeakingUserUpdate speakingUserUpdate : speakingList) {
            long userId = speakingUserUpdate.getUserId();
            boolean zAdd = speakingUserUpdate.getIsSpeaking() ? this.speakingUsers.add(Long.valueOf(userId)) : this.speakingUsers.remove(Long.valueOf(userId));
            if (!z2 && zAdd) {
                z2 = true;
            }
        }
        if (z2) {
            markChanged();
        }
    }

    @Store3
    public final void handleVoiceChannelSelected(long voiceChannelId) {
        if (voiceChannelId > 0) {
            return;
        }
        this.speakingUsers.clear();
        markChanged();
    }

    public final Observable<Set<Long>> observeSpeakingUsers() {
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66271(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.speakingUsersSnapshot = new HashSet(this.speakingUsers);
    }
}
