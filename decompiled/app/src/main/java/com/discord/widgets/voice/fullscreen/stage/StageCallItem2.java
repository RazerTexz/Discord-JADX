package com.discord.widgets.voice.fullscreen.stage;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants;

/* compiled from: StageCallItem.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem, reason: use source file name */
/* loaded from: classes.dex */
public interface StageCallItem2 {
    Channel getChannel();

    StoreVoiceParticipants.VoiceUser getVoiceUser();
}
