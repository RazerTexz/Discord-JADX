package com.discord.widgets.chat.input.autocomplete;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.ChatInputAutocompletables$EMOJI_SOURCE$2, reason: use source file name */
/* JADX INFO: compiled from: InputAutocompletables.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocompletables4 extends Lambda implements Function0<EmojiAutocompletableSource> {
    public static final InputAutocompletables4 INSTANCE = new InputAutocompletables4();

    public InputAutocompletables4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiAutocompletableSource invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiAutocompletableSource invoke() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return new EmojiAutocompletableSource(companion.getEmojis(), companion.getUserSettings());
    }
}
