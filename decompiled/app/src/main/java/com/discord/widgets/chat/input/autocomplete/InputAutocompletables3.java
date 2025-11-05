package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.ChannelAutocompletableSource;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: InputAutocompletables.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$CHANNEL_SOURCE$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables3 extends Lambda implements Function0<ChannelAutocompletableSource> {
    public static final InputAutocompletables3 INSTANCE = new InputAutocompletables3();

    public InputAutocompletables3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChannelAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChannelAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new ChannelAutocompletableSource(companion.getChannels(), companion.getThreadsActiveJoined(), companion.getPermissions());
    }
}
