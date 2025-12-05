package com.discord.widgets.voice.fullscreen;

import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.user.UserUtils;
import java.util.Comparator;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ParticipantsListItemGenerator.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.ParticipantsListItemGenerator$Companion$createUserItemsComparator$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ParticipantsListItemGenerator2<T> implements Comparator<StoreVoiceParticipants.VoiceUser> {
    public final /* synthetic */ String $mySpectatingStreamKey;

    public ParticipantsListItemGenerator2(String str) {
        this.$mySpectatingStreamKey = str;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        return compare2(voiceUser, voiceUser2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        boolean z2 = false;
        boolean z3 = this.$mySpectatingStreamKey != null;
        ModelApplicationStream applicationStream = voiceUser.getApplicationStream();
        String encodedStreamKey = applicationStream != null ? applicationStream.getEncodedStreamKey() : null;
        ModelApplicationStream applicationStream2 = voiceUser2.getApplicationStream();
        String encodedStreamKey2 = applicationStream2 != null ? applicationStream2.getEncodedStreamKey() : null;
        boolean z4 = encodedStreamKey != null;
        boolean z5 = encodedStreamKey2 != null;
        VoiceState voiceState = voiceUser.getVoiceState();
        boolean z6 = voiceState != null && voiceState.getSelfVideo();
        VoiceState voiceState2 = voiceUser2.getVoiceState();
        boolean z7 = voiceState2 != null && voiceState2.getSelfVideo();
        boolean z8 = z3 && Intrinsics3.areEqual(encodedStreamKey, this.$mySpectatingStreamKey);
        if (z3 && Intrinsics3.areEqual(encodedStreamKey2, this.$mySpectatingStreamKey)) {
            z2 = true;
        }
        if (!z8) {
            if (z2) {
                return 1;
            }
            if (!voiceUser.isMe()) {
                if (voiceUser2.isMe()) {
                    return 1;
                }
                if (!z3 || !Intrinsics3.areEqual(voiceUser.getWatchingStream(), this.$mySpectatingStreamKey) || !(!Intrinsics3.areEqual(voiceUser2.getWatchingStream(), this.$mySpectatingStreamKey))) {
                    if (z3 && Intrinsics3.areEqual(voiceUser2.getWatchingStream(), this.$mySpectatingStreamKey) && (!Intrinsics3.areEqual(voiceUser.getWatchingStream(), this.$mySpectatingStreamKey))) {
                        return 1;
                    }
                    if (!z4 || z5) {
                        if (!z4 && z5) {
                            return 1;
                        }
                        if (!z6 || z7) {
                            if (z6 || !z7) {
                                return UserUtils.INSTANCE.compareUserNames(voiceUser.getUser(), voiceUser2.getUser(), voiceUser.getNickname(), voiceUser2.getNickname());
                            }
                            return 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
