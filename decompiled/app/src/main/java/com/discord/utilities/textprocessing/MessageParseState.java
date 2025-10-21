package com.discord.utilities.textprocessing;

import com.discord.utilities.textprocessing.Rules;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MessageParseState.kt */
/* loaded from: classes2.dex */
public final class MessageParseState implements Rules.BlockQuoteState<MessageParseState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MessageParseState initialState = new MessageParseState(false);
    private final boolean isInQuote;

    /* compiled from: MessageParseState.kt */
    public static final class Companion {
        private Companion() {
        }

        public final MessageParseState getInitialState() {
            return MessageParseState.access$getInitialState$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private MessageParseState(boolean z2) {
        this.isInQuote = z2;
    }

    public static final /* synthetic */ MessageParseState access$getInitialState$cp() {
        return initialState;
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    /* renamed from: isInQuote, reason: from getter */
    public boolean getIsInQuote() {
        return this.isInQuote;
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    public /* bridge */ /* synthetic */ Rules.BlockQuoteState newBlockQuoteState(boolean z2) {
        return newBlockQuoteState(z2);
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    public MessageParseState newBlockQuoteState(boolean isInQuote) {
        return new MessageParseState(isInQuote);
    }
}
