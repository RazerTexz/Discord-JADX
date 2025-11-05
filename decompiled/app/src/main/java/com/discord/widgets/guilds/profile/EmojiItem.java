package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* loaded from: classes2.dex */
public abstract class EmojiItem {
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJI = 1;
    private final int type;

    /* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    public static final /* data */ class EmojiData extends EmojiItem {
        private final Emoji emoji;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmojiData(Emoji emoji) {
            super(0, null);
            m.checkNotNullParameter(emoji, "emoji");
            this.emoji = emoji;
        }

        public static /* synthetic */ EmojiData copy$default(EmojiData emojiData, Emoji emoji, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = emojiData.emoji;
            }
            return emojiData.copy(emoji);
        }

        /* renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final EmojiData copy(Emoji emoji) {
            m.checkNotNullParameter(emoji, "emoji");
            return new EmojiData(emoji);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof EmojiData) && m.areEqual(this.emoji, ((EmojiData) other).emoji);
            }
            return true;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public int hashCode() {
            Emoji emoji = this.emoji;
            if (emoji != null) {
                return emoji.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("EmojiData(emoji=");
            sbU.append(this.emoji);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
    public static final /* data */ class MoreEmoji extends EmojiItem {
        private final int extraEmojiCount;

        public MoreEmoji(int i) {
            super(1, null);
            this.extraEmojiCount = i;
        }

        public static /* synthetic */ MoreEmoji copy$default(MoreEmoji moreEmoji, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = moreEmoji.extraEmojiCount;
            }
            return moreEmoji.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getExtraEmojiCount() {
            return this.extraEmojiCount;
        }

        public final MoreEmoji copy(int extraEmojiCount) {
            return new MoreEmoji(extraEmojiCount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof MoreEmoji) && this.extraEmojiCount == ((MoreEmoji) other).extraEmojiCount;
            }
            return true;
        }

        public final int getExtraEmojiCount() {
            return this.extraEmojiCount;
        }

        public int hashCode() {
            return this.extraEmojiCount;
        }

        public String toString() {
            return a.B(a.U("MoreEmoji(extraEmojiCount="), this.extraEmojiCount, ")");
        }
    }

    private EmojiItem(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    public /* synthetic */ EmojiItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
