package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* compiled from: InputAutocompletables.kt */
/* loaded from: classes2.dex */
public final class ChatInputAutocompletables$USERS_SOURCE$2 extends o implements Function0<UserAutocompletableSource> {
    public static final ChatInputAutocompletables$USERS_SOURCE$2 INSTANCE = new ChatInputAutocompletables$USERS_SOURCE$2();

    public ChatInputAutocompletables$USERS_SOURCE$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UserAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new UserAutocompletableSource(companion.getUsers(), companion.getGuilds(), companion.getPresences(), companion.getPermissions(), companion.getChannels());
    }
}
