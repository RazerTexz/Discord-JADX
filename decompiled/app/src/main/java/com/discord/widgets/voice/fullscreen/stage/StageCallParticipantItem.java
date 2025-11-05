package com.discord.widgets.voice.fullscreen.stage;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants;

/* compiled from: StageCallItem.kt */
/* loaded from: classes.dex */
public interface StageCallParticipantItem {
    Channel getChannel();

    StoreVoiceParticipants.VoiceUser getVoiceUser();
}
