package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.AutocompleteSelectionTypes;
import com.discord.widgets.chat.AutocompleteTypes;
import com.discord.widgets.chat.input.MentionUtilsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public enum LeadingIdentifier {
    APP_COMMAND(Character.valueOf(MentionUtilsKt.SLASH_CHAR)),
    EMOJI_AND_STICKERS(Character.valueOf(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR)),
    CHANNELS(Character.valueOf(MentionUtilsKt.CHANNELS_CHAR)),
    MENTION(Character.valueOf(MentionUtilsKt.MENTIONS_CHAR)),
    NONE(null);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Character identifier;

    /* compiled from: Autocompletable.kt */
    public static final class Companion {
        private Companion() {
        }

        public final LeadingIdentifier fromChar(Character identifier) {
            return (identifier != null && identifier.charValue() == '/') ? LeadingIdentifier.APP_COMMAND : (identifier != null && identifier.charValue() == ':') ? LeadingIdentifier.EMOJI_AND_STICKERS : (identifier != null && identifier.charValue() == '#') ? LeadingIdentifier.CHANNELS : (identifier != null && identifier.charValue() == '@') ? LeadingIdentifier.MENTION : LeadingIdentifier.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    LeadingIdentifier(Character ch) {
        this.identifier = ch;
    }

    public final Character getIdentifier() {
        return this.identifier;
    }
}
