package com.discord.utilities.search.query.node.answer;

import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.AutocompleteUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: HasNode.kt */
/* renamed from: com.discord.utilities.search.query.node.answer.HasAnswerOption, reason: use source file name */
/* loaded from: classes2.dex */
public enum HasNode2 {
    LINK("link"),
    EMBED("embed"),
    FILE("file"),
    VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND),
    IMAGE("image"),
    SOUND("sound"),
    STICKER("sticker");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String restParamValue;

    /* compiled from: HasNode.kt */
    /* renamed from: com.discord.utilities.search.query.node.answer.HasAnswerOption$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final HasNode2 getOptionFromString(String match, SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(match, "match");
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            if (Intrinsics3.areEqual(match, searchStringProvider.getLinkAnswerString())) {
                return HasNode2.LINK;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getEmbedAnswerString())) {
                return HasNode2.EMBED;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getFileAnswerString())) {
                return HasNode2.FILE;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getVideoAnswerString())) {
                return HasNode2.VIDEO;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getImageAnswerString())) {
                return HasNode2.IMAGE;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getSoundAnswerString())) {
                return HasNode2.SOUND;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getStickerAnswerString())) {
                return HasNode2.STICKER;
            }
            throw new IllegalArgumentException(outline.m883w("invalid match: ", match));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: com.discord.utilities.search.query.node.answer.HasAnswerOption$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            HasNode2.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[HasNode2.LINK.ordinal()] = 1;
            iArr[HasNode2.EMBED.ordinal()] = 2;
            iArr[HasNode2.FILE.ordinal()] = 3;
            iArr[HasNode2.VIDEO.ordinal()] = 4;
            iArr[HasNode2.IMAGE.ordinal()] = 5;
            iArr[HasNode2.SOUND.ordinal()] = 6;
            iArr[HasNode2.STICKER.ordinal()] = 7;
        }
    }

    HasNode2(String str) {
        this.restParamValue = str;
    }

    public final String getLocalizedInputText(SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        switch (this) {
            case LINK:
                return searchStringProvider.getLinkAnswerString();
            case EMBED:
                return searchStringProvider.getEmbedAnswerString();
            case FILE:
                return searchStringProvider.getFileAnswerString();
            case VIDEO:
                return searchStringProvider.getVideoAnswerString();
            case IMAGE:
                return searchStringProvider.getImageAnswerString();
            case SOUND:
                return searchStringProvider.getSoundAnswerString();
            case STICKER:
                return searchStringProvider.getStickerAnswerString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getRestParamValue() {
        return this.restParamValue;
    }
}
