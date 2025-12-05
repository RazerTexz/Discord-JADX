package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: InputAutocompletables.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$APPLICATION_COMMANDS_SOURCE$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables2 extends Lambda implements Function0<ApplicationCommandsAutocompletableSource> {
    public static final InputAutocompletables2 INSTANCE = new InputAutocompletables2();

    public InputAutocompletables2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ApplicationCommandsAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ApplicationCommandsAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new ApplicationCommandsAutocompletableSource(companion.getUsers(), companion.getGuilds(), companion.getApplicationCommands());
    }
}
