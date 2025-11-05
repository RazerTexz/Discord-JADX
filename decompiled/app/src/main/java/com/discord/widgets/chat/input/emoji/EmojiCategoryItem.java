package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.models.guild.Guild;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.m;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmojiCategoryItem.kt */
/* loaded from: classes2.dex */
public abstract class EmojiCategoryItem implements DiffKeyProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_GUILD = 1;
    public static final int TYPE_STANDARD = 0;
    private final Pair<Integer, Integer> categoryRange;
    private final boolean isSelected;
    private final String key;
    private final long stableId;

    /* compiled from: EmojiCategoryItem.kt */
    public static final class Companion {
        private Companion() {
        }

        public final long mapEmojiCategoryToItemId(EmojiCategory emojiCategory) {
            m.checkNotNullParameter(emojiCategory, "emojiCategory");
            return emojiCategory.name().hashCode();
        }

        public final long mapGuildToItemId(Guild guild) {
            m.checkNotNullParameter(guild, "guild");
            return guild.getId();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EmojiCategoryItem.kt */
    public static final /* data */ class GuildItem extends EmojiCategoryItem {
        private final Pair<Integer, Integer> categoryRange;
        private final Guild guild;
        private final boolean isSelected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, Pair<Integer, Integer> pair, boolean z2) {
            super(EmojiCategoryItem.INSTANCE.mapGuildToItemId(guild), pair, z2, null);
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(pair, "categoryRange");
            this.guild = guild;
            this.categoryRange = pair;
            this.isSelected = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, Pair pair, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            if ((i & 2) != 0) {
                pair = guildItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = guildItem.getIsSelected();
            }
            return guildItem.copy(guild, pair, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Pair<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final GuildItem copy(Guild guild, Pair<Integer, Integer> categoryRange, boolean isSelected) {
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(categoryRange, "categoryRange");
            return new GuildItem(guild, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildItem)) {
                return false;
            }
            GuildItem guildItem = (GuildItem) other;
            return m.areEqual(this.guild, guildItem.guild) && m.areEqual(getCategoryRange(), guildItem.getCategoryRange()) && getIsSelected() == guildItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        public Pair<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Pair<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = a.U("GuildItem(guild=");
            sbU.append(this.guild);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EmojiCategoryItem.kt */
    public static final /* data */ class StandardItem extends EmojiCategoryItem {
        private final Pair<Integer, Integer> categoryRange;
        private final EmojiCategory emojiCategory;
        private final boolean isSelected;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StandardItem(EmojiCategory emojiCategory, Pair<Integer, Integer> pair, boolean z2) {
            super(EmojiCategoryItem.INSTANCE.mapEmojiCategoryToItemId(emojiCategory), pair, z2, null);
            m.checkNotNullParameter(emojiCategory, "emojiCategory");
            m.checkNotNullParameter(pair, "categoryRange");
            this.emojiCategory = emojiCategory;
            this.categoryRange = pair;
            this.isSelected = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StandardItem copy$default(StandardItem standardItem, EmojiCategory emojiCategory, Pair pair, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                emojiCategory = standardItem.emojiCategory;
            }
            if ((i & 2) != 0) {
                pair = standardItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = standardItem.getIsSelected();
            }
            return standardItem.copy(emojiCategory, pair, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final EmojiCategory getEmojiCategory() {
            return this.emojiCategory;
        }

        public final Pair<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final StandardItem copy(EmojiCategory emojiCategory, Pair<Integer, Integer> categoryRange, boolean isSelected) {
            m.checkNotNullParameter(emojiCategory, "emojiCategory");
            m.checkNotNullParameter(categoryRange, "categoryRange");
            return new StandardItem(emojiCategory, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StandardItem)) {
                return false;
            }
            StandardItem standardItem = (StandardItem) other;
            return m.areEqual(this.emojiCategory, standardItem.emojiCategory) && m.areEqual(getCategoryRange(), standardItem.getCategoryRange()) && getIsSelected() == standardItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        public Pair<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        public final EmojiCategory getEmojiCategory() {
            return this.emojiCategory;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            EmojiCategory emojiCategory = this.emojiCategory;
            int iHashCode = (emojiCategory != null ? emojiCategory.hashCode() : 0) * 31;
            Pair<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
        /* renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = a.U("StandardItem(emojiCategory=");
            sbU.append(this.emojiCategory);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private EmojiCategoryItem(long j, Pair<Integer, Integer> pair, boolean z2) {
        this.stableId = j;
        this.categoryRange = pair;
        this.isSelected = z2;
        this.key = String.valueOf(j);
    }

    public final boolean containsOnlyUnicodeEmoji() {
        return (this instanceof StandardItem) && ((StandardItem) this).getEmojiCategory().containsOnlyUnicode;
    }

    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getStableId() {
        return this.stableId;
    }

    /* renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ EmojiCategoryItem(long j, Pair pair, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, pair, z2);
    }
}
